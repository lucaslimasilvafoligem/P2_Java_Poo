/**
 * Laboratório de Programação 2 - Lab 1
 * 
 * @author Lucas de Lima da Silva - MATRICULA 121110517
 */

import java.util.Scanner;

public class Operacoes {

    public static void main(String[] Args) {
        
        Scanner sc = new Scanner(System.in);
        String oper = sc.nextLine();

        if(oper.equals("+") || oper.equals("-") || oper.equals("*") ||oper.equals("/")){  
            double num1 = sc.nextFloat();
            double num2 = sc.nextFloat();
            Double resp = 0.0;
            if(oper.equals("+")){
            resp = num1 + num2;
        }
            if(oper.equals("-")){
                resp = num1 - num2;   
            } else {
                if(oper.equals("*")){
                    resp = num1 * num2;  
                } else {  
                    if(oper.equals("/")){
                        if( num2 == 0){
                            System.out.println("ERRO");
                            return;
                        } else {
                                resp = num1 / num2;
                            }
                        }
                    }
                }  
             System.out.println("RESULTADO: " + resp);                       
                    
            } else {
            System.out.println("ENTRADA INVALIDA");
                }
}
}


