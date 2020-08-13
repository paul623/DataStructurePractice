/*
26.7  sum a 
Date: 2020/08/13
Input:n,a
OutPut:s=a+aa+aaa....+aaaaaa(n);
*/
#include<stdio.h>
int main(){
	int n,a,s=0,p=0;
	printf("Please input n and a:");
	scanf("%d%d",&n,&a);
	for(int i=1;i<=n;i++){
		p=p*10+a;
		s=s+p;
	}
	printf("%d\n",s);
	return 0;
}
