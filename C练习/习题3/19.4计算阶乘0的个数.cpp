/*
19.4 The zero number of 1000!
Date: 2020/08/08
*/ 
#include<stdio.h>
int main(){
	int k=0,m;
	for(int i=5;i<=1000;i=i+5){
		m=i;
		while(m%5==0){
			k++;
			m=m/5;
		}
	}
	printf("The zero number of 1000! is %d\n",k);
	return 0;
} 
