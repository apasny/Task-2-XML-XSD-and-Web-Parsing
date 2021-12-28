package parser;

import parser.dom.DeviceDomParser;
import parser.jaxb.DeviceJaxbParser;
import parser.sax.DeviceSaxParser;

public class ParserFactory {

    public Parser create(ParserType parserType) {

        switch (parserType) {
            case DOM:
                return new DeviceDomParser();
            case SAX:
                return new DeviceSaxParser();
            case JAXB:
                return new DeviceJaxbParser();
            default:
                throw new RuntimeException();
        }

    }

}
