#!/bin/bash
#Konstantin Zelmanovich
#Lab 2 - Q10

for file in `ls`; do
	words=`wc -w $file | cut -f1 -d' '`
	lines=`wc -l $file | cut -f1 -d' '`
  	echo "$file $lines $words"
done
