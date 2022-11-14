package ba.unsa.etf.rpr;

import java.io.Serializable;
import java.util.Objects;

/**
 * Class Laptop represents an ordinary laptop
 */
public class Laptop implements Serializable {
    private String brand;
    private String model;
    private double price;
    private int RAM;
    private int HDD;
    private int SDD;
    private String processor;
    private String graphicalCard;
    private double displaySize;

    public Laptop(){
    }

    public Laptop(
            String brand, String model, double price, int RAM, int HDD, int SDD, String processor, String graphicalCard,
            double displaySize
    ) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.RAM = RAM;
        this.HDD = HDD;
        this.SDD = SDD;
        this.processor = processor;
        this.graphicalCard = graphicalCard;
        this.displaySize = displaySize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getHDD() {
        return HDD;
    }

    public void setHDD(int HDD) {
        this.HDD = HDD;
    }

    public int getSDD() {
        return SDD;
    }

    public void setSDD(int SDD) {
        this.SDD = SDD;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getGraphicalCard() {
        return graphicalCard;
    }

    public void setGraphicalCard(String graphicalCard) {
        this.graphicalCard = graphicalCard;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(double displaySize) {
        this.displaySize = displaySize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", RAM=" + RAM +
                ", HDD=" + HDD +
                ", SDD=" + SDD +
                ", processor='" + processor + '\'' +
                ", graphicalCard='" + graphicalCard + '\'' +
                ", displaySize=" + displaySize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.price, price) == 0 && RAM == laptop.RAM && HDD == laptop.HDD && SDD == laptop.SDD && Double.compare(laptop.displaySize, displaySize) == 0 && brand.equals(laptop.brand) && model.equals(laptop.model) && processor.equals(laptop.processor) && graphicalCard.equals(laptop.graphicalCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, price, RAM, HDD, SDD, processor, graphicalCard, displaySize);
    }
}
