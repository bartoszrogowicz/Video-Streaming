import {Component, Input, OnInit} from '@angular/core';
import {Stream} from "./stream";
import {StreamService} from "./stream.service";

@Component({
  selector: 'app-streams',
  templateUrl: './streams.component.html',
  styleUrls: ['./streams.component.css']
})
export class StreamsComponent implements OnInit {

  private streams: Stream[];
  private _counter: number;
  current: number = -1;

  constructor(private streamService:StreamService) { }

  ngOnInit() {
   this.getAllStreams()
  }



  getAllStreams() {
    this.streamService.findAllStreams().subscribe(
      streams => {
        this.streams = streams;
      },
      err => {
        console.log(err)
      }
    );
  }


}
