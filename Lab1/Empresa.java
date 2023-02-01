/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Empresa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] gastos = sc.nextLine().split(" ");
        int maior = Integer.parseInt(gastos[0]);
        int segundoMaior = Integer.parseInt(gastos[0]);
        int index = 0;
        for(int i = 0; i < gastos.length;) {
            if(maior < Integer.parseInt(gastos[i])) {
                maior = Integer.parseInt(gastos[i]);
                index = i;
            }
            i += 1;
        }

        if(Integer.parseInt(gastos[index]) == Integer.parseInt(gastos[0])) {
            segundoMaior = Integer.parseInt(gastos[0+1]);
        }

        for(int j = 0; j < gastos.length;) {
            if(j == index) {
                if(gastos.length -1 == index) {
                    break;
                } else {
                    j += 1;
                }
            }
            if(segundoMaior < Integer.parseInt(gastos[j])) {
                segundoMaior = Integer.parseInt(gastos[j]);
            }
            j += 1;
        }
        int resposta = maior + segundoMaior;
        System.out.println(resposta);
    }
}
