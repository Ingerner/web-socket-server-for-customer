package ru.websocketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.websocketserver.domain.entity.DeviceData;

import java.util.Optional;

public interface DeviceDataJpaRepository extends JpaRepository<DeviceData, Long> {

    Optional<DeviceData> findDeviceDataByMac(String mac);

}