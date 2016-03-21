import java.math.BigInteger;
import java.util.Scanner;
public class _2928__Red_Matematica_1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String c;
		int i, digs, length, acum;
		BigInteger bi;
		while (true){
			c = in.next();
			digs = in.nextInt();
			if ( c.equals("0") && digs == 0)
				return;
			acum = 0;
			StringBuilder buffer = new StringBuilder(c);
			for (i = 1; i < digs; i++) {
			    buffer.append(c);
			}
			bi = new BigInteger(buffer.toString());
			c = bi.pow(2).toString();
			length = c.length();
			for(i=0;i<length;i++)
				acum += c.charAt(i)-'0';
			System.out.println(acum);
		}

	}

}
