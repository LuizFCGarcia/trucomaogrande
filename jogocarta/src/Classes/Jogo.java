/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leonardo
 */
public class Jogo {

    private Jogador[] jogador;
    private int[] pontos;
    private Rodada[] rodada;
    private int rodadaC;

    public Jogo() {
        pontos = new int[2];
        Baralho.geraVira();
        rodadaC = 0;
        jogador = new Jogador[4];
        rodada = new Rodada[3];
        rodada[0] = new Rodada(jogador, rodadaC);
        rodada[0].setManilha();
        for (int i = 0; i < 4; i++) {
            jogador[i] = new Jogador();
        }
        for (int i = 0; i < 2; i++) {
            pontos[i] = 0;
        }
    }

    public void novoJogo() {
        do {
            Baralho.embaralhar();
            Baralho.geraVira();
            rodada[rodadaC] = new Rodada(rodadaC);
            rodada[rodadaC].setManilha();

            for (int i = 0; i < 4; i++) {
                jogador[i].recebeCartas();
            }
            if (rodadaC < 2) {
                rodadaC++;
                return;
            } else {
                rodadaC = 0;
            }
        } while (pontos[0] <= 11 || pontos[1] <= 11);
    }

    public Jogador getJogador(int i) {
        return jogador[i];
    }
}
