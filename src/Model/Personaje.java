package Model;

import java.util.Objects;

//Esta clase es abstracta
public abstract class Personaje {

    //Atributos
    protected String nombre;
    protected int nivel;
    protected int salud;

    //Métodos:

    //CONSTRUCTOR
    public Personaje(String nombre, int nivel, int salud){
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }
    //Constructores con falta de parámetros
    public Personaje(int nivel, int salud){
        this("Predeterminado",nivel,salud);
    }
    public Personaje(String nombre, int nivel){
        this(nombre,nivel,100);
    }
    public Personaje(String nombre){
        this(nombre,0,100);
    }
    public Personaje(int nivel){
        this("Predeterminado",nivel,100);
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public int getSalud() {
        return salud;
    }

    //Método abstracto que las clases hijas tendrán que desarrollar
    abstract void atacar();

    //Método para cambiar el "toString" de esta clase
    @Override
     public String toString(){
        return "Personaje: "+this.nombre;
    }

   // Metodo para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
        // Si el objeto coincide se cumple la igualdad
        if (this == objetoAComparar) return true;
        // Si es nulo o no coincide con la instancia personaje no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Personaje)) return false;
        // Creamos otro personaje para que se cumpla la igualdad
        // Si el personaje procede de la misma clase son el mismo, si no no se cumple la igualdad
        Personaje otroPersonaje = (Personaje) objetoAComparar;
        return Objects.equals(nombre, otroPersonaje.nombre) && this.getClass() == otroPersonaje.getClass();
    }

     // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
        // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getClass());
    }
}
