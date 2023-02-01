/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - 121110517
 */

import java.util.Scanner;

public class Pa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resposta = "";
        int termoInicial = sc.nextInt();
        int razao = sc.nextInt();
        int totalTermos = sc.nextInt();

        for(int i = 0; i < totalTermos;) {
            resposta += termoInicial;
            resposta += " ";
            termoInicial += razao;
            i += 1;
        }
        System.out.println(resposta.trim());
    }
}
