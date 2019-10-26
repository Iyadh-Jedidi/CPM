import { Observable } from 'rxjs';
import { PagesComponent } from './../../pages/pages.component';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  url = PagesComponent.urlConfig+'/projects';

  constructor(protected httpClient: HttpClient) {
  }
  getAllProjects():Observable<any> {
    return this.httpClient.get(this.url);
  }
  getProjectByID(code_mag: number) {
    return this.httpClient.get<any>(this.url + '/' + code_mag);
  }
  addProject(project):Observable<any> {
    return this.httpClient.post(this.url,project);
  }

  deleteProject(id){
    return this.httpClient.delete(this.url + '/' + id);
  }
  updateProject(id,project):Observable<any>{
    return this.httpClient.get<any>(this.url + '/' + id,project);
  }
}
