import { Component, OnInit } from '@angular/core';
import { AsyncPipe, NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { BehaviorSubject, Observable, combineLatest, map } from 'rxjs';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';
import { loadCourses } from '../../store/course/course.actions';
import { selectAllCourses, selectCoursesLoading } from '../../store/course/course.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [NgFor, NgIf, AsyncPipe, FormsModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {
  searchTerm = '';
  selectedCourseId: number | null = null;

  isLoading$!: Observable<boolean>;
  filteredCourses$!: Observable<Course[]>;

  private readonly searchTerm$ = new BehaviorSubject<string>('');

  constructor(private store: Store, private router: Router, private route: ActivatedRoute) {
    this.isLoading$ = this.store.select(selectCoursesLoading);
  }

  ngOnInit(): void {
    this.searchTerm = this.route.snapshot.queryParamMap.get('search') ?? '';
    this.searchTerm$.next(this.searchTerm);

    this.store.dispatch(loadCourses());

    this.filteredCourses$ = combineLatest([this.store.select(selectAllCourses), this.searchTerm$]).pipe(
      map(([courses, term]) =>
        term ? courses.filter((course) => course.name.toLowerCase().includes(term.toLowerCase())) : courses
      )
    );
  }

  // trackBy avoids re-rendering every card whenever the courses array reference
  // changes; Angular only re-renders the cards whose id actually changed.
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onSearchChange(term: string): void {
    this.searchTerm$.next(term);
    this.router.navigate(['courses'], { queryParams: term ? { search: term } : {} });
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
  }

  openCourse(courseId: number): void {
    this.router.navigate(['courses', courseId]);
  }
}
