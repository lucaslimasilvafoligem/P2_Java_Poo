/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Ingrata {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] vogal = {'a','e','i','o','u'};
        int palavrasIngratas = 0;
        int palavrasGratas = 0;
        char[] palavra;
        int i = 0;
        while(palavrasIngratas < 3) {
            int cont = 0;
            int conta = 0;
            palavra = sc.nextLine().toCharArray();
            for(int j = 0; j < palavra.length;) {
                for(int x = 0; x < vogal.length;) {
                    if(palavra[j] == vogal[x]) {
                        palavrasGratas += 1;
                        break;
                    } else {
                        cont += 1;
                    }
                    x += 1;
                }
                j += 1;
                if(palavrasGratas > 0) {
                    palavrasGratas = 0;
                    break;
                } 
                if(cont == 5) {
                    conta += 1;
                    cont = 0;
                } 
            if(conta == palavra.length) {
                palavrasIngratas += 1;
                System.out.println(palavra);
            }
            i += 1;
            
            }
            if(palavrasIngratas >= 3) {
                break;
            }
        }
    }
}

