/*
23.4 Profit drawing
Date: 2020/08/08
*/ 
#include<stdio.h>
int main(){
	double profit,total=0.0;
	printf("Please input profit:");
	scanf("%lf",&profit);
	if(profit<=10){
		total=0.1*profit;
	}else if(profit>10&&profit<=20){
		total=1.0+(profit-10)*0.075;
	}else if(profit>20&&profit<=40){
		total=1.0+0.75+(profit-20)*0.05;
	}else if(profit>40&&profit<=60){
		total=1.0+0.75+1+(profit-40)*0.03;
	}else if(profit>60&&profit<=100){
		total=1.0+0.75+1+0.6+(profit-60)*0.015;
	}else{
		total=1.0+0.75+1+0.6+0.6+(profit-100)*0.01;
	} 
	printf("Profit:%lf,Reward:%lf\n",profit,total); 
	return 0;
} 
