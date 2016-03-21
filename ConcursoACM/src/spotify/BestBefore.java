package spotify;
import java.util.*;
public class BestBefore {

	public static void main(String[] args) {
		BestBefore bb=new BestBefore();
		//javax.swing.JOptionPane.showMessageDialog(null,"Es Bisiesto?\n"+bb.isLeap(Integer.parseInt(javax.swing.JOptionPane.showInputDialog("Año:"))));
		bb.test();
	}

	String year,month,day,original,temp;
	int[] vec;
	int minor12,minorDay;
	boolean error,has0;
	Scanner s;

	BestBefore(){
		s=new Scanner(System.in);
		s.useDelimiter("[/\n\r]");
		minor12=0;
		error=has0=false;
		year=month=day="";
		vec=new int[3];
	}


	public void test(){
		{
			for(int i=0;i<3;i++){
				try{
				temp=s.next();
				vec[i]=Integer.parseInt(temp);
				if(vec[i]==0){
					has0=true;}
				else if(vec[i]<=12)
					minor12++;
				}catch(Exception e){return;}
			}

			original=vec[0]+"/"+vec[1]+"/"+vec[2];
			Arrays.sort(vec);
			if(has0){vec[0]=vec[1];vec[1]=vec[2];vec[2]=2000;}

			if(minor12==0) error=true;

			else if(minor12==3){year=""+vec[0];month=""+vec[1];day=""+vec[2];}

			else if(minor12==2){
				if((minorDay=minorThan(31,12))==0){year=""+vec[2]; month=""+vec[0]; day=""+vec[1];}
				else {System.out.println("tiene 2 posibles meses y numero mayor a 30");
						year=""+vec[0]; month=""+vec[1]; day=""+vec[2];}
			}

			else if(minor12==1){
				if(vec[0]==1||vec[0]==3||vec[0]==5||vec[0]==7||vec[0]==8||vec[0]==10||vec[0]==12){
					if((minorDay=minorThan(31,12))==0){error=true;}
				}else if(vec[0]==2){
					if(isLeap()){
						if((minorDay=minorThan(29,12))==0){error=true; }
					}else if((minorDay=minorThan(28,12))==0) {error=true; }
				}else if((minorDay=minorThan(30,12))==0){error=true; }


				if(!error)
					if(minorDay==1){ year=""+vec[2]; month=""+vec[0]; day=""+vec[1];}
					else if(minorDay==2){ year=""+vec[1]; month=""+vec[0]; day=""+vec[2];}
			}

			if(error){System.out.println(original+" is illegal");}
			else printing();
		}
	}

	public boolean isLeap(){
		if(vec[1]==29)
			if(vec[2]<1000)return isLeap(2000+vec[2]);
			else return isLeap(vec[2]);

		else if(vec[2]==29)
			if(vec[1]<1000)return isLeap(2000+vec[1]);
			else return isLeap(vec[1]);
		return false;
	}

	public boolean isLeap(int year){
		if(year%4==0&&(year%100!=0||year%400==0)){
			return true;}
		return false;
	}

	public int minorThan(int top,int bottom){
		int n=0;
		for(int i=0;i<3;i++)
			if(bottom<vec[i]&&vec[i]<=top)
				n++;
		return n;
	}

	public void printing(){
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

		System.out.println(year+"-"+month+"-"+day);

	}

}
