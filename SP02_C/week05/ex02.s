.section .data
msg:
	.string "val = %d val2 = %d result = %d\n"
val:
	.int 100
val2:
	.int 300
val3:
	.int 300

.section .text
.global main

main:
	movq $msg, %rdi
	movq val, %rsi
	movq val2, %rdx
	addq %rsi, %rdx
	movq %rdx, %rcx
	movq val2, %rdx

	movq $0, %rax
	call printf
	movq $0, %rax
	ret
