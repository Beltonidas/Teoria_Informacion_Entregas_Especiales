import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {
    private List<Integer> simbolos;
    private List<Integer> datosArchivo;
    private int matrizDato [][];


    public GestorArchivos() {
        this.simbolos = new ArrayList<>();
        matrizDato = null;
        this.datosArchivo = new ArrayList<>();
    }

    public void setMatrizDato(int[][] matrizDato) {
        this.matrizDato = matrizDato;
    }

    public void insertarOrdenado(int dato){
        if (simbolos.isEmpty()){
            simbolos.add(dato);
            return;
        }
        else{
            for (int i = 0; i < simbolos.size(); i++) {
                if (simbolos.get(i) > dato) {
                    simbolos.add(i, dato);
                    return;
                }
            }
        }
        simbolos.add(dato);
    }

    //Leo los datos, los paso a valore enteros
    public void leerDatos(String ruta){
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(ruta));
            String temp = "";
            String bfRead;

            while ((bfRead = entrada.readLine()) != null){
                // Leo la entrada
                temp= bfRead;
                // Opero con la entrada
                int datoParce = Integer.parseInt(temp);
                // Copio los datos del archivo en un arreglo, para despues operar
                datosArchivo.add(datoParce);

                //Funcion que guarda los elementos que no se repiten
                ordenarDatos(datoParce);
            }
        } catch (IOException e) {
            //No se encontro el archivo
            System.out.println("No se encontro el archivo");
        }
    }

    public int getPos(int dato){
        for (int i = 0; i < simbolos.size(); i++) {
            if(matrizDato[0][i] == dato)
                return i;
        }
        return -1;
    }

    public void operarDatos(){
        //Leo mi arreglo y completo la matriz
        int dato = 0;
        int index = -1;
        for (int i = 0; i < datosArchivo.size(); i++) {
            dato = datosArchivo.get(i);
            //Insertar en la Matriz y contar los repetidos
            index = getPos(dato);
            if (index!= -1){
                matrizDato[1][index] = matrizDato[1][index] +1;
            }else {
                //Supongo que la matriz esta llena de -1's
                int j = 0;
                while (j < simbolos.size()) {
                    if(matrizDato[0][j]== -1){
                        matrizDato[0][j] = dato;
                        matrizDato[1][j] = 1;
                        j = simbolos.size();
                    }
                    j++;
                }
            }

        }

    }

    public void ordenarDatos(int dato){
        if(!simbolos.contains(dato)) {
            //Con esta funcion puedo saber cuantos datos hay en el arreglo
            simbolos.add(dato);
        }
    }

    public int cantSimbolos(){
        return simbolos.size();
    }

    public void imprimirDatos(){
        for (int i = 0; i < simbolos.size(); i++) {
            System.out.print("->"+ simbolos.get(i));
        }
    }
    public void imprimirMatriz(){
        for (int i = 0; i < simbolos.size(); i++) {
            System.out.println(matrizDato[0][i]+" -> "+ matrizDato[1][i] + ", Probabilidad: " + matrizDato[1][i] + "/" + datosArchivo.size());
        }
    }

    public void generarListaTuplas (ListaTupla listaTupla){
        int dato;
        double datoDouble;
        for (int i = 0; i < simbolos.size(); i++) {
            dato = matrizDato[1][i];
            datoDouble= (double)dato;
            Tupla nuevaTupla = new Tupla(datoDouble/datosArchivo.size(),matrizDato[0][i]);
            listaTupla.addTupla(nuevaTupla);
            //nuevaTupla.addPos(i);
        }
    }
}
