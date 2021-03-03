package service;

import com.opencsv.CSVReader;
import model.Pet;
import repository.PetDao;

import java.io.FileReader;
import java.io.IOException;

public class ImportCSV {
    public static void importCSV() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("C:\\Users\\gabri\\Desktop\\curs java\\res\\pet.csv"));
        //Reading the contents of the csv file
        StringBuffer buffer = new StringBuffer();
        String line[];
        while ((line = reader.readNext()) != null) {
            for (int i = 0; i < line.length; i++) {
//                PetDao petDao = new PetDao();
//                Pet pet = new Pet(line[i]);
//                petDao.createPet(pet);
                System.out.print(line[i] + " ");
            }
            System.out.println(" ");
        }

    }
}
