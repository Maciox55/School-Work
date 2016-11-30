  .text
  .globl  main


main:
  addi $9, 50 #loop constant
  addi $10, 0 #loop counter


loop:
  addi $10, $10, 1 #add 1 to counter:  $10 + 1
  mult $10, $10     #square the counter
  mflo $11        #squared counter result stored  in $11
  add $8, $8, $11 #add previous square with new square and move it to the sum register

  beq $10, $9, EXIT # if loop counter == constant exit loop
  j loop #jumps repeats the loop one more time

EXIT:
sll $0, $0, 0 #nop
