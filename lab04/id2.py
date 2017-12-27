#!/usr/bin/python
#id2.py
#Konstantin Zelmanovich

import sys

f = " "
accounts = dict()

if len(sys.argv) > 2 or len(sys.argv) < 2:
    c = sys.stdin
    f = c.readline()[:-1]

else:
    f = sys.argv[1]

with open(sys.argv[1], 'r') as s:
    for i in s:
        x = i.split(" ", 1)
        accounts[x[0]] = x[1]
    accounts.keys().sort()

    print "\n%-8s%-10s\n" % ("ID", "Name")
    for i in accounts:
        print "%-8s%-10s" % (str(i), accounts[i])
