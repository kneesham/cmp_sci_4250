/*
 ============================================================================
 Name        : Project5.c
 Author      : Ted Nesham
 Version     : 1
 Copyright   : Your copyright notice
 Description : Project 5 cs_4250 in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>
#define SIZE 1000

void fn1 () {

	static int number_activation = 0; // the number of current activation records.
	char values[SIZE];
	static long int addr; // will store the current starting address of the array.

	if(number_activation == 10){ // base case to exit recursion.
		puts("EXIT fn1");
	}
	else {
		long int temp = addr; // store the previous address in a temporary variable.
		addr = (long int)&values; // assign the starting address of the array.

		number_activation++; // increment the number of activation records.

		printf("Call #%d:  at %X\n", number_activation, (void*)addr); // print the current activation record instance.
		printf("AR Size #%d is %d\n", number_activation, (temp - addr)); // print the estimated size of the current activation record.

		fn1(); // recursive call to fn1.
	}
}
void fn2 (){ // function to call itself until segfault to show the stack size.

	static int number_activation = 0; // the number of current activation records.
	char values[SIZE];
	static long int addr; // will store the current starting address of the array.

	long int temp = addr; // store the previous address in a temporary variable.
	addr = (long int)&values; // assign the starting address of the array.
	int activation_record_size = temp - addr;
	static long int current_stack_size = 0;

	number_activation++; // increment the number of activation records.
	current_stack_size += activation_record_size;

	printf("Call #%d: at %X\n", number_activation, (void*)addr); // print the current activation record instance.
	printf("AR Size #%d is %d \n", number_activation, activation_record_size); // print the estimated size of the current activation record.
	printf("Stack Size #%-4d is %ld\n", number_activation, current_stack_size);

	fn2(); // recursive call to fn1.
}
void fn3 (){

	char c; // measure the size of the current activation record.
	static int number_activation = 0; // the number of current activation records.
	char *values = (char*)malloc(sizeof(char) * number_activation); // dynamically allocate memory for the array.
	values[0] = 'X';
	static long int addr; // will store the current starting address of the array.

	if(number_activation == 10){ // base case to exit recursion.
		puts("EXIT fn3");
	}
	else {

		long int temp = addr; // store the previous address in a temporary variable.
		addr = (long int)&values; // assign the starting address of the array.

		number_activation++; // increment the number of activation records.

		printf("Call #: %-2d     at %X\n", number_activation, (void*)addr); // print the current activation record instance.
		printf("AR Size#%-4d is %d\n", number_activation, (temp - addr)); // print the estimated size of the current activation record.
		free(values);
		fn3(); // recursive call to fn1.
	}
}

int main() {

	fn1();
	//fn2();
	//fn3();

	return 0;
}
