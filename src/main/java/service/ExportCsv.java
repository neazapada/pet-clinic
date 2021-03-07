package service;

import model.Consult;
import model.Owner;
import model.Pet;
import model.Veterinarian;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ExportCsv {

    public static final String CSV_SEPARATOR = ",";
    Scanner scanner = new Scanner(System.in);


    public void exportCsvPet(List<Pet> pets) {
        try {
            System.out.println("Please enter name of file");
            String numeFisier = scanner.next() + ".csv";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(numeFisier), "UTF-8"));
            for (Pet pet : pets) {
                String oneLine = pet.getIdPet() +
                        CSV_SEPARATOR +
                        pet.getRace() +
                        CSV_SEPARATOR +
                        pet.getBirthDate() +
                        CSV_SEPARATOR +
                        pet.isVaccinated() +
                        CSV_SEPARATOR +
                        pet.getOwner().getIdOwner();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Pet exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
    public void exportCsvVet(List<Veterinarian> veterinarians) {
        try {
            System.out.println("Please enter name of file");
            String numeFisier = scanner.next() + ".csv";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(numeFisier), "UTF-8"));
            for (Veterinarian veterinarian : veterinarians) {
                String oneLine = veterinarian.getIdVeterinarian() +
                        CSV_SEPARATOR +
                        veterinarian.getFirstName() +
                        CSV_SEPARATOR +
                        veterinarian.getLastName() +
                        CSV_SEPARATOR +
                        veterinarian.getAddress() +
                        CSV_SEPARATOR +
                        veterinarian.getSpeciality();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Veterinarian exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
    public void exportCsvConsult(List<Consult> consults) {
        try {
            System.out.println("Please enter name of file");
            String numeFisier = scanner.next() + ".csv";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(numeFisier), "UTF-8"));
            for (Consult consult : consults) {
                String oneLine = consult.getIdConsult() +
                        CSV_SEPARATOR +
                        consult.getDate() +
                        CSV_SEPARATOR +
                        consult.getDescription() +
                        CSV_SEPARATOR +
                        consult.getVeterinarian().getIdVeterinarian() +
                        CSV_SEPARATOR +
                        consult.getPet().getIdPet();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Consult exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public void exportCsvOwner(List<Owner> owners) {
        try {
            System.out.println("Please enter name of file");
            String numeFisier = scanner.next() + ".csv";
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(numeFisier), "UTF-8"));
            for (Owner owner : owners) {
                String oneLine = owner.getIdOwner() +
                        CSV_SEPARATOR +
                        owner.getFirstName() +
                        CSV_SEPARATOR +
                        owner.getLastName() +
                        CSV_SEPARATOR +
                        owner.getPhoneNumber() +
                        CSV_SEPARATOR +
                        owner.getEmail();
                bw.write(oneLine);
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("Owner exported to .csv!");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }
}
