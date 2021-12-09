import time

class CeaserCipher:
	def __init__(self):
		self.encoding_maps = dict([(chr(i), idx) for idx, i in enumerate(range(65, 91))])	
		self.encoded_text = []					
		self.decoded_text = []
		
	def numberToLetter(self, num):
		return chr(num + 65)


	def encrypt(self, input_string, key):
		for letter in input_string:
			encoded_letter = self.numberToLetter(((self.encoding_maps[letter]) + key) % 26)
			self.encoded_text.append(encoded_letter)
		return ''.join(self.encoded_text)

	def decrypt(self, encrypt_string, key):
		for letter in encrypt_string: 
			decoded_letter = self.numberToLetter(((self.encoding_maps[letter]) - key) % 26)
			self.decoded_text.append(decoded_letter)
		return ''.join(self.decoded_text)	
	
	def cleaner(self):
		self.encoded_text = []
		self.decoded_text = []	

def main():
	cc = CeaserCipher()	
	while 1:
		input_string = input("Enter your input string\t\t")
		key = int(input('Enter your key\t\t'))
		enc = cc.encrypt(input_string.upper(), key)
		print('Text Ecrypting......')
		time.sleep(1)
		print('Encrypted Text\t\t' + enc)
		dec = cc.decrypt(enc, key)
		print('Text Decrypting......')
		time.sleep(1)
		print('Decrypted Text\t\t' + dec)	
		more = input('Wanna Continue? (Y/N)')
		if more.lower() == 'n':
			print('Thanks for using our algorithm')
			time.sleep(1)
			break
		cc.cleaner()

main()
