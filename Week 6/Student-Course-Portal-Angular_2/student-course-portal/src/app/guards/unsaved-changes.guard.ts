import { CanDeactivateFn } from '@angular/router';

export interface HasDirtyForm {
  isFormDirty(): boolean;
}

export const unsavedChangesGuard: CanDeactivateFn<HasDirtyForm> = (component) => {
  if (component.isFormDirty()) {
    return window.confirm('You have unsaved changes. Leave?');
  }
  return true;
};
