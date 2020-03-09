## CS 254 Program 6
##
## Compute (25xy - 10x - 6y + 28)/7
##
## Programmer: Maciej Bregisz
## Date: 10/12/2019

        .text
        .globl main

main:
	
	ori $9 $0 25	  #put 10
	lui $10 0x1000    #init first mem address.
	lw $11 0($10)	  #load value from first address
	lw $11 4($10)     #while previous load is delayed, start load of second address
	mult $9 $11	  #multiply 25 with loaded X
	mflo $9		  #retrieve the product of 25 * X
	mult $9 $11	  #multiply 25X * Y
	mflo $12          #retrive product of 25xy into reg. 12
	lw $11 0($10)	  #load value x into register
	ori $9 $0 10	  #put 10 in reg. 9 while X is loading from mem
	mult $9 $11	  #multiply 10 * X
	lw $11 4($10)	  #load value y into register
	mflo $13          #product of 10X while value of Y is loaded to reg. 13
	ori $9 $0 6	  #put 6 in register
	mult $9 $11	  #multiply 6 * Y 
	mflo $14          #product of 6Y stored in reg. 14
	subu $9 $12 $13   #Subtract 10X - 25X
	subu $9 $9 $14	  #Subtract (10X-25X) - 6Y
	addu $9 $9 28	  #Add 28 to (10X-25X-6Y)
	ori $8 $0 7	  #put 7 in reg. 8 for division
	div $9 $8	  #Divide reg. 9 by 7      (10X-25X-6Y+28)/7
	mflo $12	  #Retrieve the quotient of division
	mfhi $13	  #Retrieve the remainder of division
	sw $12 12($10)    #Store quotient of division in memory address
	sw $13 8($10)	  #Store remainder of division in memory address
	
        
        

	.data
             x:         .word 1
             y:         .word 1
             rem:       .word 0
             answer:    .word 0