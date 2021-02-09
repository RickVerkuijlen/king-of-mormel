import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Player } from 'src/app/domain/player';
import { WebsocketService } from 'src/app/services/websocket/websocket.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {

  joinCode: string;

  playerForm = this.formBuilder.group({
    name: ['', Validators.required],
    weightInKilogram: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
    drinkInCentiliter: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
    alcoholPercentage: ['', [Validators.required, Validators.pattern('^[0-9]*$')]],
    gender: ['Man', Validators.required]
  });

  constructor(private formBuilder: FormBuilder, private webSocketService: WebsocketService) { }

  ngOnInit(): void {
    this.webSocketService.connect();
  }

  enterJoinCode(event: any) {
    this.joinCode = event.target.value;
  }

  onSubmit(): void {
    const player: Player = this.playerForm.getRawValue();

    if(this.joinCode == undefined) {
      alert("Je moet wel een joincode invullen kutje");
    } else {
      this.webSocketService.joinBoard(this.joinCode, player);
    }
    
    
  }

}
