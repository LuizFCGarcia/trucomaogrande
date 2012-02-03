/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Random;

/**
 *
 * @author Leonardo
 */
public class Baralho {

    private static Cartas[] cartas;
    private static Cartas vira;
    private static int manilha;

    public Baralho() {
        int temp1 = 0;//usada para controlar o naipe da carta
        int temp2 = 0;//usada para controlar o valor da carta
        cartas = new Cartas[40]; //inicia o baralho com 4 naipes e 10 valores
        // 0 - paus, 1 - copas, 2 - espada, 3 - ouros(pica)
        for (int valores = 0; valores < 40; valores++) {
            if (valores % 4 == 0 && valores != 0) { //caso % = 0, passamos para outro valor de carta
                temp1 = 0; //zermos o naipe, para que comece td de novo, porem com um valor de carta diferente
                temp2++; //valor da carta eh incrementado
            }
            char n = setNaipe(temp1);
            temp1++;//o naipe eh incrementado a cada loop, sendo zerado quando o valor da carta mudar
            cartas[valores] = new Cartas();
            cartas[valores].setCarta(temp2, n);
            cartas[valores].setCartaNaipada(Integer.toString((temp2 + 4) % 10) + n);
            cartas[valores].setValorAbsoluto(Integer.toString((temp2 + 4) % 10).charAt(0));
            transforma(cartas[valores]);
        }
    }

    public static void transforma(Cartas entrada) {
        switch (entrada.getValorAbsoluto()) {
            case '8':
                entrada.setValorAbsoluto('Q');
                break;
            case '9':
                entrada.setValorAbsoluto('J');
                break;
            case '0':
                entrada.setValorAbsoluto('K');
                break;
            case '1':
                entrada.setValorAbsoluto('A');
                break;
        }
    }

    public static char transforma(char entrada) {
        switch (entrada) {
            case '8':
                entrada = 'Q';
                break;
            case '9':
                entrada = 'J';
                break;
            case '0':
                entrada = 'K';
                break;
            case '1':
                entrada = 'A';
                break;
        }
        return entrada;
    }

    public static void setManilha(int valorAbsoluto) {
        for (int i = 0; i < 4; i++) {
            cartas[valorAbsoluto * i].setManilha(true);
        }
        manilha = valorAbsoluto;
    }

    public static char getManilha() {
        char temp;
        temp = transforma(Integer.toString((manilha+4)%10).charAt(0));
        return temp;
    }
    
    private static char setNaipe(int i) {
        char n = ' ';
        switch (i) {
            case 0:
                n = 'c';
                break;
            case 1:
                n = 'd';
                break;
            case 2:
                n = 'h';
                break;
            case 3:
                n = 's';
                break;
        }
        return n;
    }

    public static void embaralhar() {
        for (int valores = 0; valores < 40; valores++) {
            cartas[valores].setSelecionada(false);
            cartas[valores].setManilha(false);
        }
    }

    public static void geraVira() {
        Random rand1 = new Random();
        Random rand2 = new Random();
        int naipe = rand1.nextInt(4);
        int carta = rand2.nextInt(10);
        String naipada;

        char n = setNaipe(naipe);

        naipada = Integer.toString(carta) + n;

        vira = new Cartas();
        vira.setValorAbsoluto(Integer.toString((carta + 4) % 10).charAt(0));
        transforma(vira);
        vira.setCarta(carta, n);
        vira.setManilha(false);
        vira.setSelecionada(true);
        vira.setCartaNaipada(naipada);
    }

    public static int getValorCarta(int valor) {
        return cartas[valor].getValorCarta();
    }

    public static int getViraValor() {
        return vira.getValorCarta();//pega o valor da carta para sabermos a manilha
    }

    public static String getNaipada() {
        return vira.getCartaNaipada();
    }

    public static String getAbsoluto() {
        return vira.getValorAbsoluto() + "" + vira.getNaipe();
    }

    //METODO QUE DA AS CARTAS AOS JOGADORES
    public static Cartas[] darCartas() {
        Cartas[] cartasDadas = new Cartas[3];//inicializa o vetor com 3 cartas
        int numCartas = 0;//dara 3 cartas ao jogador

        do {//randomiza as cartas,
            Random rand2 = new Random();
            int carta = rand2.nextInt(40);

            if (!cartas[carta].isSelecionada()) {//verifica se a carta ja nao foi dada
                cartasDadas[numCartas] = cartas[carta]; //caso nao, da a carta
                cartas[carta].setSelecionada(true); //marca como dada para nao haver repetição
                numCartas++;//incrementa em 1 o nº de cartas dadas
            }

        } while (numCartas < 3);//faz todo o processo 3 vezes

        return cartasDadas;//retora o vetor com as 3 cartas para o dado jogador
    }
}
