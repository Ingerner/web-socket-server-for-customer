package ru.websocketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.websocketserver.domain.entity.DeviceDataTurning;

import java.util.List;

public interface DeviceTurningJpaRepository extends JpaRepository<DeviceDataTurning, Long> {
        List<DeviceDataTurning> findAllByMac(String mac);
}
