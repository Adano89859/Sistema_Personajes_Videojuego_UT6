package Model;

import java.util.Objects;

public class Asesino extends Personaje_Fisico implements Movilizable, Curable {
    // Atributos (se añaden los de su superclase):
    private boolean sigilo;
    private int critico;

    //Métodos

    //CONSTRUCTOR PRINCIPAL:
    public Asesino(String nombre, int nivel, int salud, boolean sigilo, int critico){

        super(nombre, nivel, salud);
        this.sigilo = sigilo;
        this.critico = critico;
    }

    //Subconstructores con falta de parámetros
    public Asesino(int nivel, int salud){
        this("Predeterminado", nivel, 100, false, 0);
    }

    public Asesino(String nombre, int nivel){
        this(nombre, nivel, 100, false, 0);
    }

    public Asesino(String nombre){
        this(nombre, 0, 100, false, 0);
    }

    public Asesino(int nivel){
        this("Predeterminado", nivel, 100, false, 0);
    }

    //Getters
    public boolean getSigilo(){
        return sigilo;
    }

    public int getCritico(){
        return critico;
    }

    //Setters
    public void setSigilo(boolean sigilo){
        this.sigilo = sigilo;
    }

    public void setCritico(int critico){
        this.critico = critico;
    }

    // Método de la interface de Curable
    @Override
    public void curar(){
        //Atribuimos la capacidad de curarse al personaje
        System.out.println(getNombre()+" Se ha curado");
    }

   @Override
   public void moverse(){
        System.out.println(getNombre()+ "Se mueve sigilosamente");
   }

    //Método propio de la clase Asesino
    public void atacarPorEspalda(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que atacar por la espalda es un ataque
        super.atacar();
    }

    //Método propio de la clase Asesino
    public void ocultar(){
        // Atribuimos la capacidad de ocultarse al personaje
        System.out.println(getNombre()+ " Se ha ocultado");
    }

    // LLamamos al metodo cantar balada de la clase Personaje_Fisico
    public void cantarBalada(){
        // Atribuimos que el personaje puede cantar una balada
        System.out.println(getNombre()+ " Canta su balada");
    }

    // Sobreescribimos el nombre del asesino para evitar referencias raras
    @Override
    public String toString(){
        return "Asesino: " + this.nombre;
    }

    
    // Método para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
         // Si el objeto asesino es igual al objeto se cumple la igualdad
        if (this == objetoAComparar) return true;
         // Si el objeto es nulo o no coincide con la instancia asesino no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Asesino)) return false;
         //Creamos un nuevo objeto para comparar entre asesinos
        // Si tienen el mismo sigilo son el mismo si no la tienen devuelve false
        Asesino otroAsesino = (Asesino) objetoAComparar;
        return Objects.equals(nombre, otroAsesino.nombre) && this.getSigilo() == otroAsesino.getSigilo();
    }

     // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
        // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getSigilo());
    }
}