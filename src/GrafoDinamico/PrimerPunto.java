package GrafoDinamico;
import javax.swing.JOptionPane;
/**
 * @author pc Juan C & Danny C
 */
public class PrimerPunto {

    private int n; // Se declara esta variable global para accedear en esta variable en todo el codigo .
    private int[][] Bidimensional;
    // declaro el array bidimensional con el nombre de array de manera global.
    //Constructor vacío , para inicializar la variable
    public PrimerPunto(){
    }
    // El constructor de la clase con un parametro. El cual se encargara del tamaño que tendra el array
    public PrimerPunto(int n) {
        this.n = n;// Se iguala el valor que tendra en el array
        Bidimensional = new int[n][n];   // Se declara la matriz bidimensional 
        //Se inicializa matriz en 0
        for (int i = 0; i < n; i++) { // El recorrido para la creación de la matriz. 
            for (int j = 0; j < n; j++) {
                Bidimensional[i][j] = 0; // Se iguala a 0 para poder imprimir los 0 wn la matriz
            }
        }
    }
    public int getN() { //Obtener el valor para n
        return n;
    }
    public void setN(int n) { //Establecer un valor para n
        this.n = n;
    }
    // Método para AGREGAR el nodo en la matriz 
    public void add(int i, int j, int k) {
        Bidimensional[i][j] = k;
    }
    // Método para ELIMINAR el nodo en la matriz 
    public void remove(int i, int j) {
        if (Bidimensional[i][j] > 0) {
            Bidimensional[i][j] = 0;
        }
    }
    // Método con el cual se IMPRIME la matriz
    public String toPrint() {
        String matriz = "";
        for (int i = 0; i < n; i++) { //Recorrido en filas
            for (int j = 0; j < n; j++) { //Recorrido en columnas 
                matriz += Bidimensional[i][j] + "  "; //Acumulador para la tabulación de los valores
            }
            matriz += "\n"; // Acumulador para los saltos de líneas
        }
        JOptionPane.showMessageDialog(null,"                            TABLA DE DISTANCIAS           \n"
                +"                          CIUDADES LOCALES          \n\n"+matriz);
        return matriz; //Método de tipo String pide devolver el dato establecido. 
    }
    public void DistanceMatrix() {
        int option, row, column,k;
        PrimerPunto matrix = new PrimerPunto(n);
        // Se instancia la clase y se envía el valor al constructor con la variable n
        do {
            option= Integer.parseInt((JOptionPane.showInputDialog(null,"Ingrese la opción que requiere:\n"
                    + "1. Agregar arista y recorrido\n"
                    + "2. Eliminar recorrido\n"
                    + "3. Imprimir\n"
                    + "4. Salir")));
            switch (option) {
                case 1:
                    row = Integer.parseInt((JOptionPane.showInputDialog(null,"NOTA: La matriz tiene un tamaño de " +  7  + " por " +  7  + " Digite el número de la fila que desea agregar:\n"
                    + "Tenga en cuenta la fila de la matriz Adyacente:\n"
                    + "0. Bogotá\n"
                    + "1. Armenia\n"
                    + "2. Pereira\n"
                    + "3. Calí\n"
                    + "4. Quibdó\n"
                    + "5. Medellín\n"
                    + "6. Bucaramanga")));
                    
                    column = Integer.parseInt((JOptionPane.showInputDialog(null,"NOTA: La matriz tiene un tamaño de " + 7  + " por " +  7  + ". Digite el número de la fila que desea agregar:\n"
                    + "Tenga en cuenta la fila de la matriz Adyacente:\n"
                    + "0. Bogotá\n"
                    + "1. Armenia\n"
                    + "2. Pereira\n"
                    + "3. Calí\n"
                    + "4. Quibdó\n"
                    + "5. Medellín\n"
                    + "6. Bucaramanga")));
                    
                    k = Integer.parseInt((JOptionPane.showInputDialog(null," Digite la distancia que existe entre las ciudades: ")));
                    matrix.add(row, column,k);// instacio al metodo agregar y envio sus valores con , varialbes de entrra como row y column
                    JOptionPane.showMessageDialog(null,"Se agregó exitosamente la distancia entre las ciudades de la arista");
                    break;
                    
                case 2:
                    row = Integer.parseInt((JOptionPane.showInputDialog(null,"Nota: La matriz tiene un tamaño de " + 7 + " por " + 7 + ". Digite el número de la fila que desea agregar:\n"
                    + "Tenga en cuenta la fila de la matriz Adyacente:\n"
                    + "0. Bogotá\n"
                    + "1. Armenia\n"
                    + "2. Pereira\n"
                    + "3. Calí\n"
                    + "4. Quibdó\n"
                    + "5. Medellín\n"
                    + "6. Bucaramanga")));
                    
                    column = Integer.parseInt((JOptionPane.showInputDialog(null,"Nota: La matriz tiene un tamaño de " + 7 + " por " + 7 + ". Digite el número de la fila que desea agregar:\n"
                    + "Tenga en cuenta la fila de la matriz Adyacente:\n"
                    + "0. Bogotá\n"
                    + "1. Armenia\n"
                    + "2. Pereira\n"
                    + "3. Calí\n"
                    + "4. Quibdó\n"
                    + "5. Medellín\n"
                    + "6. Bucaramanga")));
                    matrix.remove(row, column);
                    JOptionPane.showMessageDialog(null,"Se agregó exitosamente la distancia entre las ciudades de la arista");
                    break;
                    
                case 3:
                    matrix.toPrint(); //Invocación del método matrix de la clase main y la clase vacía toprint
                    break;
                    
                case 4:
                    option=0;
                    JOptionPane.showMessageDialog(null,"Se cerró el programa exitosamente");
                    //System.exit(0); // Salida del programa.
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null,"Opción inválida, vuelva a intentarlo");
            }
        } while (option != 0);
    } 
}
   
