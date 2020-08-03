/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discover.GUI;

import Discover.Game.Casillas.Casilla;
import Discover.Game.Dado;
import java.awt.*;
//import java.awt.Color;
//import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.DefaultListModel;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.*;
//import javax.swing.JLabel;
//import javax.swing.JLayeredPane;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
////import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author dany
 */
public class Discover extends JFrame implements Serializable, Runnable {

    /**
     * Creates new form Discover
     */
    TableroJuego tableroJuego;
    private JPanel contenidoPanel;
    static JTextArea informacionTextArea, textAreaInformacioPartida;
    JPanel activosJugadorPanel;
    JButton terminarTurno, TirarDado, botonPagarEstancia, botonComprar;
    CardLayout cardLayout = new CardLayout();
    boolean dadosIguales = false;

    Jugador[] jugadores = new Jugador[7];
    Dado[] dados = new Dado[4];
    static int jugandoAhora = 0;


    //definir Variables pra el reloj
    String horas, minutos, segundos, amPm;
    Calendar calendario;
    Thread hilo;
    JLabel relojlLabel;
    int horaUsuario = 0, minutoUsuario = 0, segundoUsuario = 0;
    boolean relojRegresivo = false;

    /**
     * Inicia Un nuevo Juego
     * creando un tablero 
     * los jugadores
     * @throws Exception una excepcion
     */
    public Discover() throws Exception {
        initComponents();

        contenidoPanel = new JPanel();
        contenidoPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contenidoPanel);
        contenidoPanel.setLayout(null);

        JLayeredPane layeredPane = new JLayeredPane();

        layeredPane.setBounds(6, 6, 1500, 1000);
        contenidoPanel.add(layeredPane);

        tableroJuego = new TableroJuego(6, 6, 1000, 1000, this);
        tableroJuego.setBackground(new Color(51, 255, 153));
        layeredPane.add(tableroJuego, new Integer(0));

        int posicionXInicialJugador = 115;
        for (int i = 0; i < NuevoTablero.cantidadJugadores; i++) {
            if (i < 3) {
                TipoJugador tipoJugador = new TipoJugador(this, true);
                tipoJugador.setLocationRelativeTo(null);
                tipoJugador.setVisible(true);

                Jugador nuevoJugador = new Jugador(posicionXInicialJugador, 150, i + 1, TipoJugador.jugadorColor);
                jugadores[i] = nuevoJugador;
                layeredPane.add(jugadores[i], new Integer(1));
                posicionXInicialJugador += 25;
            }
            if (i >= 3) {
                TipoJugador tipoJugador = new TipoJugador(this, true);
                tipoJugador.setLocationRelativeTo(null);
                tipoJugador.setVisible(true);

                Jugador nuevoJugador = new Jugador(posicionXInicialJugador, 175, i + 1, TipoJugador.jugadorColor);
                jugadores[i] = nuevoJugador;
                layeredPane.add(jugadores[i], new Integer(1));
                posicionXInicialJugador -= 25;
            }

        }

        JPanel panelDerecho = new JPanel();
        panelDerecho.setBackground(Color.red.brighter());
        panelDerecho.setBorder(new LineBorder(new Color(0, 0, 0)));
        panelDerecho.setBounds(1006, 6, 419, 600);
        contenidoPanel.add(panelDerecho);
        panelDerecho.setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBounds(100, 100, 1000, 1000);
        setSize(1500, 1000);
        Image icon = new ImageIcon(getClass().getResource("/img/iconoDiscover1.png")).getImage();
        setIconImage(icon);

        botonComprar = new JButton("Comprar");
        botonComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Jugador jugadorActual = jugadores[jugandoAhora];

                jugadorActual.comprarPropiedad(jugadorActual.getNumeroCasillaActual());
                boolean fueComprada = jugadorActual.isComprado();

                if (fueComprada == true) {

                    TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].setDisponible(false);
                    int retirar = TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPrecio();
                    jugadorActual.retirarBilletera(retirar);
                    botonComprar.setEnabled(false);
                    informacionTextArea.setText("Felicidades!! nueva propiedad! \n" + "Propiedad adquirida: " + TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getNombre() + "\nPrecio; " + TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPrecio());
                    actualizarInformacionTextArea();
                } else {
                    informacionTextArea.setText("Ya lo compró alguien. No puedes por aquí.");
                    botonComprar.setEnabled(false);
                    botonPagarEstancia.setEnabled(true);
                    actualizarInformacionTextArea();
                }

            }
        });

        botonComprar.setBounds(81, 478, 117, 29);
        panelDerecho.add(botonComprar);
        botonComprar.setEnabled(false);

        botonPagarEstancia = new JButton("Pagar Estancia");
        botonPagarEstancia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador jugadorActual = jugadores[jugandoAhora];
                Jugador duenioCasilla = jugadores[TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPropietario() - 1];
