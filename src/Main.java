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
        gestorArchivos.leerDatos("C:/GitHub/Teoria_Informacion/L-gante.txt");
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

        /*ListaTupla listTuplas = new ListaTupla();
        Tupla tupla1 = new Tupla(0.5);
        tupla1.addPos(0);

        Tupla tupla2 = new Tupla(0.2);
        tupla2.addPos(1);

        Tupla tupla3 = new Tupla(0.1);
        tupla3.addPos(2);

        Tupla tupla4 = new Tupla(0.1);
        tupla4.addPos(3);

        Tupla tupla5 = new Tupla(0.1);
        tupla5.addPos(4);

        listTuplas.addTupla(tupla1);
        listTuplas.addTupla(tupla2);
        listTuplas.addTupla(tupla3);
        listTuplas.addTupla(tupla4);
        listTuplas.addTupla(tupla5);



        CodigoSimple code1 = new CodigoSimple();
        CodigoSimple code2 = new CodigoSimple();
        CodigoSimple code3 = new CodigoSimple();
        CodigoSimple code4 = new CodigoSimple();
        CodigoSimple code5 = new CodigoSimple();
        ListaCodigo listCodigos = new ListaCodigo();
        listCodigos.agregarCodigoSimple(code1);
        listCodigos.agregarCodigoSimple(code2);
        listCodigos.agregarCodigoSimple(code3);
        listCodigos.agregarCodigoSimple(code4);
        listCodigos.agregarCodigoSimple(code5);


        listTuplas.ejecutar(listCodigos);


        System.out.println("----Los codigos---");
        listCodigos.getCodigoSimple(0).imprimirCodigo();
        listCodigos.getCodigoSimple(1).imprimirCodigo();
        listCodigos.getCodigoSimple(2).imprimirCodigo();
        listCodigos.getCodigoSimple(3).imprimirCodigo();
        listCodigos.getCodigoSimple(4).imprimirCodigo();*/



    }
}
