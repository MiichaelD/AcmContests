// concusro ACM escuela abril 2013

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main3 {

	public static void main(String[] args) {

		String entrada;

		ArrayList<Manejador> lista = new ArrayList<Manejador>();

		Scanner in = new Scanner(System.in);

		while(true)
		{
			entrada = in.next();
			if(entrada.equals("#"))
			{
				procesar(lista);
				lista = new ArrayList<Manejador>();
				System.exit(0);
			}

			if(entrada.equals("@"))
			{
				procesar(lista);
				lista = new ArrayList<Manejador>();
				System.out.println("@");
			}
			else
			{
			lista.add(new Manejador(entrada, in.nextInt(), in.nextInt(), in.nextInt()));
			}
		}
	}

	public static void procesar(ArrayList<Manejador> lista)
	{
		Collections.sort(lista);
		int i=0;
		 // Print the name from the list....
        for(Manejador tabla : lista) {
            //System.out.printf("%s%d %d %d%n",tabla.getNombre(),tabla.getMedallasOro(),tabla.getMedallasPlata(),tabla.getMedallasBronce());
            System.out.println(tabla.getNombre());
        }
	}
}

	class Manejador implements Comparable{

		private String nombrePais;
		private Integer oro, plata, bronce;

		Manejador(String nombrePais, Integer oro, Integer plata, Integer bronce){
			this.nombrePais = nombrePais;
			this.oro = oro;
			this.plata = plata;
			this.bronce = bronce;
		}

		public String getNombre(){
			return nombrePais;
		}

		public Integer getMedallasOro(){
			return oro;
		}

		public Integer getMedallasPlata(){
			return plata;
		}

		public Integer getMedallasBronce(){
			return bronce;
		}

		public int compareTo(Object otro) {
			Manejador otroPais = (Manejador) otro;
			int compOro=(oro.compareTo(otroPais.getMedallasOro())),
					comPlata=0, compBronze=0;
			//System.out.println(nombrePais+" vs "+otroPais.nombrePais);
			if(compOro<0)
				return 1;
			if(compOro == 0){
				comPlata= plata.compareTo(otroPais.getMedallasPlata());
				if(comPlata<0)
					return 1;
				if(comPlata==0){
					compBronze=bronce.compareTo(otroPais.getMedallasBronce());
					if(compBronze<0)
						return 1;
					if(compBronze==0){
						if(nombrePais.compareTo(otroPais.getNombre())<0){
							return -1;
						}
						return 1;
					}
					if(compBronze>0)
						return -1;
				}
				if(comPlata>0)
					return -1;
			}
			if(compOro >0)
				return -1;
			return 0;
		}
}