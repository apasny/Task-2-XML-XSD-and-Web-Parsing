package parser;

import entity.Device;

import java.util.List;

public class Director {

    private final Parser parser;
    private final XmlValidator xmlValidator;

    public Director(Parser parser, XmlValidator xmlValidator) {
        this.parser = parser;
        this.xmlValidator = xmlValidator;
    }

    public List<Device> parse(String filename) {

        return xmlValidator.validate(filename) ? parser.parse(filename) : null;

    }
}
