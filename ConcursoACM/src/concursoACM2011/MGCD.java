package concursoACM2011;
import javax.swing.JOptionPane;

public class MGCD {

	public static void main(String[] args) {
		MGCD p=new MGCD();
		p.OpenFile();
	}
	int[] arra1;

	
	public void OpenFile(){try{
		String lines="",test="";
		lines=JOptionPane.showInputDialog("ingrese Numero de casos" );
				for(int cases=0;cases<Integer.parseInt(lines);cases++){
					test=JOptionPane.showInputDialog("ingrese los numeros\nseparados por espacios");
					for(int y=0;y<test.length()-1;y++){//Letter Number
						if(test.substring(0+y,1+y).equals(" ")){
							arra1[0]=Integer.parseInt(test.substring(0,y));
							arra1[1]=Integer.parseInt(test.substring(y+1,test.length()));
							arra1[2]=
							arra1[3];

						}
					}

			}
	}catch(Exception e){System.out.println(e);}
	}

}
