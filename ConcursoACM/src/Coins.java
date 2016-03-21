import java.util.Scanner;
// concusro ACM escuela abril 2013

class Main2 {

	public static int coins[][],t,n,i,j,k,res1,res2;
	public static String name[];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in =new Scanner (System.in);
		String name[];

		//TestCases
		for(i=0, t= in.nextInt();i<t;i++){
			n = in.nextInt();
			name = new String[2];
			coins = new int[2][n];

			for(j=0;j<2;j++){
				name[j]=in.next();
				for( k=0;k<n;k++){
					coins[j][k]=in.nextInt();
				}
			}
			res1=maxSum(0);
			res2=maxSum(1);

			if(res1 == res2)
				System.out.println("Tied "+res1);
			else if(res1 < res2){
				System.out.println(name[1]+" "+res2);
			}
			else
				System.out.println(name[0]+" "+res1);
		}

	}

	public static int maxSum(int player){
		int max = 0,i,j,k,sum;
		for(i=0;i<n;i++){
			for(j=0;j<n;j++){
				sum=0;
				for(k=i;k<=j;k++){
					sum+=coins[player][k];
				}
				max=Math.max(sum, max);
			}
		}
		return max;
	}
}
/*
2
5
Elpidio 4 -2 3 2 -4
Chuncha 1 2 -3 4 1
4
Cecilin 1 2 3 4
Matojo 4 3 2 1





 */

