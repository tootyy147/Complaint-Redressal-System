import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent implements OnInit {

  admin: Admin = new Admin();
  constructor(private _adminService: AdminService,
              private _router: Router,
              private _activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const isIdPresent = this._activatedRoute.snapshot.paramMap.has('id');
    if(isIdPresent){
      const id = Number(this._activatedRoute.snapshot.paramMap.get('id'));
      this._adminService.getAdminbyId(id).subscribe(
        data => this.admin = data
      )
      // this._adminService.deleteAdmin(id).subscribe(
      //   data => this.admin = data
      // )
      
    }
  }

  saveAdmin() {
    this._adminService.saveAdmin(this.admin).subscribe(
      data => {
        console.log('response', data);
        this._router.navigateByUrl("/admin");
      }
    )

  }

  deleteAdmin(id: number) {
    this._adminService.deleteAdmin(id).subscribe(
      data => {
        console.log('deleted admin', data);
        this._router.navigateByUrl("/admin");
      }
    )
  }
}
