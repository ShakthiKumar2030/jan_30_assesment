import { TestBed } from '@angular/core/testing';

import { FilePostService } from './file-post.service';

describe('FilePostService', () => {
  let service: FilePostService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilePostService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
