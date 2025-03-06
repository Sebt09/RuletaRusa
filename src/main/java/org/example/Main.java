package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //variables
        Scanner sc = new Scanner(System.in);

        String doomie = "";
        boolean salir = true;
        int opcion = 0;
        int numJugadores = 0;
        int jugadorActual = 1;


        do{
            System.out.println("\tRULETA RUSA" +
                    "\n1. Iniciar Juego" +
                    "\n2. Salir");
            opcion = sc.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el numero de jugadores 2-6!");
                    numJugadores = sc.nextInt();
                    if(numJugadores > 6||numJugadores < 2) {
                        System.out.println("Numero de jugadores NO PERMITIDO!");
                        continue;
                    }
                    RuletaRusa juegoRuleta = new RuletaRusa();
                    juegoRuleta.iniciarJuego();
                    boolean tiro = false;
                    do {
                        //System.out.println(juegoRuleta.toString());
                        System.out.println("Pulsa S/s para disparar o F/f para rendirte o R/r para reiniciar el juego");
                        doomie = sc.next(); //
                        if(doomie.equals("F") || doomie.equals("f")){
                            System.out.println("Adios, cobarde ☠️☠️☠️");
                            salir = false;
                            break;
                        }if(doomie.equals("R") || doomie.equals("r")){
                            System.out.println("Comenzamos de nuevo. Bala cambiada de posicion!");
                            juegoRuleta.reiniciarJuego();
                            jugadorActual = 1;
                            continue;
                        }
                        //System.out.println(juegoRuleta.toString());
                        System.out.println("Posicion del tambor " + juegoRuleta.getPosicionActual());
                        System.out.println("Jugador numero " + jugadorActual + " Disparando...");
                        tiro = juegoRuleta.disparar();
                        if (tiro) {
                            System.out.println("BOOM.....!");
                            System.out.println("Juego Terminado");
                            salir = false;
                            break;
                        } else {
                            System.out.println("Clic....   El juego continua!");
                            jugadorActual++;
                        }
                        if (jugadorActual > numJugadores) {
                            jugadorActual = 1;
                        }
                        System.out.println("---------------------------------------------");

                    }while(tiro == false);
                    break;

                case 2:
                    System.out.println("Saliendo......");
                    salir = false;
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        }while(salir);

    }
}