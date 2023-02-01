/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Estabilizador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String altura = "ADEQUADO";
        int alturaAtual = sc.nextInt();
        int ideal = alturaAtual;
        alturaAtual = sc.nextInt();
        int diferenca1 = ideal - alturaAtual;
        if(diferenca1 < 0) {
                diferenca1 *= -1;
            }
        int diferenca2 = diferenca1;
        while(!altura.equals("OK")) {
            alturaAtual = sc.nextInt();
            diferenca1 = ideal - alturaAtual;
            if(diferenca1 < 0) {
                diferenca1 *= -1;
            }
            if(diferenca1 == 0) {
                System.out.println("OK");
                break;
            }
            if(diferenca1 < diferenca2) {
                System.out.println("ADEQUADO");
            }
            if(diferenca1 >= diferenca2) {
                System.out.println("PERIGO");
            }
            diferenca2 = diferenca1;
        }
    }
}
