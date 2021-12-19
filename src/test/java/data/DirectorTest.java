package data;

import entity.Cpu;
import entity.Details;
import entity.Device;
import entity.GraphicsCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXParseException;
import parser.Parser;
import parser.ParserFactory;
import parser.ParserType;
import parser.XmlValidator;

import java.util.Arrays;
import java.util.List;

public class DirectorTest {

    private final List<Device> expected = Arrays.asList(
            new Cpu("ID123", "i5", 194, "Intel", 6, 4.2, 32,
                    new Details("23145waddwa68746aw1", "132w77-wda42aw-awd251", 2019)),
            new GraphicsCard("ID44", "rtx 2060", 652, "Nvidia", 12, 192, 306,
                    new Details("f65q41fq", "dq6-fqwf1-qw55", 2018))
    );
    private final String validFilePath = "src/test/resources/devices.xml";
    private final String invalidFilePath = "src/test/resources/devicesInvalid.xml";

    @Test
    public void testParseSaxParserShouldReturnTrue() {

        Parser parser = new ParserFactory().create(ParserType.SAX);
        XmlValidator xmlValidator = new XmlValidator();
        Director director = new Director(parser, xmlValidator);

        List<Device> result = director.parse(validFilePath);

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testParseSaxParserShouldThrowDeviceErrorHandler() {

        Parser parser = new ParserFactory().create(ParserType.SAX);
        XmlValidator xmlValidator = new XmlValidator();
        Director director = new Director(parser, xmlValidator);

        SAXParseException exception = Assertions.assertThrows(SAXParseException.class, ()-> director.parse(invalidFilePath));

        Assertions.assertEquals("The end-tag for element type \"name\" must end with a '>' delimiter.",exception.getMessage());

    }

    @Test
    public void testParseDomParserShouldReturnTrue() {

        Parser parser = new ParserFactory().create(ParserType.DOM);
        XmlValidator xmlValidator = new XmlValidator();
        Director director = new Director(parser, xmlValidator);

        List<Device> result = director.parse(validFilePath);

        Assertions.assertEquals(expected, result);

    }
}