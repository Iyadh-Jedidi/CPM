import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ModalMyProjectComponent } from './modal-my-project/modal-my-project.component';
import { ThemeModule } from '../../@theme/theme.module';
import { Ng2SmartTableModule } from 'ng2-smart-table';
import { NbDialogModule, NbWindowModule } from '@nebular/theme';

@NgModule({
  imports: [
    ThemeModule,
    Ng2SmartTableModule,
    NbDialogModule.forChild(),
    NbWindowModule.forChild(),
  ],
  declarations: [
    ModalMyProjectComponent  
  ],
  entryComponents: [
    ModalMyProjectComponent,
    
  ]
})
export class MyProjectModule { }
