package intern1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class one {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String fileName = "sample.txt";

        int choice;

        do {
            System.out.println("\n===== FILE HANDLING UTILITY =====");
            System.out.println("1. Create / Write File");
            System.out.println("2. Read File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // WRITE OPERATION
                case 1:
                    try {
                        FileWriter writer = new FileWriter(fileName);

                        System.out.print("Enter text to write into file: ");
                        String data = sc.nextLine();

                        writer.write(data + "\n");
                        writer.close();

                        System.out.println("File created and data written successfully.");

                    } catch (IOException e) {
                        System.out.println("Error while writing file.");
                        e.printStackTrace();
                    }
                    break;

                // READ OPERATION
                case 2:
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(fileName));

                        String line;

                        System.out.println("\n----- FILE CONTENT -----");

                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }

                        br.close();

                    } catch (IOException e) {
                        System.out.println("Error while reading file.");
                        e.printStackTrace();
                    }
                    break;

                // MODIFY / APPEND OPERATION
                case 3:
                    try {
                        FileWriter writer = new FileWriter(fileName, true);

                        System.out.print("Enter new text to append: ");
                        String newData = sc.nextLine();

                        writer.write(newData + "\n");
                        writer.close();

                        System.out.println("File modified successfully.");

                    } catch (IOException e) {
                        System.out.println("Error while modifying file.");
                        e.printStackTrace();
                    }
                    break;

                // EXIT
                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
