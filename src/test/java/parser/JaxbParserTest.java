package parser;

import entity.Cpu;
import entity.Details;
import entity.Device;
import entity.GraphicsCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import parser.jaxb.DeviceJaxbParser;

import java.util.Arrays;
import java.util.List;

public class JaxbParserTest {

    @Test
    public void testParseJaxbParserShouldReturnTrue() {

        //given
        final List<Device> expected = Arrays.asList(
                new Cpu("ID123", "i5", 194, "Intel", 6, 4.2, 32,
                        new Details("23145waddwa68746aw1", "132w77-wda42aw-awd251", 2019)),
                new GraphicsCard("ID44", "rtx 2060", 652, "Nvidia", 12, 192, 306,
                        new Details("f65q41fq", "dq6-fqwf1-qw55", 2018))
        );
        final String validFilePath = "src/test/resources/devices.xml";

        Parser parser = new DeviceJaxbParser();

        //when
        List<Device> result = parser.parse(validFilePath);

        //then
        Assertions.assertEquals(expected, result);

    }
}
