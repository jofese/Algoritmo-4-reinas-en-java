/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.pkg4.reinas;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author InfoLabC-01
 */
public class Cola {
    LinkedList cola= new LinkedList();
    
    public void encolar(int[][] a){
        cola.addFirst(a);
    }
    public Object desencolar(){
        return cola.removeLast();
    }
    public void mostrar(){
        System.out.println(cola);
    }
    public void ordenar(){
        Collections.sort(cola);
    }
    public boolean estaVacia(){
         return cola.isEmpty();

    }
}
