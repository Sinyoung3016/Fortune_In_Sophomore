#include <stdio.h>

struct foo_s {
	int a;
	char b;
};

struct bar_s{
	char ar[100];
	struct foo_s baz;
};
int main(){
	struct bar_s biz;
	biz.ar[0] = 'a';
	biz.baz.a = 42;
	printf("biz.ar[0] = %c, biz.bar.a = %d\n", biz.ar[0], biz.baz.a);

	struct bar_s* boz = &biz;
	boz->baz.b = 't';
	printf("boz->baz.b = %c \n", boz->baz.b);
	printf("biz.baz.b = %c \n", biz.baz.b);
	return 0;
}
