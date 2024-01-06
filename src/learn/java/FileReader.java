
package learn.java;

import java.io.File;
import java.util.Scanner;

class FileReader{

    public static void main(String[] args){

        try {
            Scanner scan = new Scanner(new File("/Users/dhanunjeya/Code/InterviewPrep/change-author.sh"));
            try (scan) { // Varibale can be used for java.lang.AutoCloseable resource from java 9    
                while (scan.hasNextLine()) {
                    System.out.println(scan.nextLine());
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}