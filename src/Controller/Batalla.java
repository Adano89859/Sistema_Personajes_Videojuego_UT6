package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Batalla {

    //Atributos
    private Personaje contrincante1;
    private Personaje contrincante2;
    private ArrayList<Personaje> personajesPredeterminados;
    //Atributo que indica si hay empate
    boolean empate = false;

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

        //Bucle que representa las rondas de la batalla
        while(contrincante1.getSalud()>0 && contrincante2.getSalud()>0 && empate==false){
            //Elementos de la ronda
            //Método que permite elegir las acciones que hará cada personaje
            int accionContrincante1 = menuOpcionesBatalla(getContrincante1());
            int accionContrincante2 = menuOpcionesBatalla(getContrincante2());

            //Método que realiza los ataques de cada enemigo
            //La primera llamada es para hacer efecto sobre el contrincante 1, la segunda es para hacer efecto sobre el ontrincante 2
            accionBatalla(contrincante1,accionContrincante1,contrincante2,accionContrincante2);
            accionBatalla(contrincante2,accionContrincante2,contrincante1,accionContrincante1);
        }

        //Muestro quién es el ganador o si hay empate
        if(contrincante1.getSalud()<=0){
            System.out.println(contrincante2.getNombre()+" ganó contra "+contrincante1.getNombre()+".");
        }else if(contrincante2.getSalud()<=0){
            System.out.println(contrincante1.getNombre()+" ganó contra "+contrincante2.getNombre()+".");
        }else if(empate|| contrincante1.getSalud()<=0 && contrincante2.getSalud()<=0){
            System.out.println("Hay empate.");
        }
    }

    /*
    Resultado: Aquí se elijen los personajes que van a pelear,
    también se da lore y se explican las normas del juego.
     */
    public void inicioBatalla(){

        //Muestro el lore
        System.out.println("+--------------------------------------------------------------------------------------------------------+");
        System.out.println("En las más profundas entrañas del reino de void...");
        System.out.println("Sólo los más valientes se enfrentarán en una intrépida y ");
        System.out.println("encarnizada batalla a vida o muerte, para salir del vacío del tormento ");
        System.out.println("que los acecha, sólo los más audaces conseguirán pasar la prueba de fuego ");
        System.out.println("que los guiará por el camino hacia la luz y escapar de la inminente oscuridad del vacío...");
        System.out.println("+--------------------------------------------------------------------------------------------------------+");

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
    @param: El personaje, que realiza la acción
    @return: Un número que representa el ataque que va a realizar
    Resultado: Este método permite seleccionar el ataque realizará el personaje
     */
    public int menuOpcionesBatalla(Personaje contrincante1){
        //Variable que sirve para saber que tipo de personaje es
        int tipo=0;

        //Esto es el menú de acciones
        System.out.println("-----");
        System.out.println(contrincante1.getNombre());
        System.out.println("Tus opciones son:");
        //Muestro las acciones que puede hacer el personaje
        //Tipo: Mago=1,Hechicero=2,Guerrero=3,Arquero=4,Asesino=5
        //Acción: Atacar=1, Cantar Balada=2, Orar=3, Lanzar Hechizo=4, Curar=5, Generar mana=6, Defender=7, Invocar entidad=8,
        //Cargar ataque= 9, Moverse=10, Disparar flecha=11, Restablecer flechas=12, Ocultar=13,Atacar por la Espalda=14.
        if(contrincante1 instanceof Mago){
            System.out.println("1-Atacar");
            System.out.println("3-Orar");
            System.out.println("4-Lanzar Hechizo");
            System.out.println("5-Curar");
            System.out.println("6-Generar mana");
            tipo=1;
        } else if(contrincante1 instanceof Hechicero) {
            System.out.println("1-Atacar");
            System.out.println("3-Orar");
            System.out.println("4-Lanzar Hechizo");
            System.out.println("7-Defender");
            System.out.println("8-Invocar Entidad");
            tipo=2;
        }else if(contrincante1 instanceof Guerrero){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("7-Defender");
            System.out.println("9-Cargar Ataque");
            tipo=3;
        }else if(contrincante1 instanceof Arquero){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("10-Moverse");
            System.out.println("11-Disparar flecha");
            System.out.println("12-Restablecer flechas");
            tipo=4;
        }else if(contrincante1 instanceof Asesino){
            System.out.println("1-Atacar");
            System.out.println("2-Cantar balada");
            System.out.println("5-Curar");
            System.out.println("10-Moverse");
            System.out.println("13-Ocultar");
            System.out.println("14-Atacar Por la Espalda");
            tipo=5;
        }
        System.out.println("-----");
        int accion = teclado.nextInt();

        //Devuelvo la acción que hace el personaje, y en cierta forma filtro que lo haga con su clase
        switch (tipo) {
            //Mago
            case 1:
                switch (accion){
                    case 1:
                        return 1;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 5:
                        return 5;
                    case 6:
                        return 6;
                    default:
                        return 0;
                }
                //Hechicero
            case 2:
                switch (accion){
                    case 1:
                        return 1;
                    case 3:
                        return 3;
                    case 4:
                        return 4;
                    case 7:
                        return 7;
                    case 8:
                        return 8;
                    default:
                        return 0;
                }
                //Guerrero
            case 3:
                switch (accion) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 7:
                        return 7;
                    case 9:
                        return 9;
                    default:
                        return 0;
                }
                        //Arquero
            case 4:
                switch (accion){
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 10:
                        return 10;
                    case 11:
                        return 11;
                    case 12:
                        return 12;
                    default:
                        return 0;
                }
                //Asesino
            case 5:
                switch (accion){
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 5:
                        return 5;
                    case 10:
                        return 10;
                    case 13:
                        return 13;
                    case 14:
                        return 14;
                    default:
                        return 0;
                }
                //Ninguna clase
            default:
                return 0;
        }
    }

    /*
    @paran: Objeto de la persona afectada, int de su acción, objeto de la persona que le ataca, y su int de ataque
    Resultado: A partir de sus parámetros, crea los efectos que tendrán los ataques sobre  el primer contrincante que se introduce
     */
    public void accionBatalla(Personaje victima, int accionVictima, Personaje atacante, int accionAtacante){
        //Compruebo la acción del atacante
        switch (accionAtacante){
            //Ataque normal
            case 1:
                //Compruebo que la acción de la victima no impida el ataque
                if(accionVictima==7||accionVictima==10||accionVictima==13){
                    //Si lo impide, no hay efecto
                    System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto ante "+victima.getNombre()+".");
                    break;
                }else{
                    victima.setSalud(victima.getSalud()-1);
                    System.out.println(victima.getNombre()+" recibe "+1+" de daño, ahora tiene "+victima.getSalud()+" de vida.");
                }
                break;
                //Cantar Balada
            case 2:
                System.out.println(atacante.getNombre()+": Espada en mano, no temo caer,\n" +
                                    "mi alma arde como un fuego sin fin,\n" +
                                    "si he de morir, que sea por vencer.");
                break;
                //Orar
            case 3:
                System.out.println(atacante.getNombre()+": Que las sombras revelen lo que la luz oculta, y que el eco de mi alma despierte los velos del tiempo.");
                break;
                //Lanzar Hechizo
            case 4:
                //Compruebo que la acción de la victima no impida el ataque
                if(accionVictima==7||accionVictima==10||accionVictima==13){
                    //Si lo impide, no hay efecto
                    System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto ante "+victima.getNombre()+".");
                    break;
                }else if(((Personaje_Magico)atacante).getMana()>=2) {
                    //Le resto maná
                    ((Personaje_Magico)atacante).setMana(((Personaje_Magico)atacante).getMana()-2);
                    //Realizo el daño
                    victima.setSalud(victima.getSalud()-2);
                    System.out.println(victima.getNombre()+" recibe "+2+" de daño, a causa de un hechizo ahora tiene "+victima.getSalud()+" de vida.");
                }else{
                    //Muestro que el personaje no pudo realizar el ataque
                    System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto porque no tiene maná.");
                }
                break;
                //Curar
            case 5:
                //Sin importar la situación, el personaje se puede curar
                atacante.setSalud(atacante.getSalud()+1);
                System.out.println(atacante.getNombre()+" se cura "+1+" de vida, ahora tiene "+atacante.getSalud()+" de vida.");
                break;
                //Generar Mana
            case 6:
                //Sin importar la situación el personaje puede generar mana
                ((Personaje_Magico)atacante).setMana(((Personaje_Magico)atacante).getMana()+1);
                System.out.println(atacante.getNombre()+" obtiene "+1+" de mana, ahora tiene "+((Personaje_Magico)atacante).getMana()+" de mana.");
                break;
                //Defender
            case 7:
                //Sin importar la situación, el personaje se puede defender
                System.out.println(atacante.getNombre()+" se defiende usando toda su destreza.");
                break;
                //Invocar entidad
            case 8:
                //Compruebo que tiene mana para invocar la entidad
                if(((Hechicero)atacante).getMana()>=2){
                    //Resto el maná
                    ((Hechicero)atacante).setMana(((Hechicero)atacante).getMana()-2);
                    //Informo de lo sucedido
                    System.out.println(atacante.getNombre()+" invoca una entidad...la entidad no sabe qué hace aquí..nada, ya se fué.");
                    System.out.println(atacante.getNombre()+" perdió "+2+" de maná por ese acto, jurando no repetirlo, pues ahora tiene "+((Hechicero)atacante).getMana()+" de maná.");
                }else{
                    System.out.println(atacante.getNombre()+" no tuve suficiente maná como para invocar una entidad.");
                }
                break;
                //Cargar ataque
            case 9:
                //Compruebo que el guerrero tiene suficiente vida como para hacer un ataque cargado
                if(((Guerrero)atacante).getSalud()>=1){
                    //Le resto la vida al guerrero
                    ((Guerrero)atacante).setSalud(((Guerrero)atacante).getSalud()-1);
                    if(accionVictima==7||accionVictima==10||accionVictima==13){
                        //Si lo impide, no hay efecto
                        System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto ante "+victima.getNombre()+".");
                        break;
                    }else{
                        //Le resto la vida a la víctima, en base a la fuerza del guerrero
                        victima.setSalud(victima.getSalud()-((Guerrero)atacante).getFuerza());
                        //Muestro lo sucedido
                        System.out.println(((Guerrero)atacante).getNombre()+" cargó su ataque he hizo "+((Guerrero)atacante).getFuerza()+" de daño en base a su fuerza, pero perdió "+1+" de vida.");
                        System.out.println(victima.getNombre()+" tiene ahora "+victima.getSalud()+" de vida.");
                    }
                }else{
                    System.out.println(atacante.getNombre()+" no puede hacer un ataque cargado porque le restaría vida, y está al borde de la muerte.");
                }
                break;
                //Moverse
            case 10:
                //Sin importar la situación, el personaje puede moverse
                System.out.println(atacante.getNombre()+" se movió, esquivando todos los ataques, y puede huir rápido si hace '000'.");
                if(teclado.nextInt()==000){
                    empate=true;
                }
                break;
                //Disparar flecha
            case 11:
                //Compruebo que el personaje tiene flechas
                if(((Arquero)atacante).getnumFlechas()>=1){
                    //Gasto la flecha
                    ((Arquero)atacante).setnumFlechas(((Arquero)atacante).getnumFlechas()-1);
                    //Compruebo que le pueda dar al enemigo
                    if(accionVictima==7||accionVictima==10||accionVictima==13){
                        //Si lo impide, no hay efecto
                        System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto ante "+victima.getNombre()+".");
                        break;
                    }else{
                        //Le quito vida a la víctima
                        victima.setSalud(victima.getSalud()-2);
                        System.out.println(atacante.getNombre()+" quita "+2+" de vida a "+victima.getNombre()+", y pierde "+1+" flecha en el acto.");
                    }
                }else{
                    System.out.println(atacante.getNombre()+" no pudo lanzar flechas porque no tenía.");
                }
                break;
                //Restablecer flecha
            case 12:
                //Se pueden restablecer flechas sin importar la situación
                ((Arquero)atacante).setnumFlechas(((Arquero)atacante).getnumFlechas()+2);
                System.out.println(atacante.getNombre()+" repuso "+2+" flechas.");
                break;
                //Ocultar
            case 13:
                //Se puede ocultar al personaje sin importar la situación
                ((Asesino)atacante).setSigilo(true);
                System.out.println(atacante.getNombre()+" se ocultó de forma épica.");
                break;
                //Atacar por la espalda
            case 14:
                //Compruebo que el asesino esté en modo sigilo
                if(((Asesino)atacante).getSigilo()==true){
                    //Vuelvo el estado del asesino a no estar sigilo
                    ((Asesino)atacante).setSigilo(false);
                    //Compruebo que le pueda dar al enemigo
                    if(accionVictima==7||accionVictima==10||accionVictima==13){
                        //Si lo impide, no hay efecto
                        System.out.println("El ataque de "+atacante.getNombre()+" no surgió efecto ante "+victima.getNombre()+".");
                        break;
                    }else{
                        //Le quito la vida a la víctima, según el crítico del asesino
                        victima.setSalud(victima.getSalud()-((Asesino)atacante).getCritico());
                        //Muestro la info
                        System.out.println(atacante.getNombre()+" atacó por la espalda, realizando "+((Asesino)atacante).getCritico()+" de daño.");
                    }
                }else{
                    System.out.println(atacante.getNombre()+" no pudo atacar por la espalda porque no estaba en modo sigilo.");
                }
                break;
                //Caso predeterminado
            default:
                System.out.println(atacante.getNombre()+" intentó hacer algo que no entendía, quizás porque se creía más listo que el resto.");
                break;
        }

    }

}


