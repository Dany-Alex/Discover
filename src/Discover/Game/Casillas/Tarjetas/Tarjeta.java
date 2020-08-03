/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.Game.Casillas.Tarjetas;

import Discover.GUI.Jugador;

/**
 *
 * @author dany
 */
public class Tarjeta {
    int grupo;
    int cantidadCopias;
    private int valor;
    String mensaje;
    Tarjeta siguiente;
    Jugador jugadorActual;
    /**
     * crea una nueva tarjeta
     * @param grupo sirve para asignar un grupo a la tarjeta
     * @param cantidadCopias sirve para saber la cantidad de copias que hay de la tarjeta
     * @param mensaje sirve para guardar un mensaje para la tarjeta y sea mostrado mas adelante
     */
    public Tarjeta(int grupo, int cantidadCopias, String mensaje) {
        this.grupo = grupo;
        this.cantidadCopias = cantidadCopias;
        this.mensaje = mensaje;
        this.siguiente = siguiente;
    }

 

    public Tarjeta() {
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getCantidadCopias() {
        return cantidadCopias;
    }

    public void setCantidadCopias(int cantidadCopias) {
        this.cantidadCopias = cantidadCopias;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Tarjeta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Tarjeta siguiente) {
        this.siguiente = siguiente;
    }


    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }
    
    
    
}
