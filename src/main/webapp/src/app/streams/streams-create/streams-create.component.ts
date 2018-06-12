import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {StreamService} from "../stream.service";

@Component({
  selector: 'app-streams-create',
  templateUrl: './streams-create.component.html',
  styleUrls: ['./streams-create.component.css']
})
export class StreamsCreateComponent implements OnInit {

  private userForm : FormGroup;
  private sub: any;
  private name: String;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private streamService: StreamService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.name = params['name']});
  }

  // this.userForm = new FormGroup({
  //   name: new FormControl('', Validators.required),
  //   description: new FormControl('', Validators.required),
  //   url: new FormControl('', Validators.required)
  // });

}
