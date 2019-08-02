package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataLoader {

    static public int[] intArrayFromfile(String filename){
        File f = new File(filename);

        Scanner sc = null;
        try {
            sc = new Scanner(f);
            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] numbers = line.split(",");
                int[] ret = new int[numbers.length];
                int i = 0;
                for (String num : numbers) {
                    ret[i] = Integer.parseInt(num);
                    i++;
                }
                return ret;
            }
        } catch (FileNotFoundException e) {

            System.out.println(System.getProperty("user.dir"));
            System.out.println(e);
        }
        return null;
    }
}
