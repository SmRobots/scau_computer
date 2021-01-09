#include <stdio.h>

int main() {

	FILE *fp;
	char ch;

	if((fp = fopen("case1.in", "r"))==NULL)
		return 0;
	while((ch = fgetc(fp)) != EOF) {
		if ('A'<=ch && ch<='Z')
			ch = ch + 32;
		printf("%c", ch);
	}
	fclose(fp);

	return 0;
}



