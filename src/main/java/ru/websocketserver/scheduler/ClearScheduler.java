package ru.websocketserver.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.SubscribeManager;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClearScheduler {

    private final SubscribeManager subscribeManager;
    private final DeviceManager deviceManager;

    @Scheduled(cron = "0 0/10 * * * *")
    public void clearUnusedSubscription() {
        final List<String> emptyMacSubscription = subscribeManager.getEmptySubscriptionMac();
        for (String mac : emptyMacSubscription) {
            if (!deviceManager.isRegisteredByMac(mac)) {
                subscribeManager.removeSubscription(mac);
            }
        }
    }

}
