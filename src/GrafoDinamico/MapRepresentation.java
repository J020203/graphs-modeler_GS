package GrafoDinamico;
/**
 * @author pc Danny C
 */
public class MapRepresentation {
    
    public static Graph getCities(){
        
        Nodo Bogota = new Nodo("Bogota");
        Nodo Armenia = new Nodo ("Armenia");
        Nodo Pereira = new Nodo ("Pereira");
        Nodo Cali = new Nodo ("Calí");
        Nodo Quibdo = new Nodo ("Quibdó");
        Nodo Medellin = new Nodo ("Medellín");
        Nodo Bucaramanga = new Nodo ("Bucaramanga");
        
        Bogota.addEdge(new Edge(Bogota,Armenia,419));
        Bogota.addEdge(new Edge(Bogota,Pereira,177));
        Bogota.addEdge(new Edge(Bogota,Cali,340));
        Bogota.addEdge(new Edge(Bogota,Quibdo,424));
        Bogota.addEdge(new Edge(Bogota,Medellin,216));
        Bogota.addEdge(new Edge(Bogota,Bucaramanga,374));
        
        Armenia.addEdge(new Edge(Armenia,Bogota,419));
        Armenia.addEdge(new Edge(Armenia,Pereira,242));
        Armenia.addEdge(new Edge(Armenia,Cali,97));
        Armenia.addEdge(new Edge(Armenia,Quibdo,323));
        Armenia.addEdge(new Edge(Armenia,Medellin,358));
        Armenia.addEdge(new Edge(Armenia,Bucaramanga,293));
        
        Pereira.addEdge(new Edge(Pereira,Bogota,177));
        Pereira.addEdge(new Edge(Pereira,Armenia,242));
        Pereira.addEdge(new Edge(Pereira,Cali,172));
        Pereira.addEdge(new Edge(Pereira,Quibdo,335));
        Pereira.addEdge(new Edge(Pereira,Medellin,207));
        Pereira.addEdge(new Edge(Pereira,Bucaramanga,284));
        
        Cali.addEdge(new Edge(Cali,Bogota,340));
        Cali.addEdge(new Edge(Cali,Armenia,97));
        Cali.addEdge(new Edge(Cali,Pereira,17));
        Cali.addEdge(new Edge(Cali,Quibdo,251));
        Cali.addEdge(new Edge(Cali,Medellin,261));
        Cali.addEdge(new Edge(Cali,Bucaramanga,212));
        
        Quibdo.addEdge(new Edge(Quibdo,Bogota,424));
        Quibdo.addEdge(new Edge(Quibdo,Armenia,323));
        Quibdo.addEdge(new Edge(Quibdo,Pereira,335));
        Quibdo.addEdge(new Edge(Quibdo,Cali,251));
        Quibdo.addEdge(new Edge(Quibdo,Medellin,220));
        Quibdo.addEdge(new Edge(Quibdo,Bucaramanga,51));
        
        Medellin.addEdge(new Edge(Medellin,Bogota,216));
        Medellin.addEdge(new Edge(Medellin,Armenia,358));
        Medellin.addEdge(new Edge(Medellin,Pereira,207));
        Medellin.addEdge(new Edge(Medellin,Cali,261));
        Medellin.addEdge(new Edge(Medellin,Quibdo,220));
        Medellin.addEdge(new Edge(Medellin,Bucaramanga,176));
        
        Bucaramanga.addEdge((new Edge(Bucaramanga,Bogota,374)));
        Bucaramanga.addEdge((new Edge(Bucaramanga,Armenia,293)));
        Bucaramanga.addEdge((new Edge(Bucaramanga,Pereira,284)));
        Bucaramanga.addEdge((new Edge(Bucaramanga,Cali,212)));
        Bucaramanga.addEdge((new Edge(Bucaramanga,Quibdo,51)));
        Bucaramanga.addEdge((new Edge(Bucaramanga,Medellin,176)));
        //Invocación de la clase Graph 
        Graph graph = new Graph();
        graph.addNode(Bogota);
        graph.addNode(Armenia);
        graph.addNode(Pereira);
        graph.addNode(Cali);
        graph.addNode(Quibdo);
        graph.addNode(Medellin);
        graph.addNode(Bucaramanga);
        return graph;
    }
}

