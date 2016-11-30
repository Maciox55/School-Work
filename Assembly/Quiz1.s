.text
.globl main
  main:
    li $s0 , 0 # sum = 0
    li $s1 , 0x20 # $s1 holds the space character
    la $t0 , str # $t0 holds the address of the first character


  loop:
    lbu $t1 , 0( $t0 ) # $t1 holds the first character
    nop




    beq $t1 , $0 , endlp
    nop
    addi $t0, $t0, 1
    beq $t1, $s1, countSpace
    nop
    j loop
    nop


  countSpace:             #adds up present spaces
    addi $s0,$s0,  1
    nop
    j loop
    nop


  endlp:
    sw $s0 , spaceNum # store the sum in spaceNum
    li $v0 , 10 # exit the program
    syscall




.data
    spaceNum: .word 0
    str: .asciiz "Is this a dagger which I see before me ?" #contains 9 spaces
