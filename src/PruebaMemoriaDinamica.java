import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

interface Validacion{
	Scanner input = new Scanner(System.in);
	public static int validacionNatural() {
		int ret = 0;
		boolean err = false;
		do {
			try {
				ret = input.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida, intente de nuevo:");
				input.nextLine();
				err=true;
			}
			if (ret>0) {
				err=false;
			}else {
				System.out.println("solo n�meros naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
}

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


class RegistroAspirantes implements Validacion{
	
	ArrayList listaAspirantes;
	private int nFolio;
	
	
	
	public int getnFolio() {
		return nFolio;
	}
	public void setnFolio(int nFolio) {
		this.nFolio = nFolio;
	}
	
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
		int opc=0;
		
		do {
			System.out.println("1)Agregar aspirante \n"
					+ "2)Eliminar aspitante \n"
					+ "3)Mostrar aspirantes \n"
					+ "4)Salir");
			opc = Validacion.validacionNatural();
			switch (opc) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:break;
			default:
				System.out.println("opci�n no v�lida");
				break;
			}
			
		}while (opc!=4);
		
		System.out.println("Tama�o del arraylist: " + ra.listaAspirantes.size());
	}
}













