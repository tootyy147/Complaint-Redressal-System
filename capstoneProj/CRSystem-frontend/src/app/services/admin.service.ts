import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Admin } from '../models/admin';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private getUrl: string = "http://localhost:4200/api/get-admin";
  private getSaveUrl: string = "http://localhost:4200/api/save-admin";
  private deleteUrl: String = "http://localhost:4200/api/delete-admin";

  constructor(private _httpClient: HttpClient) { }

  getAdmin() : Observable<Admin[]> {
    return this._httpClient.get<Admin[]>(this.getUrl).pipe(
      map(responce => responce)
    )
  }

  saveAdmin(admin: Admin): Observable<Admin> {
    return this._httpClient.post<Admin>(this.getSaveUrl, admin);
  }  

  getAdminbyId(id: number): Observable<Admin> {
    return this._httpClient.get<Admin>(`${this.getUrl}/${id}`).pipe(
      map(responce => responce)
    )

  }

  deleteAdmin(id: number): Observable<any> {
    return this._httpClient.delete(`${this.deleteUrl}/${id}`, {responseType: 'text'});
  }
}
