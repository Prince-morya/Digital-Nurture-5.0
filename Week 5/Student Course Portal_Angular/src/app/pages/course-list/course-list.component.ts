import { Component, OnInit } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { Course } from '../../models/course.model';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [NgFor, NgIf, FormsModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {
  isLoading = true;
  searchTerm = '';
  selectedCourseId: number | null = null;

  courses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Operating Systems', code: 'CS205', credits: 3, gradeStatus: 'pending' },
    { id: 3, name: 'Database Management', code: 'CS210', credits: 4, gradeStatus: 'failed' },
    { id: 4, name: 'Computer Networks', code: 'CS220', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Web Technologies', code: 'CS230', credits: 2, gradeStatus: 'pending' }
  ];

  ngOnInit(): void {
    setTimeout(() => {
      this.isLoading = false;
    }, 1500);
  }

  // trackBy avoids re-rendering every card whenever the courses array reference
  // changes; Angular only re-renders the cards whose id actually changed.
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
  }

  get filteredCourses(): Course[] {
    if (!this.searchTerm.trim()) {
      return this.courses;
    }
    const term = this.searchTerm.toLowerCase();
    return this.courses.filter((course) => course.name.toLowerCase().includes(term));
  }
}
