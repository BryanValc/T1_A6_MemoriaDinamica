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
				System.out.println("solo números naturales");
				err=true;
			}
		}while(err);
		return ret;
	}
}

class Aspirante{
	private int folio;
	private String Nombre;
	private byte edad;
	private String redesSociales[];
	
	public Aspirante(int folio, String nombre, byte edad, String[] redesSociales) {
		this.folio = folio;
		Nombre = nombre;
		this.edad = edad;
		this.redesSociales = redesSociales;
	}
	
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
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
		return "Aspirante [folio=" + folio + ", Nombre=" + Nombre + ", edad=" + edad + ", redesSociales="
				+ Arrays.toString(redesSociales) + "]";
	}
	
	
}//class Aspirante


class RegistroAspirantes implements Validacion{
	
	ArrayList listaAspirantes;
	private int nFolio=1;
	
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
		this.setnFolio(this.getnFolio()+1);
		listaAspirantes.add(a);
	}
	public Object eliminarAspirante(String folio) {
		this.setnFolio(this.getnFolio()-1);
		return listaAspirantes.remove(listaAspirantes.size()-1);
	}
	public void mostrarAspirantes() {
		//Recorrido de un ARRAYLIST
		//System.out.println("----Forma 1 con un objeto ITERATOR--------");
		Iterator i = listaAspirantes.iterator();
		while(i.hasNext()) {
			Aspirante a = (Aspirante) i.next();
			System.out.println(a);
		}
	}	
}

public class PruebaMemoriaDinamica {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		RegistroAspirantes ra = new RegistroAspirantes();
		//ra.agregarAspirante(new Aspirante("1", (byte)1, redes));
		String nombre;
		String folio = null;
		int opc=0;
		int edad=0;

		do {
			System.out.println("1)Agregar aspirante \n"
					+ "2)Eliminar aspitante \n"
					+ "3)Mostrar aspirantes \n"
					+ "4)Salir");
			opc = Validacion.validacionNatural();
			switch (opc) {
			case 1:
				String redes[]=new String[3];
				System.out.println("nombre: ");
				nombre = input.nextLine();
				System.out.println("edad: ");
				edad = Validacion.validacionNatural();
				System.out.println("Facebook: ");
				redes[0]=input.nextLine();
				System.out.println("Twitter: ");
				redes[1]=input.nextLine();
				System.out.println("Instagram: ");
				redes[2]=input.nextLine();
				
				if (ra.listaAspirantes.isEmpty()) {
					ra.agregarAspirante(new Aspirante(1,nombre, (byte)edad, redes));
				}else {
					ra.agregarAspirante(new Aspirante(ra.getnFolio(), nombre, (byte)edad, redes));
				}
				break;
			case 2:
				ra.eliminarAspirante(folio);
				break;
			case 3:
				ra.mostrarAspirantes();
				break;
			case 4:
				break;
			default:
				System.out.println("opción no válida");
				break;
			}
			
		}while (opc!=4);
		
		System.out.println("Tamaño del arraylist: " + ra.listaAspirantes.size());
	}
}













