import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../services/course.service';

@Component({
  selector: 'app-course-summary-widget',
  standalone: true,
  templateUrl: './course-summary-widget.component.html',
  styleUrl: './course-summary-widget.component.css'
})
export class CourseSummaryWidgetComponent implements OnInit {
  courseCount = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    // Shares the same CourseService singleton as every other consumer
    // (providedIn: 'root'), so this count always reflects the live total.
    this.courseService.getCourses().subscribe((courses) => (this.courseCount = courses.length));
  }
}
