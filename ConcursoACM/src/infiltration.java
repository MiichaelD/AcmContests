/*
 * Problem:				infiltration
 * 
 * Programmers:		Michael Duarte
 * 								Hector Garcia 
 * 
 * Date:						May 2013
 * 
 */
import java.util.Scanner;

class infiltration {
	
	
	
	public static void main(String[] args) {
			
		//Variables
		Scanner in = new Scanner(System.in);
		String num;
		int i, controlables, cells, maCells[][], casos=0;
		Control mControl;
		
		//While there is more input
		while(in.hasNext())	{
			
			//capture cells
			cells = in.nextInt();
			in.nextLine();
			
			//instance a new array
			maCells = new int [cells][cells+1];
			
			//fill array and get the max amount of controllable cells
			for(i=0; i<cells; i++){
				num = in.nextLine();
				controlables=0;
				for(int j=0; j<cells; j++){					
					controlables+=(maCells[i][j] = num.charAt(j)-'0');
				}	
				maCells[i][cells]=controlables;
			}
			
			//create a new control object
			mControl=new Control(cells);
			
			//process input
			Object[] res=procesar(maCells, mControl);
			
			//print output
			System.out.println("Case "+(++casos)+": "+res[0]+res[1]);
		}
	}
	
	
	
	public static Object[] procesar(int[][] mat, Control mControl)
	{
		int maxCon[], cells = mat.length, iter=0;
		String cuales="";
		
		//while there are uncontrolled cells
		while(mControl.controlados < cells){
			iter++;
			maxCon=getMayorControl(mat);
			cuales+=" "+(maxCon[0]+1);
			if(mControl.controlado[maxCon[0]])
				mControl.controlados+=maxCon[1];
			else
				//we include ourselves
				mControl.controlados+=maxCon[1]+1;
			for(int i =0; i < cells; i++){
				if(mat[maxCon[0]][i] == 1){
					mControl.controlado[i]=true;
				}
			}
			updateControlados(mat,mControl);
		}
		return new Object[]{iter, cuales};
	}
	
	/**
	* calculate the new amount of controllable cells
	* by each cell 
	* @param mat cell's array
	* @param mControl control structure for this problem
	*/
	public static void updateControlados(int[][] mat, Control mControl){
		int cells = mat.length, controlables;
		for(int i=0; i<cells; i++){
			controlables=0;
			for(int j=0; j<cells; j++){
				if(mControl.controlado[j])
					continue;
				controlables+=mat[i][j];
			}	
			mat[i][cells]=controlables;
		}
	}
	
	/**
	 * this method gets the index of the cell with the most controllable
	 * cells it has and how many it controls
	 * @param mat cell's array
	 * @return Integer array [0]= cell index. [1]=amount of cells under control
	 */
	public static int[] getMayorControl(int[][] mat){
		int cells = mat.length, max=0, index= -1;
		for(int i =0; i<cells; i++){
			if(mat[i][cells] > max){
				max=mat[i][cells];
				index=i;
			}
		}
		return (new int[]{index,max});
	}
}

class Control{
	
	int controlados;
	boolean controlado[];
	
	Control(int c){
		controlados=0;
		controlado=new boolean[c];
	}
}
/*
2
00
10
3
010
001
100
5
01000
00011
11001
10100
10010


*/