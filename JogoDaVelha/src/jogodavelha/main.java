package jogodavelha;

import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        JovoDaVelha jv = new JovoDaVelha();
        String posicao;
        int validar=0, jogadas=0;
        
        while(true){
            System.out.println("-----Jogo da Velha------");
            jv.Imprimir();
            
            do{
                System.out.print("Jogador 1, informe a posição");
                posicao = ler.next();
                
                while(!jv.validar(posicao)){
                    System.out.println("Jogada invalida. Tente novamente");
                    System.out.print("Jogador 1, informe a posição");
                    posicao = ler.next();
                }
                jv.jogada(posicao, "X");
                validar = 1;
            }while(validar == 0);
            
            jogadas++;
            validar = 0;
            jv.Imprimir();
            if(!jv.ganhou(jogadas).equals("null")){
                break;
            }
            
            do{
                System.out.print("Jogador 2, informe a posição");
                posicao = ler.next();
                
                while(!jv.validar(posicao)){
                    System.out.println("Jogada invalida. Tente novamente");
                    System.out.print("Jogador 2, informe a posição");
                    posicao = ler.next();
                }
                jv.jogada(posicao, "O");
                validar = 1;
            }while(validar == 0);
            
            jogadas++;
            validar = 0;
            jv.Imprimir();
            if(!jv.ganhou(jogadas).equals("null")){
                break;
            }
            
        }
        
        System.out.println("O "+jv.ganhou(jogadas)+" Venceu!");
        
        
        
    }
    
}
