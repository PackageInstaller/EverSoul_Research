from request_proto_api.ThreeMatchScoreSave_pb2 import ThreeMatchScoreSave
import struct

data = ThreeMatchScoreSave()
data.groupNo = 1
data.stageNo = 61
data.score = 2870
data.heartCount = 3
data.clickCount = 16
data.validCount = 15

binary_data = data.SerializeToString()
data_length = len(binary_data)

with open("ThreeMatchScoreSave", "wb") as f:
    f.write(struct.pack("<I", data_length))
    f.write(binary_data)
