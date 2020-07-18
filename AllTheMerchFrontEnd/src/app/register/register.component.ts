import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ɵangular_packages_router_router_e } from '@angular/router';
import { Customer } from '../models/customer.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  private customer: Customer = new Customer();

  registerForm = new FormGroup({
    usernameForm: new FormControl(''),
    passwordForm: new FormControl(''),
    passwordConfirmForm: new FormControl(''),
    firstNameForm: new FormControl(''),
    middleNameForm: new FormControl(''),
    lastNameForm: new FormControl(''),
    addressForm: new FormControl(''),
    cityForm: new FormControl(''),
    stateForm: new FormControl(''),
    zipForm: new FormControl(''),
  });

  createAccount(){
    this.customer.address = this.registerForm.get("addressForm").value;
    this.customer.email = this.registerForm.get("emailForm").value;
    this.customer.firstName = this.registerForm.get("firstNameForm").value;
    this.customer.lastName = this.registerForm.get("lastNameForm").value;
    this.customer.password = this.registerForm.get("passwordForm").value;
    this.customer.state = this.registerForm.get("stateForm").value;
    this.customer.username = this.registerForm.get("usernameForm").value;
    this.customer.zip = this.registerForm.get("zipForm").value;
    this.http.post('http://localhost:9025/api/customers', this.customer).toPromise().then(data => {
      if(data == null || data == undefined){
        // this.invalidLogin = true;
      } else{
        // console.log(data);
        this.router.navigateByUrl('/login');
      }
    });
  }

  constructor(private router: Router, private http: HttpClient) { }

  ngOnInit(): void {
  }

}
