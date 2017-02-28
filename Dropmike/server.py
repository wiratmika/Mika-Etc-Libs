import socket
import sys
import time

HOST = 'localhost'                 
PORT = 7777

socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket.bind((HOST, PORT))

socket.listen(1)
while (1):
    conn, addr = socket.accept()
    print 'New client connected ..'
    reqCommand = conn.recv(1024)
    string = reqCommand.split(' ', 1)   #in case of 'put' and 'get' method
    reqFile = string[1] 
    print 'Client> %s' %(reqCommand)
    if (string[0] == 'quit'):
        break
    #elif (reqCommand == lls):
        #list file in server directory
    else:
        if (string[0] == 'put'):
            
            file_to_write = open(reqFile, 'wb')
            has_received = False
            print('mau nerima coooyyy')
                
            while True:
                print('menerima data...')
                data = conn.recv(1024)
                if not data and has_received:
                    break
                if data:
                    print(data)
                    has_received = True
                        
                file_to_write.write(data)
                    
            file_to_write.close()
            
            print 'Receive Successful'
        elif (string[0] == 'get'):
            with open(reqFile, 'rb') as file_to_send:
                for data in file_to_send:
                    conn.sendall(data)
            print 'Send Successful'
    conn.close()

socket.close()
