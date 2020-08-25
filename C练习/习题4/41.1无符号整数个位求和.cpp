/*
41.1  Sum
Date: 2020/08/25
*/
#include<stdio.h>
unsigned int Sum(unsigned int);
int main(){
	unsigned int number;
	printf("Please input a number:");
	scanf("%u",&number);
	printf("number %u:%u\n",number,Sum(number));
	return 0;
} 
unsigned int Sum(unsigned int number){
	unsigned int sum=0;
	while(number!=0){
		sum=sum+number%10;
		number=number/10;
	}
	return sum;
}
