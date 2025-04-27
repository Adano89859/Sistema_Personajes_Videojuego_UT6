package Model;

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
        System.out.println(getNombre()+"Se defiende");
    }

    //Método propio de la clase Guerrero
    public void cargarAtaque(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que cargar un ataque es un ataque
       super.atacar();
    }

    // LLamamos al metodo cantar balada de la clase Personaje_Fisico
    @Override
    public void cantarBalada(){
        // Atribuimos que el personaje puede cantar una balada
        super.cantarBalada();
    }

    // Sobreescribimos el nombre del guerrero para evitar referencias raras
    @Override
    public String toString(){
        return "Guerrero: " + this.nombre;
    }

    // Método para comparar entre Guerreros
    @Override
    public boolean equals(Object ObjetoComparacion){
         // Comprobamos si la superclase Personaje_Fisico coincide, y que el objeto proceda de la misma, en caso contrario se anula la igualdad
        if (!super.equals(ObjetoComparacion)) return false;
        // Comprobamos que los objetos procedan de la misma clase, sino, se anula la igualdad
        if (ObjetoComparacion == null || this.getClass() != ObjetoComparacion.getClass()) return false;
        // Creamos un nuevo objeto y lo convertimos en un objeto guerrero para seguir comparando
        Guerrero objetoGuerrero = (Guerrero) ObjetoComparacion;
        //Comparamos que los guerreros sean iguales si tienen el mismo sigilo
        if(this.getFuerza()==objetoGuerrero.getFuerza()){
            return true;
        }
        // Si no tienen la misma fuerza, no son el mismo guerrero
        return false;
    }

    // Método para introducir el nombre de la clase en el hashCode
    @Override
    public int hashCode(){
        //EL hashCode detecta el nombre de la clase y lo coje
        return this.nombre.hashCode();
    }

}
