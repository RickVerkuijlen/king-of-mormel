import { Component, OnInit } from '@angular/core';
import { Gender } from './domain/gender';
import { Owner } from './domain/owner';
import { Player } from './domain/player';
import { WebsocketService } from './services/websocket/websocket.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'King of Mormel';

  constructor() {}

}
