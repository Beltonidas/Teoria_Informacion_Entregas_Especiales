import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
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
        String dato;
        try {
            String ruta = "C:/GitHub/Teoria_Informacion/Prueba_datos_exp_2.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < simbolos.size(); i++) {
                dato = matrizDato[0][i]+" -> "+ matrizDato[1][i] + ", Probabilidad: " + matrizDato[1][i] + "/" + datosArchivo.size();
                System.out.println(matrizDato[0][i]+" -> "+ matrizDato[1][i] + ", Probabilidad: " + matrizDato[1][i] + "/" + datosArchivo.size());
                //meter en el archivo
                bw.write(dato+"\n");
            }
            bw.write("\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
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

    public int cantRepetidos(int dato){
        for (int i = 0; i < simbolos.size(); i++) {
            if (dato == matrizDato[0][i])
                return matrizDato[1][i];
        }
        return -1;
    }

    public double calcularEntropia(){
        double datoParce = 0.0;
        double logBn= 0.0;
        for (int i = 0; i < simbolos.size(); i++) {
            datoParce = (double) matrizDato[1][i]/datosArchivo.size();
            logBn +=-Math.log(datoParce)/Math.log(2.0) * datoParce;
        }
        return logBn;
    }

    public double calcularLongitudMedia(ListaCodigo listaCodigo){
        double datoParce = 0.0;
        double longMedia = 0.0;
        for (int i = 0; i < simbolos.size(); i++) {
            datoParce = (double) matrizDato[1][i] / datosArchivo.size();
            longMedia += datoParce* listaCodigo.cantidadBits(matrizDato[0][i]);
        }
        return  longMedia;
    }

    public int calcularEspacio (ListaCodigo listaCodigos){
        int suma = 0;
        int repeticiones;
        int valorTupla;
        for (int i = 0; i< listaCodigos.getListaCodigos().size(); i++){
            //deber??a buscar la tupla asociada, el nuemro
            valorTupla = listaCodigos.getListaCodigos().get(i).getTuplaAsociada().getSimboloAsociado();
            //ir a buscar en la matriz para saber cuantas veces se repite
            repeticiones = cantRepetidos(valorTupla);
            //luego multiplicar la longitud de L(i) * lo que me retorna la suma
            suma = suma + (repeticiones* listaCodigos.getListaCodigos().get(i).getCantBits());
        }
        return suma;
    }
}
