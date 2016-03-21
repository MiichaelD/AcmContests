import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
public class buzz {
	
	//uso de hashtables, 
	Scanner entry=new Scanner(System.in);;
	String string,word,clean;
	public static void main(String[] args) {
		new buzz().start2();
/*
Michael Steve duarte,Peña
par"angari cuti rimic"uaro
this is! it? or not
what do you think?
of  course 12 23   i don't!?
do you!?""
coul'd you dome a favour, please?



Other mathematics NOT here!
AA




*/
	}
	//usando solo Scanner
	public void start(){
		boolean ending=false;
		entry.useDelimiter("[ ?!,.:\n\r;$%-+/'\"(){}]");
		System.out.println(entry.delimiter());
		string="";
		while(entry.hasNext())
			if(!(word=entry.next()).equals("")){
				string+=word;
				ending=false;
			}
			else {
				if(ending)
					break;
				ending=true;
			}
		System.out.println(string);
	}

	//scanner, string tokenizer, TODO TEXTO
	public void start1(){
		word="1";
		while(!word.equals(""))//capturamos
			string+=word=entry.nextLine();
		System.out.println("Caputrado:\n\""+string+"\"\n");
		StringTokenizer st=new StringTokenizer(string,"[0123456789 ?!,.:\n\r;$%-+/'\"(){}]");
		while (st.hasMoreTokens()){
			clean+=st.nextToken();
		}
		System.out.println("Preprocesado:\n\""+clean+"\"\n");
		wordCounting2(clean.toUpperCase());
	}
	
	//scanner, string tokenizer, Linea x Linea
	public void start2(){
			word="1";
			while(!(word=entry.nextLine()).equals("")){//capturamos
				StringTokenizer st=new StringTokenizer(word,"[0123456789 ?!,.:\n\r;$%-+/'\"(){}]");
				clean="";
				while (st.hasMoreTokens()){
					clean+=st.nextToken();
				}
				System.out.println("Preprocesado:\n\""+clean.toUpperCase()+"\"");
				wordCounting(clean.toUpperCase());
			}
		}
	
	//array y sorting
	public void wordCounting(String txt){
		int lon=txt.length();
		HashMap<String,Integer> mapa;
		Integer freq;
		String sub;
		Object[] array;
		try {
			DataOutputStream salida=new DataOutputStream(new FileOutputStream(new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"salida.txt"),false));
			for (int letters=1;letters<lon;letters++){//cuantas letras a la vez se tomaran
				mapa=new HashMap<String,Integer>();
				for(int i=0;i<=lon-letters;i++){//fraccionar la palabra
					sub=txt.substring(i,i+letters);
					freq=(Integer)mapa.get(sub);
					mapa.put(sub,freq==null? 1: (new Integer(freq.intValue()+1)));
					salida.writeBytes(sub+" ");
				}
				salida.writeBytes("\n");
				array=(mapa.values().toArray());
				Arrays.sort(array,Collections.reverseOrder());
				if(((Integer) array[0]).intValue()==1){
					System.out.println();
					break;
				}
				System.out.println(letters+" "+array[0]);
				
			
			}
		} catch (Exception e) {e.printStackTrace();}
	}

	//comparando cada valor
	public void wordCounting2(String txt){
		int lon=txt.length();
		HashMap<String,Integer> mapa;
		Integer freq,mayor;
		String sub;
		try {
			for (int letters=1;letters<lon;letters++){//cuantas letras a la vez se tomaran
				mapa=new HashMap<String,Integer>();
				mayor=1;
				for(int i=0;i<=lon-letters;i++){//fraccionar la palabra
					sub=txt.substring(i,i+letters);//subPalabra
					freq=(Integer)mapa.get(sub);//checa si ya existe en el mapa, si es asi, checa su valor enlazado
					if(freq==null)
						mapa.put(sub, 1);//si no existe lo agrega
					else{
						if(freq==mayor)
							mayor++;
						mapa.put(sub,freq+1);//si ya existia le aumenta el valor enlazado +1
					}			
				}
				
				if(mayor==1){
					System.out.println();
					break;
				}
				System.out.println(letters+" "+mayor);
			}
		} catch (Exception e) {e.printStackTrace();}
	}
	
}