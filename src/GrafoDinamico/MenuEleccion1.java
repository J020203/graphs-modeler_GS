
package GrafoDinamico;
import static GrafoDinamico.MapRepresentation.getCities;
import javax.swing.JOptionPane;
/**
 * @author pc Juan C & Danny C
 */
public class MenuEleccion1 {
    public static void main(String[] args) {
//    public MenuEleccion1(){
        boolean ctrl=true;
        String[] options = {"F.Algoritmica", "Tabla de Ciudades","Grafo-Matriz Ady","Gráfica Estática"};
        while(ctrl){
            int x = JOptionPane.showOptionDialog(null,"~~~~~~~~~~~~~~~~~~~~~~~~~~~~BIENVENIDO AL PROGRAMA~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"
                    +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ESTRUCTURA DE DATOS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n"
                    +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Implementación de Grafos~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n\n"
                    +"                                                          ~~~~~~~~ESTUDIANTES~~~~~~~\n\n"
                    +"                                                         Juan Esteban Chaparro Gutiérrez\n"
                    +"                                                         Daniela Alejandra Cuellar Bueno\n\n\n\n"
                    +"                                                    Universidad San Buenaventura de Bogotá\n"
                    +"                                                                     Facultad de Ingeniería\n\n",
            
            "MENÚ DEL PROGRAMA",JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (x) {
                case -1:
                    ctrl=false;
                    JOptionPane.showMessageDialog(null,"Saliste del Programa");
                    break;
                case 0:
                    Graph graph = getCities();
                    System.out.println(graph);
                    break;
                case 1:
                    PrimerPunto matrix = new PrimerPunto();
                    matrix.setN(Integer.parseInt((JOptionPane.showInputDialog(null,"Ingrese la dimensión de la matriz"))));
                    PrimerPunto matrix1 = new PrimerPunto(matrix.getN());
                    matrix1.DistanceMatrix();
                    break;
                case 2:
                    new graficaGrafoClicDinamica();
                break;
                case 3:
                    new graficaGrafoClic();
                default:
                    JOptionPane.showMessageDialog(null,"Opción invalida");
                break;
            }
        }  
    }
}

