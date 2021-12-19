package parser.dom;

import entity.Device;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import parser.Parser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class DeviceDomParser implements Parser {

    private final DeviceDomHandler deviceDomHandler = new DeviceDomHandler();
    private DocumentBuilder documentBuilder;
    private Document document;

    public DeviceDomParser() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Device> parse(String file) {

        try {
            document = documentBuilder.parse(file);
            document.normalize();
        } catch (SAXException | IOException exception) {
            exception.printStackTrace();
        }

        return deviceDomHandler.getDevices(document);
    }
}
