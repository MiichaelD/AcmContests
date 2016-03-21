package concursoACM2012;

import java.util.Scanner;
class brothers {

	static int[][] matriz,matriz2;
	static Scanner inp;
	static int heirs,reng,col,bata;

	public static void main(String[] args) {
		inp=new Scanner(System.in);
		while((heirs=inp.nextInt())!=0){
			reng=inp.nextInt();
			col=inp.nextInt();
			bata=inp.nextInt();
			matriz=new int[reng][col];
			matriz2=new int[reng][col];
			for(int i=0;i<reng;i++){
				for(int j=0;j<col;j++){
					matriz[i][j]=inp.nextInt();
					matriz2[i][j]=matriz[i][j];
				}
			}
			for(int i=0;i<bata;i++)			{
				Batalla();
				clonarDeMatAMat(matriz2,matriz);
			}
			Imprimir(matriz2);
		}
	}

	public static void clonarDeMatAMat(int[][] matFuente, int[][] matSalida){
		for(int i=0;i<reng;i++){ //capturamos renglones;
			for(int j=0;j<col;j++)//capturamos columnas
				matSalida[i][j]=matFuente[i][j];
		}
	}

	public static void Batalla(){
		int r=reng-1, c=col-1, h=heirs-1;
		for(int i=0;i<reng;i++){
			for(int j=0;j<col;j++){
					if(j>0){
						if(h!=matriz[i][j]){
							if(matriz[i][j-1]==(1+matriz[i][j])){
								matriz2[i][j-1]=matriz[i][j];
							}
						}else{
							if(matriz[i][j-1]==0){
								matriz2[i][j-1]=matriz[i][j];
							}
						}
					}
					if(j<c){
						if(h!=matriz[i][j]){
							if(matriz[i][j+1]==(1+matriz[i][j])){
								matriz2[i][j+1]=matriz[i][j];
							}
						}else{
							if(matriz[i][j+1]==0){
								matriz2[i][j+1]=matriz[i][j];
							}
						}
					}
					if(i>0){
						if(h!=matriz[i][j]){
							if(matriz[i-1][j]==(1+matriz[i][j])){
								matriz2[i-1][j]=matriz[i][j];
							}
						}else{
							if(matriz[i-1][j]==0){
								matriz2[i-1][j]=matriz[i][j];
							}
						}
					}
					if(i<r){
						if(h!=matriz[i][j]){
							if(matriz[i+1][j]==(1+matriz[i][j])){
								matriz2[i+1][j]=matriz[i][j];
							}
						}else{
							if(matriz[i+1][j]==0){
								matriz2[i+1][j]=matriz[i][j];
							}
						}
					}
			}
		}
	}

	public static void Imprimir(int[][] mat){
		int c=col-1;
		for(int i=0;i<reng;i++){
			for(int j=0;j<col;j++)
				if(j==c)
					System.out.print(mat[i][j]);
				else
					System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
}
