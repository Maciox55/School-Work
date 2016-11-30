  .text
  .globl  main


main:
lui $10, 0x1000 #set initial memory address
lw $20, 0($10) #load x via address offset
lw $21, 4($10) #load y via address offset
sll $0, $0, 0 #delay slot

slt $8, $20, $21 # compare if $20 < $21, returns 0 if false
beq $8, $0, store #checks if 0 is in $8 and calls the branch

store:
 sw $21, 8($10) #put lowest value into min memory address

.data
x: .word 10
y: .word 5
min: .word 0
