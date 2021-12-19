package entity;

import java.util.Objects;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

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
}
