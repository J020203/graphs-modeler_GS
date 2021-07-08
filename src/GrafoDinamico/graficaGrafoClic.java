
package GrafoDinamico;
/**
 * @author pc Juan C & Danny C 
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

public class graficaGrafoClic implements ViewerListener{
    
    protected boolean loop = true;
    private Graph graph;
    
    /*public static void main(String[] args) {
        
        System.setProperty("org.graphstream.ui", "swing");
        new graficaGrafoClic();
        
    }*/
    
    public graficaGrafoClic() {
        System.setProperty("org.graphstream.ui", "swing");
        ArrayList<String> ciudades = new ArrayList<>();
        String[][] distancias = new String[7][7];
        //<editor-fold defaultstate="collapsed" desc="Definir las ciudades y distancias entre ellas.">
        ciudades.add("Bogotá");
        distancias[0][1] = "419";
        distancias[0][2] = "177";
        distancias[0][3] = "340";
        distancias[0][4] = "424";
        distancias[0][5] = "216";
        distancias[0][6] = "374";
        
        ciudades.add("Armenia");
        distancias[1][0] = "419";
        distancias[1][2] = "242";
        distancias[1][3] = "97";
        distancias[1][4] = "323";
        distancias[1][5] = "358";
        distancias[1][6] = "293";
        
        ciudades.add("Pereira");
        distancias[2][0] = "177";
        distancias[2][1] = "242";
        distancias[2][3] = "172";
        distancias[2][4] = "335";
        distancias[2][5] = "207";
        distancias[2][6] = "284";
        
        ciudades.add("Cali");
        distancias[3][0] = "340";
        distancias[3][1] = "97";
        distancias[3][2] = "172";
        distancias[3][4] = "251";
        distancias[3][5] = "261";
        distancias[3][6] = "212";
        
        ciudades.add("Quibdó");
        distancias[4][0] = "424";
        distancias[4][1] = "323";
        distancias[4][2] = "335";
        distancias[4][3] = "251";
        distancias[4][5] = "220";
        distancias[4][6] = "51";
        
        ciudades.add("Medellín");
        distancias[5][0] = "216";
        distancias[5][1] = "358";
        distancias[5][2] = "207";
        distancias[5][3] = "261";
        distancias[5][4] = "220";
        distancias[5][6] = "176";
        
        ciudades.add("Bucaramanga");
        distancias[6][0] = "374";
        distancias[6][1] = "293";
        distancias[6][2] = "284";
        distancias[6][3] = "212";
        distancias[6][4] = "51";
        distancias[6][5] = "176";
        //</editor-fold>
        
        graph = new SingleGraph("Grafo Ciudades");
        Viewer viewer = graph.display();
        
        graph.setAttribute("ui.stylesheet", styleSheet);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");
        
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);
        
        ciudades.forEach((ciudad) -> {
            graph.addNode(ciudad);
        });
        
        for(Node n:graph) {
            //n.setAttribute("ui.style", "fill-color: rgb(255,255,255);stroke-mode: plain; stroke-width: 2; shape: circle; text-mode: normal;");
            n.setAttribute("ui.label", n.getId());
        }
        
        for (int i = 0; i < ciudades.size(); i++) {
            for (int j = 0; j < ciudades.size(); j++) {
                if (i != j) graph.addEdge(ciudades.get(i) + " -> " + ciudades.get(j), ciudades.get(i), ciudades.get(j), true);
            }
        }
        /*
        for (int numEdge = 0; numEdge < graph.getNodeCount();numEdge++) {
            System.out.println(graph.getNode(numEdge));
        }
        */
        int numEdge = 0;
        while (numEdge < graph.getEdgeCount()) {
            for (int j = 0; j < ciudades.size(); j++) {
                for (int k = 0; k < ciudades.size(); k++) {
                    if (j != k) {
                        graph.getEdge(numEdge).setAttribute("ui.label", distancias[j][k]);
                        numEdge++;
                    }
                }
            }
        }
        
        int n = graph.getNodeCount();
        byte adjacencyMatrix[][] = new byte[n][n];
        String acumulador = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                adjacencyMatrix[i][j] = (byte) (graph.getNode(i).hasEdgeBetween(j) ? 1 : 0);
                if (graph.getNode(i).hasEdgeBetween(j)) acumulador += "1";
                else acumulador += "0";
                if (j < n - 1) acumulador += "      ";
            }
            acumulador += "\n";
        }
        for (byte[] adjacencyMatrix1 : adjacencyMatrix) {
            for (int j = 0; j < adjacencyMatrix1.length; j++) {
                System.out.print(adjacencyMatrix1[j] + " ");
            }
            System.out.println();
        }
        System.out.println(acumulador);
        JOptionPane.showMessageDialog(null, acumulador, "Matriz de adyacencia", 3);

        //System.out.println(graph.getNode(0).getEdge(0));
        
        for (int i = 0; i < n; i++) {
            System.out.println("Para el nodo " +  graph.getNode(i) + "\n");
            for (int j = 0; j < n; j++) {
                if (graph.getNode(i).hasEdgeBetween(j)) System.out.println("\tTiene una conexión con " + graph.getNode(j));
            }
            System.out.println("");
        }
        
        System.out.println(graph.getNode(0).getEdge(0) + " " + graph.getEdge(0).getAttribute("ui.label"));
        
        while(loop) {
            fromViewer.pump();
            
        } 
        if (!loop) System.exit(0);
        
    }
    
    public static String styleSheet = 
                                    "graph {"+
                                        "fill-color: white;" +
                                    "}"+
                                    "node {"+
                                    "	size: 110px, 40px;"+
                                    "	text-size: 15;"+
                                    "   fill-color: white;"+
                                    "	shape: circle;"+
                                    "	stroke-mode: plain;"+
                                    "	text-alignment: center;"+
                                    "	text-color: black;"+
                                    "	text-mode: normal;"+
                                    "	text-background-mode: none;"+
                                    "	text-padding: 4px;"+
                                    "	z-index: 1;"+
                                    "}"+
                                    "edge {"+
                                    "	text-color: black;"+
                                    "	shape: line;"+
                                    "	z-index: 0;"+
                                    "	arrow-shape: arrow;"+
                                    "	text-alignment: along;"+
                                    "	text-size: 20;"+
                                    "	text-background-mode: plain;"+
                                    "}";

    @Override
    public void viewClosed(String id) {
        loop = false;
        System.out.println("Ventana cerrada");
    }

    @Override
    public void buttonPushed(String id) {
        //System.out.println("El botón se presiono en nodo: " + id);
        for (int i = 0; i < (graph.getNodeCount() *2) - 2; i++) {
            if (i < graph.getNodeCount() - 1) graph.getNode(id).getEdge(i).setAttribute("ui.style", "fill-color: red;");
            else graph.getNode(id).getEdge(i).setAttribute("ui.style", "fill-color: green;");
            graph.getNode(id).getEdge(i).setAttribute("ui.style", "text-color: blue;");
        }
        
        graph.edges().forEach(edge -> {
            if(!edge.getNode0().toString().equals(id) && !edge.getNode1().toString().equals(id)) edge.setAttribute("ui.style", "fill-color: white; text-mode: hidden; stroke-color: white; text-background-mode: none; visibility-mode: hidden;");
        });
    }

    @Override
    public void buttonReleased(String id) {
        //System.out.println("El botón dejo de presionar en nodo: " + id);
        for (int i = 0; i < (graph.getNodeCount() *2) - 2; i++) {
            graph.getNode(id).getEdge(i).setAttribute("ui.style", "fill-color: black; text-color: black; stroke-color: black;");
        }
        
        graph.edges().forEach(edge -> {
            edge.setAttribute("ui.style", "fill-color: black; text-color: black; stroke-color: black; text-mode: normal; text-background-mode: none; visibility-mode: normal;");
        });
        
    }

    @Override
    public void mouseOver(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseLeft(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

