import java.util.ArrayList;
import java.util.List;

public class ListaCodigo {
    private List<CodigoSimple> listaCodigos;

    public ListaCodigo() {
        this.listaCodigos = new ArrayList<>();
    }

    public void agregarCodigoSimple(CodigoSimple codigoSimple){
        listaCodigos.add(codigoSimple);
    }

    public List<CodigoSimple> getListaCodigos() {
        return listaCodigos;
    }

    public void setListaCodigos(List<CodigoSimple> listaCodigos) {
        this.listaCodigos = listaCodigos;
    }

    public void agregarSimboloCodigo(int pos, int bit){
        listaCodigos.get(pos).setBitCodigo(bit);
    }

    public CodigoSimple getCodigoSimple (int pos){
        return listaCodigos.get(pos);
    }


    public void imprimirListaCodigo(){
        for (int i = 0; i < listaCodigos.size(); i++) {
            System.out.print(listaCodigos.get(i).getTuplaAsociada().getProbabilidadSigno() + " --> ");
        }
    }
}
