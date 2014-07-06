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
        if(args.length<=0||args.length>=2){
            System.err.println("Wrong argument. Stop.");
            return;
        }
        int id = 0;
        String fileName = args[0];
        File file = new File(fileName);
        if(!file.exists()){
            System.err.println("File does not exist. Stop.");
            return;
        }
        if(args.length==1){
            printRecipe(file);
        }else if(args.length==2&&isInt(args[1])){
            id = Integer.parseInt(args[1]);
            printRecipe(file,id);
        }else{
            //If reached here, args[1] is not integer.
            System.err.println("Wrong argument. Stop.");
        }
    }


    private boolean isInt(String string) {
        try{
            Integer.parseInt(string);
        }catch(Exception e){
            //NumberFormatException and NullPointerException are considered.
            return false;
        }
        return true;
    }

    private void printRecipe(File file, int id) {
        //TODO implement printing method when id is specified.
        //めっちゃ途中で終わっちゃいました！！すいません！！！！
        
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
