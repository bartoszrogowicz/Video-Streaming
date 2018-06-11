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

  constructor(private streamService:StreamService) { }

  ngOnInit() {
   this.getAllStreams()
  }

  @Input() counter: number;


  get count() {
    return this._counter + 1;
  }
  getAllStreams() {
    this.streamService.findAll().subscribe(
      streams => {
        this.streams = streams;
        console.log(streams)
      },
      err => {
        console.log(err)
      }
    )
  }
}
