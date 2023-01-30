#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni relative a un certoinsieme di recensori  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: recensori-separati-da-virgola"
	exit 1 
fi

# i recensori devono essere separati da virgola 
# se un recensore contiene spazi deve essere racchiuso tra virgolette 
RECENSORI=$(echo $1 | sed -e "s/ /%20/g" | sed -e "s/,/%2C/g") 

echo "# tutte le recensioni per i recensori $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/cercarecensioni/recensori/$RECENSORI --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

