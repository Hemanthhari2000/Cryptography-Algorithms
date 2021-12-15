import hashlib

hash_obj = hashlib.sha1(b"Hello")
print(hash_obj.hexdigest().upper())
