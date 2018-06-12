import { TestBed, inject } from '@angular/core/testing';

import { StreamsListService } from './streams-list.service';

describe('StreamsListService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [StreamsListService]
    });
  });

  it('should be created', inject([StreamsListService], (service: StreamsListService) => {
    expect(service).toBeTruthy();
  }));
});
