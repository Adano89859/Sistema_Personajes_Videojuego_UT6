package Controller;

import Model.Hechicero;
import Model.Mago;
import Model.Personaje;
import Model.Personaje_Magico;
import Model.Personaje_Fisico;
import Model.Arquero;
import Model.Guerrero;
import Model.Asesino;

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
                System.out.println(personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Personaje_Magico noIgual = new Personaje_Magico(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Personaje_Magico) personaje).getMana()+1);
                System.out.println(personaje.equals(noIgual));
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
                System.out.println(personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Mago noIgual = new Mago(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Mago) personaje).getMana()+1,((Mago) personaje).getSabiduria()+1);
                System.out.println(personaje.equals(noIgual));
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
                System.out.println(personaje.equals(igual));

                //Lo comparo con un objeto que no sea igual
                Hechicero noIgual = new Hechicero(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Hechicero) personaje).getMana()+1,((Hechicero) personaje).getConcentracion()+1);
                System.out.println(personaje.equals(noIgual));
            }

            if(personaje instanceof Personaje_Fisico){
                //LLamamos a todos los métodos de la clase Personaje_Fisico
                ((Personaje_Fisico) personaje).atacar();
                ((Personaje_Fisico) personaje).cantarBalada();
                System.out.println(((Personaje_Fisico) personaje).toString());
                System.out.println(((Personaje_Fisico) personaje).hashCode());

                //Comparamos el objeto con otro que sea igual
                Personaje_Fisico igual = new Personaje_Fisico(personaje.getNombre(),personaje.getNivel(),personaje.getSalud());
                System.out.println(personaje.equals(igual));

                //Comparamos el objeto con otro que no sea igual
                Personaje_Fisico noIgual = new Personaje_Fisico(personaje.getNombre()+" el distinto",personaje.getNivel()+1,personaje.getSalud()+1);
                System.out.println(personaje.equals(noIgual));
            }

            if(personaje instanceof Guerrero){
                //LLamamos a todos los métodos de la clase guerrero
                ((Guerrero) personaje).cargarAtaque();
                ((Guerrero) personaje).defender();
                ((Guerrero) personaje).cantarBalada();
                System.out.println(((Guerrero) personaje).toString());
                System.out.println(((Guerrero) personaje).hashCode());

                //Comparamos el objeto con otro que sea igual
                Guerrero igual = new Guerrero(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Guerrero) personaje).getArmadura(),((Guerrero) personaje).getFuerza(), ((Guerrero) personaje).getEscudo());
                System.out.println(personaje.equals(igual));

                //Comparamos el objeto con otro que no sea igual
                Guerrero noIgual = new Guerrero(personaje.getNombre()+"distinto",personaje.getNivel()+1,personaje.getSalud()+1, ((Guerrero) personaje).getArmadura()+1,((Guerrero) personaje).getFuerza()+1, ((Guerrero) personaje).getEscudo()+1);
                System.out.println(personaje.equals(noIgual));
            }

            if(personaje instanceof Arquero){
                //LLamamos a todos los métodos de la clase Arquero
                ((Arquero) personaje).dispararFlecha();
                ((Arquero) personaje).moverse();
                ((Arquero) personaje).restablecerFlechas();
                ((Arquero) personaje).cantarBalada();
                System.out.println(((Arquero) personaje).toString());
                System.out.println(((Arquero) personaje).hashCode());

                //Comparamos el objeto con otro que sea igual
                Arquero igual = new Arquero(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Arquero) personaje).getAgilidad(),((Arquero) personaje).getnumFlechas());
                System.out.println(personaje.equals(igual));

                //Comparamos el objeto con otro que no sea igual
                Arquero noIgual = new Arquero(personaje.getNombre()+"distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Arquero) personaje).getAgilidad()+1,((Arquero) personaje).getnumFlechas()+1);
                System.out.println(personaje.equals(noIgual));
            }

            if(personaje instanceof Asesino){
                //LLamamos a todos los métodos de la clase Asesino
                ((Asesino) personaje).atacarPorEspalda();
                ((Asesino) personaje).curar();
                ((Asesino) personaje).ocultar();
                System.out.println(((Asesino) personaje).toString());
                System.out.println(((Asesino) personaje).hashCode());

                //Comparamos el objeto con otro que sea igual
                Asesino igual = new Asesino(personaje.getNombre(),personaje.getNivel(),personaje.getSalud(),((Asesino) personaje).getSigilo(),((Asesino) personaje).getCritico());
                System.out.println(personaje.equals(igual));

                //Comparamos el objeto con otro que no sea igual
                Asesino noIgual = new Asesino(personaje.getNombre()+"distinto",personaje.getNivel()+1,personaje.getSalud()+1,((Asesino) personaje).getSigilo()+1,((Asesino) personaje).getCritico()+1);
                System.out.println(personaje.equals(noIgual));
            }
        }
    }
}
