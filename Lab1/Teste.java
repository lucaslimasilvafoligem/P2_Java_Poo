import java.util.Scanner;
public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entr1 = "";
        String entr2 = sc.nextLine();
        String[] teste = {"a ", "b ", "c ", "d "};
        for(int i = 0; i < 4;) {
            teste[i] += entr1;
            if(i % 2 == 0) {
                teste[i] += entr2;
            }
            entr1 = sc.nextLine();
            teste[i] += i;
            
            System.out.println(teste[i]);
            i += 1;
        }
    }
    
}
