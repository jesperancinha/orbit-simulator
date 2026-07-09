import { Injectable } from '@angular/core';
import { PlanetConfig } from './planet.model';

const DEFAULT_PLANETS: readonly PlanetConfig[] = [
  { id: 1, name: 'Mercury', color: '#b5b5b5', orbitRadius: 60, orbitPeriodSeconds: 3, radius: 4 },
  { id: 2, name: 'Venus', color: '#e6c27a', orbitRadius: 90, orbitPeriodSeconds: 5, radius: 6 },
  { id: 3, name: 'Earth', color: '#4f9dde', orbitRadius: 125, orbitPeriodSeconds: 8, radius: 6 },
  { id: 4, name: 'Mars', color: '#c1440e', orbitRadius: 160, orbitPeriodSeconds: 12, radius: 5 },
];

@Injectable({ providedIn: 'root' })
export class PlanetsService {
  async loadPlanets(): Promise<PlanetConfig[]> {
    return DEFAULT_PLANETS.map((planet) => ({ ...planet }));
  }
}
