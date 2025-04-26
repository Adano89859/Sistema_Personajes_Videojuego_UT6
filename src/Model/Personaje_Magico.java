package Model;

public class Personaje_Magico extends Personaje implements Magico{

    //Atributos:
    protected int mana;
    //Se le añade que Personaje_Magico hereda sus atributos de su superclase, "Personaje" en este caso.

    //Métodos:
    //CONSTRUCTOR
    public Personaje_Magico(String nombre, int nivel, int salud, int mana){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud);
        //Añado el atributo concreto que tiene esta clase
        this.mana = mana;
    }
    //Constructores con falta de parámetros
    public Personaje_Magico(int nivel, int salud){
        this("Predeterminado",nivel,salud,0);
    }
    public Personaje_Magico(String nombre, int nivel){
        this(nombre,nivel,100,0);
    }
    public Personaje_Magico(String nombre){
        this(nombre,0,100,0);
    }
    public Personaje_Magico(int nivel){
        this("Predeterminado",nivel,100,0);
    }

    //Método que la superclase me obliga a desarrollar.
    @Override
    public void atacar(){
        //Por ahora mostraré solo un texto que dice que ataca
        System.out.println(getNombre()+" hace un ataque.");
    }

    //Método que la interface de "Mágico" me obliga a realizar
    @Override
    public void lanzarHechizo(){
        //Por ahora solo digo que lanza un hechizo
        System.out.println(getNombre()+" lanza un hechizo.");
    }

    //Método propio de esta clase, inventado
    public void orar(){
        //Por ahora solo dice algo
        System.out.println(getNombre()+" ha orado.");
    }

    //Métodos de modificación sobre el objeto en sí (métodos originalmente de object)
    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        //Decido que en String aparezca el tipo de personaje que es
        return "Personaje Mágico: " + this.getNombre();
    }

    //Método para cambiar el "equals" de esta clase
    @Override
    public boolean equals(Object objetoAComparar){
        //Compruebo que la superClase de esta, "Personaje" en este caso, nos diga que este objeto es igual a ella, de no ser así, anulo la igualdad
        if (!super.equals(objetoAComparar)) return false;
        //Debido a que esta clase "Personaje_Magico" no tiene nuevos atributos que me interesen para comparar, decido que el equals de la superclase es suficiente para asegurar la igualdad
        return true;
    }

    //Método para cambiar el "hashCode" de esta clase
    @Override
    public int hashCode(){
        //Hago que el hashCode de la clase recurra al hashCode de la superclase
        return super.hashCode();
    }

}
