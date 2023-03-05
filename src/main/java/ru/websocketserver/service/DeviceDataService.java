package ru.websocketserver.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import ru.websocketserver.domain.entity.DeviceData;
import ru.websocketserver.domain.message.outgoing.DataOutgoing;
import ru.websocketserver.repository.DeviceDataJpaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceDataService {

    private final DeviceDataJpaRepository repository;

    public DeviceData saveDeviceData(@NonNull DataOutgoing data) {
        final DeviceData dataForSave = DeviceData.builder()
                .mac(data.getDeviceMac())
                .temp(data.getTemp())
                .backlight(data.getBacklight())
                .volume(data.getVolume())
                .workingHours(data.getWorkingHours())
                .build();
        return repository.save(dataForSave);
    }

    public List<DeviceData> findAllByMac(@NonNull String mac) {
        return repository.findAllDeviceDataByMac(mac);
    }


    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     * DeviceData.Fields.dateTime - сортировка по дате (dateTime)
     */
    public Page<DeviceData> getAllDevicesData(@NonNull Integer pageNum, @NonNull Integer pageSize) {
        return repository.findAll(
                PageRequest.of(
                        pageNum,
                        pageSize,
                        Sort.by("id").descending()
                )
        );
    }

    @Transactional
    public List<DeviceData> deleteByMac(String mac) {
        return repository.deleteByMac(mac);
    }

    //TODO: удалить
    public DeviceData create(@NonNull DeviceData data) {
        return repository.save(data);
    }

}
