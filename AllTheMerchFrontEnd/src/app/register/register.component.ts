import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ɵangular_packages_router_router_e } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup({
    usernameForm: new FormControl(''),
    passwordForm: new FormControl(''),
    passwordConfirmForm: new FormControl(''),
  });

  createAccount(){
    this.router.navigateByUrl('/login');
  }

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

}
