#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni relative a un certo autore  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: autore"
	exit 1 
fi

# se un autore contiene spazi deve essere racchiuso tra virgolette 
AUTORE=$(echo $1 | sed -e "s/ /%20/g") 

echo "# tutte le recensioni per l'autore $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/cercarecensioni/autore/$AUTORE --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
