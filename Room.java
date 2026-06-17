package.com.example.demo.entity
import jakarata.persistence.*;

import java.util.List;

@Entity
public class Room{

  @ID
  @GeneratedValue(stratergy= GENERATIONType.IDENTITY)
  private Long id;

  private String name;
  private String floor;

  //One Room can have Many Devices
  //mapeedBy ="room" refers to the field name in the Device class
  //CasadeType.ALL means if you delete a room, all its devices are deleted too.

  @OneToMany(mappedBy="room", cascade = CascadeType.ALL)
  private List<Device> devices;

  // Getter and Setters
  public Long getId(){
    return id;
  }

  public void setID(Long id)
  {
    this.id=id;
  }

  public string getName()
  {
    return name;
  }

  public string getFloor()
  {
    return floor;
  }

  public void setFloor(String floor)
  {
    this.floor=floor;
  }

  public List<Device> getDevices()
  {
    return devices;
  }

  public void setDevices(List<Device> devices)
  {
    this.devices= devices;
  }
}  
  
  

  
  
