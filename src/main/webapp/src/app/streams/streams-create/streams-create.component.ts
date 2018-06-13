import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {StreamService} from "../stream.service";
import {Stream} from "../stream";

@Component({
  selector: 'app-streams-create',
  templateUrl: './streams-create.component.html',
  styleUrls: ['./streams-create.component.css']
})
export class StreamsCreateComponent implements OnInit {

  private service : any;
  private errorMessage: String;
  private isError: boolean = false;

  constructor(private router: Router,
              private streamService: StreamService) { }

  ngOnInit() {
    this.service = { }
  }

  createStream() {
      this.streamService.createStream(this.service).subscribe(
        stream => {
          this.router.navigate(['/streams']);
        },
        err => {

          this.errorMessage = "Provided wrong datas";
          this.isError = true;
          console.log(err)
        }
      );
    }
  backToStreamsList() {
    this.router.navigate(['/streams']);

  }

}
