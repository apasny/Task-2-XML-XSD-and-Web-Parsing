package parser.jaxb;

import entity.Device;
import parser.Parser;

import javax.xml.bind.JAXBException;
import java.util.List;

public class DeviceJaxbParser implements Parser {

    private final DeviceJaxbHandler deviceJaxbHandler = new DeviceJaxbHandler();

    @Override
    public List<Device> parse(String file) {

        try {
            return deviceJaxbHandler.getDevices(file);
        } catch (JAXBException exception) {
            exception.printStackTrace();
        }

        return null;
    }

}
