import java.util.Arrays;
import java.util.Scanner;
public class _2970_TLE_Humbertovs_flag {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int points;
		_2970_Points[] arr;
		while( in.hasNext()){
			points=in.nextInt();
			arr = new _2970_Points[points];
			for(int i =0;i<points; i++){
				arr[i] = new _2970_Points();
				arr[i].x = in.nextInt();
				arr[i].y = in.nextInt();
				arr[i].slope = Math.atan2(arr[i].x,arr[i].y);
			}
			Arrays.sort(arr);
			System.out.println(points);
			for(int i =0;i<points; i++){
				System.out.println(arr[i].x+" "+ arr[i].y);//+" "+arr[i].slope);
			}
		}
	}
}

class _2970_Points implements Comparable{
	int x, y;
	double slope;

	public int compareTo(Object o) {
		return slope > ((_2970_Points)o).slope? 1 : -1;
	}

}