package Guadalajara2011;
//import java.io.Console;
import java.util.HashSet;
class portunolConsola {

	static HashSet<String> hm;
	static int S,P,s,p,i,j,index;
	static String pp,ss,linea,Span[], Port[];

	public static void main(String[] args) {
	//	 Console in= System.console();
	//	 if(in==null)
			System.exit(1);
		do{
	//		linea=in.readLine();
			index=linea.indexOf(' ');
			P=Integer.parseInt(linea.substring(0,index));
			if(P==0)
				break;
			S=Integer.parseInt(linea.substring((index+1),linea.length()));
			hm=new HashSet<String>();
			Port=new String[P];
			Span=new String[S];
			for(i=0;i<P;i++){
	//			Port[i]=in.readLine();
			}
			for(j=0;j<S;j++){
	//			Span[j]=in.readLine();
			}
			for(p=0;p<P;p++){//recorrer palabras portugues
				for(i=1;i<=Port[p].length();i++){//recorrer letras portugues
					pp=Port[p].substring(0,i);
					for(s=0;s<S;s++){//rrecorrer palabras spanol
						for(j=1;j<=Span[s].length();j++){//recorrer letras espanol
							ss=Span[s].substring(Span[s].length()-j,Span[s].length());
							if(!hm.contains(pp+ss))
								hm.add(pp+ss);
						}
					}
				}
			}
			System.out.println(hm.size());
		}while(true);
		System.exit(0);
	}

}
