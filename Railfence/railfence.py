import math

inputString = "I love Python for no reason".upper()

ciphertext = ""
plaintext = ""

for i in range(0, len(inputString), 2):
	ciphertext += inputString[i]
for i in range(1, len(inputString), 2):
	ciphertext += inputString[i]

print(ciphertext)

leftptr = 0
rightptr = math.ceil(len(ciphertext)/2)

count = 0
while(count < len(ciphertext)):
	if (count % 2 == 0):
		plaintext += ciphertext[leftptr]
		leftptr += 1
	else:
		plaintext += ciphertext[rightptr]
		rightptr+= 1
	count +=1

print(plaintext)