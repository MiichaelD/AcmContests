import java.util.Scanner;

// concusro ACM escuela abril 2013
class Main {
	
	static int hora,minuto;
	
	public static void main(String[] args) {
		
		String Line;
		String campos[];
		Scanner in = new Scanner(System.in);
		
		
		while(in.hasNextLine()){
			Line = in.nextLine();
			
			campos = Line.split("[: ]");			
			/*System.out.println("Campos = "+campos.length);
			for(int i=0;i<campos.length;i++){
				System.out.print("\t"+campos[i]);
			}
			*/
			
			switch (campos.length){
			case 2:
				System.out.println((Horas(campos[0])&&Minutos(campos[1])?"VALID":"INVALID"));
				break;
			case 3:
				System.out.println((Horas(campos[0])&&Minutos(campos[1])&&lastVer(campos[2])?"VALID":"INVALID"));
				break;
			default:
				System.out.println("INVALID");
				break;
			}
		}
	}
	
	public static boolean Horas(String cadena){		
		if(cadena.length()>2)
			return false;
		try{
			hora = Integer.parseInt(cadena);
		}catch(Exception e){return false;}
		return (hora>-1 && hora<24);
		
	}
	
	public static boolean Minutos(String cadena){
		if(cadena.length()!=2)
			return false;
		try{
				minuto =Integer.parseInt(cadena);
		}catch(Exception e){return false;}
		return (minuto<60 && minuto>-1);
		
	}
	
	public static boolean lastVer(String cadena){
		if (hora < 13){
			return (cadena.equalsIgnoreCase("am")||cadena.equalsIgnoreCase("pm")||cadena.equalsIgnoreCase("hrs"));
		}
		return (cadena.equalsIgnoreCase("hrs"));
	}
}
