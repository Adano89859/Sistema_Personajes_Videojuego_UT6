package Model;

public class Mago extends Personaje_Magico implements Curable{

    //Atributos:
    private int sabiduria;
    //Se le añaden los atributos de su superclase

    //Métodos:

    //CONSTRUCTOR
    public Mago(String nombre, int nivel, int salud, int mana, int sabiduria){
        //Llevo los elementos al constructor de la superclase
        super(nombre, nivel, salud, mana);
        //Añado el atributo concreto que tiene esta clase
        this.sabiduria = sabiduria;
    }
    //Constructores con falta de parámetros
    public Mago(int nivel, int salud){
        this("Predeterminado",nivel,salud,0,0);
    }
    public Mago(String nombre, int nivel){
        this(nombre,nivel,100,0,0);
    }
    public Mago(String nombre){
        this(nombre,0,100,0,0);
    }
    public Mago(int nivel){
        this("Predeterminado",nivel,100,0,0);
    }

    //Getter
    public int getSabiduria() {
        return sabiduria;
    }
    //Setter
    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    //El método "atacar" es heredado de "Personaje_Magico"

    //Método que la interface de "Mágico" me obliga a realizar
    @Override
    public void lanzarHechizo(){
        //Ya que este método está en la superclase y no pretendo hacerle cambios, hago una llamada a él
        super.lanzarHechizo();
    }

    //Método que la interface de "Curable" me obliga a realizar
    @Override
    public void curar(){
        //Por ahora solo digo que cura
        System.out.println(getNombre()+" ha curado.");
    }

    //Método "orar" es heredado de "Personaje_Magico"

    //Método propio de esta clase, inventado
    public void generarMana(){
        //Por ahora solo digo que genera Mana
        System.out.println(getNombre()+" genera Mana.");
    }

    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        return "Mago: "+this.nombre;
    }

    //Método para cambiar el "equals" de esta clase
    @Override
    public boolean equals(Object objetoAComparar){
        //Compruebo que la superClase de esta, "Personaje_Magico" en este caso, nos diga que este objeto es igual a ella, de no ser así, anulo la igualdad
        if (!super.equals(objetoAComparar)) return false;
        //Compruebo que sean de la misma clase y que no sea  nula, o sino anulo la comparación
        if (objetoAComparar == null || this.getClass() != objetoAComparar.getClass()) return false;
        //Convierto el objeto que me han dado en un "Mago" para seguir comparando
        Mago objetoACompararConvertidoEnMago = (Mago) objetoAComparar;
        //Añado que un "Mago" es igual a otro si también tiene la misma sabiduría
        if(this.getSabiduria()==objetoACompararConvertidoEnMago.getSabiduria()){
            return true;
        }
        //Si no tiene la misma sabiduría, no es el mismo personaje
        return false;
    }

    //Método para cambiar el "hashCode" de esta clase
    @Override
    public int hashCode(){
        //Hago que el hashCode coja el nombre de la clase
        return this.nombre.hashCode();
    }

    }
