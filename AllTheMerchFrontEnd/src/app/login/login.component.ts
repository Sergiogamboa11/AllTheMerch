import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Customer } from '../models/customer.model';
import { LoginService } from '../services/login.service';

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

  constructor(private router: Router, private loginService: LoginService) {
  }

  login() {
    this.customer.username = this.loginForm.get("usernameForm").value;
    this.customer.password = this.loginForm.get("passwordForm").value;

    this.loginService.post(this.customer)
      .subscribe(response => {
        if (response == null || response == undefined) {
          this.invalidLogin = true;
        } else {
          console.log(response);
          this.router.navigateByUrl('/shop');
        }
      });
  }

  ngOnInit(): void {
  }

}
