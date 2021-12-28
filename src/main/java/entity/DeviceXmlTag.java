package entity;

public enum DeviceXmlTag {

    ID("id"),
    NAME("name"),
    PRICE("price"),
    MANUFACTURER("manufacturer"),
    CORESQUANTITY("coresQuantity"),
    FREQUENCY("frequency"),
    CACHE("cache"),
    SERIALNUMBER("serialNumber"),
    DEVICEID("deviceID"),
    RELEASEDATE("releaseDate"),
    GRAPHICMEMORY("graphicMemory"),
    MEMORYBUS("memoryBus"),
    BANDWIDTH("bandwidth");

    private final String value;

    DeviceXmlTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
