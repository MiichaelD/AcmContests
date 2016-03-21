package preGuada2011;
import java.util.*;
public class Bakugan{
	/*mientras entrada!=0, a numeros pares dividir x/2, impares x*3+1 y encontrar mayor
	 * input:
10
4 2 2 2 5 6 7 8 1 1
1 4 4 4 1 1 1 1 2 3
5
3 3 3 3 2
8 9 9 9 9
10
8 4 7 1 1 9 5 2 4 3
5 6 9 7 9 4 2 3 7 4
0

	 */
	public static void main(String[] args) {
		String entrada,salida="";
		Scanner in=new Scanner(System.in);
		int VecUno [];
		int VecDos [];
		int H = 0, M = 0;
		entrada="1";
		while(Integer.parseInt(entrada)!=0){
			entrada=in.next();

			if(Integer.parseInt(entrada)!=0){
				VecUno = new int [Integer.parseInt(entrada)];
				VecDos = new int [Integer.parseInt(entrada)];

				for(int i=0;i<2;i++){// metodo para llenado de vectores
					for(int j=0;j<Integer.parseInt(entrada);j++){//llenar los valores del vector 1/2
						if(i==0)
							VecUno[j]=in.nextInt();
						else
							VecDos[j]=in.nextInt();
					}
				}
				for(int t=0;t<Integer.parseInt(entrada);t++){// sumar los numeros
					H += VecUno[t];
					M += VecDos[t];

				}

				for(int t=1;t<Integer.parseInt(entrada)-1;t++){// sumar los numeros
					if((VecUno[t-1]==VecUno[t])&&(VecUno[t]==VecUno[t+1])){
						H+=30;break;
					}
					else if((VecDos[t-1]==VecDos[t])&&(VecDos[t]==VecDos[t+1])){
						M+=30; break;
					}
				}
				System.out.print("\n");
				if(H>M){
					System.out.print("M");
				}else if(M>H){
						System.out.print("L");
				}else if(M==H){
						System.out.print("T");
					}

				H=0;M=0;
				}else {if(!salida.equals(""))System.out.println(salida.substring(0,salida.length()-1));return;}
		}
	}
}
