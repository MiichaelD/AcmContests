import java.util.*;
class sniffer {

	static char[][] matriz;
	static Scanner in;
	static String caseName,linea;
	static int fila,columna,filas,columnas;
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		while(!(caseName=in.nextLine()).equals("")){
			captura();
			System.out.println("Filas: "+filas+" Columnas: "+columnas);
			flooding(1,1);
			impresion();
		}
		/*
-- SAMPLE 1 --
+----------+
|  # #### #|
|# ##    ##|
|# ## ##   |
|#    # ###|
|######    |
+----------+
.
-- SAMPLE 2 --
+------------------------------+
| #  #########    #      # #  #|
| # #        ###### #### ######|
| ### ###### ###### #  # ######|
|     ######        #  #      #|
|######     #########   #####  |
+------------------------------+
.


*/ }
	
	public static void captura(){
		matriz=new char[50][50];
		fila=-1;
		while(!(linea=in.nextLine()).equals(".")){
			fila++;
			columnas=linea.length();
			for(int columna=0;columna<columnas;columna++){
				matriz[fila][columna]=linea.charAt(columna);
			}
		}
		columna=columnas-1;
		filas=fila+1;
	}
	
	public static void flooding(int x, int y){
		if(matriz[x][y]!=' '){
			return;
		}
		matriz[x][y]=':';
		if(y<columna){
			flooding(x,y+1);
		}
		if(x<fila){
			flooding(x+1,y);
		}
		if(y>0){
			flooding(x,y-1);
		}
		if(x>0){
			flooding(x-1,y);
		}
	}
	
	public static void impresion(){
		System.out.println(caseName);
		for (int i=0;i<filas;i++){
			for(int j=0;j<columnas;j++){
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
		System.out.println(".");
	}
}

