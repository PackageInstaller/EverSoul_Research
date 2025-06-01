def m1302_encrypt_decrypt(input_str: str) -> str:
    length = len(input_str)
    chars = [0] * length
    i = length - 1
    c = ord('F')
    while i >= 0:
        char_at = chr(ord(input_str[i]) ^ c)
        c2 = (c ^ i) & 0x3F
        chars[i] = char_at
        i2 = i - 1
        if i2 < 0:
            break
        char_at2 = chr(ord(input_str[i2]) ^ c2)
        c = (c2 ^ i2) & 0x3F
        chars[i2] = char_at2
        i = i2 - 1
    return ''.join(chars)



decrypted = m1302_encrypt_decrypt("Jghaltmbk&HI1f")
print(decrypted)