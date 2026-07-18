import { Component } from '@angular/core';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  templateUrl: './student-profile.component.html',
  styleUrl: './student-profile.component.css'
})
export class StudentProfileComponent {
  studentName = 'Prince';
  program = 'B.Tech Information Technology';
  currentSemester = 'Semester 6';
}
