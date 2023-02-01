/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Populacao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
         int totalNotas = 0;

        for (int i = 0; i < entrada.length; i++) {
            totalNotas += Integer.parseInt(entrada[i]);
            
        }
       
        int media = totalNotas / entrada.length;
        String resultado = "";
        
        for (int i = 0; i < entrada.length; i++) {
            if(Integer.parseInt(entrada[i]) > media) {
                resultado += entrada[i] + " ";
            
            }
        }  
         System.out.println(resultado.trim());

    }

}
    
