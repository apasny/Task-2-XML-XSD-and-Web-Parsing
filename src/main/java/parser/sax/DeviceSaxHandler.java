package parser.sax;

import entity.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DeviceSaxHandler extends DefaultHandler {

    private final String elementCpu = "cpu";
    private final String elementGraphicsCard = "graphicsCard";
    private final String elementDevices = "devices";
    private final String elementDetails = "details";

    private List<Device> devices;
    private Device currentDevice;
    private Cpu currentCpu;
    private GraphicsCard currentGraphicsCard;
    private Details currentDetails;
    private DeviceXmlTag currentXmlTag;

    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) {

        if (qName != null) {

            switch (qName) {
                case elementCpu:
                    currentCpu = new Cpu();
                    currentDevice = currentCpu;
                    currentDevice.setId(attr.getValue(0));
                    break;
                case elementGraphicsCard:
                    currentGraphicsCard = new GraphicsCard();
                    currentDevice = currentGraphicsCard;
                    currentDevice.setId(attr.getValue(0));
                    break;
                case elementDevices:
                    devices = new ArrayList<>();
                case elementDetails:
                    currentDetails = new Details();
                    break;
                default:
                    currentXmlTag = DeviceXmlTag.valueOf(qName.toUpperCase(Locale.ROOT));
            }

        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equals(elementCpu) || qName.equals(elementGraphicsCard)) {
            devices.add(currentDevice);
        } else if (qName.equals(elementDetails)) {
            currentDevice.setDetails(currentDetails);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();
        if (currentXmlTag != null) {
            switch (currentXmlTag) {
                case NAME:
                    currentDevice.setName(data);
                    break;
                case PRICE:
                    currentDevice.setPrice(Double.parseDouble(data));
                    break;
                case MANUFACTURER:
                    currentDevice.setManufacturer(data);
                    break;
                case CORESQUANTITY:
                    currentCpu.setCoresQuantity(Integer.parseInt(data));
                    break;
                case FREQUENCY:
                    currentCpu.setFrequency(Double.parseDouble(data));
                    break;
                case CACHE:
                    currentCpu.setCache(Integer.parseInt(data));
                    break;
                case GRAPHICMEMORY:
                    currentGraphicsCard.setGraphicMemory(Integer.parseInt(data));
                    break;
                case MEMORYBUS:
                    currentGraphicsCard.setGraphicMemoryBus(Integer.parseInt(data));
                    break;
                case BANDWIDTH:
                    currentGraphicsCard.setBandwidth(Integer.parseInt(data));
                    break;
                case SERIALNUMBER:
                    currentDetails.setSerialNumber(data);
                    break;
                case DEVICEID:
                    currentDetails.setDeviceId(data);
                    break;
                case RELEASEDATE:
                    currentDetails.setReleaseDate(Integer.parseInt(data));
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }

}
