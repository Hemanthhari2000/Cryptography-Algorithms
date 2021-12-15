import math


q = 23
a = 5

Xa = int(input("Enter Xa (<23) :\t"))
Xb = int(input("Enter Xb (<23) :\t"))

Ya = int(math.pow(a, Xa)) % q
Yb = int(math.pow(a, Xb)) % q

# Key exchange

Ka = int(math.pow(Yb, Xa)) % q
Kb = int(math.pow(Ya, Xb)) % q

if Ka == Kb:
	print('Same')
else:
	print("Nope")