import { ModalMyProjectComponent } from './modal-my-project/modal-my-project.component';
import { Component, OnInit } from '@angular/core';
import { NbWindowService } from '@nebular/theme';

@Component({
  selector: 'ngx-my-project',
  templateUrl: './my-project.component.html',
  styleUrls: ['./my-project.component.scss']
})
export class MyProjectComponent implements OnInit {

  constructor(private windowService: NbWindowService) { }

  ngOnInit() {
  }
  openWindow() {
    localStorage.removeItem('e');
    localStorage.removeItem('idRC');
    localStorage.setItem('e', '0');

    this.windowService.open(ModalMyProjectComponent,
      {title: 'Ajouter Project'});
  }
  settings = {
    delete: {
      deleteButtonContent: '<i class="nb-trash" title="supprimer"></i>',
      confirmDelete: true,
    },
    actions: {
      add: false,
      edit: false,
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
      },
      owner: {
        title: 'Owner',
        type: 'string',
        filter: true,
      },



    },
  };

  onCustom(event) {
    
    if (event.action === 'show') {
      localStorage.removeItem('e');
      localStorage.removeItem('idRC');
      localStorage.setItem('idRC', event.data.idContrat);
      this.windowService.open(ModalMyProjectComponent,
        {title: 'Afficher Magasin',context: {id:event.data.idMagasin}});
    }
   
  }
  // onDeleteConfirm(event): void {
  //   if (window.confirm(`Vous etes sure de supprimer ce Produit?`)) {
  //     event.confirm.resolve(this.serviceMagasin.deleteMagasin(event.data.idMagasin).subscribe(
  //       data => {
  //         this.source.remove(event)
  //       }),
  //     );
  //   } else {
  //     event.confirm.reject();
  //   }
  // }


}
