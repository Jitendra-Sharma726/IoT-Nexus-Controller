package com.example.demo.service;


import com.example.demo.entity.Device;
import com.example.demo.entity.Room;
import com.example.demo.respository.DeviceRepository;
import com.example.demo.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IoTService{
private final RoomRepository roomRepository;
private final DeviceRepository deviceRepository;

  
//constructor Injection for Repositories
public IoTService(RoomRepository roomRepository, DeviceRepository deviceRepository){
  this.roomRepository = roomRepository;
  this.deviceRepository = deviceRepository;
}

public Room createRoom(Room room){
    return roomRepository.save(room);
}

public List<Room> getAllRooms(){
  return roomRepository.findAll()
}
  
//Add a Device to a Specific Room
public Device addDevice(Long roomId, Device device) {

  // Try to find the Room in the database by its ID
  var roomOptional = roomRepository.findById(roomId);

  //Check if the Room actually exists
  if (roomOptional.isPresent()) {

    //Get the actual Room object out of the Optional Container
    Room foundRoom = roomOptional.get();

    //LINK the Device to the Room(This sets the Foriegn Key!)
    device.setRoom(foundRoom);

    //Save the Device to the database and return it
    return deviceRepository.save(device);
  } else {
    // If the Room wasn't found, stop and throw an error
      throw new RuntimeException("Room not found with id: " + roomId);
  }
}

  public void deleteRoom(Long roomId){
    roomRepository.deleteById(roomId);
  }

  public void deleteDevice(Long deviceId){
    //Check if it exists before deleteing
    if(deviceRepository.existsById(deviceId)) {
      deviceRepository.deleteById(deviceId);
    } else {
      throw new RuntimeException("Device not found with id: " + deviceId);
    }
  }
}











  
    
  
  
  
  


  




  
  
    
  
