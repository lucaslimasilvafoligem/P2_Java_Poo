/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */


import java.util.Scanner;
public class Wally {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nomes = sc.nextLine().split(" ");  

        String novoNome = "";
        int i = -1;
        while(!nomes[0].equals("wally")){
            i += 1;
            if(nomes[i].equals("wally")){
                break;
            }
            if(nomes[i].length() == 5) {
                novoNome = nomes[i];
            }
            if(i + 1 == nomes.length){
                if(novoNome.equals("")){
                    novoNome = "?";
                    System.out.println(novoNome);
                    novoNome = "";
                    i = -1;
                    nomes = sc.nextLine().split(" ");
                } else {
                    System.out.println(novoNome);
                    novoNome = "";
                    i = -1;
                    nomes = sc.nextLine().split(" ");           
                }
             }           
        }
    }
}

