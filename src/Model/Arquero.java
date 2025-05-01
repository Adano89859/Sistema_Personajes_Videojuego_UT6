package Model;

import java.util.Objects;

public class Arquero extends Personaje_Fisico implements Movilizable {
    // Atributos (se añaden los de su superclase):
   private int agilidad;
   private int numFlechas;

   //Métodos

   //CONSTRUCTOR PRINCIPAL:
   public Arquero(String nombre, int nivel, int salud, int agilidad, int numFlechas){

        super(nombre, nivel, salud);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
   }

   //Subconstructores con falta de parámetros
    public Arquero(int nivel, int salud){
        this("Predeterminado", nivel, 100, 0, 0);
    }

    public Arquero(String nombre, int nivel){
        this(nombre, nivel, 100, 0, 0);
    }

    public Arquero(String nombre){
        this(nombre, 0, 100, 0, 0);
    }

    public Arquero(int nivel){
        this("Predeterminado", nivel, 100, 0, 0);
    }

    //Getters
    public int getAgilidad(){
        return agilidad;
    }

    public int getnumFlechas(){
        return numFlechas;
    }

    //Setters
    public void setAgilidad(int agilidad){
        this.agilidad = agilidad;
    }

    public void setnumFlechas(int numFlechas){
        this.numFlechas = numFlechas;
    }

    // Método de la interface de Movilizable
    @Override
    public void moverse(){
        //Atribuimos la movilidad del personaje
        System.out.println(getNombre()+" Se mueve y cambia de posicion");
    }
    
    // Método de la propia clase de arquero
    public void dispararFlecha(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que disparar flecha es un ataque
        super.atacar();
    }

    // Método propio de la clase Arquero
    public void restablecerFlechas(){
        // Asignamos el reestablecimiento de flechas
        System.out.println(getNombre()+" Las flechas se han restablecido.");
    }

    // LLamamos al metodo cantar balada de la clase Personaje_Fisico
    public void cantarBalada(){
        // Atribuimos que el personaje puede cantar una balada
        System.out.println(getNombre()+" Canta su balada");
    }

    // Sobreescribimos el nombre del arquero para evitar referencias raras
    @Override
    public String toString(){
        return "Arquero: " + this.nombre;
    }

    // Método para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
        // Si el objeto Arquero es igual al objeto se cumple la igualdad
        if (this == objetoAComparar) return true;
        // Si el objeto es nulo o no coincide con la instancia arquero no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Arquero)) return false;

        //Creamos un nuevo objeto para comparar entre arqueros
        // Si tienen la misma agilidad son el mismo si no la tienen devuelve false
        Arquero otroArquero = (Arquero) objetoAComparar;
        return Objects.equals(nombre, otroArquero.nombre) && this.getAgilidad() == otroArquero.getAgilidad();
    }

    // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
        // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getAgilidad());
    }
}
