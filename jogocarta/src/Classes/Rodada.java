/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Magaly
 */
public class Rodada {

    private Jogador[] jogadores;
    private int quemJoga;
    private ArrayList<Cartas> vetorCarta;

    public Rodada(Jogador[] jogadores, int quemJoga) {
        this.jogadores = jogadores;
        this.quemJoga = quemJoga;
    }

    public Rodada(int quemJoga) {
        this.quemJoga = quemJoga;
    }

    public void addCarta(Cartas carta) {
        vetorCarta.add(quemJoga, carta);
    }

    public void limparVetorCarta() {
        vetorCarta.clear();
    }

    public void setManilha() {
        int vira;
        int numManilha;

        vira = Baralho.getViraValor();

        if (vira == 9) {
            numManilha = 0;
        } else {
            numManilha = vira + 1;
        }

        Baralho.setManilha(numManilha);

    }

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public int getQuemJoga() {
        return quemJoga;
    }

    public void setQuemJoga(int quemJoga) {
        this.quemJoga = quemJoga;
    }

    public ArrayList<Cartas> getVetorCarta() {
        return vetorCarta;
    }

    public void setVetorCarta(ArrayList<Cartas> vetorCarta) {
        this.vetorCarta = vetorCarta;
    }
}
