package ru.websocketserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.websocketserver.domain.entity.DeviceDataTurning;
import ru.websocketserver.domain.message.outgoing.DataTurningOutgoing;
import ru.websocketserver.repository.DeviceDataJpaRepository;
import ru.websocketserver.repository.DeviceTurningJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceTurningService {

    private final DeviceTurningJpaRepository repositoryTurning;

    public DeviceDataTurning saveDeviceDataTurning(@NonNull DataTurningOutgoing dataTurningOutgoing) {
        final DeviceDataTurning dataTurning = DeviceDataTurning.builder()
                .mac(dataTurningOutgoing.getDeviceMac())
                .process(dataTurningOutgoing.getProcess())
                .dateTime(dataTurningOutgoing.getDateTime())
                .build();
        return repositoryTurning.save(dataTurning);
    }

    public List<DeviceDataTurning> turningFindAllByMac(String mac) {
        return repositoryTurning.findAllByMac(mac);
    }
}

