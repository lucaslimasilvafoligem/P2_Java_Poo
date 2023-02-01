/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class MenosUm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int somador = 0;
        while(num != -1) {
            if(num % 2 == 0) {
                somador += num;
            }
            num = sc.nextInt();
        } 
        System.out.println(somador);
    }
}
