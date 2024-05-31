
import socket

s = socket.socket(
    socket.AF_INET,
    socket.SOCK_STREAM
)

s.bind(("127.0.0.1", 25566))
s.listen()
conn, addr = s.accept()  # Blocks
data = conn.recv(256)
message = data.decode('utf-8')
print(message)
conn.sendall(b'Go away')
s.close()
