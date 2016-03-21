package concursoACM2012;

import java.util.Scanner;
class grapevine {

	int vector [][];
	public Scanner in;
	int n1, n2, q, l, u;
	int i=0,j=0,x,y,difx;

	public void entrada(){
		in = new Scanner(System.in);

		while((n1 = in.nextInt())!=0){
			n2 = in.nextInt();

			vector = new int [n1][n2];
			for(int i=0; i<n1;i++){//captuar fila
				for(int j=0; j<n2;j++){ //columna
					vector[i][j] = in.nextInt();
				}
			}
			q = in.nextInt();//queries
			for(int m=0; m<q; m++){
				l = in.nextInt();
				u = in.nextInt();

				if(findEsquina()){
				x=i;
				y=j;
				while((x+1)<n1 && (y+1)<n2   && (vector[x+1][y+1]>=l && u>=vector[x+1][y+1])){
					x++;
					y++;
				}
				difx=x-(i-1);
				System.out.println(difx);}
				else
					System.out.println("0");
			}
			System.out.println("-");
		}
	}

	public boolean findEsquina(){
		for(i=0; i<n1;i++){
			for(j=0; j<n2;j++){
				if(vector[i][j]>=l && vector[i][j]<=u){
					//System.out.println("Esquina encontrada: "+vector[i][j]+" en: "+i+","+j);
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		grapevine g=new grapevine();
		g.entrada();
	}

}
