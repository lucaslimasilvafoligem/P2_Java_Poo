/**
 * Laboratório de Programação 2 - Lab 1
 *
 * @author Lucas de Lima da Silva - MATRICULA
 */

import java.util.Scanner;

public class Poesia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra1 = sc.nextLine();
        String palavra2 = sc.nextLine();
        char[] primeiroEUltimo1 = palavra1.toCharArray();
        char[] primeiroEUltimo2 = palavra2.toCharArray();
        int epoesia1 = 0;
        int epoesia2 = 0;

        if(primeiroEUltimo1[0] == primeiroEUltimo2[0]){
            epoesia1 = 1;
        }
        int index1 = palavra1.length() - 1;
        int index2 = palavra2.length() - 1;
        if(primeiroEUltimo1[index1] == primeiroEUltimo2[index2]){
            epoesia2 = 1;
        }
        if (epoesia1 == 1 && epoesia2 == 1){
            System.out.println("S");
        }
        if(epoesia1 == 0 || epoesia2 == 0){
            System.out.println("N");
        }
    }
}