package com.example.demo.entity

import jakarta.presistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Device{
  @Id
  @GeneratedValue(stratergy=GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String status;

  @ManyToOne
  @JoinColumn(name= "room_id")
  @JsonIgnore
  private Room room;

  //Getter and Setters
  pubic Long getID()
  {
    return id;
  }

  public void setId(Long id){
    this.id=id;
  }
  
  public String getName()
  {
    return name;
  }

  public String getStatus()
  {
    return status;
  }

  public void setStatus(String status)
  {
    this.status=status;
  }

  public Room getRoom()
  {
    return room;
  }

  public void setRoom(Room room)
  {
    this.room=room;
  }
}  
  
    
  
  
