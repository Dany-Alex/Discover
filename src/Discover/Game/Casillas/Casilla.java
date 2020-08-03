/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.Game.Casillas;


import Discover.GUI.NuevoTablero;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author dany
 */
public class Casilla extends JPanel {

    public int tipo;

    public Color color;
    int propietario=0;
    int numero;
    private String nombre;
    String descripcion;
    JLabel nombreLabel;
    public static int totalCasillas = 0;
    private int precio,precioEstancia;
    private boolean comprable, disponible=true;
    

    public Casilla() {

    }

    public int getTipo() {
        return tipo;
    }
    
    

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public boolean isComprable() {
        return comprable;
    }

    public int getPropietario() {
        return (propietario);
    }

    public int getPrecioEstancia() {
        return precioEstancia;
    }

    public void setPrecioEstancia(int precioEstancia) {
        this.precioEstancia = precioEstancia;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }
    

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
/**
 * crea una casilla nueva 
 * @param tipo sirve para saber el tipo de la casilla que se desea crear 
 * @param xCoord la posisicion X en donde se desea dibujar la casilla
 * @param yCoord la posisicion Y en donde se desea dibujar la casilla
 * @param ancho sirve para saber el ancho de la casilla que se desea crear 
 * @param alto sirve para saber el alto de la casilla que se desea crear 
 * @param labelString sirve para saber el nombre de la casilla que se desea crear 
 * @param precio sirve para saber el precio de la casilla que se desea crear 
 * @param precioEstancia sirve para saber el precio de estancia de la casilla que se desea crear 
 * @param gradosRotacion sirve para saber el la direccion en la que se va a dibujar la casilla que se desea crear 
 * @param comprable sirve para saber el si la casilla se puede compra o no 
 */
    public Casilla(int tipo, int xCoord, int yCoord, int ancho, int alto, String labelString,int precio,int precioEstancia, int gradosRotacion, boolean comprable) {
        this.precio=precio;
        this.precioEstancia=precioEstancia;
        this.tipo = tipo;
        this.comprable=comprable;
        numero = totalCasillas;
        nombre = labelString;
         
        totalCasillas++;
        setBorder(new LineBorder(new Color(0, 0, 0)));
        setBounds(xCoord, yCoord, ancho, alto);
       
        
        this.setLayout(null);

        if (gradosRotacion == 0) {
            nombreLabel = new JLabel(labelString);
            nombreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
            nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            nombreLabel.setBounds(0, 20, this.getWidth(), 20);
            this.add(nombreLabel);
        } else {

            nombreLabel = new JLabel(labelString) {
                protected void paintComponent(Graphics g) {
                    Graphics2D g2 = (Graphics2D) g;
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    AffineTransform aT = g2.getTransform();
                    Shape oldshape = g2.getClip();
                    double x = getWidth() / 2.0;
                    double y = getHeight() / 2.0;
                    aT.rotate(Math.toRadians(gradosRotacion), x, y);
                    g2.setTransform(aT);
                    g2.setClip(oldshape);
                    super.paintComponent(g);
                }
            };
            if (gradosRotacion == 90) {
                nombreLabel.setBounds(20, 0, this.getWidth(), this.getHeight());
            }
            if (gradosRotacion == -90) {
                nombreLabel.setBounds(-10, 0, this.getWidth(), this.getHeight());
            }
            if (gradosRotacion == 180) {
                nombreLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            if (gradosRotacion == 135 || gradosRotacion == -135 || gradosRotacion == -45 || gradosRotacion == 45) {
                nombreLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
            }
            nombreLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
            nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);

            this.add(nombreLabel);

        }

    }

    
    /**
     * 
     * @param tipo sirve para ver que tipo de casillas
     * @param nombre el nombre que se desea colocar a nuestra casilla
     * @param precio sirve para especificar el precio de la casilla
     * @param precioEstancia sirve para especificar el precio de la casilla
     * @param posicionX la posisicion X en donde se desea dibujar la casilla
     * @param posicionY la posisicion Y en donde se desea dibujar la casilla
     * @return retorna una objeto casilla
     */
    public Casilla generarCasillas(int tipo, String nombre,int precio, int precioEstancia, int posicionX, int posicionY) {

        Casilla actual = null;
        int tamanio=100;

        switch (tipo) {
            case 0:
                actual = new Inicio(0, posicionX, posicionY, tamanio, tamanio, "Inicio", 0);
                return actual;
            case 1:
                actual=new Propiedad(0, precio, precioEstancia, (precio/2), estaRentada, 1, posicionX, posicionY, tamanio, tamanio, nombre, 0);
                return actual;
            case 2:
                actual = new Lugar(0, precio, precioEstancia, (precio/2), estaRentada, 2, posicionX, posicionY, tamanio, tamanio, nombre, 0);
                return actual;
            case 3:
                actual = new Estacion(0, precio, precioEstancia, (precio/2), estaRentada, 3, posicionX, posicionY, tamanio, tamanio, nombre, 0);
                return actual;
            case 4:
                actual = new Servicio(0, precio, precioEstancia, (precio/2), estaRentada, 4, posicionX, posicionY, tamanio, tamanio, nombre, 0);
                return actual;
            case 5:
                actual = new TomarTarjeta(5, posicionX, posicionY, tamanio, tamanio, "Tomar Tarjeta", 0);
                return actual;
            case 6:
                actual = new Carcel(6, posicionX, posicionY, tamanio, tamanio, "Carcel", 0);
                return actual;
            case 7:
                actual = new Casilla(7, posicionX, posicionY, tamanio, tamanio, "Casilla",precio, precioEstancia, 0,false);
                return actual;
            case 8:
                actual = new Trampa(8, posicionX, posicionY, tamanio, tamanio, "Casilla", 0);
                return actual;

        }

        return actual;

    }
    
    /**
     * pinta las casiilas dependiendo de que tipo sean 
     * @param g El contexto gráfico a utilizar para pintar
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.tipo == 0) {

            g.setColor(Color.getHSBColor(297, 0, 38));
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        if (this.tipo == 1) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if (this.tipo == 2) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.red);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if (this.tipo == 3) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if (this.tipo == 4) {
            g.drawRect(0, 0, this.getWidth(), 20);
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if (this.tipo == 5) {
           
            g.setColor(Color.ORANGE);
            g.fillRect(0, 0, this.getWidth(), 20);
        }
        if (this.tipo == 6) {
            
            g.setColor(Color.blue.brighter());
            g.fillRect(0, 0, this.getWidth()/2, 20);
            g.setColor(Color.red.brighter());
            g.fillRect(this.getWidth()/2, 0, this.getWidth()/2, 20);
        }
        if (this.tipo == 7) {
       
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, this.getWidth(), 20);
        }

    }
    private boolean estaRentada = false;
/**
 * sirve para saber si se paga estancia
 * @return un false o un true
 */
    public boolean sePagaEstancia() {
        return estaRentada;
    }

    public void setPagoEstancia(boolean pago) {
        estaRentada = pago;
    }

}
