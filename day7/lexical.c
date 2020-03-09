#include <stdio.h>

void fun()
{
    int x = 5;

    void fun2()
    {
        printf("%d", x);
    }
}

int main(){
    fun();
    return 0;
}