import java.util.Scanner;

public class MaiorMenor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] palavras = new String[5];
        String maior = "a";
        String menor = "pneumoultramicroscopicossilicovulcanoconiótico";
        int igual = 0;

        for(int i = 0; i < 5;) {
            palavras[i] = sc.nextLine();

            if(palavras[i].length() > maior.length()) {
                maior = palavras[i];
            }
            if(palavras[i].length() < menor.length()) {
                menor = palavras[i];
            }
            if(palavras[i].length() == maior.length() && palavras[i].length() == menor.length()){
                igual += 1;
            }
            i += 1;
            }

    if(igual == 5) {
        System.out.println(palavras[0]);
        System.out.println(palavras[0]);

    } else {
        System.out.println(menor);
        System.out.println(maior);
    }
    }
}