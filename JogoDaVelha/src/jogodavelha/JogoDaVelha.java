/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Jonata Hessa
 */
public class JogoDaVelha {

    /*
    * Vetor global de nove posições para simular tabuleiro.
    */
    static String[] tabuleiro = new String[9];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        imprimeMenuInicial();
        switch (recebeOpcaoModoDeJogo()) {
            case 1:
                modoJogador();
                break;
            case 2:
                modoFacil();
                break;
            case 3:
                modoDificil();
            
        }
    }

    /*
    * Inicializa o tabuleiro, deixando-o em branco e com 
    * "| |" para desenhar o tabuleiro.
    */
    public static void inicializaTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiro[i] = "| |";
        }

    }

    
    /*
    * Imprime tabuleiro concatenado.
    */
    public static void imprimeTabuleiro() {
        System.out.println("   1  2  3\n"
                + "1 " + tabuleiro[0] + tabuleiro[1] + tabuleiro[2] + "\n"
                + "2 " + tabuleiro[3] + tabuleiro[4] + tabuleiro[5] + "\n"
                + "3 " + tabuleiro[6] + tabuleiro[7] + tabuleiro[8]);

    }

    
    /*
    * Impressão de menu inicial.
    */
    public static void imprimeMenuInicial() {
        System.out.println("Jogo Da Velha");
        System.out.println("");
        System.out.println("1-Jogador VS Jogador");
        System.out.println("2-Jogador VS Computador (Fácil)");
        System.out.println("3-Jogador VS Computador (Difícil)");
        System.out.println("0-Sair");
        System.out.println("");
        System.out.print("Insira o número da opção desejada: ");

    }

    /*
    * Recebe a opção a ser digitada no requerida na função
    * "imprimeMenuInicial" e retorna o valor digitado.
    */
    public static int recebeOpcaoModoDeJogo() {
        Scanner reader = new Scanner(System.in);
        int recebe = reader.nextInt();

        while (recebe < 0 || recebe > 3) {
            imprimeMenuInicial();
            recebe = reader.nextInt();
        }
        return recebe;
    }

    
    /*
    * Recebe a coordenada da linha digitada e retorna o mesmo valor.
    */
    public static String leiaCoordenadaLinha() {
        System.out.print("Insira o número da linha: ");
        Scanner reader = new Scanner(System.in);
        String linha = reader.next();

        while (!linha.equalsIgnoreCase("1") && !linha.equalsIgnoreCase("2")
                && !linha.equalsIgnoreCase("3")) {
            System.out.println("Número de linha invalido!\n\nInsira o número da linha:");
            linha = reader.next();
        }
        System.out.println(linha);
        return linha;
    }

    
    /*
    * Recebe a coordenada da coluna digitada e retorna o mesmo valor.
    */
    public static String leiaCoordenadaColuna() {
        System.out.print("Insira o número da coluna: ");
        Scanner reader = new Scanner(System.in);
        String coluna = reader.next();

        while (!coluna.equalsIgnoreCase("1") && !coluna.equalsIgnoreCase("2")
                && !coluna.equalsIgnoreCase("3")) {
            System.out.println("Número de coluna invalido!\n\nInsira o número da coluna:");
            coluna = reader.next();
        }
        System.out.println(coluna);
        return coluna;
    }

    
    /*
    * Imprime a pontuação do Jogador 1 e Jogador 2.
    */
    public static void imprimePontuacao(int pontoJogador1, int pontoJogador2) {
        System.out.println("Jogador 1: " + pontoJogador1 + " X " + pontoJogador2 + " Jogador 2\n");
    }

    
    /*
    * Recebe e converte coordenadas recebidas, e retorna uma posição válida do vetor
    * de acordo com as regras do jogo.
    */
    public static int converteCoordenadasEmPosicao(String linha, String coluna) {
        int posicao = 0;
        if (linha.equalsIgnoreCase("1") && coluna.equalsIgnoreCase("1")) {
            posicao = 0;
        } else if (linha.equalsIgnoreCase("1") && coluna.equalsIgnoreCase("2")) {
            posicao = 1;
        } else if (linha.equalsIgnoreCase("1") && coluna.equalsIgnoreCase("3")) {
            posicao = 2;
        } else if (linha.equalsIgnoreCase("2") && coluna.equalsIgnoreCase("1")) {
            posicao = 3;
        } else if (linha.equalsIgnoreCase("2") && coluna.equalsIgnoreCase("2")) {
            posicao = 4;
        } else if (linha.equalsIgnoreCase("2") && coluna.equalsIgnoreCase("3")) {
            posicao = 5;
        } else if (linha.equalsIgnoreCase("3") && coluna.equalsIgnoreCase("1")) {
            posicao = 6;
        } else if (linha.equalsIgnoreCase("3") && coluna.equalsIgnoreCase("2")) {
            posicao = 7;
        } else if (linha.equalsIgnoreCase("3") && coluna.equalsIgnoreCase("3")) {
            posicao = 8;
        }

        return posicao;
    }

    
    /*
    * Recebe posição e verifica se a mesma está vazia.
    */
    public static boolean posicaoValida(int posicao) {

        return tabuleiro[posicao].equalsIgnoreCase("| |");

    }

    
    /*
    * Verifica todas as sequencias de ídices do vetor tabuleiro e retorna int
    * para validar vencedor da rodada, 1: Jogador X venceu; 2: Jogador O venceu;
    * 0: não houve vencedor.
    */
    public static int verificaVencedorDeRodada() {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[1].equalsIgnoreCase("|X|") && tabuleiro[2].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[3].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[5].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[6].equalsIgnoreCase("|X|") && tabuleiro[7].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[3].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[1].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[7].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[5].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|")) {

                return 1;
            } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[1].equalsIgnoreCase("|O|") && tabuleiro[2].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[3].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[5].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[6].equalsIgnoreCase("|O|") && tabuleiro[7].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[3].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[1].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[7].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[5].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|")) {

                return 2;
            } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|")) {

                return 2;
            }
        }
        return 0;

    }

    
    /*
    * Recebe os pontos de jogador1 e jogador2, verifica qual jogador atingiu
    * 3 pontos e retorna int para validar, 1 para jogador1, 2 para jogador2
    * e 0 ninguém atingiu 3 pontos.
    */
    public static int verificaVencedorDePartida(int pontoJogador1, int pontoJogador2) {
        int retorno = 0;
        if (pontoJogador1 == 3) {
            retorno = 1;
            return retorno;
        }
        if (pontoJogador2 == 3) {
            retorno = 2;
            return retorno;
        }
        return retorno;
    }

    /*
    * Verifica se todas as posições do vetor tabuleiro estão ocupadas para 
    * validar velha e retorna false quando não der velha e true para velha.
    */
    public static boolean verificaVelha() {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i].equalsIgnoreCase("| |")) {
                return false;

            }
        }
        return true;
    }

    
    /*
    * Recebe o valor da rodada, define de quem é a vez e retorna o caractere
    * do jogador da vez.
    */
    public static String jogadorDaVez(int rodada) {
        if (rodada % 2 == 0) {
            System.out.println("Jogador 1");
            return "|X|";

        } else {
            System.out.println("Jogador 2");
            return "|O|";
        }
    }

    
    /*
    * Modo de jogo em que revezam o jogador1 e jogador2, ambos precisam digitar
    * coordenadas manualmente.
    */
    public static void modoJogador() {
        int pontoJogador1 = 0, pontoJogador2 = 0, rodada = 0, coordenada;
        String caractere;
        inicializaTabuleiro();
        imprimeTabuleiro();
        while (true) {
            caractere = jogadorDaVez(rodada);
            coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());

            while (posicaoValida(coordenada) == false) {
                System.out.println("Posicao Inválida");
                imprimeTabuleiro();
                coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());
            }
            tabuleiro[coordenada] = caractere;
            imprimeTabuleiro();
            rodada++;

            switch (verificaVencedorDeRodada()) {
                case 1:
                    System.out.println("Ponto para o Jogador 1\n");
                    pontoJogador1++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    break;
                case 2:
                    System.out.println("Ponto para o Jogador 2\n");
                    pontoJogador2++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    break;
                default:
                    if (verificaVelha() == true) {
                        System.out.println("Velha!\n");
                        imprimePontuacao(pontoJogador1, pontoJogador2);
                        inicializaTabuleiro();
                        imprimeTabuleiro();
                    }
                    break;
            }
            if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 1) {
                System.out.println("O Jogador 1 Venceu!");
                break;
            } else if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 2) {
                System.out.println("O Jogador 2 Venceu");
                break;

            }

        }

    }

    
    /*
    * Modo de jogo em que somente a entrada do jogador1 é manual e a entrada do
    * jogador2 é automática e aleatória.
    */
    public static void modoFacil() {
        Random gerar = new Random();
        int pontoJogador1 = 0, pontoJogador2 = 0, rodada = 0, coordenada;
        String caractere;
        inicializaTabuleiro();
        imprimeTabuleiro();
        while (true) {
            caractere = jogadorDaVez(rodada);
            if (rodada % 2 != 0) {
                coordenada = gerar.nextInt(9);

            } else {
                coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());
            }

            while (posicaoValida(coordenada) == false) {
                if (rodada % 2 != 0) {
                    coordenada = gerar.nextInt(9);
                } else {
                    System.out.println("Posicao Inválida");
                    imprimeTabuleiro();
                    coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());
                }
            }
            tabuleiro[coordenada] = caractere;
            imprimeTabuleiro();
            rodada++;

            switch (verificaVencedorDeRodada()) {
                case 1:
                    System.out.println("Ponto para o Jogador 1\n");
                    pontoJogador1++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    break;
                case 2:
                    System.out.println("Ponto para o Jogador 2\n");
                    pontoJogador2++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    break;
                default:
                    verificaVelha();
                    if (verificaVelha() == true) {
                        System.out.println("Velha!\n");
                        imprimePontuacao(pontoJogador1, pontoJogador2);
                        inicializaTabuleiro();
                        imprimeTabuleiro();
                    }
                    break;
            }
            if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 1) {
                System.out.println("O Jogador 1 Venceu!");
                break;
            } else if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 2) {
                System.out.println("O Jogador 2 Venceu!");
                break;

            }

        }

    }

    
    /*
    * Modo de jogo em que somente jogador1 tem entrada manual e jogador2 tem
    * entrada automática porém verifica índices ocupados no vetor e joga para
    * defender e vencer.
    */
    public static void modoDificil() {
        int pontoJogador1 = 0, pontoJogador2 = 0, rodada = 0, coordenada;
        String caractere;
        inicializaTabuleiro();
        imprimeTabuleiro();
        while (true) {
            caractere = jogadorDaVez(rodada);
            if (rodada % 2 != 0) {
                coordenada = 4;

            } else {
                coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());
            }

            while (posicaoValida(coordenada) == false) {
                if (rodada % 2 == 0) {
                    System.out.println("Posicao Inválida");
                    imprimeTabuleiro();
                    coordenada = converteCoordenadasEmPosicao(leiaCoordenadaLinha(), leiaCoordenadaColuna());
                } else {
                    
                    if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[1].equalsIgnoreCase("|O|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|O|") && tabuleiro[2].equalsIgnoreCase("|O|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[2].equalsIgnoreCase("|O|") && posicaoValida(1) == true) {
                        coordenada = 1;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && posicaoValida(5) == true) {
                        coordenada = 5;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|O|") && tabuleiro[5].equalsIgnoreCase("|O|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[5].equalsIgnoreCase("|O|") && posicaoValida(3) == true) {
                        coordenada = 3;
                        break;
                    } else if (tabuleiro[6].equalsIgnoreCase("|O|") && tabuleiro[7].equalsIgnoreCase("|O|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[6].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(7) == true) {
                        coordenada = 7;
                        break;
                    } else if (tabuleiro[7].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[3].equalsIgnoreCase("|O|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|") && posicaoValida(3) == true) {
                        coordenada = 3;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && posicaoValida(7) == true) {
                        coordenada = 7;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|O|") && tabuleiro[7].equalsIgnoreCase("|O|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[7].equalsIgnoreCase("|O|") && posicaoValida(1) == true) {
                        coordenada = 1;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[5].equalsIgnoreCase("|O|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(5) == true) {
                        coordenada = 5;
                        break;
                    } else if (tabuleiro[5].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[8].equalsIgnoreCase("|O|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[4].equalsIgnoreCase("|O|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|O|") && tabuleiro[6].equalsIgnoreCase("|O|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[1].equalsIgnoreCase("|X|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|X|") && tabuleiro[2].equalsIgnoreCase("|X|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[2].equalsIgnoreCase("|X|") && posicaoValida(1) == true) {
                        coordenada = 1;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && posicaoValida(5) == true) {
                        coordenada = 5;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|X|") && tabuleiro[5].equalsIgnoreCase("|X|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[5].equalsIgnoreCase("|X|") && posicaoValida(3) == true) {
                        coordenada = 3;
                        break;
                    } else if (tabuleiro[6].equalsIgnoreCase("|X|") && tabuleiro[7].equalsIgnoreCase("|X|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[6].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(7) == true) {
                        coordenada = 7;
                        break;
                    } else if (tabuleiro[7].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[3].equalsIgnoreCase("|X|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|") && posicaoValida(3) == true) {
                        coordenada = 3;
                        break;
                    } else if (tabuleiro[3].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && posicaoValida(7) == true) {
                        coordenada = 7;
                        break;
                    } else if (tabuleiro[1].equalsIgnoreCase("|X|") && tabuleiro[7].equalsIgnoreCase("|X|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[7].equalsIgnoreCase("|X|") && posicaoValida(1) == true) {
                        coordenada = 1;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[5].equalsIgnoreCase("|X|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(5) == true) {
                        coordenada = 5;
                        break;
                    } else if (tabuleiro[5].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && posicaoValida(8) == true) {
                        coordenada = 8;
                        break;
                    } else if (tabuleiro[0].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[8].equalsIgnoreCase("|X|") && posicaoValida(0) == true) {
                        coordenada = 0;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[4].equalsIgnoreCase("|X|") && posicaoValida(6) == true) {
                        coordenada = 6;
                        break;
                    } else if (tabuleiro[2].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|") && posicaoValida(4) == true) {
                        coordenada = 4;
                        break;
                    } else if (tabuleiro[4].equalsIgnoreCase("|X|") && tabuleiro[6].equalsIgnoreCase("|X|") && posicaoValida(2) == true) {
                        coordenada = 2;
                        break;
                    } else {
                        coordenada = coordenada + 2;
                        if (coordenada > 8) {
                            coordenada = 1;    
                        }
                    }
                }
            }
            tabuleiro[coordenada] = caractere;
            imprimeTabuleiro();
            rodada++;

            switch (verificaVencedorDeRodada()) {
                case 1:
                    System.out.println("Ponto para o Jogador 1\n");
                    pontoJogador1++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    if (rodada % 2 != 0){
                        rodada++;
                    }
                    break;
                case 2:
                    System.out.println("Ponto para o Jogador 2\n");
                    pontoJogador2++;
                    imprimePontuacao(pontoJogador1, pontoJogador2);
                    inicializaTabuleiro();
                    imprimeTabuleiro();
                    if (rodada % 2 == 0){
                        rodada++;
                    }
                    break;
                default:
                    verificaVelha();
                    if (verificaVelha() == true) {
                        System.out.println("Velha!\n");
                        imprimePontuacao(pontoJogador1, pontoJogador2);
                        inicializaTabuleiro();
                        imprimeTabuleiro();
                    }
                    break;
            }
            if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 1) {
                System.out.println("O Jogador 1 Venceu!");
                break;
            } else if (verificaVencedorDePartida(pontoJogador1, pontoJogador2) == 2) {
                System.out.println("O Jogador 2 Venceu!");
                break;

            }

        }
    }
}
