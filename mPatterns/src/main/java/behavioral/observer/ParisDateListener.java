package behavioral.observer;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ParisDateListener extends DateListener {

    private ZonedDateTime zonedDateTime;

    public ParisDateListener(InstantProvider instantProvider) {
        super(instantProvider);
    }

    @Override
    public void update() {
        zonedDateTime = instantProvider.getInstant().atZone(ZoneId.of("Europe/Paris"));
        System.out.println("ZonedDateTime : " + zonedDateTime);
    }

}
