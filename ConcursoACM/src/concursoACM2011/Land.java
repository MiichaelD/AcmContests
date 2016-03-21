package concursoACM2011;
import javax.swing.JOptionPane;
import java.util.*;

public class Land {
	public static void main(String[] args) {
		Land p=new Land();p.OpenFile();
	}
	Integer[] arra1;	
	long contador;		
	int i;
	String lines="",test="";			
	LinkedList<Integer> precios=new LinkedList<Integer>();

	public void OpenFile(){
		try{
			lines=JOptionPane.showInputDialog("ingrese Numero de casos" );
			for(int cases=0;cases<Integer.parseInt(lines);cases++){
				i=0;
				test="";
				precios.clear();
				while(!test.equals("0")){
					test=JOptionPane.showInputDialog("ingrese presio: "+(1+i));
					if(!test.equals("0"))precios.add(Integer.parseInt(test));
					i++;
				}
				contador=0;
				arra1=precios.toArray(new Integer[0]);
				Arrays.sort(arra1);
				for(int y=arra1.length-1;y>=0;y--){
					contador+=(2*(long)Math.pow(arra1[y],(arra1.length-y)));
					System.out.println("2 x	"+arra1[y]+"	a la 	"+(arra1.length-y)+"	=	" +contador);
				}
				if(contador<5000000)System.out.println("Resultado: "+contador);
				else System.out.println("Too Expensive");

			}
		}catch(Exception e){System.out.println(e);}
	}
}
