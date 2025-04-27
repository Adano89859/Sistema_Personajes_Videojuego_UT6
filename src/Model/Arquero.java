package Model;

public class Arquero extends Personaje_Fisico implements Movilizable {
   private int agilidad;
   private int numFlechas;
   
   public Arquero(String nombre, int nivel, int salud, int agilidad, int numFlechas){

        super(nombre, nivel, salud);
        this.agilidad = agilidad;
        this.numFlechas = numFlechas;
   }

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

    public int getAgilidad(){
        return agilidad;
    }

    public void setAgilidad(int agilidad){
        this.agilidad = agilidad;
    }

    public int getnumFlechas(){
        return numFlechas;
    }

    public void setnumFlechas(int numFlechas){
        this.numFlechas = numFlechas;
    }

    @Override
    public void moverse(){

        super.moverse();
    }

    public void dispararFlecha(){

        super.atacar();
    }

    public void restablecerFlechas(){

        System.out.println(getNombre()+"Las flechas se han reestablecido.");
    }

    @Override
    public String toString(){
        return "Arquero: " + this.nombre;
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
