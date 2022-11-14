package ba.unsa.etf.rpr;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, UnknownProcessorException {
        Laptop l1 = new Laptop();
        Laptop l2 = new Laptop("Acer","Gaming",2000.,16,1024,0,"Ryzen 5","Nvidia",15.6);
        LaptopGave laptops = new LaptopGaveSerializableFile();
        ArrayList<Laptop> laptops1 = new ArrayList<>();
        laptops1.add(l1);
        laptops1.add(l2);
        laptops.addLaptopToFile(l1);
        laptops.addLaptopToFile(l2);
        System.out.println(laptops.getDateFromFile());
        System.out.println(laptops.getLaptop("Ryzen 5").toString());
    }
}
