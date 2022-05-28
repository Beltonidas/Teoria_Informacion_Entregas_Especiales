import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class CodigoSimple {
    private List<Integer> codigoBinario;
    private Tupla tuplaAsociada;

    public CodigoSimple() {
        this.codigoBinario = new ArrayList<>();
    }

    public CodigoSimple(Tupla tuplaAsociada) {
        this.codigoBinario = new ArrayList<>();
        this.tuplaAsociada = tuplaAsociada;
    }

    public Tupla getTuplaAsociada() {
        return tuplaAsociada;
    }

    public void setTuplaAsociada(Tupla tuplaAsociada) {
        this.tuplaAsociada = tuplaAsociada;
    }

    public CodigoSimple(List<Integer> codigoBinario, Tupla tuplaAsociada) {
        this.codigoBinario = codigoBinario;
        this.tuplaAsociada = tuplaAsociada;
    }

    public List<Integer> getCodigoBinario() {
        return codigoBinario;
    }

    public void setCodigoBinario(List<Integer> codigoBinario) {
        this.codigoBinario = codigoBinario;
    }

    public void setBitCodigo(Integer bit) {
        codigoBinario.add(bit);
    }

    public void imprimirCodigo(){
        int pos = codigoBinario.size() -1;
        String codigo = "";
        String dato= "";
        while (pos >=0){
            System.out.print(codigoBinario.get(pos) + ":");
            codigo = codigo + codigoBinario.get(pos);
            pos--;
        }
        System.out.println("Representación del simbolo : "+ tuplaAsociada.getSimboloAsociado());
        dato= "Representación del simbolo : "+ tuplaAsociada.getSimboloAsociado();
        dato = codigo + "--> " +dato;
        // sin pisar lo demas tenes que guardar esto
        try {
            String ruta = "C:/GitHub/Teoria_Informacion/CuloRoto.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(dato+"\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCantBits(){
        return codigoBinario.size();
    }

}
