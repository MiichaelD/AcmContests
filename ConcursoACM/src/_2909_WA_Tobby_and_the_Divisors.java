import java.util.Scanner;


public class _2909_WA_Tobby_and_the_Divisors {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt(), n, acum, r, min = 0;
		while (A-- > 0){
			n = in.nextInt();
			acum = 0;
			for(int i = n ; i > 1; i--){
				r = getFactors(i);
				if(r >= acum){
					acum = r;
					min = i;
				}
			}
			System.out.println(min);
		}

	}

	public static int getFactors(int number){
		int x = 2;
		int totalFactors = 1;
		while (x*x <= number) {
		    int power = 0;
		    while (number%x == 0 ) {
		        power++;
		        number /= x;
		    }
		    totalFactors *= (power + 1);
		    x++;
		}

		if (number != 1) {
		    totalFactors *= 2;
		}
		//System.out.println("The total number of factors is: " + totalFactors);
		return totalFactors;
	}
}
