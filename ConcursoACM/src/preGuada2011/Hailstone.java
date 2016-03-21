package preGuada2011;
import java.util.*;
public class Hailstone {
	/*mientras entrada!=0, a numeros pares dividir x/2, impares x*3+1 y encontrar mayor
		input:
		5
11
27
0

	*/

	public static void main(String[] args) {
		int entry;
		Hailstone h=new Hailstone();
		Scanner in=new Scanner(System.in);
		do{
			entry=in.nextInt();
			if(entry!=0)
				System.out.println(h.metodo(entry));
		}while(entry!=0);
	}

	public int metodo(int entry){
		int may=entry;
		while(entry!=1){
			if(entry%2==0)
				entry=entry/2;
			else entry=entry*3+1;
			if(entry>may)may=entry;}
		return may;
	}
}
