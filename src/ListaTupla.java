import java.util.ArrayList;
import java.util.List;

public class ListaTupla {
    private List<Tupla> listTuplas;

    public ListaTupla() {
        this.listTuplas = new ArrayList<>();
    }

    public void addTupla(Tupla tupla){
        listTuplas.add(tupla);
    }

    public Tupla getTupla(int index){
        return listTuplas.get(index);
    }

    public List<Tupla> getListTuplas() {
        return listTuplas;
    }

    public void insertarOrdenado(Tupla tupla){
        for (int i = 0; i < listTuplas.size(); i++) {
            if (listTuplas.get(i).getProbabilidadSigno() < tupla.getProbabilidadSigno()){
                listTuplas.add(i, tupla);
                return;
            }
        }
        listTuplas.add(tupla);
    }

    public void removeAndSum(ListaCodigo listaCodigo){

        //System.out.println("Entre aca");
        int index = listTuplas.size() -1;
        Tupla aux = listTuplas.get(index);
        Tupla aux2 = listTuplas.get(index-1);

        // Coloco 0 y 1 dependiendo de las pos
        for (int i = 0; i < aux.getReferenciaPos().size(); i++) {
            int posCodigo = aux.getReferenciaPos().get(i);
            //System.out.println("Estoy agregando en la pos: "+ posCodigo);
            listaCodigo.agregarSimboloCodigo(posCodigo, 0);
        }
        for (int j = 0; j < aux2.getReferenciaPos().size(); j++) {
            int pos = aux2.getReferenciaPos().get(j);
            //System.out.println("Estoy agregando en la pos: "+ pos);
            listaCodigo.agregarSimboloCodigo(pos, 1);
        }
        //Sumo las tuplas
        double sum = aux.getProbabilidadSigno() + aux2.getProbabilidadSigno();
        //creo una nueva tupla
        Tupla nuevaTupla = new Tupla(sum);
        // Agrego las nuevas pociciones a las tuplas
        nuevaTupla.addPosicionesTupla(aux);
        nuevaTupla.addPosicionesTupla(aux2);
        listTuplas.remove(index);
        listTuplas.remove(index-1);
        // Agrego la nueva tupla
        insertarOrdenado(nuevaTupla);
    }

    public void imprimir(){
        for (int i = 0; i < listTuplas.size(); i++) {
            System.out.print("La tupla con valor: "+listTuplas.get(i).getSimboloAsociado() + ", "+ listTuplas.get(i).getProbabilidadSigno() + "--> ");
        }
    }

    public void ejecutar(ListaCodigo listaCodigo){
        while (listTuplas.size()>1)
            removeAndSum(listaCodigo);
    }

    public void sort (){
        Tupla auxiliar;
        for(int i = 0;i < listTuplas.size()-1;i++){
            for(int j = 0;j < listTuplas.size()-i-1;j++){
                // El if de abajo va a determinar si el primero es menor que el segundo
                // y si es true, se va a realizar el swap con una variable aux para
                // mover los objetos del array
                if(listTuplas.get(j+1).getProbabilidadSigno() >  listTuplas.get(j).getProbabilidadSigno()){
                    auxiliar = listTuplas.get(j+1);
                    listTuplas.set(j+1,listTuplas.get(j));
                    listTuplas.set(j,auxiliar);
                }
            }
        }
        // configuro las posiciones de mi nuevo arreglo de codigos
        for (int k = 0; k < listTuplas.size(); k++) {
            listTuplas.get(k).addPos(k);
        }
    }
}
