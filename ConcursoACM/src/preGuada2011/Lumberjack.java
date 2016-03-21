package preGuada2011;
import java.util.*;
// validar que 3 longitudes d lineas formen un triangulo
public class Lumberjack {
	public static void main(String[] args) {
		int entry;
		String salida="";
		int[] vec=new int[3];
		Scanner in=new Scanner(System.in);
		entry=Integer.parseInt(in.nextLine());
		for(int i=0;i<entry;i++){
			Scanner in2=new Scanner(in.nextLine());
			in2.useDelimiter("[ ]");
			vec[0]=(in2.nextInt());
			vec[1]=(in2.nextInt());
			vec[2]=(in2.nextInt());
			Arrays.sort(vec); //de menor a mayor;

			if(((vec[2]+vec[0]>vec[1])&&(vec[2]<vec[0]+vec[1])&&(vec[0]<vec[2]+vec[1]))|| (Math.hypot(vec[0],vec[1])==vec[2]))
				salida+="OK\n" ;
			else salida+="Wrong!!\n";
		}salida=salida.substring(0,salida.length()-1);// para eliminar ultimo enter
		System.out.println(salida);
		}
	}