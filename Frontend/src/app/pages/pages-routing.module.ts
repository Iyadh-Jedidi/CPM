import { ProfileComponent } from './profile/profile.component';
import { MyProjectComponent } from './my-project/my-project.component';
import { ProjectComponent } from './project/project.component';
import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';

import { PagesComponent } from './pages.component';


const routes: Routes = [{
  path: '',
  component: PagesComponent,
  children: [
    {
      path: '',
      redirectTo: 'project',
      pathMatch: 'full',
    },
    {
      path: 'project',
      component: ProjectComponent,
    },
    {
      path: 'myProject',
      component: MyProjectComponent,
    },
    {
      path: 'profile',
      component: ProfileComponent,
    }
    
  ],
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PagesRoutingModule {
}
