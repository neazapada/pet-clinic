import model.Veterinarian;
import repository.VeterinarianDao;
import service.ImportCSV;
import service.PetClinicService;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        PetClinicService.showOption();
        Scanner scanner = new Scanner(System.in);
//        ImportCSV.importCSV();

    }
}