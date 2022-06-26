package ru.websocketserver.manager;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.service.Device;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.websocketserver.util.ErrorMessage.DEVICE_DOES_NOT_EXIST;

@Service
public class DeviceManager {

    private final Map<String, Device> deviceBySessionId = new ConcurrentHashMap<>();

    public Device getBySessionId(@NonNull String sessionId) {
        if (!deviceBySessionId.containsKey(sessionId)) {
            throw new ProcessException(DEVICE_DOES_NOT_EXIST);
        }
        return deviceBySessionId.get(sessionId);
    }

    public void register(@NonNull Device device) {
        String sessionId = device.getSession().getId();
        deviceBySessionId.put(sessionId, device);
    }

    public void deleteBySessionId(@NonNull String sessionId) {
        deviceBySessionId.remove(sessionId);
    }

}