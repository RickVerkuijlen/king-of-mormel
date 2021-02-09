import { Component, OnInit } from '@angular/core';
import { Gender } from 'src/app/domain/gender';
import { Owner } from 'src/app/domain/owner';
import { Player } from 'src/app/domain/player';
import { WebsocketService } from 'src/app/services/websocket/websocket.service';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.scss']
})
export class GameComponent implements OnInit {

  joinCode: string;

  constructor(private webSocketService: WebsocketService) { }

  ngOnInit(): void {
    this.webSocketService.connect();
  }

  createGame(): void {
    const owner: Owner = {
      id: 0,
      name: "Rick"
    };
    this.webSocketService.createGame(owner);
  }

  joinGame(): void {
    console.log(this.joinCode)
    const player: Player = {
      id: 0,
      name: 'Rick',
      weightInKilogram: 1,
      alcoholPercentage: 0,
      drinkInCentiliter: 0,
      totalAmountOfShots: 0,
      widMark: 0,
      gender: Gender.MALE
    };
    console.log(this.joinCode)
    this.webSocketService.joinBoard(this.joinCode, player);
  }

  setJoinCode(updatedValue: any): void {
    this.joinCode = updatedValue.target.value;
    console.log(this.joinCode)
  }
}
