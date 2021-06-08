package behavioral.observer;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UkraineDateListener extends DateListener {

    private ZonedDateTime zonedDateTime;

    public UkraineDateListener(InstantProvider instantProvider) {
        super(instantProvider);
    }

    @Override
    public void update() {
        zonedDateTime = instantProvider.getInstant().atZone(ZoneId.of("Europe/Kiev"));
        System.out.println("ZonedDateTime : " + zonedDateTime);
    }

}
