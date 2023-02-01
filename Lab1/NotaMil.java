/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;
public class NotaMil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] notaAluno = sc.nextLine().split(" ");
        int maior = Integer.parseInt(notaAluno[1]);
        int menor = Integer.parseInt(notaAluno[1]);
        int somaNotas = 0; 
        int media = 0;
        int acima = 0;
        int abaixo = 0;

        int i = -1;
        while(!notaAluno[0].equals("-")) {
            i += 1;
            if(Integer.parseInt(notaAluno[1]) > maior) {
                maior = Integer.parseInt(notaAluno[1]);
            } 
            if(Integer.parseInt(notaAluno[1]) < menor) {
                menor = Integer.parseInt(notaAluno[1]);
            }
            if(Integer.parseInt(notaAluno[1]) >= 700) {
                acima += 1;
            } 
            if(Integer.parseInt(notaAluno[1]) < 700) {
                abaixo += 1;
            }
            somaNotas += Integer.parseInt(notaAluno[1]);;
            notaAluno = sc.nextLine().split(" ");
        }
        
        media = somaNotas / (i + 1);
        
        System.out.println("maior: " + maior);
        System.out.println("menor: " + menor);
        System.out.println("media: " + media);
        System.out.println("acima: " + acima);
        System.out.println("abaixo: " + abaixo);
    }
}
