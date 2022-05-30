import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Good nigth...");


        /*try {
            FileReader entrada = new FileReader("C:\\GitHub\\Teoria_Informacion\\Beethoven.txt");
            int c = entrada.read();
            while (c!= -1){
                // Leo la entrada
                c= entrada.read();

                // Opero con la entrada
                System.out.println("--> "+ c);
            }
        } catch (IOException e) {
            //No se encontro el archivo
            System.out.println("No se encontro el archivo");
        }*/

        /*------CLASE GESTORARCHIVOS--------*/
        GestorArchivos gestorArchivos = new GestorArchivos();
        gestorArchivos.leerDatos("C:/GitHub/Teoria_Informacion/Beethoven.txt");
        System.out.println(gestorArchivos.cantSimbolos());
        int cantidadSimbolos = gestorArchivos.cantSimbolos();
        //Necesito saber la cantidad de simbolos distintos que tengo para poder generar mi matriz
        int matrizDatos[][] = new int[2][cantidadSimbolos];

        //Inicializao matriz
        for (int i = 0; i < cantidadSimbolos; i++) {
            matrizDatos[0][i] = -1;
            matrizDatos[1][i] = -1;
        }
        gestorArchivos.setMatrizDato(matrizDatos);

        //Funcion que opera con la matriz
        gestorArchivos.operarDatos();
        gestorArchivos.imprimirMatriz();


        /*------CLASE lISTA TUPLAS--------*/
        ListaTupla listTuplas = new ListaTupla();
        gestorArchivos.generarListaTuplas(listTuplas);
        //Ordeno las tuplas de mayor a menor y luego acomodo los incides para los arreglos de Lista codigo
        listTuplas.sort();
        //listTuplas.imprimir();

        //Genero las codigos a partir de la cantidad de tuplas que tengo
        ListaCodigo listCodigos = new ListaCodigo();
        for (int i = 0; i < listTuplas.getListTuplas().size(); i++) {
                CodigoSimple code = new CodigoSimple(listTuplas.getListTuplas().get(i));
                listCodigos.agregarCodigoSimple(code);
        }


        System.out.println("Ejecuto Codigos:");
        listTuplas.ejecutar(listCodigos);



       System.out.println("----Los codigos---");

        for (int i = 0; i < listCodigos.getListaCodigos().size(); i++) {
            listCodigos.getCodigoSimple(i).imprimirCodigo();
        }

        System.out.println("----Cantidad de bits---");
        int cantidad = gestorArchivos.calcularEspacio(listCodigos);
        System.out.println("La cantidad de bits es: "+ cantidad);

        double entropia = gestorArchivos.calcularEntropia();
        System.out.println("Entropia: "+ entropia);

        double longMedia = gestorArchivos.calcularLongitudMedia(listCodigos);
        System.out.println("longMedia: "+ longMedia);


        /*import math
        from operator import truediv

# Estructuras de datos
        listPi = [0.6, 0.1, 0.3];
        listLog= [0,0,0];

#listPi = [1/22,1/22,18/44, 6/44, 1/11, 1/11, 4/22];
#listLog= [0,0,0, 0,0,0, 0];
#listLong=[]


        logbn = 0
        entropia = 0
        for i in range(len(listPi)):
        logbn= -math.log(listPi[i])/math.log(2)
        listLog[i] = logbn


        for i in range(len(listPi)):
        entropia += listPi[i]*listLog[i]

        print("El resultado es: ", entropia)*/

    }
}
