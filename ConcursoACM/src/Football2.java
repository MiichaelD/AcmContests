import java.util.*;

class Football2{
  
  public static void  main (String args[]) {
    int N, G, S, R, res, loses, buyWin, buyTie;
    Scanner in=new Scanner(System.in);
    LinkedList<Integer> pq = new LinkedList<Integer>();
    while(in.hasNext()){
      res = loses = 0;
      pq.clear();
      N = Integer.parseInt(in.next());
      G = Integer.parseInt(in.next());
      
      while(N-- > 0){
	S = Integer.parseInt(in.next());
	R = Integer.parseInt(in.next());
	if (S>R)
	  res+=3;
	else if(S==R){
	  if(G > 0){
	    G--;
	    res+=3;
	  }
	  else
	    res++;
	}
	else {
	  pq.add(R-S);
	  loses++;
	}
      }
      
      if(G > 0){
	Collections.sort(pq);
	
	while(!pq.isEmpty() && G>0){
	  buyTie = pq.getFirst();
	  buyWin = buyTie+1;
	  if(G >= buyWin){
	    G-=buyWin;
	    res+=3;
	    pq.removeFirst();
	  }
	  else if(G == buyTie){
	    G-=buyTie;
	    res++;
	    pq.removeFirst();
	  }
	  else
	    break;	
	}
      }
      System.out.println(res);
    }
  }
  
  
}
