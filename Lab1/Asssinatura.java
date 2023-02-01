/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Asssinatura {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nome = sc.nextLine().split(" ");
        int i = 0;
        int somador = 0;
        while(!nome[0].equals("fim")) {
            somador += Integer.parseInt(nome[1]);
            i += 1;            
            nome = sc.nextLine().split(" ");
        }

        int media = somador / i;
        System.out.println(i);
        System.out.println(media);
    }
}
