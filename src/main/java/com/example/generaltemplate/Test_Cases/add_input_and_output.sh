#!/bin/bash

for a in `find "/mnt/c/Users/Limited/Desktop/Computer Science/IntelliJ_Projects/Loops_and_Arrays_Project_Java/src/main/java/com/example/generaltemplate/Test_Cases" -mindepth 2 -type d`
do
  echo $a
  touch $a/input.txt
  touch $a/output.txt
done
