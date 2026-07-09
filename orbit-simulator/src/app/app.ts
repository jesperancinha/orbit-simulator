import { ChangeDetectionStrategy, Component } from '@angular/core';
import { OrbitSimulator } from './orbit-simulator/orbit-simulator';

@Component({
  selector: 'app-root',
  imports: [OrbitSimulator],
  templateUrl: './app.html',
  styleUrl: './app.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class App {}
