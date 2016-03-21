import java.util.Arrays;
import java.util.Scanner;

//WRONG ANSWER
//http://coj.uci.cu/contest/cproblem.xhtml?cid=1365&abb=2968

public class _2968_WA_Tobby_And_The_River {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k, sum, mid, arr[], index, tries;
		String NO = "Tobby no puede cruzar", YES = "Tobby puede cruzar";
		arr = new int[6];
		k = in.nextInt();
		while(k-- > 0){
			sum = 0;
			for(int i = 0 ; i < 6 ; i ++){
				arr[i] = in.nextInt();
				sum += arr[i];
			}
			if( sum % 2 != 0){
				System.out.println(NO);
			}
			else{
				//debemos encontrar la permutación de perros necesarios
				//que su suma de pesos nos den la mitad del total.
				mid = sum / 2;
				Arrays.sort(arr);
				tries = 0;
				do{
					index = 5 - tries;
					sum = 0;
					while( index >= 0 && sum < mid){
						if( mid - sum >=  arr[index]){
							sum += arr[index];
						}
						index --;
					}
					if(sum == mid){
						System.out.println(YES);
						break;
					}
					tries++;
				}while( tries < 6);
				if(tries == 6)
					System.out.println(NO);
			}
		}
	}

}
