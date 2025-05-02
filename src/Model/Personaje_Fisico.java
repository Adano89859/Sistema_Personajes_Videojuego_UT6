package Model;

import java.util.Objects;

public class Personaje_Fisico extends Personaje {

    // CONSTRUCTOR GENERAL:
    public Personaje_Fisico(String nombre, int nivel, int salud){
        super(nombre, nivel, salud);
        
    }

    // Subconstructores con falta de parámetros
    public Personaje_Fisico(int nivel, int salud){
        this("Predeterminado", nivel, salud);
    }
    
    public Personaje_Fisico(String nombre, int nivel){
        this(nombre, nivel, 100);
    }

    public Personaje_Fisico(String nombre){
        this(nombre, 0, 100);
    }

    public Personaje_Fisico(int nivel){
        this("Predeterminado", nivel, 100);
    }

    // Método propio de la clase que atribuye a los personajes físicos a atacar
    @Override
    public void atacar(){
        System.out.println(getNombre()+ " Realiza un ataque");
    }

    // Sobreescribimos el nombre de los personajes para evitar referencias raras
    @Override
    public String toString(){
        return "Personaje físico: " + this.getNombre();
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