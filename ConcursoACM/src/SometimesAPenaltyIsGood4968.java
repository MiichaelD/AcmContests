import java.util.Scanner;
class SometimesAPenaltyIsGood4968 {
/*input:
8 4 2 0 
8 4 2 1 
-1 -1 -1 -1

output:
8*2/4+0=63+0
8*2/4+1=79+15
*/
	static long G,A,T,D,X,Y;
	static Scanner in;

	public static void main(String[] args) {
		in =new Scanner(System.in);
		while((G=in.nextLong())!=-1){
			T=in.nextLong();
			A=in.nextLong();
			D=in.nextLong();
			X=(G*factorial(T-1))+stage2Games((G*A)+D);
			if(Y!=0)
				Y=Y-(G*A)-D;//Y= Needed to be Added
			System.out.println(G+"*"+A+"/"+T+"+"+D+"="+X+"+"+Y);
		}
	}
	
	static long factorial(long n){
		for(int i=(int)(n-1);i>0;i--)
			n+=i;
		return n;
		/*RECURSIVE
		if(n!=0)
			return n+factorial(n-1);
		else 
			return 0;
		*/
	}
	
	static long stage2Games(long advanced){
		if(isPowerOf2(advanced))
			return advanced-1;
		else{
			//Y=Advanced + Default + Needed to Be added
			Y=(long)Math.pow(2, roundUP(Math.log(advanced)/Math.log(2)));
			return Y-1;
		}
	}

	/**a number 'n' is  power of 2 if the result of 
	 * bitwise operation of that (n & n-1) equals 0
	 * ej. 4 = 1 0 0.
	 *     3 = 0 1 1.
	 *     0 = 0 0 0.
	 * @param n = number to be checked;
	 * @return true if number n is power of 2;
	 * otherwise false;
	 */
	static boolean isPowerOf2(long n){
		return (n!=0 && ((n&(n-1))==0));
	}
	
	public static int roundUP(double m){
		if(m>(int)m)
			return (int)(m+1);
		return (int)m;
	}

}
