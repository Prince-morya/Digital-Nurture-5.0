# Student Course Portal — Angular v20

Digital Nurture 5.0 hands-on submission — full project covering all 10 hands-on
exercises (Part 1: Hands-On 1–5, Part 2: Hands-On 6–10).

## Running the project

Terminal 1 — mock backend:
```
npm install
npx json-server --watch db.json --port 3000
```

Terminal 2 — Angular app:
```
npm start
```

Then open http://localhost:4200.

## What's covered

**Part 1**
- Hands-On 1: workspace scaffold, HeaderComponent, HomeComponent, CourseListComponent, StudentProfileComponent
- Hands-On 2: binding types, lifecycle hooks, @Input/@Output on CourseCardComponent
- Hands-On 3: structural/attribute directives, HighlightDirective, CreditLabelPipe
- Hands-On 4: EnrollmentFormComponent — template-driven form with validation
- Hands-On 5: ReactiveEnrollmentFormComponent — FormBuilder, custom validators, FormArray

**Part 2**
- Hands-On 6: `CourseService` / `EnrollmentService` (providedIn: 'root'), `NotificationService` as a
  component-level provider on `NotificationComponent`, `CourseSummaryWidgetComponent` proving the
  singleton is shared
- Hands-On 7: `CourseDetailComponent`, nested `courses/:id` route under `CoursesLayoutComponent`,
  query-param search sync, `NotFoundComponent` wildcard route, lazy-loaded `enroll` feature,
  `authGuard` (CanActivate), `unsavedChangesGuard` (CanDeactivate)
- Hands-On 8: `CourseService` refactored onto `HttpClient` (GET/POST/PUT/DELETE) against JSON Server,
  RxJS `map`/`tap`/`retry`/`catchError`, `authInterceptor`, `errorHandlerInterceptor`, `loadingInterceptor`
- Hands-On 9: NgRx store for `course` and `enrollment` slices (actions/reducer/selectors/effects),
  `CourseListComponent` and `CourseCardComponent` driven by store selectors and dispatches, a
  cross-slice `selectEnrolledCourses` selector
- Hands-On 10: Jasmine/Karma specs — `course-card.component.spec.ts` (creation, input rendering,
  output event, ngOnChanges), `course.service.spec.ts` (HttpClientTestingModule, success + error +
  retry paths), `course-list.component.spec.ts` (MockStore, loading vs loaded states)

## Notes

- Standalone components throughout (Angular 20 default) — no NgModules.
- The enrollment feature (`features/enrollment/`) is lazy-loaded via `loadChildren` in `app.routes.ts`.
- `db.json` is the JSON Server dataset the app talks to once HttpClient is wired in (Hands-On 8+).
