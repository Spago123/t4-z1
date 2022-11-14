package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopGaveXMLFile implements LaptopGave{

    private File file;
    private ArrayList<Laptop> laptops;

    public LaptopGaveXMLFile(){
        this.file = new File("dat.xml");
        getDateFromFile();
    }

    @Override
    public Laptop addLaptopToList(Laptop laptop) {
        laptops.add(laptop);
        return laptop;
    }

    @Override
    public Laptop addLaptopToFile(Laptop laptop) throws IOException {
        XmlMapper mapper = new XmlMapper();
        this.addLaptopToList(laptop);
        mapper.writeValue(file, this.laptops);
        return laptop;
    }

    @Override
    public Laptop getLaptop(String processor) throws UnknownProcessorException {
        for(Laptop laptop : this.laptops)
            if(processor.equals(laptop.getProcessor()))
                return laptop;

        throw new UnknownProcessorException(processor);
    }

    @Override
    public void fillTheList(ArrayList<Laptop> laptops) throws IOException {
        for(Laptop laptop : laptops)
            this.laptops.add(laptop);
        XmlMapper mapper = new XmlMapper();
        mapper.writeValue(file, this.laptops);
    }

    @Override
    public ArrayList<Laptop> getDateFromFile() {
        XmlMapper mapper = new XmlMapper();
        try{
            this.laptops = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (Exception e){
            this.laptops = new ArrayList<>();
        }
        return this.laptops;
    }
}
