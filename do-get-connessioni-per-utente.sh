#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le connessioni per un certo utente  

if [ $# -eq 0 ]
  then
    echo "Manca il parametro: utente"
	exit 1 
fi

# se un utente contiene spazi deve essere racchiuso tra virgolette 
UTENTE=$(echo $1 | sed -e "s/ /%20/g") 

echo "# tutte le connessioni per autore per l'utente $1" 
echo $(curl -s ${SERVICE_HOST}:8080/connessioni/connessioniautore/$UTENTE --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le connessioni per recensore per l'utente $1" 
echo $(curl -s ${SERVICE_HOST}:8080/connessioni/connessionirecensore/$UTENTE --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
