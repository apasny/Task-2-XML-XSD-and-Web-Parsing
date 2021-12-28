package parser.sax;

import entity.Device;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import parser.DeviceErrorHandler;
import parser.Parser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class DeviceSaxParser implements Parser {

    private final DeviceSaxHandler deviceSaxHandler = new DeviceSaxHandler();
    private final DeviceErrorHandler deviceErrorHandler = new DeviceErrorHandler();
    private XMLReader xmlReader;

    public List<Device> parse(String filename) {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            xmlReader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        xmlReader.setContentHandler(deviceSaxHandler);
        xmlReader.setErrorHandler(deviceErrorHandler);

        try {
            xmlReader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return deviceSaxHandler.getDevices();
    }

}
