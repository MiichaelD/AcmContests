import java.util.HashMap;
import java.util.Scanner;

public class _2952_TLE_Tobby_and_tanks {

	static Scanner in;
	public static void main(String[] args) {
		sol2();
	}

	static void sol0(){
		in = new Scanner(System.in);
		int bckts, queries, buckets[], q, i;
		while(in.hasNext()){
			bckts = in.nextInt();
			queries = in.nextInt();
			buckets= new int[bckts];

			buckets[0] = 1;
			in.nextInt();

			for(i = 1 ; i < bckts; i++)
				buckets[i] = buckets[i-1]+in.nextInt();


			for(int j = 0 ; j < queries; j++){
				q = in.nextInt();
				for( i = 1 ; i < bckts && q - buckets[i] > 0 ; i++);
				System.out.print(j > 0? " "+i : ""+i );
			}
			System.out.println();
		}
	}

	static void sol1(){
		in = new Scanner(System.in);
		int bckts, queries, buckets[], sum, q, i;
		HashMap<Integer,Integer> tanks;
		while(in.hasNext()){
			bckts = in.nextInt();
			queries = in.nextInt();
			tanks = new HashMap<Integer,Integer>(bckts);

			in.nextInt();
			sum = 1;
			tanks.put(sum,0);
			for(i = 1 ; i < bckts; i++){
				sum += in.nextInt();
				tanks.put(sum, i);
			}


			for(int j = 0 ; j < queries; j++){
				q = in.nextInt();
				for( i = q; i > 1; i--){
					if(tanks.get(i) != null){
						i = tanks.get(i)+1;
						break;
					}
				}
				System.out.print(j > 0? " "+i : ""+i );
			}
			System.out.println();
		}
	}

	static void sol2(){
		in = new Scanner(System.in);

		int bckts, queries, sum, tank, m, q, i, aux;
		HashMap<Integer,Integer> tanks;
		while(in.hasNext()){
			bckts = in.nextInt();
			queries = in.nextInt();
			tanks = new HashMap<Integer,Integer>(bckts);

			in.nextInt();
			sum = 1;
			aux = 0;
			for(i = 1 ; i < bckts; i++){
				tank = in.nextInt();
				m = sum;
				sum += tank;
				for(; m < sum; m++)
					tanks.put(m, i);
			}

			q = in.nextInt();

			for(int j = 0 ; j < queries; j++){
				q = in.nextInt();
				if( q >= sum)
					System.out.print(j > 0? " "+bckts : ""+bckts );
				else
					System.out.print(j > 0? " "+tanks.get(q) : ""+tanks.get(q) );
			}
			System.out.println();
		}
	}
}
