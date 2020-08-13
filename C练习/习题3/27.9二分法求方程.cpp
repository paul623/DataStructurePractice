/*
27.9  Bisection method
Date: 2020/08/13
2x^3-4x^2+3x-6=0; (-10,10)
*/
#include<stdio.h>
#include<math.h>
float fx(float x) {
	return 2 * x * x * x - 4 * x * x + 3 * x - 6;
}
int main() {
	float l = -10, r = 10, m;
	float f1, f2, f;
	do {
		m = (l + r) * 0.5;
		f1 = fx(l);
		f = fx(m);
		f2 = fx(r);
		if (f1 * f < 0) {
			r = m;
		}
		else if(f*f2<0){
			l = m;
		}
	}while(fabs(f)>=1e-6);
	printf("2x^3-4x^2+3x-6=0 x=%f\n", l);
	return 0;
}
