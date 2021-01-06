#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	int m;
	scanf("%d", &m);
	double sum1 = 0, sum2 = m;
	double a1 = 0.01;
	int count = 1;
	while (sum1 < sum2) {
		// 陌生人获得的钱 
		sum1 += a1;
		// 富翁获得的钱 
		sum2 += m;
		a1 *= 2.0;
		count++;
	}
	printf("%d", --count);
		
	return 0;
}



