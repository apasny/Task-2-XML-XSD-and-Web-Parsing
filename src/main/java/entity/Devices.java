package entity;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "devices", namespace = "http://www.example.com/devices")
@XmlAccessorType(XmlAccessType.FIELD)
public class Devices {

    @XmlElements
            ({
                    @XmlElement(name = "cpu", type = Cpu.class),
                    @XmlElement(name = "graphicsCard", type = GraphicsCard.class)
            })
    private List<Device> devicesList = null;

    public Devices() {
    }

    public Devices(List<Device> vehicleCollection) {
        this.devicesList = vehicleCollection;
    }


    public List<Device> getListOfDevices()
    {
        return devicesList;
    }

    public void setListOfDevices(List<Device> listOfDevices)
    {
        this.devicesList = listOfDevices;
    }

}
