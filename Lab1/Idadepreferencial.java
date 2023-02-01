import java.util.Scanner;

public class Idadepreferencial {
    public static void main(String[] args) { // definindo uma função
        Scanner sc = new Scanner(System.in);
        int idade = sc.nextInt();
        if (idade >= 60) {
            System.out.println("Você têm " + idade + " anos. Você pode usar o atendimento especial.");
        } else {
            System.out.println("Você têm " + idade + " anos. Você ainda não pode usar o atendimento especial.");
        }
    }
}
