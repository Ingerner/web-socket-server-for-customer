package ru.websocketserver.manager;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.service.Device;

import javax.swing.*;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import static ru.websocketserver.util.ErrorMessage.DEVICE_DOES_NOT_EXIST;

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

    public Optional<Device> getByMac(@NonNull String mac) {
        return Optional.ofNullable(
                deviceByMac.get(mac)
        );
    }

    public void register(@NonNull Device device) {
        String sessionId = device.getSession().getId();
        deviceBySessionId.put(sessionId, device);
        deviceByMac.put(device.getMac(), device);
    }

    public void deleteBySessionId(@NonNull String sessionId) {
        if (deviceBySessionId.containsKey(sessionId)) {
            Device device = deviceBySessionId.get(sessionId);
            deviceBySessionId.remove(sessionId);
            deviceByMac.remove(device.getMac());
        }
    }

}