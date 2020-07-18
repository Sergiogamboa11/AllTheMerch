import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private customer: Customer = new Customer();

  invalidLogin = false;

  loginForm = new FormGroup({
    usernameForm: new FormControl(''),
    passwordForm: new FormControl(''),
  });

  login(){
    this.customer.username = this.loginForm.get("usernameForm").value;
    this.customer.password = this.loginForm.get("passwordForm").value;
    this.http.post('http://localhost:9025/api/login', this.customer).toPromise().then(data => {
      if(data == null || data == undefined){
        this.invalidLogin = true;
      } else{
        console.log(data);
        this.router.navigateByUrl('/shop');
      }
    });
  }

  constructor(private http: HttpClient, private router: Router) {
   }

  ngOnInit(): void {
  }

}
