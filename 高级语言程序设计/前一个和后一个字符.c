#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main() {
	
	char ch;
	scanf("%c", &ch);
	if (ch < '0' || ch > '9') {
		printf("error");
	}
	if (ch == '0') {
		printf("first 1");
	}
	if (ch == '9') {
		printf("8 last");
	}
	if (ch > '0' && ch < '9') {
		printf("%c %c", ch - 1, ch + 1);
	}
	
	return 0;
}



