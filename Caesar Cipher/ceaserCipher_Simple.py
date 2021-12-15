encoding_maps = dict([(chr(char), idx) for idx, char in enumerate(range(65, 91))])
print(encoding_maps)

plaintext = "Hemanth"
key = 3
ciphertext = []
deciphertext = []
def numberToLetter(num):
    return chr(num + 65)
    
for letter in plaintext.upper():
    val = encoding_maps[letter]
    encoded_letter = numberToLetter((val + key) % 26)
    ciphertext.append(encoded_letter)

ciphertext = "".join(ciphertext)
print(f"Encrypted Data: {ciphertext}")

for letter in ciphertext:
    val = encoding_maps[letter]
    decoded_letter = numberToLetter((val - key) % 26)
    deciphertext.append(decoded_letter)

deciphertext = "".join(deciphertext)
print(f"Decrypted Data: {deciphertext}")    