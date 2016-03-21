import java.util.Scanner;

public class _2976__Magnificent_Meatballs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int ind, guests, sum, arr[], sumSam, sumElla, indS, indE;
		while((guests = in.nextInt())!= 0 ){
			arr = new int[guests];
			sum = ind = 0;

			//save the meatballs per guest
			while(ind < guests ){
				arr[ind] = in.nextInt();
				sum+= arr[ind++];
			}

			//if sum of meatballs are odd, there could no be an
			//equal partitioning.
			if (sum % 2 != 0){
				System.out.println("No equal partitioning.");
				continue;
			}

			ind = 2;
			indS = 0;
			indE = guests-1;
			sumSam = arr[indS++];
			sumElla = arr[indE--];
			while(ind < guests){
				if(sumElla >= sumSam){
					sumSam += arr[indS++];
					ind++;
				}

				if (sumSam > sumElla ){
					sumElla += arr[indE--];
					ind++;
				}
			}
			if(sumSam == sumElla){
				System.out.printf("Sam stops at position %d and Ella stops at position %d.%n", indS, indE+2);
			}
			else{
				System.out.println("No equal partitioning.");
			}
		}

	}

}
