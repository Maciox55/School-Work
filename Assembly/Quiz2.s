  .text
  .globl main
main:

  li $v0 , 4
  la $a0 , promptC  #asks user for input
  syscall
  li $v0 , 5
  syscall # read input
  move $a0, $v0
  li $s1 , 50 # upper bound
  li $s2 , -50 # lower bound
  bgt $v0 , $s1 , exit # if larger than 50 , exit
  nop
  blt $v0 , $s2 , exit # if lower than -50 , exit
  nop

  jal conversion
  nop
  
  li $v0 , 4
  la $a0 , msgF
  syscall

  move $a0, $s3

  li $v0, 1
  syscall

  j main
  nop

exit:
  li $v0 , 10
  syscall


.data
  promptC: .asciiz "\n Please enter a temperature in Celsius : "
  msgF: .asciiz "\n The converted Fahrenheit is : "

  .text
  .globl conversion

conversion:
  sll $a0 , $a0 , 1 # $a0 times 2
  addiu $s3 , $a0 , 32
  jr $ra
  nop
