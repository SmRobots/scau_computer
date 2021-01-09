#include <stdio.h>

int main() {

	FILE *fp;
    char ch;

    if((fp = fopen("case1.in", "r"))==NULL)
        return 0;
    while((ch = fgetc(fp)) != EOF) 
    {
        if (ch >= '0' && ch <= '9') {
        	printf("%c", ch);
		} 
    }
    fclose(fp);

}



