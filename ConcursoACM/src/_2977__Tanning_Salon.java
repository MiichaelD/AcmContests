import java.util.HashSet;
import java.util.Scanner;
public class _2977__Tanning_Salon {

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int beds, length, unattendedCustomers;
		String sequence = null;
		char chr;
		HashSet<Character> Tanning, Waiting;
		while((beds = in.nextInt())!= 0){
			sequence = in.next();
			Tanning = new HashSet<Character>();
			Waiting = new HashSet<Character>();
			length = sequence.length();
			unattendedCustomers = 0;
			for(int ind = 0 ; ind < length ; ind++){
				chr =sequence.charAt(ind);

				//if the person was already tanning he leaves happy
				if(Tanning.contains(chr)){
					Tanning.remove(chr);
					// we get a bed available
					if(Waiting.isEmpty())
						beds++;
					// or assing the next customer in line to the bed available
					else{
						char c = Waiting.iterator().next();
						Tanning.add(c);
						Waiting.remove(c);
					}
					continue;
				}

				//if the person was already waiting, he leaves unattended
				if(Waiting.contains(chr)){
					unattendedCustomers++;
					Waiting.remove(chr);
					continue;
				}

				//if there is space available assing the customer to a bed
				if(beds > 0 ){
					beds--;
					Tanning.add(chr);
				}

				//if no space available put him in the Waiting list
				else{
					Waiting.add(chr);
				}
			}
			if(unattendedCustomers == 0 )
				System.out.println("All customers tanned successfully.");
			else
				System.out.println(unattendedCustomers+" customer(s) walked away.");

		}
	}
}
