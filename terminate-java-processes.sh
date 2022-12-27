#!/bin/bash

echo Halting all running java processes except Eclipse  

ps ax | awk '/java/ && !/eclipse/ {system("sudo kill "$1)}'
