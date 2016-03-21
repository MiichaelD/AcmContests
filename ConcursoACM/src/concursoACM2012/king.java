package concursoACM2012;

import java.util.Arrays;
import java.util.Scanner;
class king {

	static Scanner in;
	static int input[];
	public static void main(String[] args) {
		in=new Scanner(System.in);
		input= new int[3];
		while((input[0] = in.nextInt()) != 0){
			input[1]=in.nextInt();
			input[2]=in.nextInt();
			System.out.println(getBetterHand());
		}
	}

	public static String getBetterHand(){
		Arrays.sort(input);
		if(input[0]==input[1]){//par chicos
			if(input[1]==input[2]){//si es TERCIA
				if(input[0]==13){// es tercia MAXIMA
					return "*";
				}
				else{//tercia minima, se manda siguiente tercia mayor
					return (input[0]+1)+" "+(input[0]+1)+" "+(input[0]+1);
				}
			}
			else{//par chico  y carta grande
				if(input[2]==13){// carta grande = carta mas alta
					return 1+" "+(input[0]+1)+" "+(input[1]+1);
				}
				else{//carta no mas alta
					return input[0]+" "+input[0]+" "+(input[2]+1);
				}
			}
		}
		else{
			if(input[1] == input[2]){//par grande, carta chica
				if((input[0]+1) == input[1]){//si al aumentar carta chica, tiende atercia
					if(input[1] != 13){ //si el par grande son maximos, no se debe incrementar carta chica
						return input[1]+" "+input[1]+" "+(input[0]+2);
					}
					else{
						return 1+" "+1+" "+1;//se regresa tercia mas chica
					}
				}
				else{
					return (input[0]+1)+" "+input[1]+" "+input[1];
				}
			}
			else{
				return 1+" "+1+" "+2;
			}
		}
	}

}
