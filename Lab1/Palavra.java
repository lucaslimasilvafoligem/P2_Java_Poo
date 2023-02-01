/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Palavra {
    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        String palav1 = sc.nextLine();
        String palav2 = sc.nextLine();

        if(palav1.length() > palav2.length()){
            System.out.println(palav2);
            System.out.println(palav1);

        } else {
            if(palav2.length() > palav1.length()){
                System.out.println(palav1);
                System.out.println(palav2);

            } else {
                if(palav1.length() == palav2.length()){
                    System.out.println(palav1);
                    System.out.println(palav1);
                }
            }            
        }    
    }
}
