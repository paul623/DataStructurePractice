/*
41.3  legendre polynomial expansion
Date: 2020/08/25
*/
#include<stdio.h>
#include<math.h> 
double fun(int,double);
int main(){
	int n;
	double x;
	printf("Please input n x\n");
	float a,b,c;
	scanf("%d %lf",&n,&x);
	printf("p(%d,%lf)=%lf",n,x,fun(n,x));
	return 0;
} 
double fun(int n,double x){
	if(n==0){
		return 1.0;
	}else if(n==1){
		return x;
	}else{
		return ((2*n-1)*x*fun(n-1,x)-(n-1)*fun(n-2,x))/n;
	}
}
