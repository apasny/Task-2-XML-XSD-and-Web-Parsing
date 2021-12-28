package parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

public class XmlValidatorTest {

    @Test
    public void testValidateShouldReturnTrueIfFileCorrect() throws SAXException, IOException {

        //given
        String validFilePath = "src/test/resources/devices.xml";
        XmlValidator xmlValidator = new XmlValidator();

        //when
        boolean result = xmlValidator.validate(validFilePath);

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void testValidateShouldThrowsExceptionIfFileIncorrect() {

        //given
        String invalidFilePath = "src/test/resources/devicesInvalid.xml";
        XmlValidator xmlValidator = new XmlValidator();

        //when
        Throwable exception = Assertions.assertThrows(SAXException.class, () -> xmlValidator.validate(invalidFilePath));

        //then
        Assertions.assertEquals("The end-tag for element type \"name\" must end with a '>' delimiter.", exception.getMessage());
    }

}
