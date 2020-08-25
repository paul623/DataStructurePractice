/*
41.2  Solve equations
Date: 2020/08/25
*/
#include<stdio.h>
#include<math.h> 
void fun(float,float,float);
int main(){
	printf("Please input a b c\n");
	float a,b,c;
	scanf("%f %f %f",&a,&b,&c);
	fun(a,b,c);
	return 0;
} 
void fun(float a,float b,float c){
	if(a==0){
		printf("ERROR");
		return;
	}
	if(b*b-4*a*c<0){
		printf("NULL");
	}else {
		float x1=(-b+sqrt(b*b-4*a*c))/2*a;
		float x2=(-b-sqrt(b*b-4*a*c))/2*a;
		printf("%fx^2+%fx+%c=0,x1=%f,x2=%f",a,b,c,x1,x2);
	}
}
