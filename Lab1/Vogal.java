/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Vogal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] vogais = {'a'};
        for (int i = 0; i < 5;) {
            char[] palavra = sc.nextLine().toCharArray();
            for(int j = 0; j < 1;) {
                if(palavra[0] == vogais[0]) {
                    System.out.println("s");
                    break;
                } else {
                    System.out.println("n");
                }

                j += 1; 
            }
            i += 1;
        }
    }
}
