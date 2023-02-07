package ru.websocketserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.websocketserver.domain.entity.DeviceData;
import ru.websocketserver.domain.message.outgoing.DataOutgoing;
import ru.websocketserver.repository.DeviceDataJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceDataService {

    private final DeviceDataJpaRepository repository;

    public DeviceData saveDeviceData(DataOutgoing data) {
        final DeviceData dataForSave = DeviceData.builder()
                .mac(data.getDeviceMac())
                .temp(data.getTemp())
                .backlight(data.getBacklight())
                .volume(data.getVolume())
                .workingHours(data.getWorkingHours())
                .build();
        return repository.save(dataForSave);
    }

    public List<DeviceData> findAllByMac(String mac) {
        return repository.findAllDeviceDataByMac(mac);
    }



}
