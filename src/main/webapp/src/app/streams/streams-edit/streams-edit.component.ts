import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {StreamService} from "../stream.service";
import {Stream} from "../stream";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'app-streams-edit',
  templateUrl: './streams-edit.component.html',
  styleUrls: ['./streams-edit.component.css']
})
export class StreamsEditComponent implements OnInit {

  private userForm : FormGroup;
  private sub: any;
  private streamId: number;
  private stream: Stream;
  private isError: boolean = false;
  private errorMessage: string = "";

  constructor(private route: ActivatedRoute,
              private router: Router,
              private streamService: StreamService) { }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      this.streamId = params['id']});

    this.getOneStream(this.streamId);
  }


  getOneStream(id: number) {
    this.streamService.findOneStreamById(id).subscribe(
      stream1 => {
        this.stream = stream1
      },
      err => {
        console.log(err)
      }
    );
  }

  redirectStreamsPage() {
    this.router.navigate(['/streams']);

  }

  updateStream(stream: Stream) {
    this.streamService.updateStream(stream).subscribe(
      stream1 => {
        this.redirectStreamsPage();
      },
      err => {
        this.isError = true;
        this.errorMessage = "Invalid datas"
        console.log(err)
      }
    );
  }


  // this.userForm = new FormGroup({
  //   name: new FormControl('', Validators.required),
  //   description: new FormControl('', Validators.required),
  //   url: new FormControl('', Validators.required)
  // });

}
