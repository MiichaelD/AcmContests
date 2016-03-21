import java.util.Scanner;


public class _2979__Tobby_And_Sequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n;
		if(in.hasNext()){
			n = in.nextInt();
			//StringBuilder sb = new StringBuilder();
			String str = n+"";
			for(int i = 1; i < n ; i++){
				if( i % 2 != 0)
					str+=" "+ (i+1)/2;
				else
					str+=" "+ (n-i/2);
			}
			System.out.println(str);
		}

	}

}
