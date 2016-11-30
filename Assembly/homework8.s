. text
. globl main
main :
li $s0 , 0 # sum = 0
li $s1 , 0 x20 # $s1 holds the space character
la $t0 , str # $t0 holds the address of the first character

loop :
lbu $t1 , 0( $t0 ) # $t1 holds the first character
nop
beq $t1 , $0 , endlp
nop






endlp :
sw $s0 , spaceNum # store the sum in spaceNum
li $v0 , 10 # exit the program
syscall




. data
spaceNum : . word 0
str : . asciiz " Is this a dagger which I see before me ?"
