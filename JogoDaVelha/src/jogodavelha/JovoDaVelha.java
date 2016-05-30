package jogodavelha;

import java.util.Arrays;

public class JovoDaVelha {
    
     private String[][] matriz = {
                         {"1","2","3"},
                         {"4","5","6"},
                         {"7","8","9"}
                         };
     
     
    public String Imprimir(){
        for (String[] linha : matriz) {
            System.out.println(Arrays.toString(linha));
        }
        return null;
    }
    
    public boolean validar (String posicao){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(matriz[i][j].equals(posicao)){
                    return true;
                }
                }
            }
        return false;
        }
    
    public void jogada(String posicao, String jodador){
       if(posicao.equals("1")){
           matriz[0][0] = jodador;
       }else if(posicao.equals("2")){
           matriz[0][1] = jodador;
       }else if(posicao.equals("3")){
           matriz[0][2] = jodador;
       }else if(posicao.equals("4")){
           matriz[1][0] = jodador;
       }else if(posicao.equals("5")){
           matriz[1][1] = jodador;
       }else if(posicao.equals("6")){
           matriz[1][2] = jodador;
       }else if(posicao.equals("7")){
           matriz[2][0] = jodador;
       }else if(posicao.equals("8")){
           matriz[2][1] = jodador;
       }else if(posicao.equals("9")){
           matriz[2][2] = jodador;
       }
       
//       int indice=0;
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                indice++;
//                if(posicao.equals(indice)){
//                    matriz[i][j] = posicao;
//                }
//                
//            }
//        }
    }
    
    public String ganhou(int jogadas){
        String[] T = new String[8];
        
        String vencedor = "null";
        if(jogadas == 9){
            vencedor = "VELHA";
        }
        
        T[0] = matriz[0][0]+matriz[0][1]+matriz[0][2];
        T[1] = matriz[1][0]+matriz[1][1]+matriz[1][2];
        T[2] = matriz[2][0]+matriz[2][1]+matriz[2][2];
        
        T[3] = matriz[0][0]+matriz[1][0]+matriz[2][0];
        T[4] = matriz[0][1]+matriz[1][1]+matriz[2][1];
        T[5] = matriz[0][2]+matriz[1][2]+matriz[2][2];
        
        T[6] = matriz[0][0]+matriz[1][1]+matriz[2][2];
        T[7] = matriz[0][2]+matriz[1][1]+matriz[2][0];
        
        for (int i = 0; i < T.length; i++) {
            if(T[i].equals("XXX")){
                vencedor = "Jogador 1";
            }else if(T[i].equals("OOO")){
                vencedor = "Jogador 2";
            }
        }
        return vencedor;
    }
    
}
