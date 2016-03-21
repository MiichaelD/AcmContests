package spotify.zipfsong;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

	static song aux,first;
	static int n, m, i=0;
	static Scanner in;
	static song ll[];


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

