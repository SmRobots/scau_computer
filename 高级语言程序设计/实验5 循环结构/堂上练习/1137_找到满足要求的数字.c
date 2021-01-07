#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	for (int i = 7; i <= 9999; i++) {
		if (i % 7 == 0) {	// 能被7整除 
			int temp = i;
			while (temp) {	// 判断是否有一个值为5 
				if (temp % 10 == 5) {
					printf("%d\n", i);
					break; 
				}
				temp /= 10;
			}
		}
		
	}
	
	return 0;
}



