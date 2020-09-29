import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

class Aspirante{
	
	//folio
	private String Nombre;
	private byte edad;
	private String redesSociales[];
	
	public Aspirante(String nombre, byte edad, String[] redesSociales) {
		Nombre = nombre;
		this.edad = edad;
		this.redesSociales = redesSociales;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public byte getEdad() {
		return edad;
	}
	public void setEdad(byte edad) {
		this.edad = edad;
	}
	public String[] getRedesSociales() {
		return redesSociales;
	}
	public void setRedesSociales(String[] redesSociales) {
		this.redesSociales = redesSociales;
	}
	@Override
	public String toString() {
		return "Aspirante [Nombre=" + Nombre + ", edad=" + edad + ", redesSociales=" + Arrays.toString(redesSociales)
				+ "]";
	}
}//class Aspirante


class RegistroAspirantes{
	
	ArrayList listaAspirantes;
	
	public RegistroAspirantes() {
		listaAspirantes = new ArrayList();
	}
	
	public void agregarAspirante(Aspirante a) {
		listaAspirantes.add(a);
	}
	
	public Object eliminarAspirante(String folio) {
		
		//eliminacion del ultimo aspirante
		return listaAspirantes.remove(listaAspirantes.size()-1);
	}
	
	public void mostrarAspirantes() {
		
		//Recorrido de un ARRAYLIST
		
		System.out.println("----Forma 1 con un objeto ITERATOR--------");
		Iterator i = listaAspirantes.iterator();
		while(i.hasNext()) {
			Aspirante a = (Aspirante) i.next();
			System.out.println(a);
		}
		
		
		
	}	
}

public class PruebaMemoriaDinamica {
	public static void main(String[] args) {
		
		RegistroAspirantes ra = new RegistroAspirantes();
		
		String redes[] = {"FB", "TW", "IG"};
		
		ra.agregarAspirante(new Aspirante("1", (byte)1, redes));
		ra.agregarAspirante(new Aspirante("2", (byte)2, redes));
		ra.agregarAspirante(new Aspirante("3", (byte)3, redes));
		ra.agregarAspirante(new Aspirante("4", (byte)4, redes));
		ra.agregarAspirante(new Aspirante("5", (byte)5, redes));
		
		ra.mostrarAspirantes();
		
		System.out.println("Tamaño del arraylist: " + ra.listaAspirantes.size());
	}
}













