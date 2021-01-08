#include <stdio.h>

int f(char *s) {
	int count = 0;
	while (s[count++] != '\0');
	// 最后一次\0的累加要减去 
	return count - 1;
}

int main() {

	char s[80];
    int i;
    scanf("%s", s);
    i=f(s);
    printf("%d", i);

	return 0;
}



