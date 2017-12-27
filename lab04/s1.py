#!/usr/bin/python
#s1.py
#Konstantin Zelmanovich

import sys

def average(list):
	res = 0
        count = 0
        for i in list:
                res += i
		count +=1
        return res/count

if len(sys.argv) > 2 or len(sys.argv) < 2:
        print  "This program accepts only 1 argument"
        sys.exit(1)
        
with open(sys.argv[1],'r') as s:
        print "\n%-8s%-10s\n" % ("Name", "Average")
        for i in s:
                student = i.split(' ',i.count(' '))
		each_average = str( average([int(i) for i in student[1:]]))
		print "%-8s%-10s" % (student[0], each_average) 	
