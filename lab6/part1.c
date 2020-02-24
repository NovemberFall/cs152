#include<stdio.h>
#include<stdlib.h>

int x = 42;

void foo(){
    printf("%d\n ",x);
}

void bar(){
    int x = 666;
    foo();
}

int main(){
    bar();
    return 0;
}