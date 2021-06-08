package behavioral.observer;

import utils.WaitUtils;

public class Timer implements Runnable {

    private InstantProvider instantProvider;

    public Timer(final InstantProvider instantProvider) {
        this.instantProvider = instantProvider;
    }

    @Override
    public void run() {
        for(int i = 0; i <= 5; i++) {
            WaitUtils.waitABit(1000);
            instantProvider.updateInstant();
        }
    }
}
