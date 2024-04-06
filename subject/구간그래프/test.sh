#!/bin/bash
g++ -o interval interval.cpp
for ((i=1; i<=3; i++))
do
    ./interval < input$i.txt > output$i.txt
done