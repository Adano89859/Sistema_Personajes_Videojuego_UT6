package Controller;

import Model.Hechicero;
import Model.Mago;
import Model.Personaje;
import Model.Personaje_Magico;

import java.util.ArrayList;

public class Juego {

    //Atributos:
    private ArrayList<Personaje> personajes;

    //Métodos:

    //CONSTRUCTOR
    public Juego(ArrayList<Personaje> personajes){
        this.personajes = personajes;
    }

    //Getter
    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }
    //Setter
    public void setPersonajes(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    /*
    Resultado: Este método recorre todos los Personajes de "personajes" y muestra todas la habilidades de cada uno
    */
    public void mostrarAcciones(){

        //Recorro el Array de los personajes
        for(Personaje personaje : personajes){
            //Compruebo que la clase es de una clase concreta
            if(personaje instanceof Personaje_Magico){
                //Hago todos los métodos de esta clase
                ((Personaje_Magico) personaje).atacar();
                ((Personaje_Magico) personaje).lanzarHechizo();
                ((Personaje_Magico) personaje).orar();
                System.out.println(((Personaje_Magico) personaje).toString());
                System.out.println(((Personaje_Magico) personaje).hashCode());

                //Lo comparo con un objeto que sea igual
                Personaje_Magico igual = new Personaje_Magico(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Personaje_Magico) personaje).getMana());
                System.out.println("¿La clase es igual a otra clase igual? " + personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Personaje_Magico noIgual = new Personaje_Magico(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Personaje_Magico) personaje).getMana()+1);
                System.out.println("¿La clase es igual a otra clase diferente? " + personaje.equals(noIgual));
            }
            if(personaje instanceof Mago){
                //Hago todos los métodos de esta clase
                ((Mago) personaje).atacar();
                ((Mago) personaje).lanzarHechizo();
                ((Mago) personaje).orar();
                ((Mago) personaje).curar();
                ((Mago) personaje).generarMana();
                System.out.println(((Mago) personaje).toString());
                System.out.println(((Mago) personaje).hashCode());

                //Lo comparo con un objeto que sea igual
                Mago igual = new Mago(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Mago) personaje).getMana(),((Mago) personaje).getSabiduria());
                System.out.println("¿La clase es igual a otra clase igual? " + personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Mago noIgual = new Mago(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Mago) personaje).getMana()+1,((Mago) personaje).getSabiduria()+1);
                System.out.println("¿La clase es igual a otra clase diferente? " + personaje.equals(noIgual));
            }
            if(personaje instanceof Hechicero){
                //Hago todos los métodos de esta clase
                ((Hechicero) personaje).atacar();
                ((Hechicero) personaje).lanzarHechizo();
                ((Hechicero) personaje).orar();
                ((Hechicero) personaje).defender();
                ((Hechicero) personaje).invocarEntidad();
                System.out.println(((Hechicero) personaje).toString());
                System.out.println(((Hechicero) personaje).hashCode());

                //Lo comparo con un objeto que sea igual
                Hechicero igual = new Hechicero(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Hechicero) personaje).getMana(),((Hechicero) personaje).getConcentracion());
                System.out.println("¿La clase es igual a otra clase igual? " + personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Hechicero noIgual = new Hechicero(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Hechicero) personaje).getMana()+1,((Hechicero) personaje).getConcentracion()+1);
                System.out.println("¿La clase es igual a otra clase diferente? " + personaje.equals(noIgual));
            }
        }

    }



}
