package parser.jaxb;

import entity.Device;
import entity.Devices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class DeviceJaxbHandler {

    public List<Device> getDevices(String file) throws JAXBException {

        File xmlSource = new File(file);

        JAXBContext context = JAXBContext.newInstance(Devices.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Devices devicesList = (Devices) unmarshaller.unmarshal(xmlSource);

        return devicesList.getListOfDevices();

    }

}

