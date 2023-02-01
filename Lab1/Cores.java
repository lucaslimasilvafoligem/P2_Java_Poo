/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Cores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entr1 = sc.nextInt();
        int entr2 = sc.nextInt();
        int entr3 = sc.nextInt();

        if(entr1 == 128 && entr2  == entr1 &&  entr2 ==  entr3){
            System.out.println("BRANCO");

        } else {
            if(entr1  < 128 || entr2 < 128 || entr3 < 128){
               System.out.println("PRETO");    

            } else {
                System.out.println("BRANCO");
            }
        }

    }

}

