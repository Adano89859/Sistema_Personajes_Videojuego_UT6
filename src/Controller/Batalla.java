package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Batalla {

    //Atributos
    private Personaje contrincante1;
    private Personaje contrincante2;
    private ArrayList<Personaje> personajesPredeterminados;

    //Métodos
    //CONSTRUCTOR
    public Batalla(ArrayList<Personaje> personajesPredeterminados){
        this.personajesPredeterminados =personajesPredeterminados;
    }

    //Declaro e inicializo el scanner del teclado
    Scanner teclado = new Scanner(System.in);

    //GETTER
    public Personaje getContrincante1() {
        return contrincante1;
    }
    public Personaje getContrincante2() {
        return contrincante2;
    }
    public ArrayList<Personaje> getPersonajesPredeterminados() {
        return personajesPredeterminados;
    }

    //SETTER
    public void setContrincante1(Personaje contrincante1) {
        this.contrincante1 = contrincante1;
    }
    public void setContrincante2(Personaje contrincante2) {
        this.contrincante2 = contrincante2;
    }
    public void setPersonajesPredeterminados(ArrayList<Personaje> personajesPredeterminados) {
        this.personajesPredeterminados = personajesPredeterminados;
    }

    /*
    Resultado:Este método trabaja toda la lógica de la batalla
     */
    public void completoBatalla(){
        //Realizo todos los trámites necesarios para que empiece la batalla
        inicioBatalla();

        //Método que permite elegir las acciones que hará cada personaje
        menuOpcionesBatalla(getContrincante1(),getContrincante2());
        menuOpcionesBatalla(getContrincante2(),getContrincante1());
    }

    /*
    Resultado: Aquí se elijen los personajes que van a pelear,
    también se da lore y se explican las normas del juego.
     */
    public void inicioBatalla(){

        //Muestro el lore

        //Indico el sistema de reglas

        //Le muestro al usuario los personajes que hay y le dejo escoger 2 de ellos
        for(Personaje personaje : getPersonajesPredeterminados()){
            System.out.println("-----");
            System.out.println(personaje.getNombre());
            System.out.println("--");
            //Según el tipo que sea, digo el tipo que es
            System.out.println(mostrarTipoPersonaje(personaje));
            System.out.println("-----");
        }

        //Le pido que escriba el nombre de los personajes que van a pelear
        System.out.println("Escriba el nombre del primer luchador");
        setContrincante1(obtenerPersonaje(teclado.nextLine()));
        System.out.println("Escriba el nombre del segundo luchador");
        setContrincante2(obtenerPersonaje(teclado.nextLine()));
    }

    /*
    Resultado: Este método servirá para verificar cosas
     */
    public void validate(){

    }

    /*
    @param: El Personaje del que se va a mirar la clase
    return: Un Strin con el tipo del personaje
    Resultado: Muestra el tipo del personaje mediante un string
     */
    private String mostrarTipoPersonaje(Personaje personaje){
        //Compruebo que la clase es de una clase concreta
            if(personaje instanceof Mago){
                return "Mago";
            }
            if(personaje instanceof Hechicero) {
                return "Hechicero";
            }
        if(personaje instanceof Personaje_Magico){
            return "Personaje Mágico";
        }
        //Comprobamos que la clase proceda de una clase concreta

            if(personaje instanceof Guerrero){
                return "Guerrero";
            }
            if(personaje instanceof Arquero){
                return "Arquero";
            }
            if(personaje instanceof Asesino){
                return "Asesino";
            }
        if(personaje instanceof Personaje_Fisico){
            return "Personaje Físico";
        }
        return "Este personaje parece no existir";
    }

    /*
    @param: String con el nombre del personaje
    @return: El objeto de personaje con ese nombre
    Resultado: Este método optiene el nombre de un personaje, y con ello lo entrega
     */
    public Personaje obtenerPersonaje(String nombre){
        //Recorro los personajes del sistema
        for(Personaje personaje: getPersonajesPredeterminados()){
            //Si el personaje tiene el mismo nombre que el string que traigo, devuelvo el personaje
            if(nombre.equals(personaje.getNombre())){
                return personaje;
            }
        }
        //Si ningún personaje tiene ese nombre, devuelvo null
        return null;
    }

    /*
    @param: El primer personaje, que realiza la acción, el segundo personaje, que la recibe
    Resultado: Este método permite seleccionar el ataque realizará el personaje
     */
    public void menuOpcionesBatalla(Personaje contrincante1, Personaje contrincante2){
        //Esto es el menú de acciones
        System.out.println("-----");
        System.out.println(contrincante1.getNombre());
        System.out.println("Tus opciones son:");
        //Muestro las acciones que puede hacer el personaje
        if(contrincante1 instanceof Mago){
            System.out.println("1-Atacar");
            System.out.println("2-Orar");
            System.out.println("3-Lanzar Hechizo");
            System.out.println("4-Curar");
            System.out.println("5-Generar mana");
        } else if(contrincante1 instanceof Hechicero) {
            System.out.println("1-Atacar");
            System.out.println("2-Orar");
            System.out.println("3-Lanzar Hechizo");
            System.out.println("4-Defender");
            System.out.println("5-Invocar Entidad");
        }else if(contrincante1 instanceof Personaje_Magico){
            System.out.println("1-Atacar");
            System.out.println("2-Orar");
            System.out.println("3-Lanzar Hechizo");
        }else if(contrincante1 instanceof Guerrero){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("3-Cargar Ataque");
            System.out.println("4-Defender");
        }else if(contrincante1 instanceof Arquero){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("3-Moverse");
            System.out.println("4-Disparar flecha");
            System.out.println("5-Restablecer flechas");
        }else if(contrincante1 instanceof Asesino){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("3-Curar");
            System.out.println("4-Moverse");
            System.out.println("5-Ocultar");
            System.out.println("6-Atacar Por la Espalda");
        }else if(contrincante1 instanceof Personaje_Fisico){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
        }
        System.out.println("-----");
    }

}


