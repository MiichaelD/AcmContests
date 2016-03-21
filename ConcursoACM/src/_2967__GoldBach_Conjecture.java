
import java.util.HashSet;
import java.util.Scanner;
public class _2967__GoldBach_Conjecture {


	static int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
		31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
		73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
		127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
		179, 181, 191, 193, 197, 199, 211, 223, 227, 229,
		233, 239, 241, 251, 257, 263, 269, 271, 277, 281,
		283, 293, 307, 311, 313, 317, 331, 337, 347, 349,
		353, 359, 367, 373, 379, 383, 389, 397};

	static HashSet<Integer> hs = new HashSet<Integer>();

	public static void main(String[] args) {

		for (int i = 0; i< primes.length; i++){
			hs.add(primes[i]);
		}

		Scanner in = new Scanner(System.in);
		int lines = in.nextInt();

		while(lines-- > 0){
			System.out.println(possibleSums(in.nextInt()));
		}
	}

	static int possibleSums(int in){
		int i = 0, res = 0, min = in;
		while(min > primes[i]){
			min = in - primes[i];
			//System.out.printf("Number %d: %d + %d  - ",in,primes[i],min);
			if( hs.contains(min)){
				res++;
				//System.out.println("Accepted");
			}
			/*
			else
				System.out.println("DENIED");
			*/
			i++;
		}
		return res;
	}

}
