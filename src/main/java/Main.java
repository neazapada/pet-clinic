import repository.PetDao;
import service.ExportCsv;
import service.ImportCsv;
import service.PetClinicService;
import utility.HibernateUtil;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        PetClinicService.showOption();

//        HibernateUtil.shutdown();


    }
}