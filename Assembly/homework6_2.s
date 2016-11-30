# Evaluate 15x^3 - 9x^2 +10x +24


  .text
  .globl  main


main:
	lui $10, 0x1000 #set initial memory addtress
	lw $11,0($10) #load x via address offset
	addi $7, $0, 15 #init 15 in register $7

	mult $7, $11 #multiply 15 by x, $7 now holds 15x
	mflo $7 #get result

	addi $7, $7, -9 #add -9 to previous result Accu now holds 15x-9
	mult $7, $11 #multiply by x, 
	mflo $7	 #get result

	addi $7, $7, 10 #add 10 to previous resuly Accu now holds 15x^2-9x+10
	mult $7, $11 #multiply by x
	mflo $7	 #get result final Accu is 15x^3-9x^2+10

	addi $7, $7, 24 #add 24 to previous result, Final 15x^3 - 9x^2 +10x +24    With  x = 2, the final result should be 128
	sw $7, 4($10) #store result into poly address

.data
	x: .word 2
	poly: .word 0