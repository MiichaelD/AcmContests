package spotify.zipfsong;
/*
http://www.spotify.com/int/jobs/tech/zipfsong/


Programmer:		Michael Duarte

Task:


Input:

Output:

15 3
197812 re_hash
78906 5_4
189518 tomorrow_comes_today
39453 new_genious
210492 clint_eastwood
26302 man_research
22544 punk
19727 sound_check
17535 double_bass
18782 rock_the_house
198189 19_2000
13151 latin_simone
12139 starshine
11272 slow_country
10521 m1_a1


4 2
30 one
30 two
15 three
25 four


*/
import java.util.Arrays;
import java.util.Scanner;
public class ZipfsSong {

	static song aux,first;
	static int n, m, i=0;
	static Scanner in;
	static song ll[];

	/**En este metodo tenemso la posibilidad de perder presicion
	 * por utilizar divisiones (las cuales pueden hacer un numero muy muy pequeno */
	static void method1(){
		first=new song(Double.parseDouble(in.next()), in.next());
		first.qi=first.fi/first.fi;
		ll[0]=first;

		for(i=1;i<n;i++){
			aux=new song(Double.parseDouble(in.next()), in.next());
			aux.qi=aux.fi/(first.fi/(i+1)); // = aux.qi=aux.fi*(i+1)/first.fi;
			ll[i] = aux;
		}
	}

	/** Nos evitamos el pasdo de divir todo entre el primer f1	 */
	static void method2(){
		for(i=0;i<n;i++){
			aux=new song(Double.parseDouble(in.next()), in.next());
			aux.qi=aux.fi*(i+1);
			ll[i]=(aux);
		}
	}


	public static void main(String[] args) {
		in=new Scanner(System.in);
		n=in.nextInt();		m=in.nextInt();
		ll = new song[n];
		method2();
		Arrays.sort(ll);
		//NOTE: get last items it's not the same to reverseOrder

		//int showing = n-m-1;
		//for(i=n-1; i>showing ;i--){
		for(i=0; i<m ;i++){
			System.out.println(ll[i].name);
		}
	}

	static class song implements Comparable<song>{
		Double fi, qi;
		String name;
		public song(double fi, String name){
			this.fi=fi;			this.name=name;
		}
		public int compareTo(song o) {//order desc
			return -qi.compareTo(o.qi);
		}
	}
}

