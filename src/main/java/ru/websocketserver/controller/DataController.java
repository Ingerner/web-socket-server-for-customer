package ru.websocketserver.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.websocketserver.domain.entity.DeviceData;
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
}
