package parser;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import java.io.File;
import java.io.IOException;

public class XmlValidator {

    public boolean validate(String file) {

        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String xsdSchema = "src/test/resources/devices.xsd";

        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdSchema);

        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(file);
            validator.setErrorHandler(new DeviceErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException exception) {
            exception.printStackTrace();
        }

        return true;
    }

}
