import java.util.Scanner;
import java.util.HashMap;
class portunol {

	static Scanner in;
	static HashMap<String,Integer> hm;
	static int S,P,s,p,i,j;
	static String pp,ss;
	static String[] Span, Port;
	
	public static void main(String[] args) {
		in=new Scanner(System.in);
		while((P=in.nextInt())!=0){
			S=in.nextInt();
			hm=new HashMap<String,Integer>();
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
							if(hm.get(pp+ss)==null)
								hm.put(pp+ss,1);
						}
					}
				}
			}
			System.out.println(hm.size());
		}
		System.exit(0);
	}

}
