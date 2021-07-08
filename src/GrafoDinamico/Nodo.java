package GrafoDinamico;
import java.util.ArrayList;
import java.util.List;
/**
 * @author pc
 */
public class Nodo{
    private String city;
    private List<Edge> edges;
    
    public Nodo(String city){
        this.city=city;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public List<Edge> getEdges(){
        return edges;
    }
    public void addEdge(Edge edge){
        if (edges==null){
            edges= new ArrayList<>();
        }edges.add(edge);
    }
    public String toString(){
        return "\n \tNode [city=" +city+", edges="+edges+"]";
    }
}
