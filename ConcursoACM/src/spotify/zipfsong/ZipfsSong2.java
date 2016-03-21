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
import java.util.Scanner;
import java.util.LinkedList;

import spotify.zipfsong.ZipfsSong.song;
public class ZipfsSong2 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n, m, i=0, j;
		LinkedList<song> ll=new LinkedList<song>();
		n=in.nextInt();
		m=in.nextInt();
		song aux,first;

		first=new song(Double.parseDouble(in.next()), in.next());
		first.qi=((double)first.fi)/(first.fi);
		ll.add(first);

		for(i=1;i<n;i++){
			aux=new song(Double.parseDouble(in.next()), in.next());
			aux.qi=aux.fi/(first.fi/(i+1));
			ll.addLast(aux);
		}

		quicksort(ll,0,n-1);

		//for(i=0;i<n;i++){
		int showing = n-m-1;
		for(i=n-1; i>showing ;i--){
			System.out.println(ll.get(i).name);
		}
	}

	static song sortAux;
	public static void quicksort(LinkedList<song> ll,int min, int max){
		int i=min, j=max;
		double pivot=ll.get(min + (max-min)/2).qi;

		while(i <= j ){

			while(ll.get(i).qi < pivot) {
				i++;
			}

			while(ll.get(j).qi > pivot){
				j--;
			}

			if( i <= j){
				sortAux=ll.get(i);
				ll.set(i,ll.get(j));
				ll.set(j,sortAux);
				i++;
				j--;
			}
		}

		if(min < j)
			quicksort(ll,min,j);
		if(i < max)
			quicksort(ll,i,max);

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