import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GameComponent } from './component/game/game.component';
import { HomeComponent } from './component/home/home.component';


const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "game", component: GameComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
