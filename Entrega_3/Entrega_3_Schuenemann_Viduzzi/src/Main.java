import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi beltom");
        System.out.println("Como te gusta el java gil..");
        int simbolo_1=0;
        int simbolo_2=0;
        int simbolo_3=0;
        String ruta = "C:/GitHub/Teoria_Informacion/Entrega_3/Entrega_3_Schuenemann_Viduzzi/documentoPrueba.txt";

        try {
            BufferedReader entrada = new BufferedReader(new FileReader(ruta));
            String temp = "";
            String bfRead;

            while ((bfRead = entrada.readLine()) != null){
                // Leo la entrada
                temp= bfRead;
                // Opero con la entrada
                //int datoParce = Integer.parseInt(temp);
                if(bfRead.equals("0"))
                    simbolo_1++;
                if(bfRead.equals("1"))
                    simbolo_2++;
                if(bfRead.equals("2"))
                    simbolo_3++;

            }
        } catch (IOException e) {
            //No se encontro el archivo
            System.out.println("No se encontro el archivo");
        }
        //System.out.println("la cantidad de simbolo 0 es igual: "+simbolo_1 +", la cantidad de simbolo 1 es igual: " +simbolo_2);
        System.out.println("la cantidad de simbolo 0 es igual: "+simbolo_1 +", la cantidad de simbolo 1 es igual: " +simbolo_2+", la cantidad de simbolo 2 es igual: " +simbolo_3);
    }
}
