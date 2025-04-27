package Model;

public class Guerrero extends Personaje_Fisico implements Defendible {

    private int fuerza;
    private int armadura;
    private int escudo;

    public Guerrero(String nombre, int nivel, int salud, int fuerza, int armadura, int escudo){

        super(nombre, nivel, salud);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo= escudo;
    }

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

    public int getFuerza(){
        return fuerza;
    }

    public void setFuerza(int fuerza){
        this.fuerza = fuerza;
    }

    public int getArmadura(){
        return armadura;
    }

    public void setArmadura(int armadura){
        this.armadura = armadura;
    }

    public int getEscudo(){
        return escudo;
    }

    public void setEscudo(int escudo){
        this.escudo = escudo;
    }

    @Override
    public void defender(){

        super.defender();
    }
    
    public void cargarAtaque(){

       super.atacar();
    }

    @Override
    public String toString(){
        return "Guerrero: " + this.nombre;
    }

    @Override
    public boolean equals(Object ObjetoComparacion){
        if (!super.equals(ObjetoComparacion)) return false;
        if (ObjetoComparacion == null || this.getClass() != ObjetoComparacion.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode(){
        
        return this.nombre.hashCode();
    }

}
