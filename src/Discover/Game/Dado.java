/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author dany
 */
public class Dado extends JPanel implements Runnable{

    
    Random rnd = new Random();
    int valorCaraDado = 1;
/**
 * crea un dado 
 * @param xCoord punto en x donde se va a dibujar el dado
 * @param yCoord punto en y donde se va a dibujar el dado
 * @param widthHeight el tamanio del dado tanto de alto como de ancho, poque es cuadrado 
 */
    public Dado(int xCoord, int yCoord, int widthHeight) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, widthHeight, widthHeight);
    }

int tamanioCirculo = (10);

/**
 * 
 * pinta los circulo/s en la cara del dado, dependiendo del la variable valorCaraDado
 * @param g El contexto gráfico a utilizar para pintar
 */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (valorCaraDado == 1) {
            g.fillOval(getWidth() / 2 - tamanioCirculo/2, getHeight() / 2 - tamanioCirculo/2, tamanioCirculo, tamanioCirculo);
        } else if (valorCaraDado == 2) {
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
        } else if (valorCaraDado == 3) {
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - tamanioCirculo/2, getHeight() / 2 - tamanioCirculo/2, tamanioCirculo, tamanioCirculo);
        } else if (valorCaraDado == 4) {
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
        } else if (valorCaraDado == 5) {
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - tamanioCirculo/2, getHeight() / 2 - tamanioCirculo/2, tamanioCirculo, tamanioCirculo);
        } else {
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 - 3*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 + 2*(tamanioCirculo), tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 - 3*(tamanioCirculo), getHeight() / 2 - tamanioCirculo/2 , tamanioCirculo, tamanioCirculo);
            g.fillOval(getWidth() / 2 + 2*(tamanioCirculo), getHeight() / 2 - tamanioCirculo/2 , tamanioCirculo, tamanioCirculo);
        }

    }
    
/**
 * genera un numero aleatorio entre 1 y 6, despues repinta los circulo/s en la cara del dado
 */
    public void tirarDado() {
        valorCaraDado = rnd.nextInt(6) + 1;
        repaint();
    }

    /**
     * obtiene / devuelve el valor de la cara del dado
     * @return un entero valorCaraDado
     */
    public int getValorCaraDado() {
        return valorCaraDado;
    }

    public Dado(int xCoord, int yCoord, int width, int height, String labelString) {
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, width, height);

    }
/**
 * llama al metodo tirarDado
 */
    @Override
    public void run() {
       tirarDado();
       
    }

}
