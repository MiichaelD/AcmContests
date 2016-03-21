import java.text.DecimalFormat;
import java.util.Scanner;
class Format {
	//http://sistemas.uniandes.edu.co/~maraton/mua/lib/exe/fetch.php?media=problemas:2012:entrenamiento1.pdf
	static int cases,count,cifras=(int) Math.pow(10,2);//numeros de decimales que qieres;
	static String line;
	static String[] array;
	static double media;
	static Scanner entry=new Scanner(System.in);
	//regular Expresion for Space: "\\s" or "[ ]"

	public static void main(String[] args){
		Format1();
	}

	public static void Format1(){
		/*input:
4
### ### ##
##
####


	 */
		for(int i=0,cases=Integer.parseInt(entry.nextLine());i<cases;i++)
			if((line=entry.nextLine()).equals(""))
				System.out.println("0 0 0.00");
			else{
				array=line.split("\\s");
				count=1+line.length()-array.length;
				media=(double)count/array.length;
				System.out.println(array.length+" "+count+" "+round(media));
			}
	}


	public static void Format2(){
/*
4
###
###
##
*
##
*
####
*
*



 */
		int lines;
		for(int i=0,cases=entry.nextInt();i<cases;i++){
			count=lines=0;
			while(!(line=entry.next()).equals("*")){
				count+=line.length();
				lines++;
			}
			if(lines==0)
				System.out.println("0 0 0.00");
			else{
				media=(double)count/lines;
				System.out.println(lines+" "+count+" "+round(media));
			}
		}
	}

	public static void Format3(){
		/*
		input:
### ### ##
##
####

0

		*/
		while(entry.hasNextLine()){
			if((line=entry.nextLine()).equals(""))
				System.out.println("0 0 0.00");
			else
		    try{
		    	if(line.contains("0"))
		    		break;
		    	array=line.split(" ");
				count=1+line.length()-array.length;
				media=(double)count/array.length;
				System.out.println(array.length+" "+count+" "+round2(media));
		    }catch(NumberFormatException e){}
		}
	}

	public static String round(double m){
		if(m-(int)m==0)
			return m+"0";
		else {
		      return ""+Math.rint(m*cifras)/cifras;
		}
	}

	static DecimalFormat dec = new DecimalFormat("#.##");
	public static String round2(double m){
		if(m-(int)m==0)
			return m+"0";
		else {
			return dec.format(m);

		}
	}

}/*
input:


output:
3 8 2.67
1 2 2.00
1 4 4.00
0 0 0.00




*/
