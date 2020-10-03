class Solution:
    def intToRoman(self, num):
        # this is the official solution
        # the key idea of these number based algorithms are
        # the prime numbers, and the %  and / of them
        # another thought is, you can replace a lot of if with a table.
        values = [ 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 ]
        numerals = [ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" ]
        
        res = ''
        # so we need to check how many of these prime numbers we have
        for i in range(len(values)) : # iterate through all stems and primes
            if not num:
                break
            res += numerals[i] * (num//values[i])
            num %= values[i]
        
        return res