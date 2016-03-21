#include <stdio.h>
#include <algorithm>
/*
http://www.spotify.com/int/jobs/tech/zipfsong/


Programmer:		Michael Duarte

Task:					Order by Zipf's Law (desc) and return m elements from the list 
							If many elements share the same  qi factor, return the ones that
							appeared first.


Input:			
15 3
197812 re_hash
78906 5_4
189518 tomorrow_comes_today
39453 new_genious
210492 clint_eastwood
26302 man_research
22544 punk
19727 sound_check
17535 double_bass
18782 rock_the_house
198189 19_2000
13151 latin_simone
12139 starshine
11272 slow_country
10521 m1_a1 


4 2
30 one
30 two
15 three
25 four 


*/


class song{
	public:
	float fi, qi;			
	char name[32];	
	
	song(){};
	~song(){};
	
};
	
	
struct descending_songs{
    bool operator() (const song &s1, const song &s2) {
        //I used > because if they have the same Qi,
        //the one appeared first will be send back in
        //the ordered list (to return it first)
        return s1.qi > s2.qi;
    }
};

struct ascending_songs{
    bool operator() (const song &s1, const song &s2) {
        return s1.qi < s2.qi;
    }
};


	
void fill(song *arr, int n){
	int i ;
	for(i=0;i<n;i++){
		scanf("%f %s",&arr[i].fi, arr[i].name);
		arr[i].qi = arr[i].fi * (i+1);
	}
}


int main() {
	int n,m,i;
	scanf("%d %d",&n, &m);
	song *songs = new song[n];
	
	fill(songs, n);
	//std::sort(songs, songs+n, descending_songs());
	std::stable_sort(songs, songs+n, descending_songs());
	//http://www.cplusplus.com/reference/algorithm/stable_sort/
	
	for(i=0; i<m ;i++){
		printf("%s\n",songs[i].name);	
	}
	
	if(songs){
		delete[] songs;
		songs = 0;
	}
	return 0;
}	


