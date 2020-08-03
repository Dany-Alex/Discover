/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.GUI;

import Discover.Game.Casillas.Casilla;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author dany
 */
public class Jugador extends JPanel {

    private int numeroJugador;
    JLabel numreoJugadorLabel;
    static int totalJugadores = 0; // podría necesitar este número más adelante

    private int billetera = 3200; // Dinero Inicial

    private int numeroCasillaActual = 1; // donde el jugador se encuentra actualmente. inicialmente cero
    private int[] titulosPropiedad = new int[100]; // casillas que tiene el jugador
    private Casilla[] titulosPropiedadJugador = new Casilla[TableroJuego.coordenandaXCasilla.length]; // casillas que tiene el jugador

    public int getBilletera() {
        return billetera;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }


    public void setBilletera(int billetera) {
        this.billetera = billetera;
    }

    public int getNumeroCasillaActual() {
        return numeroCasillaActual;
    }

    public Casilla[] getTitulosPropiedadJugador() {
        return titulosPropiedadJugador;
    }

    public boolean isComprado() {
        return comprado;
    }
    
    int contador=0;
    boolean comprado;
    
    /**
     * compra una casilla y la agraga a arreglo de propiedades del usuario 
     * @param numeroCasilla le indiaca el numero de casilla actual del jugador 
     */
	public void comprarPropiedad(int numeroCasilla) {
		if(TableroJuego.todasCasillas[numeroCasilla].getPropietario()!=0) {
                   comprado=false;
			System.out.println("Ya lo compró alguien. No puedes por aquí.");
		} else {
                    comprado=true;
                    System.out.println("Felicidades!! adquiriste una nueva propiedad!");
			titulosPropiedadJugador[contador]=(TableroJuego.todasCasillas[numeroCasilla]);
			TableroJuego.todasCasillas[numeroCasilla].setPropietario(getNumeroJugador());
                        
                        System.out.println("propiedad adquirida: "+titulosPropiedadJugador[contador].getNombre()+" ---- Numero propietario: "+getNumeroJugador());
                        contador++;
		}
	}

    /**
     * se utiliza para restarle la cantidad enviada (por medio del parametro) a la billetera del jugador
     * @param cantidadRetirarBilletera es un valor entero que indica cuanto se va a restar a la billetera del jugador
     */
    public void retirarBilletera(int cantidadRetirarBilletera) {
        if (cantidadRetirarBilletera > billetera) {
            setVisible(false);
            System.out.println("Jugador " + getNumeroJugador() + " se declara en bancarrota!");
        } else {
            billetera -= cantidadRetirarBilletera;
        }
    }

    
/**
 * le suma a la billatar la cantidad especificada en el monto recivido por el parametro cantidadDepositoBilletera
 * @param cantidadDepositoBilletera es un valor entero que indica cuanto se va a sumar a la billetera del jugador
 */
    public void depositoBilletera(int cantidadDepositoBilletera) {
        billetera += cantidadDepositoBilletera;
        System.out.println("El Jugador " + getNumeroJugador() + ". se ha acreditado a la billetera la cantidad de Q."+cantidadDepositoBilletera+" !");
    }

    public boolean tineTituloPropiedad(int numeroCasilla) {
        return  false;
    }
    
    public Jugador(int xCoord, int yCoord, int width, int height) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(xCoord, yCoord, 20, 20);
		this.setLayout(null);
	}
/**
 * creamos un jugador
 * @param xCoord    le enviamos la coodenanda X donde queremos que aparezca
 * @param yCoord    le enviamos la coodenanda X donde queremos que aparezca
 * @param numeroJugador le enviamos el numero de jugador que es
 * @param color     le enviamos el color de ficha 
 */
	public Jugador(int xCoord, int yCoord,int numeroJugador, Color color) {
		// TODO Auto-generated constructor stub
		this.numeroJugador = numeroJugador;
		this.setBackground(color);
		numreoJugadorLabel = new JLabel(""+numeroJugador);
		numreoJugadorLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		numreoJugadorLabel.setForeground(Color.WHITE);
		this.add(numreoJugadorLabel); 
		this.setBounds(xCoord,yCoord, 20, 20); 
		totalJugadores++;
	}
              
        /**
         * sirve para que el jugador se pueda mover por medio de un setLocation
         * @param totalDado este parametro resive la suma de dados, para hacer el calculo y saber a que casilla moverse
         */
        public void mover(int totalDado) {
		if(numeroCasillaActual + totalDado > Casilla.totalCasillas) {
			depositoBilletera(NuevoTablero.cantidadDineroVuelta);
		}
                  System.out.println("Casilla casilla Actual"+numeroCasillaActual);
		int casillaObjetivo = (numeroCasillaActual + totalDado)%Casilla.totalCasillas;
		numeroCasillaActual = casillaObjetivo;
		
                
			this.setLocation((TableroJuego.coordenandaXCasilla[casillaObjetivo]*100)+40, (TableroJuego.coordenandaYCasilla[casillaObjetivo]*100)+55);
                        System.out.println("Casilla nueva casilla Actual"+numeroCasillaActual+"Casilla objetivo: "+casillaObjetivo+"---El jugador se movio a la cooordenada: "+TableroJuego.coordenandaXCasilla[casillaObjetivo]+","+TableroJuego.coordenandaYCasilla[casillaObjetivo]);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
