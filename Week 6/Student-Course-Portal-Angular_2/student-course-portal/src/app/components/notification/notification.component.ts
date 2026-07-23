import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [NgFor],
  // Component-level provider: this NotificationComponent (and any children)
  // receives its own NotificationService instance, separate from any other
  // instance elsewhere in the app — useful when notifications shouldn't leak
  // across unrelated widgets.
  providers: [NotificationService],
  templateUrl: './notification.component.html',
  styleUrl: './notification.component.css'
})
export class NotificationComponent {
  constructor(private notificationService: NotificationService) {}

  get messages(): string[] {
    return this.notificationService.getAll();
  }

  addSampleNotification(): void {
    this.notificationService.push(`New update at ${new Date().toLocaleTimeString()}`);
  }
}
