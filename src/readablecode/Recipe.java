package readablecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Recipe {


    public static void main(String[] args) {
        Recipe recipe = new Recipe();
        recipe.run(args);
    }
    
    private void run(String[] args) {
        if(args.length!=1){
            System.err.println("Wrong argument. Stop.");
            return;
        }
        String fileName = args[0];
        File file = new File(fileName);
        if(!file.exists()){
            System.err.println("File does not exist. Stop.");
            return;
        }
        printRecipe(file);
    }

    private static void printRecipe(File file){
        try {
            Scanner scanner = new Scanner(new FileInputStream(file));
            for(int id=1;scanner.hasNext();id++){
                System.out.println(id+": "+scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
    }

}
