/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Monotona {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada1 = sc.nextInt();
        int entrada2 = sc.nextInt();
        int entrada3 = sc.nextInt();
        int entrada4 = sc.nextInt();

        if(entrada1 != entrada2 && entrada1 != entrada3 && entrada1 != entrada4 && entrada2 != entrada3 && entrada2 != entrada4 && entrada3 != entrada4){
            if(entrada1 < entrada2 && entrada2 < entrada3 && entrada3 < entrada4){
                System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
            }  else {
                if(entrada1 > entrada2 && entrada2 > entrada3 && entrada3 > entrada4){
                    System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
                } else {
                    if( 1 > 0){
                        System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
                }
            }
            } 
        }else {
            if( 1 > 0){
                System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
                }

            } 

                    
            }
        }

