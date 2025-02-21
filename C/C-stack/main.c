#include <stdio.h>
#include <stdlib.h>
#include "stack.h"
#include "stack.c"

int main(int argc, char** argv) {
    stack myStack = init(); 
    printf("size(myStack) = %i\n", size(myStack));
    printf("isEmpty(myStack) = %i\n", isEmpty(myStack));
    print(myStack);
    top(myStack);
    myStack = push(42, myStack);
    myStack = push(77, myStack);
    myStack = push(1, myStack);
    printf("size(myStack) = %i\n", size(myStack));
    printf("isEmpty(myStack) = %i\n", isEmpty(myStack));
    print(myStack);
    return (EXIT_SUCCESS);
}