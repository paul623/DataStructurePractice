/*
22.2 The min number
Date: 2020/08/08
*/ 
#include<stdio.h>
int main(){
	double x,y,z;
	double min;
	printf("Please enter in x,y,z\n");
	scanf("%lf%lf%lf",&x,&y,&z);
	min=x<y?x:y;
	min=min<z?min:z;
	printf("The min number is:%lf",min);
}
