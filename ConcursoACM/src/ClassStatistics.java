import java.util.*;
/*
 * 28/Junio/12
 * 
 */
class ClassStatistics {

	static int k,classes,pupils,max,min,gap,currentMark,last;
	static Scanner entry=new Scanner (System.in);
	static ArrayList<Integer> marks;
	
	public static void main (String[] arg){
		classes=entry.nextInt(); 
		for(k=0;k<classes;k++){
			init();
			capture();
			sort();
			print();
		}
	}
	
	public static void init(){
		pupils=entry.nextInt();
		max=0;min=100;gap=0;currentMark=0;
		marks=new ArrayList<Integer>();
	}
	
	public static void capture(){
		for(int p=0;p<pupils;p++){
			marks.add((currentMark=entry.nextInt()));
			if((currentMark)>max)
				max=currentMark;
			if(currentMark<min)
				min=currentMark;
		}
	}
	
	public static void sort(){
		Collections.sort(marks);
		for(int p=1;p<pupils;p++){
			if((last=marks.get(p)-marks.get(p-1))>gap)
				gap=last;
		}
	}
	
	public static void print(){
		System.out.println("Class "+(k+1));
		System.out.println("Max "+max+", Min "+min+", Largest gap "+gap);
	}
}
/*
input:
2
5 30 25 76 23 78
6 25 50 70 99 70 90


output:
Class 1
Max 78, Min 23, Largest gap 46
Class 2
Max 99, Min 25, Largest gap 25

				
*/