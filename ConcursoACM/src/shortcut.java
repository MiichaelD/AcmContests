import java.util.Scanner;
/*
 * http://sistemas.uniandes.edu.co/~maraton/mua/lib/exe/fetch.php?media=problemas:2012:entrenamiento4.pdf
	Input:
1
12
NNNENNWWWSSW


 */
public class shortcut {

	static Path arr[];
	static Path[][] mat;
	static int sections, X=0, Y=0, maxX, maxY, minX, minY, wholeX, wholeY;
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int cases=in.nextInt();
		for (int i=0;i<cases;i++){
			sections=in.nextInt();
			arr=new Path[sections+1];
			String path=in.next();
			arr[0]=new Path(X,Y,0,'X');
			for(int j=1;j<sections+1;j++){
				char c=path.charAt(j-1);
				switch(c){
				case 'N':
					arr[j]=new Path(X, ++Y,j,c);
					if(Y>maxY) maxY=Y;
					break;
					
				case 'E':
					arr[j]=new Path(++X, Y,j,c);
					if(X>maxX) maxX=X;
					break;
					
				case 'S':
					arr[j]=new Path(X, --Y,j,c);
					if(Y<minY) minY=Y;
					break;
					
				case 'W':
					arr[j]=new Path(--X, Y,j,c);
					if(X<minX) minX=X;
					break;
				}
				//print(j")\t"+arr[j].x+" "+arr[j].y+" "+arr[j].dir+"\n");
			}
			//once we got the limits, we insert the data in a Matrix
			minX=Math.abs(minX);
			minY=Math.abs(minY);
			
			// Filas x Columnas = fc = Y x X
			mat=new Path[1+maxY+minY][1+maxX+minX];
			
			//we update each path position and add them to the matrix:
			for(int j=0;j<sections+1;j++){
				Path aux=arr[j];
				aux.x+=minX;	aux.y+=minY;
				mat[aux.y][aux.x]=aux;
			}
			
			
			/*
			print(" Printing matrix\n" );
			for (int z=mat.length-1;z>=0;z--){//Y = ultima fila
				for(int a=0;a<mat[0].length;a++){// X = primera Columna
					print(mat[z][a]==null?"  -\t":mat[z][a].num+""+mat[z][a].dir+"\t");
				}
				print("\n");
			}			
			
						
			print("Finding shortcut...\n");*/
			for(int s=1;s<sections;s++){
				String st=findShortcut(s);
				if(st != null){
					print(st+"\n");
					break;
				}	
			}
		}
	}
	
	
	public static String findShortcut(int pIndex){
		Path aux=arr[pIndex];
		Path next=arr[pIndex+1];
		Path last=arr[pIndex-1];
		int print=0;
		int y1=aux.y,	x1=aux.x;
		int y2=y1,		x2=x1;
		
		
		int maxIt=0;
		if(y1>0 && last.y!=y1-1)
			if(aux.dir != 'N' && next.dir != 'S')
				maxIt=y1; 								// distancia en Y (hacia abajo)
		
		if(y1<mat.length-1 && last.y!=y1+1)
			if(aux.dir != 'S' && next.dir != 'N')
				maxIt=Math.max(maxIt, mat.length-1-y1);//distancia de Y a tope (hacia arriba)
		
		if(x1>0 && last.x!=x1-1)
			if(aux.dir != 'E' && next.dir != 'W')
				maxIt=Math.max(maxIt, x1);				//distancia en X (hacia izqierda)
		
		if(x1<mat[0].length-1 && last.x!=x1+1)
			if(aux.dir != 'W' && next.dir != 'E')
				maxIt=Math.max(maxIt, mat[0].length-1-x1);//distancia de X a tope
		
		//print("En el punto ("+pIndex+") "+x1+","+y1+" numero de iteraciones maximas: "+maxIt+", para "+mat.length+" filas(Y) y "+mat[0].length+" columnas(X) \n");
		for(int it=0;it<maxIt;it++){
			if(aux.dir != 'N' && next.dir != 'S' )// distancia en Y (hacia abajo)
				y2--;
			if(aux.dir != 'S' && next.dir != 'N' )//distancia de Y a tope (hacia arriba)
				y1++;
			if(aux.dir != 'E' && next.dir != 'W' )//distancia en X (hacia izqierda)
				x2--;
			if(aux.dir != 'W' && next.dir != 'E' )//distancia de X a tope
				x1++;
			
			if(y1 < mat.length && x1 < mat[0].length && y2 >= 0 && x1 >= 0){
				if(mat[y1][x1]!=null && mat[y2][x2]!=null)
					print = Math.max(mat[y1][x1].num,mat[y2][x2].num);
				else print=0;
			}
			else print=0;
			
			
			if(y1 < mat.length && x1 < mat[0].length)
				if(mat[y1][x1]!=null && print <= mat[y1][x1].num)
					return (Math.abs(y1-aux.y)+Math.abs(x1-aux.x))+" "+pIndex+" "+mat[y1][x1].num+" "+(x1!=aux.x? 'E': 'N');//+". x,y= "+x1+","+y1;
				
			if(y2 >= 0 && x1 >= 0)
				if(mat[y2][x2]!=null)
					return (Math.abs(y2-aux.y)+Math.abs(x2-aux.x))+" "+pIndex+" "+mat[y2][x2].num+" "+(aux.x!=x2? 'W': 'S');//+". x,y= "+x2+","+y2;
				
			
		}return null;		
	}
	
	public static void print(String s){
		System.out.print(s);
	}

}

class Path{
	int x,y,num;	char dir;
	
	Path(int x1, int y1, int n, char d){
		x=x1;	y=y1;	num=n;	dir=d;
	}
}
