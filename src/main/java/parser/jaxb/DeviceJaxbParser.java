package parser.jaxb;

import entity.Device;
import parser.Parser;

import java.util.List;

public class DeviceJaxbParser implements Parser {

    private final DeviceJaxbHandler deviceJaxbHandler = new DeviceJaxbHandler();

    @Override
    public List<Device> parse(String file) {

        return deviceJaxbHandler.getDevices(file);
    }

}
