package club2012;

/*
 * Problema: Almost
 * Solution by Alessandro de Luna Almeida
 *
 * Dijkstra
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class dijkstraMatriz {
	static int m, n, s, d, grafo[][], grafo2[][];
	static StreamTokenizer in;
	static PrintStream out;
	static int[] dist, dist2;

	static boolean readdata() throws IOException {
		in.nextToken();
		n = (int) in.nval;//numero de Nodos
		if (n == 0)
			return false;
		in.nextToken();
		m = (int) in.nval; // numero de caminos
		in.nextToken();
		s = (int) in.nval; //fuente 
		in.nextToken();
		d = (int) in.nval; //destino

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
			in.nextToken();
			int u = (int) in.nval;//origen
			in.nextToken();
			int v = (int) in.nval;//fin
			in.nextToken();
			int p = (int) in.nval;//pasos
			grafo[u][v] = p;
			grafo[v][u] = p;
		}
		long time=System.nanoTime();
		dijkstra(s, grafo, dist);
		System.out.println("Tiempo en dijkstra: "+(System.nanoTime()-time));
		for(int i=0;i<dist.length;i++)
			out.print(" "+dist[i]);
		out.println();
		int mindist = dist[d];
		if (mindist == Integer.MAX_VALUE / 3) { //si no hubo forma de llegar al nodo destino
			out.println(-1);
			return;
		}
		dijkstra(d, grafo2, dist2);
		for(int i=0;i<dist.length;i++)
			out.print(" "+dist2[i]);
		out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grafo[i][j] > 0) {
// dist para ese punto + distancia de ese punto al destino + distancia de dijkstra transpuesta
					if (dist[i] + grafo[i][j] + dist2[j] == mindist){
						out.println("eliminamos camino de: "+i+" a "+j);
						grafo[i][j] = 0;//eliminamos la union al destino
					}
				}
			}
		}
		Arrays.fill(dist, Integer.MAX_VALUE / 3);// rellenamos el arreglo de distancia a infinito
		dijkstra(s, grafo, dist);
		out.println(dist[d] == Integer.MAX_VALUE / 3 ? -1 : dist[d]);
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
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = System.out;
		while (readdata())
			process();
		out.close();
	}
}