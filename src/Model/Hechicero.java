package Model;

/*

AÑADIR LA INTERFACE DE "DEFENDIBLE" PARA SEGUIR TRABAJAMNDO ESTA CLASE

 */

//Work In Progress

public class Hechicero extends Personaje_Magico implements Defendible{

    //Atributos:
    private int concentracion;
    //Se le añaden los atributos de su superclase

    //Métodos:

    //CONSTRUCTOR
    public Hechicero(String nombre, int nivel, int salud, int mana, int concentracion){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud, mana);
        //Añado el atributo concreto que tiene esta clase
        this.concentracion = concentracion;
    }
    //Constructores con falta de parámetros
    public Hechicero(int nivel, int salud){
        this("Predeterminado",nivel,salud,0,0);
    }
    public Hechicero(String nombre, int nivel){
        this(nombre,nivel,100,0,0);
    }
    public Hechicero(String nombre){
        this(nombre,0,100,0,0);
    }
    public Hechicero(int nivel){
        this("Predeterminado",nivel,100,0,0);
    }

    //Getter
    public int getConcentracion() {
        return concentracion;
    }
    //Setter
    public void setConcentracion(int concentracion) {
        this.concentracion = concentracion;
    }

    //El método "atacar" es heredado de "Personaje_Magico"

    //Método que la interface de "Mágico" me obliga a realizar
    @Override
    public void lanzarHechizo(){
        //Ya que este método está en la superclase y no pretendo hacerle cambios, hago una llamada a él
        super.lanzarHechizo();
    }

    //Método que la interface de "Defendible" me obliga a realizar
    @Override
    public void defender(){
        //Por ahora solo digo que defiende
        System.out.println(getNombre()+" defiende.");
    }

    //Método "orar" es heredado de "Personaje_Magico"

    //Método propio de esta clase, inventado
    public void invocarEntidad(){
        //Por ahora solo digo que invoca una Entidad
        System.out.println(getNombre()+" invoca una Entidad.");
    }

    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        return "Hechicero: "+this.nombre;
    }

    //Método para cambiar el "equals" de esta clase
    @Override
    public boolean equals(Object objetoAComparar){
        //Compruebo que la superClase de esta, "Personaje_magico" en este caso, nos diga que este objeto es igual a ella, de no ser así, anulo la igualdad
        if (!super.equals(objetoAComparar)) return false;
        //Compruebo que sean de la misma clase y que no sea  nula, o sino anulo la comparación
        if (objetoAComparar == null || this.getClass() != objetoAComparar.getClass()) return false;
        //Considero que el Hechicero es igual a otro Hechicero segun los criterios de la superclase, es decir, no voy a usar la "concentracion" para la comparación
        return true;
    }

    //Método para cambiar el "hashCode" de esta clase
    @Override
    public int hashCode(){
        //Hago que el hashCode coja el nombre de la clase
        return this.nombre.hashCode();
    }

}