//                if (jugandoAhora==TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPropietario()-1) {
//                    
//                } else {
                informacionTextArea.setText("Pagaste a la jugador " + (TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPropietario()) + " el pago por la estancia: Q." + (TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPrecioEstancia()));

                int retirar = TableroJuego.todasCasillas[jugadorActual.getNumeroCasillaActual()].getPrecioEstancia();
                System.out.println(retirar);
                jugadorActual.retirarBilletera(retirar);
                duenioCasilla.depositoBilletera(retirar);

////                }
                terminarTurno.setEnabled(true);
                botonPagarEstancia.setEnabled(false);
                actualizarInformacionTextArea();

            }

        });
        botonPagarEstancia.setBounds(210, 478, 117, 29);
        panelDerecho.add(botonPagarEstancia);
        botonPagarEstancia.setEnabled(false);

        int posicionXInicialDado = 100;
        for (int i = 0; i < NuevoTablero.cantidadDados; i++) {
            Dado nuevDado = new Dado(posicionXInicialDado, 800, 100);
            dados[i] = nuevDado;
            layeredPane.add(dados[i], new Integer(1));
            posicionXInicialDado += 105;
        }

        TirarDado = new JButton("Lanzar Dado");
        TirarDado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (NuevoTablero.cantidadDados == 1) {
                    dados[0].run();
                    int dadoValor = dados[0].getValorCaraDado();

                    System.out.println("Total Dados: " + dadoValor + "--- Cantidad Dados: " + 1);

                    if (dados[0].getValorCaraDado() == 6) {
                        dadosIguales = true;
                        informacionTextArea.setText("Que suerte! has obtineido un 6\nVuelve a tirar los dados");
//                        terminarTurno.setEnabled(false);
                    } else {
                        dadosIguales = false;
                    }

                    jugadores[jugandoAhora].mover(dadoValor);

                }
                if (NuevoTablero.cantidadDados == 2) {
                    dados[0].run();
                    dados[1].run();
                    int dadoValor2 = dados[0].getValorCaraDado();
                    int dadoValor3 = dados[1].getValorCaraDado();

                    int total = dadoValor3 + dadoValor2;
                    System.out.println("Total Suma de Dados: " + total + "--- Cantidad Dados: " + 2);

                    if (dados[0].getValorCaraDado() == dados[1].getValorCaraDado()) {
                        dadosIguales = true;
                        informacionTextArea.setText("Que suerte! has obtineido dobles\nVuelve a tirar los dados");
//                        terminarTurno.setEnabled(false);
                    } else {
                        dadosIguales = false;
                    }
                    jugadores[jugandoAhora].mover(total);
                }
                if (NuevoTablero.cantidadDados == 3) {
                    dados[0].run();
                    dados[1].run();
                    dados[2].run();

                    int dadoValor4 = dados[0].getValorCaraDado();
                    int dadoValor5 = dados[1].getValorCaraDado();
                    int dadoValor6 = dados[2].getValorCaraDado();

                    int total = dadoValor4 + dadoValor5 + dadoValor6;
                    System.out.println("Total Dados: " + total + "--- Cantidad Dados: " + 3);

                    System.out.println("Total Suma de Dados: " + total + "--- Cantidad Dados: " + 2);

                    if (dados[0].getValorCaraDado() == dados[1].getValorCaraDado() && dados[0].getValorCaraDado() == dados[2].getValorCaraDado()) {
                        dadosIguales = true;
                        informacionTextArea.setText("Que suerte! has obtineido triples\nVuelve a tirar los dados");
//                        terminarTurno.setEnabled(false);
                    } else {
                        dadosIguales = false;
                    }
                    jugadores[jugandoAhora].mover(total);

                    if (jugadores[jugandoAhora].getNumeroCasillaActual() + total > Casilla.totalCasillas) {
                        informacionTextArea.setText("Sele ha pagado por pasaro por el Inicio Q." + NuevoTablero.cantidadDineroVuelta);
                    }
                }

                if (TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getPropietario() != 0) // no por si mismo
                {
                    botonComprar.setEnabled(false);
                    TirarDado.setEnabled(false);
                    terminarTurno.setEnabled(false);
                    botonPagarEstancia.setEnabled(true);
                }

                if (TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].isComprable() == false) { //si es una casilla no comprable 
                    if (TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getTipo() == 5) {
                        Random rnd = new Random();
                        int obtenerTarjeta = rnd.nextInt(NuevoTablero.cantidadTarjetas);
                        try {
                            informacionTextArea.setText("Sacaste una Tarjeta:\n"+tableroJuego.lista.getMensaje(obtenerTarjeta));
                            System.out.println("Sacaste una Tarjeta y dice: " + tableroJuego.lista.getMensaje(obtenerTarjeta));
                        } catch (Exception ex) {
                            Logger.getLogger(Discover.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    botonComprar.setEnabled(false);
                    terminarTurno.setEnabled(true);

                } else if (!(jugadores[jugandoAhora].getNumeroJugador() == TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getPropietario())) { //si no fue comprado por alguien
                    botonComprar.setEnabled(true);
                    terminarTurno.setEnabled(true);
                    botonPagarEstancia.setEnabled(false);
                }
                if (dadosIguales == true) {
                    TirarDado.setEnabled(true);
                    terminarTurno.setEnabled(false);
                } else {
                    TirarDado.setEnabled(false);
                    terminarTurno.setEnabled(true);
                }

                if (TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getPropietario() != 0) // no por si mismo
                {
                    botonComprar.setEnabled(false);
                    TirarDado.setEnabled(false);
                    terminarTurno.setEnabled(false);
                    botonPagarEstancia.setEnabled(true);
                }
                if (jugadores[jugandoAhora].getNumeroJugador() == TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getPropietario() // Si es comprado por alguien
                        && TableroJuego.todasCasillas[jugadores[jugandoAhora].getNumeroCasillaActual()].getPropietario() == jugadores[jugandoAhora].getNumeroJugador()) { // y por si mismo
                    botonComprar.setEnabled(false);
                    botonPagarEstancia.setEnabled(false);
                    terminarTurno.setEnabled(true);
                }

                layeredPane.remove(tableroJuego);
                layeredPane.add(tableroJuego, new Integer(0));

                actualizarInformacionTextArea();
            }
        });
        TirarDado.setBounds(81, 400, 246, 53);
        panelDerecho.add(TirarDado);

        terminarTurno = new JButton("Terminar Turno");
        terminarTurno.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                TirarDado.setEnabled(true);
