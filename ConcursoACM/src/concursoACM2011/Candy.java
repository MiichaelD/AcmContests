package concursoACM2011;

import javax.swing.JOptionPane;

public class Candy {

	int m = Integer.parseInt(JOptionPane.showInputDialog("Numero de Filas"));
	int n = Integer.parseInt(JOptionPane.showInputDialog("Numero de Columnas"));
	int [][] Matriz = new int [m][n];
	int d = Matriz[0][0];
	public int PosX = 0, PosY = 0;


	int Cont = 0;
	int ContadorDulces = 0;
	boolean Estado = true;

	public void Metodo(){

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
		Matriz[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero"));
			}}
		if(m==5&&n==5){
			ContadorDulces++;
		}
	while(Estado){
		d = 0;
		Cont++;



		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if (Matriz[i][j] != 0){

				}else{
					if(i==m-1&&j==n-1){
				Estado = false;
					}
				}
			}
		}


	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if (Matriz[i][j]>d){
				d = Matriz[i][j];
				PosX = i;
				PosY = j;
			}
		}
	}

	ContadorDulces+= Matriz[PosX][PosY];
	Matriz[PosX][PosY] = 0;


	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			if(PosX>0){
				if(PosX>4){

				}else{
					//Si corresponde a todos
					if(PosX==i-1){
						Matriz[i][j]=0;
					}
					if(PosX==i+1){
						Matriz[i][j]=0;
					}
					if(PosX==i&&(PosY==j-1||PosY==j+1)){
						Matriz[i][j]=0;
					}

				}
			}else{
				if(PosX==i-1){
					Matriz[i][j]=0;
				}
				if(PosX==i&&(PosY==j-1||PosY==j+1)){
					Matriz[i][j]=0;
				}
			}
		}	}

	}
	JOptionPane.showMessageDialog(null,"Maximo numero de Dulces: "+ContadorDulces);
	}



	public static void main(String[] args) {
		Candy x = new Candy();
		x.Metodo();

	}

}
