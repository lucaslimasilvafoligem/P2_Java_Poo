/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Sensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        int entr = 1;
        while(entr != 0) {
            entr = sc.nextInt();
            if(entr < 0) {
                cont += 1;
            }
        }
        System.out.println(cont);
    }
}
