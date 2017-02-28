import sys
import socket
import os
import time

# How to use:
# Jalankan dengan python3 client.py [directory] [ip]
# IP bersifat opsional

# Case yang belum dihandle:
# - Folder client adalah valid
# - Huruf terakhir argumen directory BUKAN merupakan slash (/)
# - Nama file harus 1 kata

# Fungsi untuk memparse parameter directory
host = 'localhost'
port = 7777
directory = ''
local_dir = ''
buffer_size = 1024

# Kayaknya gak guna...
def parse_input_directory(directory):
    if dir == '.': 
        print('Directory argument must not be current directory.')
        sys.exit(1)
    
    # Cek apakah directory tersebut ada dan valid
    if not os.path.isdir(directory):
        print('Directory argument is not valid.')
        sys.exit(1)
    
    return directory.split('/')[-1]

# ====================================
# Fungsi untuk mengirim file ke server
# ====================================
def send_to_server(filename):
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((host, port))
    s.send('put ' + filename)
    
    time.sleep(1) # untuk mencegah 'put' terlebur
    
    file = open(directory + '/' + filename, 'rb')
    for data in file:
        s.sendall(data)
        
    print('Sending file %s to server successful.' % filename)
    s.close()
    return


# ======================================
# Fungsi untuk menerima file dari server
# ======================================
def receive_from_server(filename):
    print('Receiving file %s from server successful.' % filename)


# ================================================================
# Fungsi untuk membandingkan file yang ada di client dengan server
# ================================================================
def check_local(filename):
    # check di server udah ada apa belom
    # kalo misalnya belom ada...
    if True:
        send_to_server(filename)
    else:
        if True: #kondisi ketika udah ada last modified beda
            if True: # kondisi ketika server lebih KUNO
                print('Updating file %s...' % filename)
        else:
            print('File %s already exists on the server.')


# ================================================================
# Fungsi untuk membandingkan file yang ada di server dengan client
# ================================================================
def check_server(filename):
    #check file di server ini uda ada apa belom
    # Kalo misalnya belom ada, maka fetch dari server
    # Kalo misalnya udah ada, cek lebih update mana
    print('jozzz')

# =================================================
# Fungsi untuk mensinkronisasi file secara periodik
# =================================================
def synchronize():
    print('Synchronizing...')
    
    for filename in os.listdir(directory):
        check_local(filename)
    
    # Minta daftar nama file yang ada di server dong
    # for filename in daftarnamafile:
        # check_server(filename
    
    print('Synchronization completed.')


def main(argv):
    global directory, local_dir, host
    
    if len(argv) == 0:
        print('Please enter directory that will be used by client as argument.')
        sys.exit(1)

    directory = argv[0]
    local_dir = parse_input_directory(argv[0])
    
    # Custom IP host
    if len(argv) == 2:
        host = argv[1]
    
    print('Initializing client on directory "%s" and server at %s:%s.' % (directory, host, port))
    
    while True:
        synchronize()
        time.sleep(5)

main(sys.argv[1:])
