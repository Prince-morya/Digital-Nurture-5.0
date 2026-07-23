import { Injectable } from '@angular/core';
import { Actions, CreateEffectMetadata, createEffect, ofType } from '@ngrx/effects';
import { catchError, map, of, Observable, switchMap } from 'rxjs';
import { CourseService } from '../../services/course.service';
import { loadCourses, loadCoursesFailure, loadCoursesSuccess } from './course.actions';

@Injectable()
export class CourseEffects {
  loadCourses$!: Observable<any> & CreateEffectMetadata;

  constructor(private actions$: Actions, private courseService: CourseService) {
    this.loadCourses$ = createEffect(() =>
      this.actions$.pipe(
        ofType(loadCourses),
        switchMap(() =>
          this.courseService.getCourses().pipe(
            map((courses) => loadCoursesSuccess({ courses })),
            catchError((error: Error) => of(loadCoursesFailure({ error: error.message })))
          )
        )
      )
    );
  }
}
