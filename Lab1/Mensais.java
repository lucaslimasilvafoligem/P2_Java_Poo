/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Mensais {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] meses = sc.nextLine().split(" ");
        String[] valores = sc.nextLine().split(" ");
        String mes = sc.nextLine();
        int index = 0;
        
        for(int i = 0; i < 12;) {
            if(meses[i].equals(mes)) {
                index = i;
                break;
            }
            i += 1; 
        }
        System.out.println(valores[index]);
    }
}
