import { TestBed } from '@angular/core/testing';

import { MicroservicioBaseService } from './microservicio-base.service';

describe('MicroservicioBaseService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MicroservicioBaseService = TestBed.get(MicroservicioBaseService);
    expect(service).toBeTruthy();
  });
});
