/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.GUI;

import Discover.Game.Casillas.Casilla;
import Discover.Game.Casillas.Tarjetas.*;
import Discover.Game.Casillas.Tarjetas.ListaTarjeta;
import Discover.Game.Casillas.Tarjetas.Tarjeta;
import Discover.Game.Casillas.TipoCasilla;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author dany
 */
public class TableroJuego extends JPanel {
    
    private final JFrame frame;

    /**
     * Crea un nuevo Tablero
     *
     * @param xCoord punto en x donde se va a dibujar
     * @param yCoord punto en x donde se va a dibuja
     * @param width es el tamanio de ancho que va tener
     * @param height es el tamanio de alto que va tener
     * @param frame es el frame donde se va aniadir, se utilizo para los
     * jdialogs como TipoCasilla, TipoTarjeta
     * @throws Exception una excepcion
     */
    public TableroJuego(int xCoord, int yCoord, int width, int height, JFrame frame) throws Exception {
        this.frame = frame;
        setBounds(xCoord, yCoord, width, height);
        this.setLayout(null);
        Casilla casillas = new Casilla();
        ImprimirCasillaMatriz();
        
    }
    static public int cantidadCasillasFila = (NuevoTablero.cantidadCasillas / 4) + 1;
    static public int cantidadCasillasColumna = ((NuevoTablero.cantidadCasillas / 4) + 1) - 2;
    
