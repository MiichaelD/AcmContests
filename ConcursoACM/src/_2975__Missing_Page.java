import java.util.Scanner;

public class _2975__Missing_Page {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int pages, missing, aux, sheet, sheets;

		while((pages = in.nextInt()) != 0){
			missing = in.nextInt();
			aux = pages /2;
			sheets = pages / 4;
			if(missing > aux ){
				sheet = sheets + 1 - (missing - aux + 1) / 2;
				//System.out.printf("Paginas: %d, faltante: %d en la hoja: %d de %d hojas.%n",pages, missing, sheet,sheets);
				//'aux' now storing first pair of pages from same sheet
				aux = sheet * 2 - 1;
				System.out.printf("%d %d %d%n",aux, aux+1,missing+ (missing % 2 == 0?-1:1) );
			}
			else{
				sheet = (missing+1)/2;
				//System.out.printf("Paginas: %d, faltante: %d en la hoja: %d de %d hojas.%n",pages, missing, sheet,sheets);
				//'aux' now storing last pair of pages from same sheet
				aux = pages-((sheet-1)*2);
				System.out.printf("%d %d %d%n", missing+ (missing % 2 == 0?-1:1), aux-1, aux);
			}
		}
	}

}
