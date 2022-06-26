package ru.websocketserver.service.message.set;

import org.springframework.stereotype.Service;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;

import static ru.websocketserver.util.MessageId.SET_REBOOT;

@Service
public class SetRebootMessageHandler extends SetMessageHandler {

    public SetRebootMessageHandler(DeviceManager deviceManager, PersonManager personManager) {
        super(deviceManager, personManager);
    }

    @Override
    public String getMessageType() {
        return SET_REBOOT;
    }
}
