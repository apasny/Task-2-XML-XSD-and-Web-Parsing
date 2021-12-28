package parser;

import entity.Device;
import java.util.List;

public interface Parser {
    List<Device> parse(String file);
}
