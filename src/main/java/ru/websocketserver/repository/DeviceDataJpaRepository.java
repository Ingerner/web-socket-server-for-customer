package ru.websocketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.websocketserver.domain.entity.DeviceData;

import java.util.List;
import java.util.Optional;

public interface DeviceDataJpaRepository extends JpaRepository<DeviceData, Long> {

    List<DeviceData> findAllDeviceDataByMac(String mac);

    @Query("select d.mac from DeviceData d")
    List<String> findAllMac();

}