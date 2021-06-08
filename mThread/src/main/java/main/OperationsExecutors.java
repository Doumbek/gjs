package main;

import lombok.extern.slf4j.Slf4j;
import models.Account;
import models.Transfer;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.TimeUnit.SECONDS;
import static utils.Utils.getFailedLockCounter;


@Slf4j
public class OperationsExecutors {

    public static final long SERVICE_TERMINATION_TIMEOUT = 20;

    public static void main(String[] args) throws Exception {

        final Account firstAccount = new Account(1000);
        final Account secondAccount = new Account(2000);

        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Boolean>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(service.submit(new Transfer(firstAccount, secondAccount, RandomUtils.nextInt(50, 100))));
        }
        service.shutdown();
        service.awaitTermination(SERVICE_TERMINATION_TIMEOUT, SECONDS);

        log.info("Failed lock attempt numbers: " + getFailedLockCounter());

        results.forEach(f -> {
            try {
                log.info(String.valueOf(f.get()));
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
