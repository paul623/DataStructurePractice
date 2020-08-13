/*
24.5  Convert the case to all upper case.  
Date: 2020/08/12
*/ 
#include<stdio.h>
int main(){
	int steps='A'-'a';
	printf("Please input lower case words:");
	char c;
	while((c=getchar())!='\n'){
		if(c>='a'&&c<='z'){
			c=c+steps;
		}
		putchar(c);
	}
	return 0;
}
