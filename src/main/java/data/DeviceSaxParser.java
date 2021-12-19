package data;

import entity.Device;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class DeviceSaxParser implements Parser {

    private final DeviceHandler deviceHandler = new DeviceHandler();
    private XMLReader xmlReader;

    public DeviceSaxParser() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            xmlReader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        xmlReader.setContentHandler(deviceHandler);
    }

    public List<Device> parse(String filename) {
        try {
            xmlReader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return deviceHandler.getDevices();
    }

}
