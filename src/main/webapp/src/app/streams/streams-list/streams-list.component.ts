import { Component, OnInit } from '@angular/core';
import {StreamService} from "../stream.service";
import {Stream} from "../stream";

@Component({
  selector: 'app-streams-list',
  templateUrl: './streams-list.component.html',
  styleUrls: ['./streams-list.component.css']
})
export class StreamsListComponent implements OnInit {
  private streams: Stream[];

  constructor(private streamService: StreamService) { }

  ngOnInit() {
    this.getAllStreams();
  }

  deleteUser(id: number) {
    this.streamService.deleteStreamById(id).subscribe(streams => {
        this.getAllStreams();
      },
      err => {
        console.log(err)
      }
    );
  }

  getAllStreams() {
    this.streamService.findAllStreams().subscribe(
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
