/*
21.1 if else ex.
Date: 2020/08/08
*/ 
#include<stdio.h>
double fx(double x);
int main(){
	double x;
	printf("Please type in x:");
	scanf("%lf",&x);
	printf("f(%lf)=%lf",x,fx(x)); 
	return 0;
}
double fx(double x){
	if(x<1){
		return x;
	}else if(x>=10){
		return 3*x-11;
	}else{
		return 2*x-11;
	}
}
