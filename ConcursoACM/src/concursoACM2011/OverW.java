package concursoACM2011;
import java.util.*;
import java.math.*;
public class OverW {

	public static void main(String[] args) {
		String nombre="",r,output="",s,linea="";
		int edad,edadob=0;
		double w,h;
		OverW o=new OverW();
		System.out.println("Introducir datos AQUI:\n(0 termina)");
		Scanner lineas=new Scanner(System.in);

		while(true){try{
			linea=lineas.next();
			Scanner in=new Scanner(linea);
			in.useDelimiter("[,|\n]");
			if(linea.equals("0"))break;
			nombre=(in.next());
			w=Double.parseDouble(in.next());
			h=Double.parseDouble(in.next());
			edad=Integer.parseInt(in.next());
			s=in.next();
			r=o.olevel(w,h,edad,s);
			if((r).equals("Obese")||(r).equals("OverWeigth")){
				if(edadob!=edad){	edadob=edad;	output+=edadob+" Years Old\n";	}
				output=output+nombre+"\n"+o.redondear(o.BMI,2)+r+"\n";
				}
		}catch(NumberFormatException e){e.getStackTrace();}
		}System.out.println(output);
	}

	double BMI;
	public double redondear(double doble,int decimales){
		      BigDecimal big = new BigDecimal(doble+"");
		      big = big.setScale(decimales, RoundingMode.HALF_UP);
		      return Double.parseDouble(""+big);
	}

	public double redondear2(double doble,int digitos){
		      int cifras=(int) Math.pow(10,digitos);//numeros de decimales que qieres
		      return Math.rint(doble*cifras)/cifras;//aumentamos el doble a los decimales qe qeremos,
		      										//redondeamos y ya podemos regresarlo a decimal
	}

	public String olevel(double w,double h,int age,String sex){
		BMI=w/(h*h);
		if(sex.equalsIgnoreCase("f")){
			switch(age){
			case 10:if(BMI<=19.8) return "Normal";
					else if(BMI<=24) return "OverWeigth";
					else return "Obese";
			case 11:
				if(BMI<=20.6) return "Normal";
				else if(BMI<=25.3) return "OverWeigth";
				else return "Obese";
			case 12:
				if(BMI<=21.6) return "Normal";
				else if(BMI<=26.5) return "OverWeigth";
				else return "Obese";
			case 13:
				if(BMI<=22.5) return "Normal";
				else if(BMI<=27.7) return "OverWeigth";
				else return "Obese";
			case 14:
				if(BMI<=23.2) return "Normal";
				else if(BMI<=28.5) return "OverWeigth";
				else return "Obese";
			default: return"OutRange mujer";
			}
		}
		else{
			switch(age){
			case 10: if(BMI<=19.7) return "Normal";
					else if(BMI<=23.9) return "OverWeigth";
					else return "Obese";
			case 11:
				if(BMI<=20.5) return "Normal";
				else if(BMI<=25) return "OverWeigth";
				else return "Obese";
			case 12:
				if(BMI<=21.1) return "Normal";
				else if(BMI<=25.9) return "OverWeigth";
				else return "Obese";
			case 13:
				if(BMI<=21.8) return "Normal";
				else if(BMI<=26.7) return "OverWeigth";
				else return "Obese";
			case 14:
				if(BMI<=22.5) return "Normal";
				else if(BMI<=27.5) return "OverWeigth";
				else return "Obese";
				default: return "OutRange hombre";
			}
		}
	}
}
