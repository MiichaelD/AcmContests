package concursoACM2010;
import javax.swing.*;
public class NumbersWithoutE {

	int 	position=0,Ecount=0,i;

	public static void main(String[] args) {
		NumbersWithoutE ob=new NumbersWithoutE();
		ob.loop();


	}

	public void show(){
		JOptionPane.showMessageDialog(null,"the "+position+" number Without E is: \""+(i-1)+"\"");
		}

	public void loop(){
		do{try{
			position=Integer.parseInt(JOptionPane.showInputDialog("Insert Desired Position:\nOr \"0\" to Exit"));
			if(position!=0){
				Ecount=0;
				for(i=1;Ecount<position;i++){
					if(i<31)to30();
					if(i>30&&i<2001)to2000();
					if(i>2000&&i<4001)to4000();
					if(i>4000&&i<6001)to6000();

					if(i>6000&&i<30001)to30000();

					if(i>30000&&i<32001)to32000();
					if(i>32000&&i<34001)to34000();
					if(i>34000&&i<36001)to36000();
					if(i>36000&&i<40001)to40000();
					if(i>40000&&i<42001)to42000();
					if(i>42000&&i<44001)to44000();
					if(i>44000&&i<46001)to46000();
					if(i>46000&&i<50001)to50000();
					if(i>50000&&i<52001)to52000();
					if(i>52000&&i<54001)to54000();
					if(i>54000&&i<56001)to56000();
					if(i>56000&&i<60001)to60000();
					if(i>60000&&i<62001)to62000();
					if(i>62000&&i<64001)to64000();
					if(i>64000&&i<66001)to66000();

				}
				show();}

			}catch(Exception E){}
			}while(position!=0);
	}

	public void to30(){
			if (i==2||i==4||i==6||i==30)
			{Ecount++; }
			System.out.println(Ecount+"		"+(i));
	}

	public void to2000(){
		if (i==30||i==40|i==50||i==60||i==2000){Ecount++; System.out.println(Ecount+"		"+(i));}
		else {
			if (i>30&&i<40) {i-=30;  to30(); i+=30;}
			if (i>40&&i<50) {i-=40;  to30(); i+=40;}
			if (i>50&&i<60) {i-=50;  to30(); i+=50;}
			if (i>60&&i<70) {i-=60;  to30(); i+=60;}}
	}

	public void to4000(){
		i-=2000;
		if (i<31){to30();}		else {to2000();}
		i+=2000;	}

	public void to6000(){
		i-=2000;	to4000();	i+=2000;}

	public void to30000(){
		if(i<7000){i-=2000; to6000(); i+=2000;}//79
		if(i==30000){i-=24000; to6000(); i+=24000; }}


	public void to32000(){
		i-=2000; to30000(); i+=2000;	}

	public void to34000(){
		i-=2000; to32000(); i+=2000;	}

	public void to36000(){
		i-=2000; to34000(); i+=2000;	}

	public void to40000(){
		i-=4000; to36000(); i+=4000;	}

	public void to42000(){
		i-=2000; to40000(); i+=2000;	}

	public void to44000(){
		i-=2000; to42000(); i+=2000;	}

	public void to46000(){
		i-=2000; to44000(); i+=2000;	}

	public void to50000(){
		i-=4000; to46000(); i+=4000;	}

	public void to52000(){
		i-=2000; to50000(); i+=2000;	}

	public void to54000(){
		i-=2000; to42000(); i+=2000;	}

	public void to56000(){
		i-=2000; to54000(); i+=2000;	}

	public void to60000(){
		i-=4000; to56000(); i+=4000;	}

	public void to62000(){
		i-=2000; to60000(); i+=2000;	}

	public void to64000(){
		i-=2000; to62000(); i+=2000;	}

	public void to66000(){
		i-=2000; to64000(); i+=2000;	}



}
