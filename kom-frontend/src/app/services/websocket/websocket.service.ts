import { Injectable } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { environment } from 'src/environments/environment';
import { User } from 'src/app/domain/user';
import { GameMessage } from 'src/app/domain/messages/gameMessage';

@Injectable({
  providedIn: 'root'
})
export class WebsocketService {
  private stompClient: Stomp.Client;

  connect(): void {
    const ws = new SockJS(environment.webSockerURL);
    this.stompClient = Stomp.over(ws);

    this.stompClient.connect(
      {},
      () => this.onJoined(),
      () => this.onError()
    );
  }

  private onJoined(): void {
    this.stompClient.subscribe(
      '/game',
      (res) => this.processMessages(res),
      () => this.onError()
    );
  }

  private onError(): void {
    console.log('error');
  }

  private processMessages(payload: any): void {
    console.log(payload);
  }

  createGame(user: User): void {
    const wsMessage: GameMessage = {
      sender: user.name,
      content: JSON.stringify(user),
      timestamp: new Date()
    };
    this.stompClient.send('/app/createBoard', {}, JSON.stringify(wsMessage));
  }
}
