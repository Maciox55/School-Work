# Evaluate ax^3+bx^2+cx+d

  .text
  .globl  main


main:
	lui $10, 0x1000 #set initial memory addtress
	lw $11,0($10) #load x via address offset
	lw $12,4($10) #load a via address offset
	lw $13,8($10) #load b via address offset
	lw $14,12($10) #load c via address offset
	lw $15,16($10) #load d via address offset

	add $7, $0, $12 #Accumulator, Holds a
	mult $7, $11 #multiply a * x
	mflo $7 #store result ax

	add $7, $7, $13 #Accumulator holds ax+b
	mult $7, $11 # ax+b * x
	mflo $7 #store result ax^2+bx

	add $7, $7, $14 #Accumulator holds ax^2+bx+c
	mult $7, $11 # ax^2+bx+c * x
	mflo $7 #store result ax^3+bx^2+cx

	add $7, $7, $15 #Accumulator holds ax^3+bx^2+cx + d
	
	sw $7, 20($10) #store result into poly address

.data
	x: .word 1
	a: .word -7
	b: .word 15
	c: .word -32
	d: .word 25
	poly: .word 0