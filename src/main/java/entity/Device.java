package entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlSeeAlso({Cpu.class, GraphicsCard.class})
public abstract class Device {

    private String id;
    private String name;
    private double price;
    private String manufacturer;
    private Details details;

    public Device() {
    }

    public Device(String id, String name, double price, String manufacturer, Details details) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
        this.details = details;
    }

    @XmlElement(name = "details", namespace = "http://www.example.com/devices")
    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "name", namespace = "http://www.example.com/devices")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "price", namespace = "http://www.example.com/devices")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @XmlElement(name = "manufacturer", namespace = "http://www.example.com/devices")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Double.compare(device.price, price) == 0 && Objects.equals(id, device.id) && Objects.equals(name, device.name) && Objects.equals(manufacturer, device.manufacturer) && Objects.equals(details, device.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, manufacturer, details);
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                ", details=" + details.toString() +
                '}';
    }
}
