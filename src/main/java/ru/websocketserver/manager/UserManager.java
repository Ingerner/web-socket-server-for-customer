package ru.websocketserver.manager;

import ru.websocketserver.service.Person;

import java.util.Map;

public class UserManager implements Manager {

    private Map<String, Person> personsBySessionId;

    @Override
    public void register() {

    }

}