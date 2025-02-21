#include <stdio.h>
#include <stdlib.h>

void printNumbersGoto(int n) {
    int i = 0;
    start:
    if (i <= n) {
        printf("%d ", i);
        i++;
        goto start;
    }
}

void printNumbersFor(int n) {
    for (int i = 0; i <= n; i++) {
        printf("%d ", i);
    }
}

void printNumbersRecursiveFunction(int n) {
    if (n == 0) {
        printf("%d ", n);
    } else {
        printNumbersRecursiveFunction(n - 1);
        printf("%d ", n);
    }
}

void printReverseNumbersRecursiveFunction(int n) {
    if (n == 0) {
        printf("%d ", n);
    } else {
        printf("%d ", n);
        printReverseNumbersRecursiveFunction(n - 1);
    }
}   

int main(int argc, char** argv) {
    printNumbersGoto(7);
    printf("= printNumbersGoto(7)\n");
    printNumbersFor(7);
    printf("= printNumbersFor(7)\n");
    printNumbersRecursiveFunction(7);
    printf("= printNumbersRecursiveFunction(7)\n");
    printReverseNumbersRecursiveFunction(7);
    printf("= printReverseNumbersRecursiveFunction(7)\n");

    return (EXIT_SUCCESS);
}