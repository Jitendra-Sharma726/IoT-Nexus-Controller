package com.example.demo.controller;

import com.example.demo.entity.Device;
import com.example.demo.entity.Room;
import com.example.demo.service.IoTService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
  public class IoTController {
    private final IoTService iotService;

    public IoTController(IoTService iotService){
      this.iotservice = iotService;
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room) {
      return iotService.createRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms(){
      return iotService.getAllRooms();
    }

    @PostMapping("/rooms/{roomId}/devices")
    public Device addDeviceToRoom(@PathVariable Long roomId, @RequestBody Device device){
      return iotService.addDevice(roomId, device);

    @DeleteMapping("/rooms/{id}")
      public String deleteRoom(@PathVariable Long id) {
            iotService.deleteRoom(id);
            return "Room deleted sucessfully.";
    }

    @DeleteMapping("/devices/{id}")
      public String deleteDevice(@PathVariable Long id) {
             iotService.deleteDevice(id);
             return "Device deleted successfully.";
    }
}
      
      

