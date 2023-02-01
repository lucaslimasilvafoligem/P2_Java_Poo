/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

 import java.util.Scanner;

public class Sorvete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int posiInicial1 = sc.nextInt();
        int velocidade1 = sc.nextInt();
        int posiInicial2 = sc.nextInt();
        int velocidade2 = sc.nextInt();
        int tempo = sc.nextInt();
        int distancia1 = posiInicial1 + velocidade1 * tempo;
        int distancia2 = posiInicial2 + velocidade2 * tempo;
        int resposta = distancia1 - distancia2;
        if(resposta < 0) { 
            System.out.println(resposta*-1);
        } else {
          System.out.println(resposta);  
        }
    }
}
