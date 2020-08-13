/*
22.3 The day of the year
Date: 2020/08/08
*/ 
#include<stdio.h> 
int main(){
	printf("Please type in the date:"); 
	int y,m,d;
	scanf("%d%d%d",&y,&m,&d);
	int leapYear=(y%4==0&&y%100!=0||y%400==0);
	int days[]={31,28,31,30,31,30,31,31,30,31,30,31};
	int sum=0;
	for(int i=0;i<m-1;i++){
		sum=sum+days[i];
	}
	if(leapYear&&m>2){
		sum++;
	}
	sum=sum+d;
	printf("%d-%d-%d:%d\n",y,m,d,sum); 
	return 0;
}




