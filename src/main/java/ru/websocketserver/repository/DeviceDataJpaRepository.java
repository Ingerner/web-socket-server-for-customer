package ru.websocketserver.repository;

import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import ru.websocketserver.domain.entity.DeviceData;

import java.util.List;

public interface DeviceDataJpaRepository extends JpaRepository<DeviceData, Long> {

    List<DeviceData> findAllDeviceDataByMac(@NonNull String mac,
                                            @NonNull Pageable pageable);

    Page<DeviceData> findAll(@NonNull Pageable pageable);

     List<DeviceData> deleteByMac(String mac);

}