#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
// 设置一个标志位
	int flag;
	for (int i = 2; i <= 200; i++) {
		flag = 1;
		for (int j = 2; j <= sqrt(i); j++) {
    // 循环判断到i的开方是否有能整除的数
			if (i % j == 0) {
				flag = 0;
			}
		}
		if (flag) {
			printf("%d\n", i);
		}
	}
	return 0;
}



