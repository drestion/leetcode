class Codec:
    
    #11:35am
    # 11:40am
    
    # a surprizingly easy to understand solution from this guy.

    alphabet = string.ascii_letters + '0123456789'  # notice the use of ascii_letters

    def __init__(self):
        self.url2code = {}
        self.code2url = {}

    def encode(self, longUrl):
        while longUrl not in self.url2code:
            code = ''.join(random.choice(Codec.alphabet) for _ in range(6))
            if code not in self.code2url: # incase the short code is duplicated.
                self.code2url[code] = longUrl
                self.url2code[longUrl] = code
        return 'http://tinyurl.com/' + self.url2code[longUrl]

    def decode(self, shortUrl):
        return self.code2url[shortUrl[-6:]]  # only use the short code before the / sign