package Model;

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
        System.out.println(getNombre()+"Se mueve y cambia de posicion");
    }
    
    // Método de la propia clase de arquero
    public void dispararFlecha(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que disparar flecha es un ataque
        super.atacar();
    }

    // Método propio de la clase Arquero
    public void restablecerFlechas(){
        // Asignamos el reestablecimiento de flechas
        System.out.println(getNombre()+"Las flechas se han reestablecido.");
    }

    // LLamamos al metodo cantar balada de la clase Personaje_Fisico
    @Override
    public void cantarBalada(){
        // Atribuimos que el personaje puede cantar una balada
        super.cantarBalada();
    }

    // Sobreescribimos el nombre del arquero para evitar referencias raras
    @Override
    public String toString(){
        return "Arquero: " + this.nombre;
    }

    // Método para comparar entre arqueros
    @Override
    public boolean equals(Object ObjetoComparacion){
        // Comprobamos si la superclase Personaje_Fisico coincide, y que el objeto proceda de la misma, en caso contrario se anula la igualdad
        if (!super.equals(ObjetoComparacion)) return false;
        // Comprobamos que los objetos procedan de la misma clase, sino, se anula la igualdad
        if (ObjetoComparacion == null || this.getClass() != ObjetoComparacion.getClass()) return false;
        // Creamos un nuevo objeto y lo convertimos en un objeto arquero para seguir comparando
        Arquero objetoArquero = (Arquero) ObjetoComparacion;
         //Comparamos que los arqueros sean iguales si tienen la misma agilidad
        if(this.getAgilidad()==objetoArquero.getAgilidad()){
            return true;
        }
        // Si no tienen la misma agilidad, no son el mismo arquero
        return false;
    }

    // Método para introducir el nombre de la clase en el hashCode
    @Override
    public int hashCode(){
        //EL hashCode detecta el nombre de la clase y lo coje
        return this.nombre.hashCode();
    }
}
