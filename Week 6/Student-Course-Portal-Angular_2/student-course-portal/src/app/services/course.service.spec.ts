import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS205', credits: 3, gradeStatus: 'pending' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [CourseService]
    });

    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should fetch the course list', () => {
    service.getCourses().subscribe((courses) => {
      expect(courses.length).toBe(2);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should surface a friendly error message when the request fails', () => {
    service.getCourses().subscribe({
      next: () => fail('expected an error, not a success response'),
      error: (error: Error) => expect(error.message).toBe('Failed to load courses. Please try again.')
    });

    // getCourses() applies retry(2), so a failing request is attempted
    // three times in total (the original call plus two retries) before
    // the error is allowed to propagate to the subscriber.
    for (let attempt = 0; attempt < 3; attempt++) {
      httpMock.expectOne('http://localhost:3000/courses').flush('server exploded', {
        status: 500,
        statusText: 'Server Error'
      });
    }
  });
});
