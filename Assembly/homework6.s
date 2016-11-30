# evaluate  27xy+16x-12y+55

  .text
  .globl  main


main:
    lui $10, 0x1000 #set initial memory addtress
	lw $11,0($10) #load x via address offset
    lw $12,4($10) #load y
	addi $13, $0, 27	#init const 27
	addi $14, $0, 16 #init const 16
	addi $16, $0, -12 #init const -12
 
	
	mult $11, $12 #Multiply x by y
	mflo $5 #get mult result
	mult $5, $13 #multiply result by 27
	mflo $5	#get result into $5

	mult $14, $11 #multiply x by 16
	mflo $6 #get result

	add $5, $5, $6 #add results of (27xy) + (16x) into 

	multu $16, $12 #multiply -12 by y
	mflo $4 #get result

	addi $7, $4, 55 #Add 55 with the resuly of (-12y)
	add $7, $7, $5 #Add first half of expression with the second half (27xy+16x)+(-12y+55)

	sw $7, 8($10) #Store result in answer 

  .data
	x: .word 1
	y: .word 2
	answer: .word 0