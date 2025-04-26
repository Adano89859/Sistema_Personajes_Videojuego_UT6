package Model;

//Esta clase es abstracta
public abstract class Personaje {

    //Atributos
    protected String nombre;
    protected int nivel;
    protected int salud;

    //Métodos:

    //CONSTRUCTOR
    public Personaje(String nombre, int nivel, int salud){
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }
    //Constructores con falta de parámetros
    public Personaje(int nivel, int salud){
        this("Predeterminado",nivel,salud);
    }
    public Personaje(String nombre, int nivel){
        this(nombre,nivel,100);
    }
    public Personaje(String nombre){
        this(nombre,0,100);
    }
    public Personaje(int nivel){
        this("Predeterminado",nivel,100);
    }

    //Setter
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public void setSalud(int salud) {
        this.salud = salud;
    }

    //Getter
    public String getNombre() {
        return nombre;
    }
    public int getNivel() {
        return nivel;
    }
    public int getSalud() {
        return salud;
    }

    //Método abstracto que las clases hijas tendrán que desarrollar
    abstract void atacar();

    //Método para cambiar el "toString" de esta clase
    @Override
     public String toString(){
        return "Personaje: "+this.nombre;
    }

    //Método para cambiar el "equals" de esta clase
    @Override
    public boolean equals(Object objetoAComparar){
        //Compruebo que la superClase de esta, "object" en este caso, nos diga que este objeto es igual a ella, de no ser así, anulo la igualdad
        if (!super.equals(objetoAComparar)) return false;
        //Compruebo que sean de la misma clase y que no sea  nula, o sino anulo la comparación
        if (objetoAComparar == null || this.getClass() != objetoAComparar.getClass()) return false;
        //Convierto el objeto que me han dado en un "Personaje" para seguir comparando
        Personaje objetoACompararConvertidoEnPersonaje = (Personaje) objetoAComparar;
        //Considero que para ser el mismo objeto, debe tener el mismo NOMBRE y NIVEL
        //Pero decido que no tiene porqué tener la misma SALUD
        if(this.nombre.equals(objetoACompararConvertidoEnPersonaje.nombre) && this.nivel==objetoACompararConvertidoEnPersonaje.nivel){
            return true;
        }
        //Si el nombre o el nivel no es el mismo, digo que no son el mismo personaje
        return false;
    }

    //Método para cambiar el "hashCode" de esta clase
    @Override
    public int hashCode(){
        //Hago que el hashCode coja el nombre de la clase
        return this.nombre.hashCode();
    }
}
