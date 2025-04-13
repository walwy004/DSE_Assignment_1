/*
 * === Custom Feature: Weather System ===
 * On each turn, the WeatherManager determines if a weather event occurs.
 * - Drought (10%): crops do not age (tick is skipped)
 * - Flood (10%): all Apples and Grain are wiped out and replaced with UntilledSoil
 * This feature introduces environmental randomness and challenges the player to plan ahead.
 */

package students;

import java.util.Random;

public class Weather {
	
	public static final int NONE = 0;
    public static final int FLOOD = 1;
    public static final int DROUGHT = 2;

    private Random random;

    public Weather() {
        this.random = new Random();
    }

    public int getWeatherEvent() {
        int roll = random.nextInt(100); // 0–99

        if (roll < 10) {
            return FLOOD;
        } else if (roll < 20) {
            return DROUGHT;
        } else {
            return NONE;
        }
    }

}
