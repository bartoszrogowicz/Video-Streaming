import { Component, OnInit } from '@angular/core';
import {StreamService} from "../stream.service";
import {Stream} from "../stream";
import {ActivatedRoute, Router} from "@angular/router";



@Component({
  selector: 'app-streams-list',
  templateUrl: './streams-list.component.html',
  styleUrls: ['./streams-list.component.css']
})
export class StreamsListComponent implements OnInit {
  private streams: Stream[];

  constructor(private streamService: StreamService,
              private route: ActivatedRoute,
              private router: Router) { }

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

  editUserPage(str: Stream) {
    if (str) {
      this.router.navigate(['/streams/edit', str.id], { relativeTo: this.route });
    }
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
    );
  }

}
