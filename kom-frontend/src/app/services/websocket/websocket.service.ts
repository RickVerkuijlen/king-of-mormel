import { Injectable } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';
import { environment } from 'src/environments/environment';
import { wsMessage } from 'src/app/domain/messages/wsMessage';
import { Owner } from 'src/app/domain/owner';
import { Player } from 'src/app/domain/player';
import { join } from 'path';
import { MessageType } from 'src/app/domain/messages/messagetype';

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
    const wsMessage: wsMessage = JSON.parse(payload.body);

    console.log(wsMessage);
  }

  createGame(owner: Owner): void {
    const wsMessage: wsMessage = {
      messagetype: MessageType.CREATE_BOARD,
      sender: owner.name,
      content: JSON.stringify(owner),
      timestamp: new Date()
    };
    this.stompClient.send('/app/createBoard', {}, JSON.stringify(wsMessage));
  }

  joinBoard(joinCode: string, player: Player) {
    this.stompClient.subscribe(
      '/game/' + joinCode,
      (res) => this.processMessages(res),
      () => this.onError()
    );
    const wsMessage: wsMessage = {
      messagetype: MessageType.ADD_PLAYER,
      sender: player.name,
      content: JSON.stringify(player),
      timestamp: new Date()
    };
    this.stompClient.send('/app/joinBoard/' + joinCode, {}, JSON.stringify(wsMessage));
  }
}
