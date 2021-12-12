
def lin_search(arr, ele):
	if ele == 'I':
		return lin_search(arr, 'J')
	for i in range(5):
		for j in range(5):
			if arr[i][j] == ele:
				return [i, j]
	return [-1, -1]

print(my_matrix)
plaintext = "This is a good world".upper()
plaintext = plaintext.replace(" ", "")
# plaintext = "instruments".upper()
key = "MONARCHY"
ciphertext = []

grid = [char for char in key]

for i in range(65, 91):
	if chr(i) == 'I':
		# grid.append("J")
		continue
	if chr(i) not in grid:
		grid.append(chr(i))


grid = [grid[i: i+5] for i in range(0, len(grid), 5)]

print("GRID:")
for row in grid:
	print(row)

# for i in range(1, len(plaintext)):



for i in range(0, len(plaintext) + 1, 2):
	if i < len(plaintext)-1:
		if plaintext[i] == plaintext[i+1]:
			plaintext = plaintext[:i+1] + "X" + plaintext[i+1:]
if len(plaintext) % 2 != 0:
	plaintext = plaintext[:] + 'X' 

pairLetters = [plaintext[i: i+2] for i in range(0, len(plaintext), 2)]

print(" ".join(pairLetters))

for pair in pairLetters:
	f_pos = lin_search(grid, pair[0])
	s_pos = lin_search(grid, pair[1])
	# print(f_pos, s_pos)

	# 1 Same Column
	if f_pos[1] == s_pos[1]:
		f_pos[0] = (f_pos[0] + 1) % 5
		s_pos[0] = (s_pos[0] + 1) % 5
		ciphertext.append(f"{grid[f_pos[0]][f_pos[1]]}{grid[s_pos[0]][s_pos[1]]}")

	# 2 Same Row
	elif f_pos[0] == s_pos[0]:
		f_pos[1] = (f_pos[1] + 1) % 5
		s_pos[1] = (s_pos[1] + 1) % 5
		ciphertext.append(f"{grid[f_pos[0]][f_pos[1]]}{grid[s_pos[0]][s_pos[1]]}")

	# 3 Diagonal
	else:
		ciphertext.append(f"{grid[f_pos[0]][s_pos[1]]}{grid[s_pos[0]][f_pos[1]]}")


print(" ".join(ciphertext))
print("PD SX SX NJ AV RH VN MT BZ")
		