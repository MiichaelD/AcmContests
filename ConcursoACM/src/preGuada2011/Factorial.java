package preGuada2011;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args) {
		int entry;
		String salida="";
		Scanner in=new Scanner(System.in);
		do{
			entry=Integer.parseInt(in.next());
			if(entry!=0)
				salida+=Factorial.fac(entry)+"\n";
			else {salida=salida.substring(0,salida.length()-1);
			System.out.println(salida);
			return;
			}
		}while(true);

	}
	 public static String fac(int n){
	int conta=1,i;
		for(i=1;i<=n;i++) {
			conta*=i;
		}
	 return "N="+n+",Factorial="+conta;}

}
