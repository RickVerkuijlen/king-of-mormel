package nl.rickverkuijlen.mormel.game.objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private int id;
    private String name;
    private double weightInKilogram;
    private double alcoholPercentage;
    private double drinkInCentiliter;
    private double totalAmountOfShots;
    private double widMark;
    private Gender gender;
}
