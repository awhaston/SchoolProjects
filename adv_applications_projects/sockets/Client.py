import socket

s = socket.socket(
    socket.AF_INET,
    socket.SOCK_STREAM
)

s.connect(("127.0.0.1", 25566))
message = "Hello World"
byte_array = message.encode('utf-8')
s.sendall(byte_array)
print(s.recv(256).decode('utf-8'))
s.close()

