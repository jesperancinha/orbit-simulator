import { DecimalPipe } from '@angular/common';
import {
  ChangeDetectionStrategy,
  Component,
  DestroyRef,
  ElementRef,
  computed,
  effect,
  inject,
  resource,
  signal,
  viewChild,
} from '@angular/core';
import { PlanetsService } from '../planets/planets.service';

@Component({
  selector: 'app-orbit-simulator',
  templateUrl: './orbit-simulator.html',
  styleUrl: './orbit-simulator.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [DecimalPipe],
})
export class OrbitSimulator {
  private readonly planetsService = inject(PlanetsService);
  private readonly destroyRef = inject(DestroyRef);
  private readonly canvasRef = viewChild<ElementRef<HTMLCanvasElement>>('canvas');

  protected readonly planetsResource = resource({
    loader: () => this.planetsService.loadPlanets(),
  });

  protected readonly running = signal(true);
  protected readonly speedFactor = signal(1);
  protected readonly elapsedSeconds = signal(0);

  protected readonly planetCount = computed(() => this.planetsResource.value()?.length ?? 0);

  private animationFrameId: number | undefined;
  private lastTimestampMs: number | undefined;

  constructor() {
    effect((onCleanup) => {
      if (this.running()) {
        this.animationFrameId = requestAnimationFrame(this.tick);
      }
      onCleanup(() => {
        if (this.animationFrameId !== undefined) {
          cancelAnimationFrame(this.animationFrameId);
        }
        this.lastTimestampMs = undefined;
      });
    });

    effect(() => {
      const planets = this.planetsResource.value();
      if (planets) {
        this.draw(this.elapsedSeconds());
      }
    });

    this.destroyRef.onDestroy(() => {
      if (this.animationFrameId !== undefined) {
        cancelAnimationFrame(this.animationFrameId);
      }
    });
  }

  protected toggleRunning(): void {
    this.running.update((isRunning) => !isRunning);
  }

  protected setSpeedFactor(value: number): void {
    this.speedFactor.set(value);
  }

  private readonly tick = (timestampMs: number): void => {
    if (this.lastTimestampMs !== undefined) {
      const deltaSeconds = ((timestampMs - this.lastTimestampMs) / 1000) * this.speedFactor();
      this.elapsedSeconds.update((seconds) => seconds + deltaSeconds);
    }
    this.lastTimestampMs = timestampMs;
    this.draw(this.elapsedSeconds());

    if (this.running()) {
      this.animationFrameId = requestAnimationFrame(this.tick);
    }
  };

  private draw(elapsedSeconds: number): void {
    const canvas = this.canvasRef()?.nativeElement;
    const context = canvas?.getContext('2d');
    const planets = this.planetsResource.value();
    if (!canvas || !context || !planets) {
      return;
    }

    const centerX = canvas.width / 2;
    const centerY = canvas.height / 2;

    context.clearRect(0, 0, canvas.width, canvas.height);

    context.fillStyle = '#ffd54f';
    context.beginPath();
    context.arc(centerX, centerY, 10, 0, Math.PI * 2);
    context.fill();

    for (const planet of planets) {
      const angle = (elapsedSeconds / planet.orbitPeriodSeconds) * Math.PI * 2;
      const x = centerX + Math.cos(angle) * planet.orbitRadius;
      const y = centerY + Math.sin(angle) * planet.orbitRadius;

      context.strokeStyle = 'rgba(255, 255, 255, 0.15)';
      context.beginPath();
      context.arc(centerX, centerY, planet.orbitRadius, 0, Math.PI * 2);
      context.stroke();

      context.fillStyle = planet.color;
      context.beginPath();
      context.arc(x, y, planet.radius, 0, Math.PI * 2);
      context.fill();
    }
  }
}
