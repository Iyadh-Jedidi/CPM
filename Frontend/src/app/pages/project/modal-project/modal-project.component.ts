import { Component, OnInit } from '@angular/core';
import { NbWindowRef } from '@nebular/theme';

@Component({
  selector: 'ngx-modal-project',
  templateUrl: './modal-project.component.html',
  styleUrls: ['./modal-project.component.scss']
})
export class ModalProjectComponent implements OnInit {
  project : Object = new Object();
  e= localStorage.getItem('e');
  AMB = "";
  constructor(public windowRef : NbWindowRef,) { }

  ngOnInit() {
    if (this.e=='0'){
      this.AMB="ADD";
    }
  }
  settings = {
    add: {
      addButtonContent: '<i class="nb-plus"></i>',
      createButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmCreate: true,
      mode:"external"
    },
    delete: {
      deleteButtonContent: '<i class="nb-trash" title="supprimer"></i>',
      confirmDelete: true,
    },
    edit: {
      editButtonContent: '<i class="nb-plus"></i>',
      saveButtonContent: '<i class="nb-checkmark"></i>',
      cancelButtonContent: '<i class="nb-close"></i>',
      confirmSave: true,
      mode:"inline"
    },
    actions: {
      position: 'right',
      custom: [
        {
          name: 'show',
          title: '<i class="nb-sunny" title="Afficher"></i>',
        },
 
      ],
    },
    columns: {
      
      title: {
        title: 'Title',
        type: 'string',
        filter: true,

      },
      description: {
        title: 'Description',
        type: 'string',
        filter: true,
      }
      



    },
  };
  close(){
    localStorage.removeItem('e');
    localStorage.removeItem('idRC');
    this.windowRef.close();
  }

}
