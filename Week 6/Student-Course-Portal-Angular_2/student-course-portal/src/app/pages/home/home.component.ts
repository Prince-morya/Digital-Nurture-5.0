import { Component, OnDestroy, OnInit } from '@angular/core';
import { AsyncPipe, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Store } from '@ngrx/store';
import { Observable, map } from 'rxjs';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses } from '../../store/course/course.selectors';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';
import { CourseSummaryWidgetComponent } from '../../components/course-summary-widget/course-summary-widget.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NgIf, AsyncPipe, FormsModule, CourseSummaryWidgetComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';
  gpa = 3.8;

  coursesAvailable$!: Observable<number>;
  enrolledCount$!: Observable<number>;

  constructor(private store: Store) {}

  ngOnInit(): void {
    console.log('HomeComponent initialised — courses loaded');
    this.store.dispatch(loadCourses());

    this.coursesAvailable$ = this.store.select(selectAllCourses).pipe(map((courses) => courses.length));
    this.enrolledCount$ = this.store.select(selectEnrolledIds).pipe(map((ids) => ids.length));
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}
