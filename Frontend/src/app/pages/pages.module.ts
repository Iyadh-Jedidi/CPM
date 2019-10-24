import { MyProjectModule } from './my-project/my-project.module';
import { ProjectModule } from './project/project.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';
import { PagesRoutingModule } from './pages-routing.module';
import { ThemeModule } from '../@theme/theme.module';
import { ProjectComponent } from './project/project.component';
import { ModalProjectComponent } from './project/modal-project/modal-project.component';
import { MyProjectComponent } from './my-project/my-project.component';
import { ProfileComponent } from './profile/profile.component';


const PAGES_COMPONENTS = [
  PagesComponent,
];

@NgModule({
  imports: [
    PagesRoutingModule,
    ThemeModule,
    Ng2SmartTableModule,
    ProjectModule,
    MyProjectModule
  ],
  declarations: [
    ...PAGES_COMPONENTS,
    ProjectComponent,
    MyProjectComponent,
    ProfileComponent,
  ],
  
})
export class PagesModule {
}
