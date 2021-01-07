#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {

	int a[20], i, j, t;
	for(i=0; i<20; i++)
		scanf("%d", a + i) ;
    // 可以先对数组排序
	for(i = 0; i < 20 - 1; i++) {
		for(j=0; j< 20 - i - 1; j++)
			if (a[j] > a[j + 1]) {
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t; 
			}
	}
	int count = 1;
  // 之后再统计
	for (i = 1; i < 20; i++) {
		if (a[i] == a[i - 1]) { // 和前面一个相同直接跳过不统计
			continue;
		}
		count++;
	}
	printf("%d", count);

	return 0;
}



