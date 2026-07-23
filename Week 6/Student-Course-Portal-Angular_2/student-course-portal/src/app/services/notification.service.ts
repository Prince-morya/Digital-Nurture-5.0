import { Injectable } from '@angular/core';

// Provided at the component level (see NotificationComponent), so every
// component that supplies it gets its own isolated instance instead of
// sharing the app-wide singleton.
@Injectable()
export class NotificationService {
  private messages: string[] = [];

  push(message: string): void {
    this.messages.push(message);
  }

  getAll(): string[] {
    return this.messages;
  }
}
