/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;
public class Menorzinho {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maior = 0;
        int menor = 100000;
        for(int i = 0;i < 5;) {
            int num = sc.nextInt();
            if(num < menor) {
                menor = num;
            }
            if(num > maior) {
                maior = num;
            } 
            i += 1;
        }
        int resultado = maior - menor;
        System.out.println(resultado);
    }
}
