#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova una recensione 

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: id-recensione"
	exit 1 
fi

RECENSIONE=$1 

echo "# trova la recensione $RECENSIONE" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/recensioni/${RECENSIONE} --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

