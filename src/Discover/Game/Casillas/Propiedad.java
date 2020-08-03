/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.Game.Casillas;

import java.awt.Color;

/**
 *
 * @author dany
 */
public class Propiedad extends Casilla{
    public int propietario;
    public int precioCompra,precioEstancia,precioHipoteca;
    public boolean estado;
    /**
     * crea una nueva prepiedad
     * @param propietario sirve para saber el elprepietario de la casilla que se desea crear 
     * @param precioCompra sirve para saber el precio de compra de la casilla que se desea crear 
     * @param precioEstancia sirve para saber el precio de estancia de la casilla que se desea crear 
     * @param precioHipoteca sirve para saber el precio por hipotecar la casilla que se desea crear 
     * @param estado sirve para saber estado de la casilla que se desea crear 
     */
    public Propiedad(int propietario, int precioCompra, int precioEstancia, int precioHipoteca, boolean estado) {
        this.propietario = propietario;
        this.precioCompra = precioCompra;
        this.precioEstancia = precioEstancia;
        this.precioHipoteca = precioHipoteca;
        this.estado = estado;
    }
    
    /**
     * crea una nueva prepiedad
     * @param propietario sirve para saber el elprepietario de la casilla que se desea crear 
     * @param precioCompra sirve para saber el precio de compra de la casilla que se desea crear 
     * @param precioEstancia sirve para saber el precio de estancia de la casilla que se desea crear 
     * @param precioHipoteca sirve para saber el precio por hipotecar la casilla que se desea crear 
     * @param estado sirve para saber estado de la casilla que se desea crear 
     * @param tipo sirve para saber el tipo de la casilla que se desea crear 
     * @param xCoord la posisicion X en donde se desea dibujar la casilla
     * @param yCoord la posisicion Y en donde se desea dibujar la casilla
     * @param ancho sirve para saber el ancho de la casilla que se desea crear 
     * @param alto sirve para saber el alto de la casilla que se desea crear 
     * @param labelString sirve para saber el nombre de la casilla que se desea crear 
     * @param gradosRotacion sirve para saber el la direccion en la que se va a dibujar la casilla que se desea crear 
     */

    public Propiedad(int propietario, 
                     int precioCompra, 
                     int precioEstancia, 
                     int precioHipoteca, 
                     boolean estado, 
                     int tipo, 
                     int xCoord, 
                     int yCoord, 
                     int ancho, 
                     int alto, 
                     String labelString, 
                     int gradosRotacion) {
        super(tipo, xCoord, yCoord, ancho, alto, labelString,precioCompra, precioEstancia, gradosRotacion, true);
        
        this.propietario = propietario;
        this.precioCompra = precioCompra;
        this.precioEstancia = precioEstancia;
        this.precioHipoteca = precioHipoteca;
        this.estado = estado;
    }



    
    
}
