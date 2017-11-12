import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { WeekendAppSharedModule } from '../../shared';
import { WeekendAppAdminModule } from '../../admin/admin.module';
import {
    ActivityService,
    ActivityPopupService,
    ActivityComponent,
    ActivityDetailComponent,
    ActivityDialogComponent,
    ActivityPopupComponent,
    ActivityDeletePopupComponent,
    ActivityDeleteDialogComponent,
    activityRoute,
    activityPopupRoute,
} from './';

const ENTITY_STATES = [
    ...activityRoute,
    ...activityPopupRoute,
];

@NgModule({
    imports: [
        WeekendAppSharedModule,
        WeekendAppAdminModule,
        RouterModule.forRoot(ENTITY_STATES, { useHash: true })
    ],
    declarations: [
        ActivityComponent,
        ActivityDetailComponent,
        ActivityDialogComponent,
        ActivityDeleteDialogComponent,
        ActivityPopupComponent,
        ActivityDeletePopupComponent,
    ],
    entryComponents: [
        ActivityComponent,
        ActivityDialogComponent,
        ActivityPopupComponent,
        ActivityDeleteDialogComponent,
        ActivityDeletePopupComponent,
    ],
    providers: [
        ActivityService,
        ActivityPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class WeekendAppActivityModule {}
