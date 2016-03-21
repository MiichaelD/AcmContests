package usaco;
/* 	Problema:	 	Simplifying the Farm
   	WebSite:		http://www.usaco.org/index.php?page=dec11problems
	input:
5 7
2 1 5
1 3 1
3 2 8
3 5 7
3 4 3
2 4 7
4 5 2


*
*/
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SimplifyingTheFarm {
	static int m, n, s, d, grafo[][], grafo2[][];
	static Scanner in;
	static int[] dist, dist2;

	static boolean readdata() throws IOException {
		if(!in.hasNextInt())
			return false;
		n = in.nextInt();//numero de Nodos
		if (n == 0)
			return false;

		m = in.nextInt(); // numero de caminos
		s = 0;			  //fuente
		d = n-1;			  //destino

		grafo = new int[n][n];// inicializamos la matriz
		grafo2 = new int[n][n];
		dist = new int[n];// inicializamos el arreglo de distancia
		dist2 = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE / 3); //llenamos distancias a infinito
		Arrays.fill(dist2, Integer.MAX_VALUE / 3);
		return true;
	}

	static void process() throws IOException {
		for (int i = 0; i < m; i++) {
			int u = in.nextInt()-1;//origen
			int v = in.nextInt()-1;//fin
			int p = in.nextInt();//pasos
			grafo[u][v] = p;
			grafo[v][u] = p;
		}
		long time=System.nanoTime();
		dijkstra(s, grafo, dist);
		System.out.println("Tiempo en dijkstra: "+(System.nanoTime()-time));
		for(int i=0;i<dist.length;i++)
			System.out.print(" "+dist[i]);
		System.out.println();
		int mindist = dist[d];
		if (mindist == Integer.MAX_VALUE / 3) { //si no hubo forma de llegar al nodo destino
			System.out.println(-1);
			return;
		}
		dijkstra(d, grafo2, dist2);
		for(int i=0;i<dist2.length;i++)
			System.out.print(" "+dist2[i]);
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grafo[i][j] > 0) {
// dist para ese punto + distancia de ese punto al destino + distancia de dijkstra transpuesta
					if (dist[i] + grafo[i][j] + dist2[j] == mindist){
						System.out.println("eliminamos camino de: "+i+1+" a "+j+1);
						grafo[i][j] = 0;//eliminamos la union al destino
					}
				}
			}
		}
		Arrays.fill(dist, Integer.MAX_VALUE / 3);// rellenamos el arreglo de distancia a infinito
		dijkstra(s, grafo, dist);
		System.out.println(dist[d] == Integer.MAX_VALUE / 3 ? -1 : dist[d]);
	}

	static void dijkstra(int source, int[][] g, int[] dis) {
		boolean mark[] = new boolean[n];
		dis[source] = 0;
		int v;
		while (!mark[d] && (v = getmin(dis, mark)) != -1) {//solo punto importante
			mark[v] = true;
			for (int w = 0; w < n; w++) {
				if (g[v][w] > 0 && !mark[w] && (dis[v] + g[v][w] < dis[w])) {
					dis[w] = dis[v] + g[v][w];
				}
			}
		}
	}

	static int getmin(int[] dis, boolean[] mark) {
		int ret = -1, min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (!mark[i] && dis[i] < min) {
				min = dis[i];
				ret = i;
			}
		}
		return ret;
	}

	public static void main(String[] args) throws IOException {
		in = new Scanner(System.in);
		while (readdata())
			process();
	}
}