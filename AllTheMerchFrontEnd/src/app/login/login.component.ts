import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  invalidLogin = false;

  loginForm = new FormGroup({
    usernameForm: new FormControl(''),
    passwordForm: new FormControl(''),
  });

  postData = {
    username: 'Steven123',
    password: 'password2'
  }

  login(){
    this.postData.username = this.loginForm.get("usernameForm").value;
    this.postData.password = this.loginForm.get("passwordForm").value;
    this.http.post('http://localhost:9025/api/login', this.postData).toPromise().then(data => {
      if(data == null || data == undefined){
        this.invalidLogin = true;
      } else{
        this.router.navigateByUrl('/shop');
      }
    });
  }

  constructor(private http: HttpClient, private router: Router) {
   }

  ngOnInit(): void {
  }

}
