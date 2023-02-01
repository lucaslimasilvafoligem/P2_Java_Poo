/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class DobroTriplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada = sc.nextInt();
        int dobro = entrada * 2;
        int triplo = entrada * 3;
        System.out.println("dobro: " + dobro + ", triplo: " + triplo);
    }
}
