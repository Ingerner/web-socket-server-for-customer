package ru.websocketserver.service.message.set;

import ru.websocketserver.domain.incoming.set.SetCommandMessage;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;

public class SetCommandHandler extends SetMessageHandler<SetCommandMessage> {

    private final String handleMessage;

    public SetCommandHandler(DeviceManager deviceManager, PersonManager personManager, String handleMessage) {
        super(SetCommandMessage.class, deviceManager, personManager);
        this.handleMessage = handleMessage;
    }

    @Override
    public String getMessageType() {
        return handleMessage;
    }
}
