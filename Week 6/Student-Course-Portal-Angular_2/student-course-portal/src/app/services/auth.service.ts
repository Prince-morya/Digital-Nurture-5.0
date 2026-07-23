import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  // Hardcoded for now — a real login flow would set this from a token/session check.
  isLoggedIn = true;
}
