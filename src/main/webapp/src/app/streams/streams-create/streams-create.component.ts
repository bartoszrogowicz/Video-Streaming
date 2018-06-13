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

  private url = ""
  private description = "";
  private name: "";
  private service : any;
  private errorMessage: String;
  private isError: boolean = false;

  constructor(private router: Router,
              private streamService: StreamService
              // public service: Stream
              ) { }

  ngOnInit() {
    this.service = {}
  }

  createStream(stream: any) {

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

  // dodajStream(stream: Stream) {
  //   stream.id = null;
  //   this.streamService.updateStream(stream).subscribe(
  //     stream1 => {
  //       this.backToStreamsList();
  //     },
  //     err => {
  //       this.isError = true;
  //       this.errorMessage = "Invalid datas"
  //       console.log(err)
  //     }
  //   );
  // }

  backToStreamsList() {
    this.router.navigate(['/streams']);

  }

}
