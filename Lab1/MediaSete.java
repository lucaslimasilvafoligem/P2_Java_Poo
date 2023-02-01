/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author lucas de Lima da Silva - 121110517
 */
import java.util.Scanner;

public class MediaSete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double entrada1 = sc.nextDouble();
        double entrada2 = sc.nextDouble();
        double media = (entrada1 + entrada2) / 2;
        if(media >= 7){
            System.out.println("pass: True!");
        } else if(media < 7){
        System.out.println("pass: False!");
        }
    
    }
}
