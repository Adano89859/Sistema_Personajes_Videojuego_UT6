package Model;

public class Asesino extends Personaje_Fisico implements Curable {
    // Atributos (se añaden los de su superclase):
    private int sigilo;
    private int critico;

    //Métodos

    //CONSTRUCTOR PRINCIPAL:
    public Asesino(String nombre, int nivel, int salud, int sigilo, int critico){

        super(nombre, nivel, salud);
        this.sigilo = sigilo;
        this.critico = critico;
    }

    //Subconstructores con falta de parámetros
    public Asesino(int nivel, int salud){
        this("Predeterminado", nivel, 100, 0, 0);
    }

    public Asesino(String nombre, int nivel){
        this(nombre, nivel, 100, 0, 0);
    }

    public Asesino(String nombre){
        this(nombre, 0, 100, 0, 0);
    }

    public Asesino(int nivel){
        this("Predeterminado", nivel, 100, 0, 0);
    }

    //Getters
    public int getSigilo(){
        return sigilo;
    }

    public int getCritico(){
        return critico;
    }

    //Setters
    public void setSigilo(int sigilo){
        this.sigilo = sigilo;
    }

    public void setCritico(int critico){
        this.critico = critico;
    }

    // Método de la interface de Curable
    @Override
    public void curar(){
        //Atribuimos la capacidad de curarse al personaje
        System.out.println(getNombre()+"Se ha curado");
    }

    //Método propio de la clase Asesino
    public void atacarPorEspalda(){
        //LLamamos al metodo atacar de la clase personaje_fisico ya que atacar por la espalda es un ataque
        super.atacar();
    }

    //Método propio de la clase Asesino
    public void ocultar(){
        // Atribuimos la capacidad de ocultarse al personaje
        System.out.println(getNombre()+ "Se ha ocultado");
    }

    // Sobreescribimos el nombre del asesino para evitar referencias raras
    @Override
    public String toString(){
        return "Asesino: " + this.nombre;
    }

    // Método para comparar entre Asesinos
    @Override
    public boolean equals(Object ObjetoComparacion){
        // Comprobamos si la superclase Personaje_Fisico coincide, y que el objeto proceda de la misma, en caso contrario se anula la igualdad
        if (!super.equals(ObjetoComparacion)) return false;
        // Comprobamos que los objetos procedan de la misma clase, sino, se anula la igualdad
        if (ObjetoComparacion == null || this.getClass() != ObjetoComparacion.getClass()) return false;
        // Creamos un nuevo objeto y lo convertimos en un objeto asesino para seguir comparando
        Asesino objetoAsesino = (Asesino) ObjetoComparacion;
        //Comparamos que los asesinos sean iguales si tienen el mismo sigilo
        if(this.getSigilo()==objetoAsesino.getSigilo()){
            return true;
        }
         // Si no tienen el mismo sigilo, no son el mismo asesino
        return false;
    }

     // Método para introducir el nombre de la clase en el hashCode
    @Override
    public int hashCode(){
         //EL hashCode detecta el nombre de la clase y lo coje
        return this.nombre.hashCode();
    }
}
