#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

int f(int n, int m)
{
    int  r;
    while ((r=m%n)!=0)
    {
        m=n;
        n=r;
    }
    return  n;
}

int main() {
  // 不知道n是定义来干嘛的
	int  a, b, n;
    scanf("%d%d", &a, &b);
    printf("%d\n", f(a, b));
	return 0;
}



