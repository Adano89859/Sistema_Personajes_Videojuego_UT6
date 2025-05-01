package Model;
import java.util.Objects;

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
        System.out.println(getNombre()+" Se ha curado.");
    }

    //Método "orar" es heredado de "Personaje_Magico"

    //Método propio de esta clase, inventado
    public void generarMana(){
        //Por ahora solo digo que genera Mana
        System.out.println(getNombre()+" Genera Mana.");
    }

    //Método para cambiar el "toString" de esta clase
    @Override
    public String toString(){
        return "Mago: "+this.nombre;
    }

    
    // Método para comparar entre objetos
    @Override
    public boolean equals(Object objetoAComparar) {
        // Si el objeto mago es igual al objeto se cumple la igualdad
        if (this == objetoAComparar) return true;
        // Si el objeto es nulo o no coincide con la instancia mago no se cumple la igualdad
        if (objetoAComparar == null || !(objetoAComparar instanceof Mago)) return false;
         //Creamos un nuevo objeto para comparar entre magos
        // Si tienen la misma sabiduría son el mismo si no la tienen devuelve false
        Mago otroMago = (Mago) objetoAComparar;
        return Objects.equals(nombre, otroMago.nombre) && this.getSabiduria() == otroMago.getSabiduria();
    }

    // Utilizamos el hacshCode para obtener el objeto por su nombre y Agilidad que es lo que lo diferencia
    @Override
    public int hashCode() {
         // Hacemos la llamada al objeto y al atributo que lo diferencia
        return Objects.hash(nombre, getSabiduria());
    }

}
