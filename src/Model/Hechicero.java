package Model;

import java.util.Objects;

/*

AÑADIR LA INTERFACE DE "DEFENDIBLE" PARA SEGUIR TRABAJAMNDO ESTA CLASE

 */

//Work In Progress

public class Hechicero extends Personaje_Magico implements Defendible{

    //Atributos:
    private int concentracion;
    //Se le añaden los atributos de su superclase

    //Métodos:

    //CONSTRUCTOR
    public Hechicero(String nombre, int nivel, int salud, int mana, int concentracion){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud, mana);
        //Añado el atributo concreto que tiene esta clase
        this.concentracion = concentracion;
    }
    //Constructores con falta de parámetros
    public Hechicero(int nivel, int salud){
        this("Predeterminado",nivel,salud,0,0);
    }
    public Hechicero(String nombre, int nivel){
        this(nombre,nivel,100,0,0);
    }
    public Hechicero(String nombre){
        this(nombre,0,100,0,0);
    }
    public Hechicero(int nivel){
        this("Predeterminado",nivel,100,0,0);
    }

    //Getter
    public int getConcentracion() {
        return concentracion;
    }
    //Setter
    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }

    //El método "atacar" es heredado de "Personaje_Magico"

    //Método que la interface de "Mágico" me obliga a realizar
    @Override
    public void lanzarHechizo(){
        //Ya que este método está en la superclase y no pretendo hacerle cambios, hago una llamada a él
        super.lanzarHechizo();
    }

    //Método que la interface de "Defendible" me obliga a realizar
    @Override
    public void defender(){
        //Por ahora solo digo que defiende
        System.out.println(getNombre()+" Se defiende.");
    }

    //Método "orar" es heredado de "Personaje_Magico"

    //Método propio de esta clase, inventado
    public void invocarEntidad(){
        //Por ahora solo digo que invoca una Entidad
        System.out.println(getNombre()+" Invoca una Entidad.");
    }

    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        return "Hechicero: "+this.nombre;
    }

    
    // Método para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
         // Si el objeto Hechicero es igual al objeto se cumple la igualdad
        if (this == objetoAComparar) return true;
        // Si el objeto es nulo o no coincide con la instancia hechicero no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Hechicero)) return false;
        //Creamos un nuevo objeto para comparar entre hechiceros
        // Si tienen la misma concentración son el mismo si no la tienen devuelve false
        Hechicero otroHechicero = (Hechicero) objetoAComparar;
        return Objects.equals(nombre, otroHechicero.nombre) && this.getConcentracion() == otroHechicero.getConcentracion();
    }

    // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
        // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getConcentracion());
    }
}
