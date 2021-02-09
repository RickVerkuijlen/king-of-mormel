import { Component, OnInit } from '@angular/core';
import { User } from './domain/user';
import { WebsocketService } from './services/websocket/websocket.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'King of Mormel';

  constructor(private webSocketService: WebsocketService) {}
  
  ngOnInit(): void {
    this.webSocketService.connect();
  }

  createGame(): void {
    const user: User = {
      name: "Rick"
    };
    this.webSocketService.createGame(user);
  }
}
