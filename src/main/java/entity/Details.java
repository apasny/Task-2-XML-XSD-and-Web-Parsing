package entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlType(name = "details", namespace = "http://www.example.com/devices")
public class Details {

    private String serialNumber;
    private String deviceId;
    private int releaseDate;

    public Details() {

    }

    public Details(String serialNumber, String deviceId, int releaseDate) {
        this.serialNumber = serialNumber;
        this.deviceId = deviceId;
        this.releaseDate = releaseDate;
    }

    @XmlElement(name = "serialNumber", namespace = "http://www.example.com/devices")
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @XmlElement(name = "deviceID", namespace = "http://www.example.com/devices")
    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @XmlElement(name = "releaseDate", namespace = "http://www.example.com/devices")
    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Details details = (Details) o;
        return releaseDate == details.releaseDate && Objects.equals(serialNumber, details.serialNumber) && Objects.equals(deviceId, details.deviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialNumber, deviceId, releaseDate);
    }

    @Override
    public String toString() {
        return "Details{" +
                "serialNumber='" + serialNumber + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
