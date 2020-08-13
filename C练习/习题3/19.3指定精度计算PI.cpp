/*
19.3 Calculate Pi 
Date 2020.08.08 
*/
#include<stdio.h> 
int main(){
	double s=1.0,eps,t=1.0;
	int n;
	printf("Please enter the eps:"); 
	scanf("%lf",&eps);
	for(n=1;t>=eps;n++){
		t=t*n/(2*n+1);
		s=s+t;
	}
	printf("PI=%lf\n",2*s);
	return 0;
} 
