// concusro ACM escuela abril 2013
import java.util.Hashtable;
import java.util.Scanner;


class BigList {

	/**
	 *
3 3
2+4+1 7
0+9+1 10
7+2+6 15
7+2+8
2+4+1 10
7+2+6 15
	 * @param args
	 */

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String ans=null, arr[];


		Hashtable<String,String> list=new Hashtable<String,String>();
		int N=in.nextInt(), M=in.nextInt();
		for(int i =0;i<N;i++){
			list.put(in.next(), in.next());
		}
		ans=in.nextLine();
		for(int i =0;i<M;i++){
			ans=in.nextLine();

			if(ans.indexOf(' ') == -1){
				//no space, not found
				System.out.println("not found");
				continue;
				/*
				if((lg=list.get(ans)) == null){
					System.out.println("not found");
					continue;
				}
				*/

			}
			arr=ans.split(" ");
			if(list.get(arr[0]).equals(arr[1])){
				System.out.println("ok");
			}
			else
				System.out.println("wrong");
		}

	}

}
