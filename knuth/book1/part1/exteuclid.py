
def euclid(m, n):
    a=0
    b=1
    aa=1
    bb=0
    c=m
    d=n

    r=1
    while True:
        q=c/d
        r=c%d
        if r == 0:
             break
        c=d
        d=r
        t=aa
        aa=a
        a=t-q*a
        t=bb
        bb=b
        b=t-q*b;

    return q, a, b, aa, bb,d


print euclid(14, 30)
