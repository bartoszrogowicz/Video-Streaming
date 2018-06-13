import { TestBed, async, inject } from '@angular/core/testing';

import { StreamGuard } from './stream.guard';

describe('StreamGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StreamGuard]
    });
  });

  it('should ...', inject([StreamGuard], (guard: StreamGuard) => {
    expect(guard).toBeTruthy();
  }));
});
