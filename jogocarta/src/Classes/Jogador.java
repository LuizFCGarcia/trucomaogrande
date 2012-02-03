/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Classes;

/**
 *
 * @author Leonardo
 */
public class Jogador {

    private Cartas[] cartas;

    public Jogador(){
        this.cartas = Baralho.darCartas();
    }

    public void recebeCartas(){
        this.cartas = Baralho.darCartas();
    }
    
    public Cartas getCartasC(int i){
        return cartas[i];
    }
}
