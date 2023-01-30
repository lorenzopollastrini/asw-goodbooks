#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni relative a un certo libro  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: titolo"
	exit 1 
fi

# se un titolo contiene spazi deve essere racchiuso tra virgolette 
TITOLO=$(echo $1 | sed -e "s/ /%20/g") 

echo "# tutte le recensioni per il libro $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/cercarecensioni/titolo/$TITOLO --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