    static public int cantidadCasillasUsuario = NuevoTablero.cantidadCasillas;
    static public int[] coordenandaXCasilla = new int[cantidadCasillasUsuario + 1];
    static public int[] coordenandaYCasilla = new int[cantidadCasillasUsuario + 1];
    static public Casilla[] todasCasillas, CasillaFila1, CasillaColumna1, CasillaFila2, CasillaColumna2;
    static public Tarjeta[] tarjetas = new Tarjeta[NuevoTablero.cantidadTarjetas + 1];
    static public  ListaTarjeta lista;
    
    
    /**
     * crea cada casilla dependiendo de la cantidad queel usaurio haya
     * especificado, despues de crarlos las muestra cada casilla es guardada en
     * un vector dependiendo dependiendo si va a ir en una fila o una columna
     * con el fin de que lleve una secuencia, con el fin de que los jugadores se
     * muevan en un sentido
     *tambien se crean las tarjetas despues de haber creado las casillas
     *
     * @throws Exception una excepcion
     */
    public void ImprimirCasillaMatriz() throws Exception {
        
        Casilla casillas = new Casilla();
//
        int contador = 0;
        int i, j, k = 0, l;
        CasillaFila1 = new Casilla[cantidadCasillasFila + 1];
        CasillaColumna1 = new Casilla[cantidadCasillasColumna + 2];
        CasillaFila2 = new Casilla[cantidadCasillasFila + 1];
        CasillaColumna2 = new Casilla[cantidadCasillasColumna + 2];
        
        todasCasillas = new Casilla[cantidadCasillasUsuario + 1]; //aqui guardo todas las casillas creadas

        for (i = 1; i < CasillaFila1.length; i++) {
            TipoCasilla tipocasillasFila1 = new TipoCasilla(frame, true);
            tipocasillasFila1.setLocationRelativeTo(null);
            tipocasillasFila1.setVisible(true);
            CasillaFila1[i] = casillas.generarCasillas(tipocasillasFila1.getTipo(), tipocasillasFila1.getNombre(), tipocasillasFila1.getPrecio(), tipocasillasFila1.getPrecioEstancia(), i * 100, 100);
            todasCasillas[contador] = CasillaFila1[i];
            
            this.add(todasCasillas[contador]);
            System.out.println(i * 1 + "," + 1);
            System.out.println("precio: " + tipocasillasFila1.getPrecio() + "estancia:" + tipocasillasFila1.getPrecioEstancia());
            coordenandaXCasilla[contador] = i * 1;
            coordenandaYCasilla[contador] = 1;
            
            contador++;
            
        }
        for (j = 2; j < CasillaColumna1.length; j++) {
            TipoCasilla tipocasillasColumna1 = new TipoCasilla(frame, true);
            tipocasillasColumna1.setLocationRelativeTo(null);
            tipocasillasColumna1.setVisible(true);
            CasillaColumna1[j] = casillas.generarCasillas(tipocasillasColumna1.getTipo(), tipocasillasColumna1.getNombre(), tipocasillasColumna1.getPrecio(), tipocasillasColumna1.getPrecioEstancia(), i * 100 - 100, j * 100);
            todasCasillas[contador] = CasillaColumna1[j];
            
            this.add(todasCasillas[contador]);
            System.out.println((i * 1 - 1) + "," + j * 1);
            System.out.println("precio: " + tipocasillasColumna1.getPrecio() + "estancia:" + tipocasillasColumna1.getPrecioEstancia());
            coordenandaXCasilla[contador] = (i * 1 - 1);
            coordenandaYCasilla[contador] = j;
            
            contador++;
            
        }
        
        for (k = i - 1; k > 0; k--) {
            TipoCasilla tipocasillasFila1 = new TipoCasilla(frame, true);
            tipocasillasFila1.setLocationRelativeTo(null);
            tipocasillasFila1.setVisible(true);
            CasillaFila2[k] = casillas.generarCasillas(tipocasillasFila1.getTipo(), tipocasillasFila1.getNombre(), tipocasillasFila1.getPrecio(), tipocasillasFila1.getPrecioEstancia(), k * 100, j * 100);
            todasCasillas[contador] = CasillaFila2[k];
            
            this.add(todasCasillas[contador]);
            System.out.println((k * 1) + "," + j * 1);
            System.out.println("precio: " + tipocasillasFila1.getPrecio() + "estancia:" + tipocasillasFila1.getPrecioEstancia());
            coordenandaXCasilla[contador] = k * 1;
            coordenandaYCasilla[contador] = j * 1;
            
            contador++;
            
        }
        for (l = j - 1; l > 1; l--) {
            TipoCasilla tipocasillasColumna1 = new TipoCasilla(frame, true);
            tipocasillasColumna1.setLocationRelativeTo(null);
            tipocasillasColumna1.setVisible(true);
            CasillaColumna2[l] = casillas.generarCasillas(tipocasillasColumna1.getTipo(), tipocasillasColumna1.getNombre(), tipocasillasColumna1.getPrecio(), tipocasillasColumna1.getPrecioEstancia(), k * 100 + 100, l * 100);
            todasCasillas[contador] = CasillaColumna2[l];
            
            this.add(todasCasillas[contador]);
            System.out.println((k * 1 + 1) + "," + l * 1);
            System.out.println("precio: " + tipocasillasColumna1.getPrecio() + "estancia:" + tipocasillasColumna1.getPrecioEstancia());
            coordenandaXCasilla[contador] = k * 1 + 1;
            coordenandaYCasilla[contador] = l * 1;
            
            contador++;
            
        }

        //imprime en la consola las coordenadas de las casillas creadas
        System.out.println("Lista de coordenadas");
        for (int m = 0; m < coordenandaXCasilla.length; m++) {
            System.out.println(coordenandaXCasilla[m] + "," + coordenandaYCasilla[m]);
        }

        // Aqui se crean las tarjetas y se gurdan en ListaTarjetas
        lista = new ListaTarjeta();
        
        for (int m = 0; m < NuevoTablero.cantidadTarjetas; m++) {
            
            TipoTarjeta tipoTarjeta = new TipoTarjeta(frame, true);
            tipoTarjeta.setLocationRelativeTo(null);
            tipoTarjeta.setVisible(true);
            
            lista.agregarTarjeta(lista.generarCasillas(tipoTarjeta.getTipo(),tipoTarjeta.getCantidadCopias(), tipoTarjeta.getMensaje()));
            lista.listar();
            System.out.print(" | Tamaño: ");
            System.out.println(lista.getTamanio());
            System.out.println(lista.getMensaje(0));
        }
        
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
    
}
