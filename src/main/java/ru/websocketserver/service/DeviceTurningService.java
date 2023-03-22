package ru.websocketserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.websocketserver.repository.DeviceDataJpaRepository;

@Service
@RequiredArgsConstructor
public class DeviceTurningService {

    private final DeviceDataJpaRepository repositoryTurning;
}

