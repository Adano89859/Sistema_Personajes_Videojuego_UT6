package Model;

public class Personaje_Fisico extends Personaje {


    public Personaje_Fisico(String nombre, int nivel, int salud){
        super(nombre, nivel, salud);
        
    }
    
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

    @Override
    public void atacar(){
        System.out.println(getNombre()+ "Realiza un ataque");
    }

    public void cantarBalada(){
        System.out.println(getNombre()+ "El personaje canta su balada épica");
    }

    @Override
    public String toString(){
        return "Personaje físico: " + this.getNombre();
    }

    @Override
    public boolean equals(Object ObjetoComparacion){
        if (!super.equals(ObjetoComparacion)) return false;
        if (ObjetoComparacion == null || this.getClass() != ObjetoComparacion.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

}