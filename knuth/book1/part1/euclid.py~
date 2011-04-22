def gcd_rec(m, n):
    r=m%n
    #print "%d %d %d" % (m, n, r)
    if(r==0):
        return n
    else:
        return gcd_rec(n, r)

print gcd_rec(24, 100)

def gcd_iter(m, n):
    r=1 #some intialisation
    while r!=0:
        r=m%n
        m=n
        n=r
    return m

print gcd_iter(24, 100)



