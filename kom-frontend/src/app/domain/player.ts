import { Component } from "@angular/core";
import { Gender } from "./gender";

export interface Player {
    id: number;
    name: string;
    weightInKilogram: number;
    alcoholPercentage: number;
    drinkInCentiliter: number;
    totalAmountOfShots: number;
    widMark: number;
    gender: Gender;
}