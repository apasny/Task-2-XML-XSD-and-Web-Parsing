package parser.dom;

import entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DeviceDomHandler {

    private final String elementCpu = "cpu";
    private final String elementGraphicsCard = "graphicsCard";
    private final String elementDetails = "details";
    private final List<Device> devices = new ArrayList<>();

    private Device currentDevice;

    public List<Device> getDevices(Document document) {

        parseListDevices(document);

        return devices;
    }

    private void parseListDevices(Document document) {

        Element root = document.getDocumentElement();
        NodeList cpuList = root.getElementsByTagName(elementCpu);
        NodeList graphicsCardList = root.getElementsByTagName(elementGraphicsCard);

        addDevice(cpuList);
        addDevice(graphicsCardList);

    }

    private Device parseDevice(Element element) {

        switch (element.getTagName()) {
            case elementCpu:
                Cpu currentCpu = new Cpu();
                currentDevice = currentCpu;
                int coresQuantity = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.CORESQUANTITY.getValue()));
                double frequency = Double.parseDouble(getElementTextContent(element, DeviceXmlTag.FREQUENCY.getValue()));
                int cache = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.CACHE.getValue()));
                currentCpu.setCoresQuantity(coresQuantity);
                currentCpu.setFrequency(frequency);
                currentCpu.setCache(cache);
                break;
            case elementGraphicsCard:
                GraphicsCard currentGraphicsCard = new GraphicsCard();
                currentDevice = currentGraphicsCard;
                int graphicMemory = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.GRAPHICMEMORY.getValue()));
                int memoryBus = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.MEMORYBUS.getValue()));
                int bandwidth = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.BANDWIDTH.getValue()));
                currentGraphicsCard.setGraphicMemory(graphicMemory);
                currentGraphicsCard.setGraphicMemoryBus(memoryBus);
                currentGraphicsCard.setBandwidth(bandwidth);
                break;
        }

        currentDevice.setId(element.getAttribute(DeviceXmlTag.ID.getValue()));
        currentDevice.setName(getElementTextContent(element, DeviceXmlTag.NAME.getValue()));
        int price = Integer.parseInt(getElementTextContent(element, DeviceXmlTag.PRICE.getValue()));
        currentDevice.setPrice(price);
        currentDevice.setManufacturer(getElementTextContent(element, DeviceXmlTag.MANUFACTURER.getValue()));

        Details details = new Details();
        Element detailsElement = (Element) element.getElementsByTagName(elementDetails).item(0);
        details.setSerialNumber(getElementTextContent(detailsElement, DeviceXmlTag.SERIALNUMBER.getValue()));
        details.setDeviceId(getElementTextContent(detailsElement, DeviceXmlTag.DEVICEID.getValue()));
        int releaseDate = Integer.parseInt(getElementTextContent(detailsElement, DeviceXmlTag.RELEASEDATE.getValue()));
        details.setReleaseDate(releaseDate);
        currentDevice.setDetails(details);

        return currentDevice;
    }

    private void addDevice(NodeList nodeList) {

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element deviceElement = (Element) nodeList.item(i);
            currentDevice = parseDevice(deviceElement);
            devices.add(currentDevice);
        }

    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }

}
