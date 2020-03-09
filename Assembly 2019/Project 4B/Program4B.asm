## CS 254 Program 4B
##
## Compute 23*x
##
## Programmer: Maciej Bregisz
## Date: 09/28/2019

        .text
        .globl main

main:
	
        ori $7 $0 6	     #Puts x in register 7

        sll $8 $7 4          #Shifts x 4 times, resulting in multiplication by 16 then stores result in reg. 8
        sll $9 $7 2          #Shifts x 2 times, resulting in multi. by 4 then stores result in $9
        addu $10 $8 $9       #Adds the results of the multiplication by 16 and 4 in $8 and $9, stores in $10

        sll $8 $7 1          #Shifts x 1 times, resulting in multiplication by 2 then stores result in $8
        addu $10 $10 $8      #Adds result of last shift to the result.
        addu $10 $10 $7      #Adds x to the result of mult. by 22, making it the result of x*23. Result in $10