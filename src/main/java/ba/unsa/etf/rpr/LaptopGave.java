package ba.unsa.etf.rpr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface that defines the ways of working with the laptop class
 */
public interface LaptopGave {
    Laptop addLaptopToList(Laptop laptop);
    Laptop addLaptopToFile(Laptop laptop) throws IOException;
    Laptop getLaptop(String processor) throws UnknownProcessorException;
    void fillTheList(ArrayList<Laptop> laptops) throws IOException;
    ArrayList<Laptop> getDateFromFile() throws FileNotFoundException;
}
