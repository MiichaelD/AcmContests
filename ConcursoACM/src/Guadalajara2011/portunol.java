package Guadalajara2011;
import java.util.Scanner;
import java.util.HashSet;
class portunol {

	static Scanner in;
	static HashSet<String> hs;
	static int S,P,s,p,i,j;
	static String pp,ss,Span[], Port[];
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		while((P=in.nextInt())!=0){
			S=in.nextInt();
			hs=new HashSet<String>();
			Port=new String[P];
			Span=new String[S];
			for(i=0;i<P;i++){
				Port[i]=in.next();
			}
			for(j=0;j<S;j++){
				Span[j]=in.next();
			}
			for(p=0;p<P;p++){//recorrer palabras portugues
				for(i=1;i<=Port[p].length();i++){//recorrer letras portugues
					pp=Port[p].substring(0,i);
					for(s=0;s<S;s++){//rrecorrer palabras spanol
						for(j=1;j<=Span[s].length();j++){//recorrer letras espanol
							ss=Span[s].substring(Span[s].length()-j,Span[s].length());
							if(!hs.contains(pp+ss))
								hs.add(pp+ss);
						}
					}
				}
			}
			System.out.println(hs.size());
			
		}
		System.exit(0);
	}
}
/*
3 3
mais
grande
mundo
mas
grande
mundo
1 5
a
aaaaa
aaaaaa
aaaaaaa
a
aaaaaaaaa
1 1
abc
abc
0 0


 */

