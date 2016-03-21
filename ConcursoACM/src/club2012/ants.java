package club2012;
import java.util.*;
class ants {

	/*
	 * input:
	 *
6
0 8
1 7
1 9
0 3
4 2
4
2 3
5 2
1 4
0 3
2
0 1
2
1 0
0 1
6
0 1000000000
1 1000000000
2 1000000000
3 1000000000
4 1000000000
3
5 0
0 5
2 4
16
0 10
0 15
5 20
0 40
1 80
3 160
3 320
4 8
5 640
4 10
10 11
11 1200
2 1000000
12 1
6 100
6
13 14
13 15
15 13
14 13
15 14
14 15
0



	 */

	static class Anthill{
		int ver;
		long steps;

		public Anthill(int a1,  long s){
			ver=a1;	steps=s;}
}

	static int q1,q2,anthills,queries;
	static long count;
	static List<Anthill>[] antlists;
	static long dist[];

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		//java.awt.Toolkit.getDefaultToolkit().beep();

		Scanner entry=new Scanner(System.in);
		while(true){
			anthills=entry.nextInt();
			if(anthills==0){
			break;}
			antlists=new LinkedList[anthills];

			for(int i=0;i<anthills;i++){//inicialisamos listas con dif. objetos nuevos;
				antlists[i]=new LinkedList<Anthill>();
			}
			//Arrays.fill(antlists, 0, anthills, new LinkedList<Anthill>());//de esta forma inicial. con mismo obj.
			
			for(int q=1;q<anthills;q++){// anadimos aristas a los vertices
				q1=entry.nextInt();	q2=entry.nextInt();

				antlists[q].add(new Anthill(q1,q2));
				antlists[q1].add(new Anthill(q,q2));
			}
			queries=entry.nextInt();
			for(int i=0;i<queries;i++){
				count=0;
				q1=entry.nextInt();		q2=entry.nextInt();
				dist=new long[anthills];
				//long time=System.nanoTime();
				System.out.print(dijkstra(dist,q1,q2)+" ");
				//System.out.println("Tiempo en dijkstra: "+(System.nanoTime()-time));

			}System.out.println();

		}
	}

	static long dijkstra(long dist[],int inicio,int fin){
		boolean[] visit=new boolean[anthills];
		int nodo,vertices;
		Anthill aux;
		Arrays.fill(dist,Long.MAX_VALUE/3);
		dist[inicio]=0;
		while(/*!visit[fin] &&*/ (nodo=calcularMenor(dist,visit))!=-1){
			visit[nodo]=true;
			vertices=antlists[nodo].size();
			for (int w = 0; w < vertices; w++) {
				aux=antlists[nodo].get(w);
				if (!visit[aux.ver] &&	(dist[nodo] + aux.steps) < dist[aux.ver]) {
					dist[aux.ver] = dist[nodo] + aux.steps;
				}
			}
		}
		for(int i=0;i<anthills;i++)		System.out.print(dist[i]+"\t");		System.out.println();
		return dist[fin];
	}

	static int calcularMenor(long d[],boolean etiqueta[]){
	    int k,ret=-1;
	    long aux=Long.MAX_VALUE/3;
	    for(k=0;k<anthills;k++)
	    	if(!etiqueta[k] && d[k] < aux){
	    		aux=d[k];
	    		ret=k;}
	     return ret;
	}
}