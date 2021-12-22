package parser.jaxb;

import entity.Cpu;
import entity.Device;
import entity.Devices;
import entity.GraphicsCard;
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

            JAXBContext jaxbContext = JAXBContext.newInstance(Devices.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            Devices devicesList = (Devices) jaxbUnmarshaller.unmarshal(xmlSource);

            devices = devicesList.getListOfDevices();

            LOGGER.info(devices);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return devices;

    }

}

