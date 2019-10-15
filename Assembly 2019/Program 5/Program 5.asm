## CS 254 Program 5
##
## Compute 7x^4 + 2x^3 + 10x^2 - 3x + 17 using Horners method
##
## Programmer: Maciej Bregisz
## Date: 10/05/2019

        .text
        .globl main

    main:
	ori $6 $0 3	     #Puts 3 in register 6 for substitution

	ori $7 $0 4	     #Puts x in register 7, example value of 4

	addu  $10 $0 7        #Store add 7 in reg. 10
	mult  $10 $7          #Multiply 7 by x
	mflo  $10             #Store result of multiplication from LO register in reg 10
	addu  $10 $10 2        #Add 2 to the accumulated value
	mult  $10 $7          #Multiply by x
	mflo  $10             #Store results of mult. from LO register in reg. 10
	addu  $10 $10 10       #Add 10 to accum. value.
	mult  $10 $7          #Multiply by x
	mflo  $10             #Store results of mult. from LO register in reg. 10
	sub   $10 $10 $6       #Subtract 3 from accumulated value
	mult  $10 $7          #Multiply by x
	mflo  $10             #Store results of mult. from LO register in reg. 10
	addu  $10 $10 17      #Add 17 to accumulated value and store result in reg. 10
	
