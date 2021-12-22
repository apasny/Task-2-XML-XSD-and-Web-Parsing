package entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlType(name = "cpu")
public class Cpu extends Device {

    private int coresQuantity;
    private double frequency;
    private int cache;

    public Cpu() {

    }

    public Cpu(String id, String name, double price, String manufacturer, int coresQuantity, double frequency, int cache, Details details) {
        super(id, name, price, manufacturer, details);
        this.coresQuantity = coresQuantity;
        this.frequency = frequency;
        this.cache = cache;
    }

    @XmlElement(name = "coresQuantity")
    public int getCoresQuantity() {
        return coresQuantity;
    }

    public void setCoresQuantity(int coresQuantity) {
        this.coresQuantity = coresQuantity;
    }

    @XmlElement(name = "frequency")
    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    @XmlElement(name = "cache")
    public int getCache() {
        return cache;
    }

    public void setCache(int cache) {
        this.cache = cache;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cpu cpu = (Cpu) o;
        return coresQuantity == cpu.coresQuantity && Double.compare(cpu.frequency, frequency) == 0 && cache == cpu.cache;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coresQuantity, frequency, cache);
    }
}
