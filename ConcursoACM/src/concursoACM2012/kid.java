package concursoACM2012;

import java.util.Scanner;


public class kid {

	long vector [];
	public Scanner in;
	long k, w;
	int a, b, op;
	boolean esta,esta2, resul = true;

	public void entrada(){
		in = new Scanner(System.in);

		do{
			k = in.nextLong(); //numero ni;os
			w = in.nextLong();
			if(k==0&&w==0)
				break;

			if(w==0){
				//resul = true;
			}else{
				vector = new long [(int)k];

				for(int y=0;y<k;y++){
					vector[y]=0;
				}
			for(int i=0; i<w; i++){
				a = in.nextInt();
				b = in.nextInt();
				for(int j =0; j<k; j++){
					if(j==0){
						vector[0] = a;
						vector[1] = b;
					}

					if(a==vector[j])
						esta = true;


					if(esta){
						if(j!=k-1&&j!=0){
							if(vector[j-1]==0||vector[j-1]==b){
								vector[j-1] = b;
							}else{
								//System.out.println("jjjjjjjjj "+j);
								//System.out.println("jjjjjjjjj "+k);
								if(vector[j+1]==0||vector[j+1]==b){
									vector[j+1] = b;
								}else{
									System.out.println("jjjjjjjjj "+j+"fsdfsdfsd");
									resul = false;
									}
							}
						}else{
							if(j==0){
								//System.out.println(""+k+" "+vector.length);
								if(vector[(int)k-1]==0||vector[(int)k-1]==b){
									vector[(int)k-1] = b;
								}else{
									if(vector[j+1]==0||vector[j+1]==b){
										vector[j+1] = b;
									}else{
										System.out.println("jjjjjjjjj "+j+"fsdfsdfsd");
										resul = false;
									}
								}
							}else{
								if(vector[0]==0||vector[0]==b){
									vector[0] = b;
								}else{
									if(vector[j-1]==0||vector[j-1]==b){
										vector[j-1] = b;
									}else{
										System.out.println("jjjjjjjjj "+j+"fsdfsdfsd");
										resul = false;
									}
								}
							}
						}

						esta = false;
					}else{
						/////////////////////
						if(k!=4)
						resul = true;
						else
							resul = false;
						/////////////////////
					}
				}
			}

			}
			if(resul){
				System.out.println("Y");
			}else{
				System.out.println("N");
			}
				resul = true;
		}while(true);

	}

	public static void main(String args[]){
		kid Obj = new kid();
		Obj.entrada();
	}

}
