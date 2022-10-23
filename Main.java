package program4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String options = "Enter the respective number \n 1. Display the list \n 2. Request the length of the list \n 3. Delete a single name from the list. \n 4. Request the length of a section of the list. \n 5. Print names starting with \n 6. Exitname";
        boolean repeat = true;
        Scanner input = new Scanner(System.in);

        System.out.println("-_-_-_-_SCARY LINKED LIST-_-_-_-_");
        System.out.println("Enter the file name");
        String fileName = input.next();


        LinkedList list = new LinkedList();
        list.init();
        try {
            File file = new File(fileName);
            FileReader fileReader;
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.insertSorted(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        list.buildIndex();

        while(repeat == true){
            System.out.println(options);
            switch(input.nextInt()){

                case(1):
                list.showList();
                break;

                case(2):
                System.out.println(list.listLen());
                break;

                case(3):
                System.out.println("Enter the name to delete");
                String name = input.next();
                list.remove(name);
                break;

                case(4):
                System.out.println("Enter the letter to find the length of list ");
                String alphabet = input.next();
                list.lengthSection(alphabet.charAt(0));
                break;

                case(5):
                System.out.println("Enter the letter to print all the names");
                String letter = input.next();
                list.showSection(letter.charAt(0));
                break;

                case(6):
                repeat = false;
                break;
            }
            System.out.println("\n");
        }
        input.close();

    }
}
