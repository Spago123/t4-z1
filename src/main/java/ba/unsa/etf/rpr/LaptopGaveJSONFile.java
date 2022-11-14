package ba.unsa.etf.rpr;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LaptopGaveJSONFile implements LaptopGave{

    private File file;
    private ArrayList<Laptop> laptops;

    public LaptopGaveJSONFile(){
        this.file = new File("dat.json");
        getDateFromFile();
    }

    @Override
    public Laptop addLaptopToList(Laptop laptop) {
        laptops.add(laptop);
        return laptop;
    }

    @Override
    public Laptop addLaptopToFile(Laptop laptop) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
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
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, this.laptops);
    }

    @Override
    public ArrayList<Laptop> getDateFromFile() {
        ObjectMapper mapper = new ObjectMapper();
        try{
            this.laptops = mapper.readValue(file, new TypeReference<ArrayList<Laptop>>() {});
        } catch (Exception e){
            this.laptops = new ArrayList<>();
        }
        return this.laptops;
    }
}
