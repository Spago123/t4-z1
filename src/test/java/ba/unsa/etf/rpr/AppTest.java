package ba.unsa.etf.rpr;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void BinaryDatTest() throws IOException, UnknownProcessorException {
        Laptop l = new Laptop("Acer","Gaming",2000.,16,1024,0,"Ryzen 5","Nvidia",15.6);
        LaptopGave writer = new LaptopGaveSerializableFile();
        writer.addLaptopToFile(l);
        assertEquals(2000, writer.getLaptop("Ryzen 5").getPrice());
    }
    @Test
    public void JsonDatTest() throws IOException, UnknownProcessorException {
        Laptop l = new Laptop("Acer","Gaming",2000.,16,1024,0,"Ryzen 5","Nvidia",15.6);
        LaptopGave writer = new LaptopGaveJSONFile();
        writer.addLaptopToFile(l);
        assertEquals(2000, writer.getLaptop("Ryzen 5").getPrice());
    }

    @Test
    public void XmlDatTest() throws IOException, UnknownProcessorException {
        Laptop l = new Laptop("Acer","Gaming",2000.,16,1024,0,"Ryzen 5","Nvidia",15.6);
        LaptopGave writer = new LaptopGaveXMLFile();
        writer.addLaptopToFile(l);
        assertEquals(2000, writer.getLaptop("Ryzen 5").getPrice());
    }

    @Test
    public void ExceptionThrows() throws IOException, UnknownProcessorException {
        Laptop l = new Laptop("Acer","Gaming",2000.,16,1024,0,"Ryzen 5","Nvidia",15.6);
        final LaptopGave writer = new LaptopGaveXMLFile();
        writer.addLaptopToFile(l);
        assertThrows(UnknownProcessorException.class, ()->{
            writer.getLaptop("Unknown");
        });
    }

    /**
     * We use mockito to fake a document where we store laptops
     * @throws IOException
     * @throws UnknownProcessorException
     */
    @Test
    public void MockitoTest() throws IOException, UnknownProcessorException {
        LaptopGaveJSONFile writer = Mockito.mock(LaptopGaveJSONFile.class);
        Laptop l = new Laptop("lenovo", "IdeaPad", 1000, 8, 700, 240, "I7-100", "NVIDIA", 15.6);
        writer.addLaptopToFile(l);
        Mockito.when(writer.getLaptop("NVIDIA")).thenReturn(new Laptop());
        assertEquals(null, writer.getLaptop("NVIDIA").getBrand());
    }
}
