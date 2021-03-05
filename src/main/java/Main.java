import service.ImportCsv;
import service.PetClinicService;
import utility.HibernateUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        PetClinicService.showOption();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.println(option);

        HibernateUtil.shutdown();

//        Scanner scanner = new Scanner(System.in);
//
//  ImportCsv.importCsvPet();

    }
}