#!/usr/bin/env python3
import http.server
import socketserver
import os
from urllib.parse import urlparse, parse_qs

#print('source code for "http.server":', http.server.__file__)

class web_server(http.server.SimpleHTTPRequestHandler):
    
    def do_GET(self):

        parsed_url = urlparse(self.path)
        parsedArgs = parse_qs(parsed_url.query)

        print(parsed_url.path)
        
        if parsed_url.path == '/':
            self.protocol_version = 'HTTP/1.1'
            self.send_response(200)
            self.send_header("Content-type", "text/html; charset=UTF-8")
            self.end_headers()
            if parsedArgs.get('str', None):
                text = parsedArgs.get('str', None)[0]
                num_of_low = sum(1 for char in text if char.islower())
                num_of_high = sum(1 for char in text if char.isupper())
                num_of_digits = sum(1 for char in text if char.isdigit())
                num_of_special = sum(1 for char in text if char.isalpha())

                json = {
                    'lowercase': num_of_low,
                    'uppercase': num_of_high,
                    'digits': num_of_digits,
                    'special': num_of_special
                }

                self.wfile.write(str(json).encode('utf-8'))


        else:
            super().do_GET()



    
# --- main ---

PORT = 4080

print(f'Starting: http://localhost:{PORT}')

tcp_server = socketserver.TCPServer(("",PORT), web_server)
tcp_server.serve_forever()
