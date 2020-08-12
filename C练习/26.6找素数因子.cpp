/*
25.6  Find the prime factor  
Date: 2020/08/12
*/
#include<stdio.h>
int main(){
	int m,k=2;
	printf("Please input a number:");
	scanf("%d",&m);
	while(k<m){
		if(m%k==0){
			printf("%4d",k);
			m=m/k;
		}else{
			k++;
		}
	}
	printf("%4d\n",m);
	return 0;
}
