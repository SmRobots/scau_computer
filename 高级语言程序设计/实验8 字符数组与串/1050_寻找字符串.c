#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int main() {

	char str1[81];
	char str2[81];
	gets(str1);
	gets(str2);
	int len1 = strlen(str1);
	int len2 = strlen(str2);
	if (len2 > len1) {    // 匹配的长度大于被匹配的长度
		printf("-1");
		return 0;
	}
	for (int i = 0; i <= len1 - len2; i++) {
		int j, k;
		for (j = 0, k = i; j < len2; j++) {
			if (str1[k++] != str2[j]) {
				break;
			}
		}
		if (j == len2) {  // 找到第一个满足条件的直接退出即可
			printf("%d", i + 1);
			return 0;
		}
	} 
  // 没有找到满足条件
	printf("-1");
	
	return 0;
}



