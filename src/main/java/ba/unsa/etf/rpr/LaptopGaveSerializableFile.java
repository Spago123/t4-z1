package ba.unsa.etf.rpr;


import java.io.*;
import java.util.ArrayList;

public class LaptopGaveSerializableFile implements LaptopGave{
    private File file;
    private ArrayList<Laptop> laptops;

    public LaptopGaveSerializableFile() throws FileNotFoundException {
        this.file = new File("dat.txt");
        getDateFromFile();
    }
    @Override
    public Laptop addLaptopToList(Laptop laptop) {
        laptops.add(laptop);
        return laptop;
    }

    @Override
    public Laptop addLaptopToFile(Laptop laptop) throws IOException {
        laptops.add(laptop);
        FileOutputStream dat = new FileOutputStream(file);
        ObjectOutputStream stream = new ObjectOutputStream(dat);
        stream.writeObject(laptops);
        dat.close();
        stream.close();
        return laptop;
    }

    @Override
    public Laptop getLaptop(String processor) throws UnknownProcessorException {
        for(Laptop laptop : laptops)
            if (processor.equals(laptop.getProcessor()))
                return laptop;

        throw new UnknownProcessorException(processor);
    }

    @Override
    public void fillTheList(ArrayList<Laptop> laptops) {
        for(Laptop laptop : laptops)
            this.laptops.add(laptop);
    }

    @Override
    public ArrayList<Laptop> getDateFromFile() throws FileNotFoundException {
        try {
            FileInputStream dat = new FileInputStream(file);
            ObjectInputStream stream = new ObjectInputStream(dat);
            this.laptops = (ArrayList<Laptop>) stream.readObject();
        } catch (Exception e){
            this.laptops = new ArrayList<>();
        }
        return this.laptops;
    }
}
