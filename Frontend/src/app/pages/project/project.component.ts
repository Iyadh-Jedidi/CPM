import { ProjectService } from './../../services/project/project.service';
import { ModalProjectComponent } from './modal-project/modal-project.component';
import { Component, OnInit } from '@angular/core';
import { NbWindowService } from '@nebular/theme';
import { LocalDataSource } from 'ng2-smart-table';

@Component({
  selector: 'ngx-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.scss']
})
export class ProjectComponent implements OnInit {
  source : LocalDataSource = new LocalDataSource()
  constructor(private windowService: NbWindowService,
    private serviceProject : ProjectService) { }

  ngOnInit() {
    this.serviceProject.getAllProjects().subscribe(projects=>{
      this.source = new LocalDataSource(projects)
    })
  }
  openWindow() {
    localStorage.removeItem('e');
    localStorage.removeItem('idRC');
    localStorage.setItem('e', '0');

    this.windowService.open(ModalProjectComponent,
      {title: 'Add Project'});
  }
  settings = {
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
      add: false,
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
        valuePrepareFunction(row,cell){
          console.log (row)
          return row.name
        }
      },



    },
  };

  onCustom(event) {
    
    if (event.action === 'show') {
      localStorage.removeItem('e');
      localStorage.removeItem('idRC');
      localStorage.setItem('idRC', event.data.idContrat);
      this.windowService.open(ModalProjectComponent,
        {title: 'Show Project',context: {id:event.data.idProject}});
    }
   
  }
  onDeleteConfirm(event): void {
    if (window.confirm(`Vous etes sure de supprimer ce Produit?`)) {
      event.confirm.resolve(this.serviceProject.deleteProject(event.data.idProject).subscribe(
        data => {
          this.source.remove(event)
        }),
      );
    } else {
      event.confirm.reject();
    }
  }
  editProject(event){

  }

}
