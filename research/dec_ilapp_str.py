def dec_1():
    enc = bytearray(b'K, ",.<|?6 426,8t?=)')
    key = enc[0]
    for i in range(19):
        enc[i + 1] ^= i + key
    return enc[1:20].decode(errors="replace")


def dec_2():
    enc = bytearray(b"bttfut0cjo0Ebub0Nbobhfe0Nfubebub0hmpcbm.nfubebub/ebu")
    for i in range(52):
        enc[i] -= 1
    return enc.decode(errors="replace")


if __name__ == "__main__":
    print(dec_1())
    print(dec_2())
