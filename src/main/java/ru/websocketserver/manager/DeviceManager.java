package ru.websocketserver.manager;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.service.Device;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static ru.websocketserver.util.ErrorMessage.DEVICE_DOES_NOT_EXIST;
import static ru.websocketserver.util.ErrorMessage.DEVICE_WITH_MAC_ADDRESS_WAS_REGISTERED;
import static ru.websocketserver.util.ErrorMessage.DEVICE_WITH_SESSION_WAS_REGISTERED;

@Service
public class DeviceManager {

    private final Map<String, Device> deviceBySessionId = new ConcurrentHashMap<>();
    private final Map<String, Device> deviceByMac = new ConcurrentHashMap<>();

    public Device getBySessionId(@NonNull String sessionId) {
        if (!deviceBySessionId.containsKey(sessionId)) {
            throw new ProcessException(DEVICE_DOES_NOT_EXIST);
        }
        return deviceBySessionId.get(sessionId);
    }

    public Device getByMac(@NonNull String mac) {
        if (!deviceByMac.containsKey(mac)) {
            throw new ProcessException(DEVICE_DOES_NOT_EXIST);
        }
        return deviceByMac.get(mac);
    }

    public Optional<Device> getByMacOfOptional(@NonNull String mac) {
        return Optional.ofNullable(
                deviceByMac.get(mac)
        );
    }

    public void register(@NonNull Device device) {
        String sessionId = device.getSession().getId();
        if (deviceBySessionId.containsKey(sessionId)) {
            throw new ProcessException(DEVICE_WITH_SESSION_WAS_REGISTERED);
        }
        if (deviceByMac.containsKey(device.getMac())) {
            throw new ProcessException(DEVICE_WITH_MAC_ADDRESS_WAS_REGISTERED);
        }

        deviceBySessionId.put(sessionId, device);
        deviceByMac.put(device.getMac(), device);
    }

    public void deleteBySessionId(@NonNull String sessionId) {
        if (deviceBySessionId.containsKey(sessionId)) {
            Device device = deviceBySessionId.get(sessionId);
            deviceByMac.remove(device.getMac());
            deviceBySessionId.remove(sessionId);
            device.close();
        }
    }

    public boolean isRegisteredBySessionId(@NonNull String sessionId) {
        return deviceBySessionId.containsKey(sessionId);
    }

}