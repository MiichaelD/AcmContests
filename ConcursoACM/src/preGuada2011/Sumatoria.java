package preGuada2011;

import java.util.Scanner;

public class Sumatoria {
	public static void main(String[] args) {
		int entry;
		Scanner in=new Scanner(System.in);
		while((entry=Integer.parseInt(in.next()))!=0){
			System.out.printf("N=%d,Sum=%d\n",entry,Sumatoria.sumOptimo(3,entry));
		}
	}

	 public static int sumFor(int inicio,int tope){
		 int conta=0,i;
		 for(i=inicio;i<=tope;i++) {
			 conta+=i;}
		 return conta;}

	 public static int sumOptimo(int tope){
		 /*se puede calcular como
		 * (inicio+tope)*tope)/2
		 * surge de mr gauss: * como de 1 a 1000
		 * i se va incrementando, tope se va decementando
		 * y sumandose (Esto generará el doble del resultado
		 * la secuencia desde 1 a 1000 y la de 1000 a 1 qe se stan sumando)
		 * 1+1000,2+999,3+998.... todos los resultados dan 1001
		 * y esta operacion se realiza (tope) numero de veces.
		 *
		 *
		 * se multiplica la suma de el primer mas el ultimo numero
		 * y se divide entre 2 porqe apartir de la mitad
		 * se repiten los numeros del principio, pero en orden diferente.
		 * 499+502,500+501,501+500,502+499
		 * de ahi surge la formula
		 */
		 return ((tope+1)*tope/2);
	 }

	 public static int sumOptimo(int inicio, int tope){
		 /*/*
			 *esta formula fue modificada para que la sumatoria pudiera funcionar desde
			 *cualqier numero, no como la forma de gauss anterior,que solo funcionaba
			 *desde 1 hasta tope. ej.
			 *
			 *desde 1 a 10 = 55
			 *pero de 3 a 10 = 13*10/2= 65
			 *cuando en realidad tendria que ser 52
			 *
			 *de (1 a 10) - ( 1 a 3) = 55 - 2*3/2 = 52 CORRECTO!
			 *
			 */
		 return (((tope+1)*tope/2)-((inicio-1)*(inicio)/2));
	 }

}
