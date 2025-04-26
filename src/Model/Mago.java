package Model;

public class Mago extends Personaje_Magico implements Curable{

    //Atributos:
    private int mana;
    private int sabiduria;

    //Métodos:

    //CONSTRUCTOR
    public Mago(String nombre, int nivel, int salud){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud);
    }
    //Constructores con falta de parámetros
    public Mago(int nivel, int salud){
        super("Predeterminado",nivel,salud);
    }
    public Mago(String nombre, int nivel){
        super(nombre,nivel,100);
    }
    public Mago(String nombre){
        super(nombre,0,100);
    }
    public Mago(int nivel){
        super("Predeterminado",nivel,100);
    }



    }
