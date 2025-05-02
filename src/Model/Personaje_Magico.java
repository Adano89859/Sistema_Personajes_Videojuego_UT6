package Model;

import java.util.Objects;

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

    //Getter y Setter
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
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
        System.out.println(getNombre()+" Ha orado.");
    }

    //Métodos de modificación sobre el objeto en sí (métodos originalmente de object)
    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        //Decido que en String aparezca el tipo de personaje que es
        return "Personaje Mágico: " + this.getNombre();
    }

    // Metodo para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
        // Si el objeto coincide se cumple la igualdad
        if (this == objetoAComparar) return true;
        // Si es nulo o no procede de la misma clase no se cumple la igualdad
        if (objetoAComparar == null || this.getClass() != objetoAComparar.getClass()) return false;
        return super.equals(objetoAComparar);
    }

    // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
        // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(getClass()); 
    }
}
