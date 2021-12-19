package parser;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class DeviceErrorHandler implements ErrorHandler {

    private static final Logger LOGGER = LogManager.getLogger(DeviceErrorHandler.class);

    @Override
    public void warning(SAXParseException exception) {
        LOGGER.warn(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        LOGGER.error(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) {
        LOGGER.fatal(getLineColumnNumber(exception) + " - " + exception.getMessage());
    }

    private String getLineColumnNumber(SAXParseException exception) {
        return exception.getLineNumber() + " : " + exception.getColumnNumber();
    }
}
