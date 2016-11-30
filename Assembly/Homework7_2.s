  .text
  .globl  main


main:
  addi $9, 100 #loop constant
  addi $10, 0 #loop counter


loop:
  addi $10, $10, 2   #add 1 to counter:  $10 + 1

  add $8, $8, $10    #add previous square with new square and move it to the sum register

  beq $10, $9, EXIT  #if loop counter == constant exit loop
  j loop             # repeats the loop one more time

EXIT:
sll $0, $0, 0 #nop