//				Compar.setEnabled(false);
//				PagarEstancia.setEnabled(false);
                terminarTurno.setEnabled(false);

                if (jugandoAhora < 6 && dadosIguales) {
                    jugandoAhora++;
                    dadosIguales = false;
                } else if (!dadosIguales && !dadosIguales) {
                    jugandoAhora = (jugandoAhora + 1) % NuevoTablero.cantidadJugadores;
                }

                cardLayout.show(activosJugadorPanel, "" + (jugandoAhora));
                actualizarInformacionTextArea();
                informacionTextArea.setText("Ahora es el turno del jugador: " + (jugandoAhora + 1) + " \nDinero jugador: " + jugadores[jugandoAhora].getBilletera());
            }

        });

        terminarTurno.setBounds(81, 519, 246, 53);
        panelDerecho.add(terminarTurno);
        terminarTurno.setEnabled(false);

        JPanel prueba = new JPanel();
        prueba.setBounds(81, 312, 255, 75);
        panelDerecho.add(prueba);
        prueba.setLayout(null);

        activosJugadorPanel = new JPanel();
        activosJugadorPanel.setBounds(81, 28, 246, 189);
        panelDerecho.add(activosJugadorPanel);
        activosJugadorPanel.setLayout(cardLayout);

        JPanel jugadorPanel = new JPanel();
        jugadorPanel.setBackground(Color.RED.darker());
        activosJugadorPanel.add(jugadorPanel, "" + jugandoAhora);
        jugadorPanel.setLayout(null);

        JLabel jugadorPanelTituloLabel = new JLabel("TIEMPO " + (relojRegresivo == false ? "TRASCURRIDO" : "RESTANTE"));
        jugadorPanelTituloLabel.setForeground(Color.WHITE);
        jugadorPanelTituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jugadorPanelTituloLabel.setBounds(0, 5, 240, 16);
        jugadorPanel.add(jugadorPanelTituloLabel);

        relojlLabel = new JLabel();
        relojlLabel.setForeground(Color.WHITE);
        relojlLabel.setHorizontalAlignment(SwingConstants.CENTER);
        relojlLabel.setBounds(0, 20, 240, 16);
        jugadorPanel.add(relojlLabel);

        botonComprar.setForeground(Color.RED);
        botonComprar.setBackground(Color.WHITE);

        botonPagarEstancia.setForeground(Color.red);
        botonPagarEstancia.setBackground(Color.WHITE);

        terminarTurno.setForeground(Color.red);
        terminarTurno.setBackground(Color.WHITE);

        TirarDado.setForeground(Color.red);
        TirarDado.setBackground(Color.WHITE);

        JPanel panelInformacioPartida = new JPanel();
        panelInformacioPartida.setBackground(Color.red.brighter());
        panelDerecho.add(panelInformacioPartida);
        panelInformacioPartida.setLayout(null);

        JLabel panelInformacioPartidaTitulo = new JLabel("Informacio Partida");
        panelInformacioPartidaTitulo.setForeground(Color.WHITE);
        panelInformacioPartidaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panelInformacioPartidaTitulo.setBounds(0, 6, 240, 16);
        panelInformacioPartida.add(panelInformacioPartidaTitulo);

        textAreaInformacioPartida = new JTextArea();
        textAreaInformacioPartida.setBounds(10, 34, 230, 149);
        panelInformacioPartida.add(textAreaInformacioPartida);

        actualizarInformacionTextArea();

        informacionTextArea = new JTextArea();
        informacionTextArea.setColumns(20);
        informacionTextArea.setRows(5);
        informacionTextArea.setBounds(4, 4, 248, 68);
        prueba.add(informacionTextArea);
        informacionTextArea.setLineWrap(true);
        informacionTextArea.setText("¡El jugador 1 comienza el juego haciendo clic en Lanzar dados!!");

        hilo = new Thread(this);
        hilo.start();

    }

    /**
     * actualiza el textaArea de informacion
     * 
     */
    public void actualizarInformacionTextArea() {
        // TODO Auto-generated method stub
        String nombre = "", result = "";
        result += "Dinero: " + jugadores[jugandoAhora].getBilletera() + "\n";

        result += "Titulos de Propiedad: \n";

//		for(int i = 0; i < jugadores[jugandoAhora].getTitulosPropiedadJugador().length; i++) {
//                    
//			result += " - "+ nombre+"\n";
//		}
        textAreaInformacioPartida.setText(result);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * se le indica al reloj como debe se actuar
     */
    @Override
    public void run() {
        Thread reloj = Thread.currentThread();
        int horasInt = 0,
                minutosInt = 0,
                segundosInt = 0;
    
        while (reloj == hilo) {
            calcularReloj();

            if (relojRegresivo == false) {

                if (minutosInt == 60) {
                    minutosInt = 0;
                    horasInt++;
                }

                if (segundosInt == 60) {
                    segundosInt = 0;
                    minutosInt++;
                }
                if (horasInt > 24) {
                    horasInt = 24;
                    minutosInt = 0;
                    segundosInt = 0;
                } else {
                    if (minutosInt > 60) {
                        minutosInt = 60;
                        segundosInt = 60;

                    } else {

                        segundosInt++;

                    }

                }

            } else {
                if (minutosInt == 0) {
                    minutosInt = 60;
                    horasInt--;
                }

                if (segundosInt == 0) {
                    segundosInt = 60;
                    minutosInt--;
                }
                if (horasInt < 0) {
                    horasInt = 0;
                    minutosInt = 0;
                    segundosInt = 0;
                } else {
                    if (minutosInt < 0) {
                        minutosInt = 0;
                        segundosInt = 0;

                    } else {

                        segundosInt--;

                    }

                }

            }

            relojlLabel.setText(horasInt + " : " + minutosInt + " : " + segundosInt);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }

    }
/**
 * modifica las variables dependiendo si los nnumeros son menores a 9 concatena un 0 antes decada numero con el fin de que sigan el fotmato 09,08..etc
 */
    private void calcularReloj() {
        Calendar calendarioReloj = new GregorianCalendar();
        Date fehcDate = new Date();
        calendarioReloj.setTime(fehcDate);
        amPm = calendarioReloj.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";
        if (amPm.equals("PM")) {
            int h = calendarioReloj.get(Calendar.HOUR_OF_DAY) - 12;
            horas = h > 9 ? "" + horas : "0" + h;
        } else {
            horas = calendarioReloj.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendarioReloj.get(Calendar.HOUR_OF_DAY) : "0" + calendarioReloj.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendarioReloj.get(Calendar.MINUTE) > 9 ? "" + calendarioReloj.get(Calendar.MINUTE) : "0" + calendarioReloj.get(Calendar.MINUTE);
        segundos = calendarioReloj.get(Calendar.SECOND) > 9 ? "" + calendarioReloj.get(Calendar.SECOND) : "0" + calendarioReloj.get(Calendar.SECOND);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
