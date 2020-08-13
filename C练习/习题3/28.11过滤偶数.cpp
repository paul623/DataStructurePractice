/*
28.11  Reorganization
Date: 2020/08/13 
Input£º123456
OutPut£º135 
*/
#include<stdio.h>
int main(){
	int number,result=0,counter=0;
	scanf("%d",&number);
	int temp;
	while(number!=0){
		temp=number%10;
		number=number/10;
		if(temp%2!=0){
			counter++;
			for(int i=1;i<counter;i++){
				temp=temp*10;
			}
			result=result+temp;
		}
	}
	printf("Result:%d",result);
} 
