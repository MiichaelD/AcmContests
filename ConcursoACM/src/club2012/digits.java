package club2012;
import java.util.*;
class digits {
	public static void main(String[] args) {
		/*
1 9
12 321
5987 6123
12345678 12345679
0 0
		*/
		long[] array;
		Scanner entry=new Scanner(System.in);
		long n1,n2;
		do{
			array=new long[10];
			n1=entry.nextLong();n2=entry.nextLong();
			if(n1==0&&n2==0) break;
			for(long i=n1;i<=(n2);i++){
				String str=Long.toString(i);
				for(int j=0;j<str.length();j++){
					++array[str.charAt(j)-'0'];
				}
			}
			for(int i=0;i<10;i++){
				//System.out.print(array[i]+" ");
				System.out.printf("%d ",array[i]);
			}//System.out.println();
			System.out.printf("\n");
		}while(true);
	}

}
