import java.util.ArrayList;
import java.util.Scanner;


public class _2932__Tobby_and_Primoshkas_tree {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		_2932_primoNodo[] arr;
		int N, Q;
		while(in.hasNext()){
			N = in.nextInt();
			Q = in.nextInt();
			arr = new _2932_primoNodo[N];
			for(int i = 0; i < N; i++){
				arr[i] = new _2932_primoNodo();
			}
			N--;
			for(int i = 0; i < N; i++){
				arr[in.nextInt()].addNode(arr[in.nextInt()]);
			}
			for(int i = 0; i < Q; i++){
				if(in.nextInt() == 0){//toggle
					arr[in.nextInt()].toggle_Recursively();
				}
				else{//getPrimoshkas
					System.out.println(arr[in.nextInt()].getPrimoshkas_Recursively());
				}
			}

		}

	}

}

class _2932_primoNodo{

	private int mPrimoshkas;
	public int ID;
	public ArrayList<_2932_primoNodo> nodos;

	_2932_primoNodo(){
		nodos = new ArrayList<_2932_primoNodo>();
	}

	public void toggle(){
		mPrimoshkas = mPrimoshkas == 1? 0: 1;
	}

	public void toggle_Recursively(){
		for(_2932_primoNodo nodo:nodos){
			nodo.toggle_Recursively();
		}
		toggle();
	}

	public int getPrimoshkas(){
		return mPrimoshkas;
	}

	public int getPrimoshkas_Recursively(){
		int acumulator = 0;
		for(_2932_primoNodo nodo:nodos){
			acumulator += nodo.getPrimoshkas_Recursively();
		}
		return acumulator + getPrimoshkas();
	}

	public void addNode(_2932_primoNodo id){
		nodos.add(id);
	}

}
