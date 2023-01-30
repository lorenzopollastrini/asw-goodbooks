#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni seguite da un certo utente 

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: utente"
	exit 1 
fi

# se l'utente contiene spazi deve essere racchiuso tra virgolette 
UTENTE=$(echo $1 | sed -e "s/ /%20/g") 

echo "# le recensioni seguite da $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni-seguite/recensioniseguite/$UTENTE --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
