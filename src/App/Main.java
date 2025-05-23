package App;

import Controller.Batalla;
import Controller.Juego;
import Model.Hechicero;
import Model.Mago;
import Model.Personaje;
import Model.Arquero;
import Model.Guerrero;
import Model.Asesino;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creo la clase juego y le introduzco los personajes
        Juego juego = new Juego(crearPersonajesPredeterminados());

        //Creo la clase de batalla
        Batalla batalla = new Batalla(crearPersonajesPredeterminados());


        //Llamo al método "mostrarAciones" de "juego"
        juego.mostrarAcciones();

        //Inicio la pelea
        batalla.completoBatalla();
    }

    /*
    Resultado: Crea un ArrayList de personajes
    Return: Devuleve el ArrayList de personajes
    */
    static public ArrayList<Personaje> crearPersonajesPredeterminados() {
        //Creo el ArrayList de Personajes
        ArrayList<Personaje> personajes = new ArrayList<>();
        //No añado un objeto de la clase "Personaje" porque es abstracta y no deja crear una instancia
        //Añado los personajes mágicos
        personajes.add(new Mago("Gandalf", 2, 7, 10,7));
        personajes.add(new Hechicero("Mer", 1, 3, 4,1));

        //Añado los personajes físicos
        personajes.add(new Guerrero("JGarVill", 5, 100, 90, 100, 100));
        personajes.add(new Arquero("RobinHood", 2, 10, 3,20));
        personajes.add(new Asesino("Capuchino", 4, 20, false,3));

        //Devuelvo el ArrayList
        return personajes;
    }
}