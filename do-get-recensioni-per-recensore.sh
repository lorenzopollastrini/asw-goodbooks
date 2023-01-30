#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni di un certo recensore  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: recensore"
	exit 1 
fi

# se un recensore contiene spazi deve essere racchiuso tra virgolette 
RECENSORE=$(echo $1 | sed -e "s/ /%20/g") 

echo "# tutte le recensioni del recensore $1" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/cercarecensioni/recensore/$RECENSORE --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
