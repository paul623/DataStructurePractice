/*
27.8  Nine Heads Bird 
Date: 2020/08/13
bird��9 2
chicken��1 2
rabbit��1 4
heads:100 foots:100 
*/
#include<stdio.h>
int main(){
	 int bird=0,chicken=0,rabbit=0;
	 for(rabbit=0;rabbit<=25;rabbit++){
	 	for(chicken=0;chicken<=50;chicken++){
	 		for(bird=0;bird<=50;bird++){
	 			if((rabbit*4+chicken*2+bird*2)==100&&(rabbit+chicken+9*bird)==100){
	 				printf("Success,	Rabbit��%2d,	Chicken��%2d,	Bird:%2d\n",rabbit,chicken,bird);
				}
			}	
		}
	 } 
	 return 0;
}
