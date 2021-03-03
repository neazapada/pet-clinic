package service;

import com.opencsv.CSVReader;
import model.Pet;
import repository.PetDao;

import java.io.FileReader;
import java.io.IOException;

public class ImportCSV {
    /**canis, azi, FALSE, ion*/
    public static void importCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\gabri\\Desktop\\curs java\\res\\pet1.csv"));
        //Reading the contents of the csv file
        StringBuffer buffer = new StringBuffer();
        String[] line;
        while ((line = reader.readNext()) != null) {

                PetDao petDao = new PetDao();
                Pet pet = new Pet();

                /**[canis, azi, FALSE, ion]*/
                pet.setRace(line[0]);
                pet.setBirthDate(line[1]);
                pet.setVaccinated(Boolean.parseBoolean(line[2]));
                pet.setOwnerName(line[3]);
                petDao.createPet(pet);
                System.out.print(line + " ");

            System.out.println(" ");
        }

    }

}
