package spotify;
//me falta arreglar el WHILE
import java.util.*;
public class BestBefore2 {
/*
 * Problem ID: bestbefore
 *
Just about any product found in a grocery store has a "best before" date printed on it.
Unfortunately, the format for these dates can vary quite a bit: what is it supposed to
mean that the bread you bought yesterday is "best before 12/11/10"? It could mean that
the bread expires on November 10, 2012 (now that's a suspiciously durable bread and
probably it is not healthy for you for other reasons!), or it could mean that the bread
expired on December 11, 2010 (d'oh!), or a variety of other options. To be safe, the truly
paranoid (or healthily skeptic, depending on who you ask) person would assume that it means
"best before November 12, 2010", since that is the earliest possible date. On the other hand,
seeing "31/5/2012" even the truly paranoid person knows that this must mean May 31, 2012 since
that is the only possible real date using these three numbers.
Given a possibly ambiguous date "A/B/C", where A,B,C are integers between 0 and 2999, output
the earliest possible legal date between Jan 1, 2000 and Dec 31, 2999 (inclusive) using them as day,
month and year (but not necessarily in that order).

Recall that a year is a leap year (has 366 days) if the year is divisible by 4, unless it is
divisible also by 100 but not by 400 (so 2000 is a leap year, 2100 is not a leap year, and 2012
is a leap year).

Input

The input file consists of a single line containing three integers separated by "/".
There are no extra spaces around the "/". Years may be truncated to two digits and may
in that case also omit the leading 0 (if there is one), so 2000 could be given as "2000",
"00" or "0" (but not as an empty string). Months and days may be zero-padded. You may assume that the year,
when given with four digits, is between 2000 and 2999. At most one of the integers has four digits, and the
others have one or two digits.
Output

Output a single line giving the earliest legal date possible given the above constraints. The output
should be formatted as year-month-day, where year has four digits, and month and day have two digits
each (zero padding), for example "2011-07-15". If there is no legal date (subject to the above constraints)
then output a single line with the original string followed by the words "is illegal".

Sample input 1
02/4/67
31/9/73
29/02/16

Sample output 1
2067-02-04
31/9/73 is illegal
2016-02-29
 */

	public static void main(String[] args) {
		BestBefore2 bb=new BestBefore2();
		//JOptionPane.showMessageDialog(null,"Es Bisiesto?\n"+bb.isLeap(Integer.parseInt(JOptionPane.showInputDialog("Año:"))));
		bb.test();
	}

	String year,month,day,first,temp;
	int[] vec;
	int minor12,minorDay;
	boolean error,has0;

	public void test(){
		Scanner s=new Scanner(System.in);
		s.useDelimiter("[/\n\r]");
		//while(s.hasNext())
		{
			minor12=0;
			error=false;
			has0=false;
			year=month=day="";
			vec=new int[3];
			first="";

			for(int i=0;i<3;i++){
				temp=s.next();
				vec[i]=Integer.parseInt(temp);

				//remaking ENTRY
				if(i!=2)
					first+=vec[i]+"/";
				else
					first+=vec[i];

				//Validations
				if(vec[i]==0)			vec[i]=2000;
				else if(vec[i]<=12){	minor12++;}
			}
			//if(s.hasNext())s.next();

			Arrays.sort(vec);//sorting ascending the array

			switch(minor12){
			//debe haber almenos 1 numero menor a 12;
			case 0:	error=true;
					break;
			// si nomas hay numero menor a 12, debe aber uno menor a 31
			case 1:

					switch(vec[0]){
						case 1: 	case 3: 	case 5: 		case 7:
						case 8:		case 10:	case 12:

							if((minorDay=minorThan(31,12))==0){error=true;}
							break;

						case 2://si es febrero

							if(isLeap()){//es año bisiesto?
									if((minorDay=minorThan(29,12))==0){//debe haber numero menor a 29
										error=true; }
								}else if((minorDay=minorThan(28,12))==0) {//sino es bisiesto debe haber menor a 28
									error=true; }
								break;

						default://cualquier otro caso
								if((minorDay=minorThan(30,12))==0){
									error=true; }
								break;
					}
					if(!error)
						if(minorDay==1){
							year=""+vec[2]; month=""+vec[0]; day=""+vec[1];}
						else if(minorDay==2){
							year=""+vec[1]; month=""+vec[0]; day=""+vec[2];}
					break;

			// hay 2 dias menores a 12, el tercero puede ser lo qe sea
			case 2:
					if((minorDay=minorThan(31,12))==0){
						year=""+vec[2]; month=""+vec[0]; day=""+vec[1];}
					else {
						year=""+vec[0]; month=""+vec[1]; day=""+vec[2];}
					break;

			//los asignamos a año/mes/dia menor a mayor
			case 3: year=""+vec[0];month=""+vec[1];day=""+vec[2];
					break;

			}
			if(error){
				System.out.println(first+" is illegal");
			}else
				printing(year,month,day);
		}
	}

	public boolean isLeap(){
		if(vec[1]==29) // si tiene 29 dias tiene qe tener año bisiesto
			if(vec[2]<1000)return isLeap(2000+vec[2]);
			else return isLeap(vec[2]);

		else if(vec[2]==29) // si tiene 29 dias tiene qe tener año bisiesto
			if(vec[1]<1000)return isLeap(2000+vec[1]);
			else return isLeap(vec[1]);
		return false;
	}

	public boolean isLeap(int year){
		if(year%4==0&&(year%100!=0||year%400==0)){
			return true;}
		return false;
	}

	public int minorThan(int top,int untop){
		int n=0;
		for(int i=0;i<3;i++)
			if(untop<vec[i]&&vec[i]<=top)
				n++;
		return n;
	}

	public void printing(String year,String month,String day){
		if(year.length()==2)
			year="20"+year;
		else if(year.length()==3)
			year="2"+year;
		else if(year.length()==1)
			year="200"+year;

		if(month.length()==1)
			month="0"+month;

		if(day.length()==1)
			day="0"+day;

		System.out.printf("%s-%s-%s",year,month,day);

	}

}
