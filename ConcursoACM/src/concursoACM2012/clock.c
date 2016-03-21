//Locks
#include <stdio.h>
#include <math.h>
#include <string.h>

#define M 1000
char pass[M];
double lockDecoder(char[]);
int decoder(char pass[], char cad[], int directions[], int letters);
char getNext(char,int);
void getDirections(int[], char[], char[], int);
int maxMoves(int[], int, int, char);

main (){
     scanf("%s",pass);
     while(pass[0]!='*'){
//            printf("%s",pass);
//            break;
            printf("%.0f\n",lockDecoder(pass));
            scanf("%s",pass);
     }   
}

double lockDecoder(char in[]){
       double moves;
       int letters,i;
       //check hw many letters there are on the array
       for (i=0;i<M;i++){
           if(in[i] == 0){
                    letters=i;
                    break;
           }
       }
       char cad[letters];
       int directions[letters];
       
       for(i=0; i<letters;i++){
                cad[i]='a';
       }
       
       cad[letters]=0;
       moves=decoder(pass,cad,directions,letters);
       return moves;
}


int decoder(char pass[], char cad[], int directions[],int letters){
    char comp; int moves=0,i,findex,lindex;
    while(strcmp(cad,pass)!=0){
         getDirections(directions,cad,pass,letters);
         for(i=0;i<letters;i++){
           if(directions[i]!=0){
             findex=i;           
             if(directions[i]>0){
              comp='+'; while(directions[i]>0 &&i != letters) i++;
             }
             else{
              comp='-'; while(directions[i]<0 && i!= letters) i++;
             }
             lindex=i;
             break;
           }
         }
         int aux=(maxMoves(directions,findex,lindex,comp));
         if(aux<0)
                  moves+=(-aux);
         else
             moves+=aux;
         for(i=findex;i<lindex;i++){
          cad[i]=pass[i];
         }
    }
    return moves;
}

int maxMoves(int dir[],int findex, int lindex,char dire){
    int moves=0, i;
    if(dire == '+'){
            for(i=findex;i<lindex;i++){
                if(dir[i]> moves) moves=dir[i];
            }
    }
    else{
         for(i=findex;i<lindex;i++){
               if(dir[i]<moves) moves=dir[i];     
         }
    }
    return moves;
}

void getDirections(int dir[], char cad[], char pass[], int len){
     char curC, lastC;
     int i,difC, difL, steps, steps2;
     for(i=0;i<len;i++){
      if(pass[i]==cad[i]){
       dir[i]=0; continue;
      }
     curC=cad[i];
     difC=pass[i]-curC;
     if(difC>13){
      dir[i]=difC-26;
      steps=-dir[i];
     }
     else{
          steps=difC;
          dir[i]=difC;
     }
     
 /*    if(pass[i]=='n')
          if(i<len-1){
               if(pass[i]-'a'>13){
                
               }
    }
*/     
     if(i>0){
             lastC=cad[i-1];
             difL=pass[i]-lastC;
             if(difL>0){
              if(difL>13){
               if(steps>26-difL){
                dir[i]=difL-26;
                cad[i]=cad[i-1];
               }
              }
              else
                if(steps>difL){
                 dir[i]=difL;
                 cad[i]=cad[i-1];
                }
     }
          else{
               steps2=-difL;
               if(steps2>13){
                if(steps>difL+26){
                 dir[i]=difL+26;
                 cad[i]=cad[i-1];
                }
               }
               else{
                if(steps>steps2){
                 dir[i]=difL;
                 cad[i]=cad[i-1];
                }
               }
              }
             }
     }
     }
     
