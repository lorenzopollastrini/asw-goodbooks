#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le connessioni 

echo "# tutte le connessioni con autore" 
echo $(curl -s ${SERVICE_HOST}:8080/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le connessioni con recensore" 
echo $(curl -s ${SERVICE_HOST}:8080/connessioni/connessionirecensore --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 