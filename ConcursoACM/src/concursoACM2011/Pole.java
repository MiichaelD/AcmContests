package concursoACM2011;

import java.io.*;
import java.util.*;

public class Pole {

	public static void main(String[] args) throws FileNotFoundException {
		Pole p = new Pole();
		// p.OpenFile(new File("src/concursoACM2011/Pole.in"));
		p.OpenFile(new File("Pole.in"));
	}

	File file;
	Scanner in;
	int[] pole;
	int n, c, p, tmp;
	boolean ok;
	// arra1 = car number; arra2 positions gain/lost

	public void OpenFile(File f) throws FileNotFoundException {
		in = new Scanner(f);
		n = in.nextInt();
		while (n > 0) {
			pole = new int[n];
			ok = true;
			for (int i = 0; i < n; i++) {
				c = in.nextInt();
				p = in.nextInt();
				tmp = i + p;
				if (tmp >= 0 && tmp < n && pole[tmp] == 0)
					pole[tmp] = c;
				else
					ok = false;
			}
			if (ok) {
				System.out.print(pole[0]);
				for (int i = 1; i < n; i++)
					System.out.print(" " + pole[i]);
				System.out.println("");
			} else
				System.out.println("-1");
			n = in.nextInt();
		}
	}
}