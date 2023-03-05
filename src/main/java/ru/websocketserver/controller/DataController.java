package ru.websocketserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.websocketserver.domain.entity.DeviceData;
import ru.websocketserver.domain.response.DeviceDataResponse;
import ru.websocketserver.service.DeviceDataService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device-data")
public class DataController {

    private final DeviceDataService service;

    @GetMapping("/{mac}")
    public ResponseEntity<List<DeviceData>> findAll(@PathVariable("mac") String mac) {
        return ResponseEntity.ok(
                service.findAllByMac(mac)
        );
    }

    @GetMapping("/db")
    public ResponseEntity<DeviceDataResponse> showDeviceData(
            @RequestParam("pageNum") Integer pageNum,
            @RequestParam("pageSize") Integer pageSize
    ) {
        Page<DeviceData> page = service.getAllDevicesData(pageNum, pageSize);
        return ResponseEntity.ok(
                DeviceDataResponse.builder()
                        .data(page.getContent())
                        .pageSize(page.getSize())
                        .pageNum(page.getNumber())
                        .totalPages(page.getTotalPages())
                        .build()
        );
    }

    @DeleteMapping("/{mac}")
    public ResponseEntity <List<DeviceData>> deleteDeviceData(@PathVariable String mac) {
         return ResponseEntity.ok(
                 service.deleteByMac(mac)
         );
    }

/**
    //TODO: удалить
    @PostMapping
    public ResponseEntity<DeviceData> create(
            @RequestBody DeviceData data
    ) {
        return ResponseEntity.ok(
                service.create(data)
        );
    }
 */

}
