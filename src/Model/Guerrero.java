package Model;

import java.util.Objects;

public class Guerrero extends Personaje_Fisico implements Defendible {
    // Atributos (se añaden los de su superclase):
    private int fuerza;
    private int armadura;
    private int escudo;
    
    //Métodos

    //CONSTRUCTOR PRINCIPAL:
    public Guerrero(String nombre, int nivel, int salud, int fuerza, int armadura, int escudo){

        super(nombre, nivel, salud);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo= escudo;
    }

    //Subconstructores con falta de parámetros
    public Guerrero(int nivel, int salud){
        this("Predeterminado", nivel, 100, 0, 0, 0);
    }

    public Guerrero(String nombre, int nivel){
        this(nombre, nivel, 100, 0, 0, 0);
    }

    public Guerrero(String nombre){
        this(nombre, 0, 100, 0, 0, 0);
    }

    public Guerrero(int nivel){
        this("Predeterminado", nivel, 100, 0, 0, 0);
    }

    //Getters
    public int getFuerza(){
        return fuerza;
    }

    public int getArmadura(){
        return armadura;
    }
    
    public int getEscudo(){
        return escudo;
    }

    //Setters
    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }

    public void setArmadura(int armadura){
        this.armadura = armadura;
    }

    public void setEscudo(int escudo){
        this.escudo = escudo;
    }

    // Método de la interface de Defendible
    @Override
    public void defender(){
         //Atribuimos la capacidad de defenderse al personaje
        System.out.println(getNombre()+" Se defiende");
    }

    //Método propio de la clase Guerrero
    public void cargarAtaque(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que cargar un ataque es un ataque
       System.out.println(getNombre()+ " Carga un ataque");
    }

    public void cantarBalada(){
        // Atribuimos que el personaje puede cantar una balada
        System.out.println(getNombre()+ " Canta su balada");
    }

    // Sobreescribimos el nombre del guerrero para evitar referencias raras
    @Override
    public String toString(){
        return "Guerrero: " + this.nombre;
    }

    // Método para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
        // Si el objeto guerrero es igual al objeto se cumple la igualdad
        if (this == objetoAComparar) return true;
         // Si el objeto es nulo o no coincide con la instancia guerrero no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Guerrero)) return false;
         //Creamos un nuevo objeto para comparar entre guerreros
        // Si tienen la misma fuerza son el mismo si no la tienen devuelve false
        Guerrero otroGuerrero = (Guerrero) objetoAComparar;
        return Objects.equals(nombre, otroGuerrero.nombre) && this.getFuerza() == otroGuerrero.getFuerza();
    }

     // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
         // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getFuerza());
    }
}
