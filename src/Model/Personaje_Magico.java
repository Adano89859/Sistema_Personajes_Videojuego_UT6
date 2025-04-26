package Model;

public class Personaje_Magico extends Personaje implements Magico{

    //Atributos:
    //Este Personaje_Magico hereda sus atributos de su superclase, "Personaje" en este caso.

    //Métodos:
    //CONSTRUCTOR
    public Personaje_Magico(String nombre, int nivel, int salud){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud);
    }
    //Constructores con falta de parámetros
    public Personaje_Magico(int nivel, int salud){
        super("Predeterminado",nivel,salud);
    }
    public Personaje_Magico(String nombre, int nivel){
        super(nombre,nivel,100);
    }
    public Personaje_Magico(String nombre){
        super(nombre,0,100);
    }
    public Personaje_Magico(int nivel){
        super("Predeterminado",nivel,100);
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
        return super.toString();
    }

    //Método para cambiar el "equals" de esta clase
    @Override
    public boolean equals(Object objetoAComparar){
        //Compruebo que la superClase de esta, "Personaje" en este caso, nos diga que este objeto es igual a ella, de no ser así, anulo la igualdad
        if (!super.equals(objetoAComparar)) return false;
        //Debido a que esta clase "Personaje_Magico" no tiene nuevos atributos, decido que el equals de la superclase es suficiente para asegurar la igualdad
        return true;
    }

    //Método para cambiar el "hashCode" de esta clase
    @Override
    public int hashCode(){
        //Hago que el hashCode de la clase recurra al hashCode de la superclase
        return super.hashCode();
    }

}
