/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Gastos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 4;) {
            String[] semana = sc.nextLine().split(" ");
            int somador = 0;
            int menor = Integer.parseInt(semana[0]);
            int maior = Integer.parseInt(semana[0]);
            for(int j = 0; j < 7;) {
                somador += Integer.parseInt(semana[j]);
                if(Integer.parseInt(semana[j]) < menor) {
                    menor = Integer.parseInt(semana[j]);
                }
                if(Integer.parseInt(semana[j]) > maior) {
                    maior = Integer.parseInt(semana[j]);
                }
                j += 1;
                }
            System.out.println(somador + " " + menor + " " + maior);
            i += 1;
        }
    }    
}

