import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/models/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-list-admin',
  templateUrl: './list-admin.component.html',
  styleUrls: ['./list-admin.component.css']
})
export class ListAdminComponent implements OnInit {

  admin: Admin[] = [];

  constructor(private _adminService: AdminService) { }

  ngOnInit(): void {
    this.listAdmin();
  }

  deleteAdmin(id: number){
    this._adminService.deleteAdmin(id).subscribe(
      data => {
        console.log('deleted admin', data);
        this.listAdmin();
     }
    )

 }

 listAdmin() {
  this._adminService.getAdmin().subscribe(
    data => this.admin = data
  )

 }

}
