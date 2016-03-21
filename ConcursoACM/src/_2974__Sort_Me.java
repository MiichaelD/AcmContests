import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _2974__Sort_Me {

	static String order = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int wrds, cases=0;
		String words[];
		while( (wrds=in.nextInt()) != 0 ){
			//Capture
			order = in.next();
			words = new String[wrds];
			for(int i=0; i<wrds; i++){
				words[i]=in.next();
			}

			//sort
			Arrays.sort(words, new Comparator<String>(){
				public int compare(String o1, String o2) {
					int pos1, pos2, len1 = o1.length(), len2 = o2.length(),
						length = len1 < len2? len1 : len2;
					for(int i = 0 ; i < length; i ++){
						pos1 = order.indexOf(o1.charAt(i));
						pos2 = order.indexOf(o2.charAt(i));
						if(pos1 != pos2){
							return pos1-pos2;
						}
					}

					if (len1 == len2)
						return 0;
					else
						return len1 < len2? -1: 1;
				}
			});

			//print
			System.out.println("year "+ ++cases);
			for(int i = 0 ; i < wrds; i ++){
				System.out.println(words[i]);
			}
		}
	}
}
