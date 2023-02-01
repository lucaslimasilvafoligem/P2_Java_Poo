/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class UltimaVogal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] vogais = {'a', 'e', 'i', 'o', 'u'};
        String asVogais = "";
        
        for(int i = 0; i < 5;) {
            char[] palavra = sc.nextLine().toCharArray();
            for(int j = 0; j < vogais.length;) {
                if(palavra[palavra.length-1] == vogais[j]) {
                    asVogais += vogais[j];
                    break;
                }
                j += 1;
            }
            i += 1;
        }
        System.out.println(asVogais);
    }
}
