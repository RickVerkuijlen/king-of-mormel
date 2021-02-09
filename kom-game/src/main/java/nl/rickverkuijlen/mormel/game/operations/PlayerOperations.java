package nl.rickverkuijlen.mormel.game.operations;

import nl.rickverkuijlen.mormel.game.objects.Gender;
import org.springframework.stereotype.Component;

@Component
public class PlayerOperations {

    public double determineWidMark(Gender gender) {
        if (gender == Gender.MALE) {
            return 0.66;
        } else {
            return 0.73;
        }
    }
}
