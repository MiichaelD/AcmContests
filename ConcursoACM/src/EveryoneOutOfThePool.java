import java.util.Scanner;
class EveryoneOutOfThePool {
//http://sistemas.uniandes.edu.co/~maraton/mua/lib/exe/fetch.php?media=problemas:2012:entrenamiento3.pdf
	//5783 - http://livearchive.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&category=&problem=3794
	public static void main(String[] args) {
		long a,b,cases=0;
		Scanner in=new Scanner(System.in);
		while((a=in.nextLong())!=0){
			b=in.nextLong();
			cases++;		
			System.out.println("Case "+cases+": "+check2(a,b));
		}		
	}
	
	public static long check(long a,long b){
		double sqrt;
		long cont=0;
		for(;++a<b;)
			//System.out.println("X: "+a+"\tX-1:"+(a-1));			
			if((sqrt=Math.sqrt(a))==(long)sqrt)
				if((a-1)%3==0)
					cont++;	
		return cont;
	}

	public static long check2(long a,long b){
		double sqrt;
		long cont=0;
		b--;
		for(;a<b;++a)
			//System.out.println("X: "+a+"\tX+1:"+(a+1));
			if((a)%3==0)
				if((sqrt=Math.sqrt(a+1))==(long)sqrt)
					cont++;	
		return cont;
	}
	
}
/*input:
15 17
14 16
1 20
0 0


output:
Case 1: 1
Case 2: 0
Case 3: 2
*/