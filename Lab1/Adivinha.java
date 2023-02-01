/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Adivinha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int entr = 0;
        if (num == entr) {
            entr = sc.nextInt();
            if(num == entr) {
            System.out.println("ACERTOU");
            } else {
                if(entr > num) {
                    System.out.println("MAIOR");
                }
                if(entr < num) {
                    System.out.println("MENOR");
                }
            }
        }
        while(num != entr) {
            entr = sc.nextInt();
            if(entr == num) {
                System.out.println("ACERTOU");
            } else {
                if(entr > num) {
                    System.out.println("MAIOR");
                }
                if(entr < num) {
                    System.out.println("MENOR");
                }
            }
        }   
    }
}
