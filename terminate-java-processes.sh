#!/bin/bash

echo Halting all running java processes  

ps ax | awk '/java/ && !/eclipse/ {system("sudo kill "$1)}'
