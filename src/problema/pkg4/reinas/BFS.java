/*
 * Busqueda en amplitud
 */
package problema.pkg4.reinas;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Arrays;
import java.util.Iterator;
import static java.lang.Math.abs;
/**
 *
 * @author Joel
 */
public class BFS {
    private Queue<int[][]> nodosFrontera;
    private ArrayList<int[][]> nodosVisitados;
    private int[][] nodoInicial;
    private int[][] estadoFinal;
    private int[][] nodoActual;
    
    private final Interfaz interfaz;
    public BFS(Interfaz i){
        this.interfaz=i;
    }
    public int[][] getNodoIncial() {
        return nodoInicial;
    }

    public void setNodoIncial(int[][] nodoIncial) {
        this.nodoInicial = nodoIncial;
    }



    public ArrayList<int[][]> getNodosVisitados() {
        return nodosVisitados;
    }

    public void setNodosVisitados(ArrayList<int[][]> nodosVisitados) {
        this.nodosVisitados = nodosVisitados;
    }

    public int[][] getNodoActual() {
        return nodoActual;
    }

    public void setNodoActual(int[][] nodoActual) {
        this.nodoActual = nodoActual;
    }

    
   public void buscar(){
       
       nodosFrontera=new LinkedList<int[][]>();
       nodosVisitados=new ArrayList<int[][]>();
       nodosFrontera.add(nodoInicial);
       int tam=nodoInicial.length;
       while(!nodosFrontera.isEmpty()){
           nodoActual=nodosFrontera.poll();
           if(esSolucion(nodoActual)){
               /*enviar solucion a la interfaz y salir*/
               interfaz.mostrarSolucion(nodoActual);
               break;
           }
           
           nodosVisitados.add(nodoActual);
           System.out.println("  nodo Actual  ");
           imprimirMatriz(nodoActual);
           for (int j = 0; j < tam; j++) {
               for (int k = 0; k < tam; k++) {
                   if(nodoActual[j][k]==0){
                       System.out.println("El nodo padre es ");
                       imprimirMatriz(nodoActual);
                        int nodoHijo[][]=obtenerNodoHijo(j,k,nodoActual);
                        System.out.println(" nodo hijo ");
                        imprimirMatriz(nodoHijo);
                        if(!compararConVisitados(nodoHijo)){
                            nodosFrontera.add(nodoHijo);
                            System.out.println("Añadiendo nodo a nodoFrontera");
                        }
                   }
               }
           }
           System.out.println("nodo actual despues de generar hijos");
           imprimirMatriz(nodoActual);
        
       }
   }
   
   public boolean esSolucion(int nodo[][]){
       boolean val;
       int cont=0;
       int contR=0;
       int arr[][]=nodo;
       val=false;
       for (int j = 0; j < arr.length; j++) {
           for (int k = 0; k < arr.length; k++) {
               if(arr[j][k]==0){
                   cont++;
               }
               if(arr[j][k]==1){
                   contR++;
               }
                   
           }
       }
       
       if(cont==0&&contR==4){
           val=true;
       }
       
       return val;
   }
   
   public int[][] obtenerNodoHijo(int x,int y,int[][] nodoPadre){
       int[][] nodoHijo;
       int tam=nodoPadre.length;
       nodoHijo=nodoPadre;
       nodoHijo[x][y]=1;
       for (int i = 0; i < tam; i++) {
           for (int j = 0; j < tam; j++) {
               if (i==x||j==y||abs(i-x)==abs(j-y)) {
                    if(nodoHijo[i][j]!=1&&nodoHijo[i][j]!=-8){
                        nodoHijo[i][j]=-8;    
                    }                    
                }
           }
       }

       return nodoHijo;
   }
           
public boolean compararConVisitados(int[][] nodoHijo){
    boolean estaEnVisitados;
    int tam=nodoHijo.length;

    estaEnVisitados=false;
    System.out.println("la cantidad de nodos de nodosVisitados es:"+nodosVisitados.size());
    for (int i = 0; i < nodosVisitados.size(); i++) {
        System.out.println("comparando con nodo visitado");
        imprimirMatriz(nodosVisitados.get(i));
        estaEnVisitados=nodoHijo.equals(nodosVisitados.get(i));
        
    }
    System.out.println("esta en visitados es: "+estaEnVisitados);
    return estaEnVisitados;
}

public void imprimirMatriz(int[][] nodo){
        int matriz[][]=nodo;
        System.out.println("--------------");
        for (int j = 0; j < matriz.length; j++) {
            for (int k = 0; k < matriz.length; k++) {
                System.out.print(matriz[j][k]+"    ");
            }
            System.out.println("");
    }
}

}
