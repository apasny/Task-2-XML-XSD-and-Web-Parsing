package parser;

import entity.Device;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.List;

public class Director {

    private final Parser parser;
    private final XmlValidator xmlValidator;
    private List<Device> deviceList;

    public Director(Parser parser, XmlValidator xmlValidator) {
        this.parser = parser;
        this.xmlValidator = xmlValidator;
    }

    public List<Device> parse(String filename) {

        try {
            deviceList = xmlValidator.validate(filename) ? parser.parse(filename) : null;
        } catch (SAXException | IOException exception) {
            exception.printStackTrace();
        }

        return deviceList;

    }
}
