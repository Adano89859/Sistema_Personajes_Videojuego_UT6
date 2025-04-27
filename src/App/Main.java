package App;

import Controller.Juego;
import Model.Hechicero;
import Model.Mago;
import Model.Personaje;
import Model.Personaje_Magico;
import Model.Personaje_Fisico;
import Model.Arquero;
import Model.Guerrero;
import Model.Asesino;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creo la clase juego y le introduzco los personajes
        Juego juego = new Juego(crearPersonajesPredeterminados());


        //Llamo al método "mostrarAciones" de "juego"
        juego.mostrarAcciones();

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
        personajes.add(new Personaje_Magico("Elemental", 0, 100, 0));
        personajes.add(new Mago("Gandalf", 2, 100, 10,7));
        personajes.add(new Hechicero("Mer", 1, 100, 3,1));
        //Añado los personajes físicos
        personajes.add(new Personaje_Fisico("Aleatorio", 0, 100));
        personajes.add(new Guerrero("JGarVill", 5, 100, 90, 100, 100));
        personajes.add(new Arquero("RobinHood", 2, 100, 3,20));
        personajes.add(new Asesino("Capuchino", 4, 100, 2,3));

        //Devuelvo el ArrayList
        return personajes;
    }
}