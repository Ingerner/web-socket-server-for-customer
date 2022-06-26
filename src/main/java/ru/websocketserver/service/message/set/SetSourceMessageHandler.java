package ru.websocketserver.service.message.set;

import org.springframework.stereotype.Service;
import ru.websocketserver.domain.incoming.set.SetSource;
import ru.websocketserver.manager.DeviceManager;
import ru.websocketserver.manager.PersonManager;

import static ru.websocketserver.util.MessageId.SET_SOURCE;

@Service
public class SetSourceMessageHandler extends SetMessageHandler<SetSource> {

    public SetSourceMessageHandler(DeviceManager deviceManager, PersonManager personManager) {
        super(SetSource.class, deviceManager, personManager);
    }

    @Override
    public String getMessageType() {
        return SET_SOURCE;
    }
}
