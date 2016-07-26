#!/bin/bash

clear;

option="${1}"

case ${option} in

    1) echo "Selected option 1: File will update and apks will download."
    curl https://androzoo.uni.lu/static/lists/latest.csv.gz | gzip -d  > result2.txt

    cat result2.txt | head -n $2 | tail -n $3 | sed 's/^\([^,][^,]*\),.*$/\1/' | while read x ; do curl -O --remote-header-name -G -d apikey=$4 -d sha256=$x https://androzoo.uni.lu/api/download ; done
        ;;
    2) echo "Selected option 2: File will update and apks will download."
    cat result2.txt | head -n $2 | tail -n $3 | sed 's/^\([^,][^,]*\),.*$/\1/' | while read x ; do curl -O --remote-header-name -G -d apikey=$4 -d sha256=$x https://androzoo.uni.lu/api/download ; done
        ;;
    *)
    echo "invalid option"
    exit 1 # Command to come out of the program with status 1
        ;;
esac
