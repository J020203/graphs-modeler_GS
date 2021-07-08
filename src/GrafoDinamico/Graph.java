package GrafoDinamico;
import java.util.ArrayList;
import java.util.List;
/**
 * @author pc Danny C
 */
public class Graph {
    private List<Nodo> nodes;
    public void addNode (Nodo nodo){
        if (nodes==null){
            nodes= new ArrayList<>();  
        }
        nodes.add(nodo);
    }
    public List<Nodo> getNodes(){
        return nodes;
    }
    @Override
    public String toString(){
        return "Graph [nodes=" +nodes+ "]";
    }
}
