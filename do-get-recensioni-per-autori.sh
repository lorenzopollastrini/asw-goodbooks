#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni relative a un certoinsieme di autori  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: autori-separati-da-virgola"
	exit 1 
fi

# gli autori devono essere separati da virgola 
# se un autore contiene spazi deve essere racchiuso tra virgolette 
AUTORI=$(echo $1 | sed -e "s/ /%20/g" | sed -e "s/,/%2C/g") 

echo "# tutte le recensioni per gli autori $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/cercarecensioni/autori/$AUTORI --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

