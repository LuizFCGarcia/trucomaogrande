/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leonardo
 */
public class Cartas {

    private int valorCarta;
    private boolean eManilha;
    private char naipe;
    private boolean selecionada;
    private String cartaNaipada;
    private char valorAbsoluto;

    public Cartas() {
        setCarta(-1,'x');
        setManilha(false);
    }

    public boolean iseManilha() {
        return eManilha;
    }

    public void seteManilha(boolean eManilha) {
        this.eManilha = eManilha;
    }

    public char getNaipe() {
        return naipe;
    }

    public void setNaipe(char naipe) {
        this.naipe = naipe;
    }
    

   public void setCarta(int v,char c){
       this.valorCarta = v;
       this.naipe = c;
   }

    public boolean isManilha() {
        return eManilha;
    }

    public void setManilha(boolean eManilha) {
        this.eManilha = eManilha;
    }

    public boolean isSelecionada() {
        return selecionada;
    }

    public void setSelecionada(boolean selecionada) {
        this.selecionada = selecionada;
    }

    public int getValorCarta() {
        return valorCarta;
    }

    public void setValorCarta(int valorCarta) {
        this.valorCarta = valorCarta;
    }

    public String getCartaNaipada() {
        return cartaNaipada;
    }

    public void setCartaNaipada(String cartaNaipada) {
        this.cartaNaipada = cartaNaipada;
    }

    public char getValorAbsoluto() {
        return valorAbsoluto;
    }

    public void setValorAbsoluto(char valorAbsoluto) {
        this.valorAbsoluto = valorAbsoluto;
    }
    
    
   
}
