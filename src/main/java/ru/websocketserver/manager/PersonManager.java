package ru.websocketserver.manager;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.websocketserver.exception.ProcessException;
import ru.websocketserver.service.Person;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ru.websocketserver.util.ErrorMessage.PERSON_DOES_NOT_EXIST;

@Service
@RequiredArgsConstructor
public class PersonManager {

    private final Map<String, Person> personsBySessionId = new ConcurrentHashMap<>();
    private final SubscribeManager subscribeManager;

    public Person getBySessionId(@NonNull String sessionId) {
        if (!personsBySessionId.containsKey(sessionId)) {
            throw new ProcessException(PERSON_DOES_NOT_EXIST);
        }
        return personsBySessionId.get(sessionId);
    }

    public void register(@NonNull Person person) {
        String sessionId = person.getSession().getId();
        personsBySessionId.put(sessionId, person);
        subscribeManager.subscribe(person);
    }

    public void deleteBySessionId(@NonNull String sessionId) {
        Person deletedPerson = personsBySessionId.remove(sessionId);
        if (deletedPerson != null) {
            subscribeManager.unsubscribePersonForAll(deletedPerson);
        }
    }

}