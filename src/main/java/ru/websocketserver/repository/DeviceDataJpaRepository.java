package ru.websocketserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.websocketserver.domain.entity.DeviceData;

public interface DeviceDataJpaRepository extends JpaRepository<DeviceData, Long> {

}