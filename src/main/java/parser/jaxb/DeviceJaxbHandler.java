package parser.jaxb;

import entity.Device;
import entity.Devices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DeviceJaxbHandler {

    private static final Logger LOGGER = LogManager.getLogger(DeviceJaxbHandler.class);

    private List<Device> devices = new ArrayList<>();

    public List<Device> getDevices(String file) {

        File xmlSource = new File(file);

        try {

            JAXBContext context = JAXBContext.newInstance(Devices.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Devices devicesList = (Devices) unmarshaller.unmarshal(xmlSource);

            devices = devicesList.getListOfDevices();

            LOGGER.info(devices.get(0).toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return devices;

    }

}

