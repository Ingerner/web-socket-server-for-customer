package ru.websocketserver.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.websocketserver.domain.entity.DeviceDataTurning;
import ru.websocketserver.service.DeviceTurningService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/device-turning")
public class DataTurningController {
   private final DeviceTurningService turningService;

   @GetMapping("/{mac}")
   public ResponseEntity<List<DeviceDataTurning>> findAllByMac(@PathVariable("mac") String mac) {
      return ResponseEntity.ok(
              turningService.turningFindAllByMac(mac));
   }
}
