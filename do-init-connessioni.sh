#!/bin/bash

SERVICE_HOST=goodbooks
INGRESS_PORT=31080

# inizializza il db delle connessioni 

# connessioni con autore 

curl -X POST ${SERVICE_HOST}/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"autore\": \"Tolstoj\"}"
echo 

curl -X POST ${SERVICE_HOST}/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Alice\", \"autore\": \"Manzoni\"}"
echo 

curl -X POST ${SERVICE_HOST}/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"autore\": \"Manzoni\"}"
echo 

curl -X POST ${SERVICE_HOST}/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"autore\": \"Tolkien\"}"
echo 

# connessioni con recensore 

curl -X POST ${SERVICE_HOST}/connessioni/connessionirecensore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Bob\", \"recensore\": \"Woody\"}"
echo 

curl -X POST ${SERVICE_HOST}/connessioni/connessionirecensore --connect-to ${SERVICE_HOST}:80:kube-cluster:${INGRESS_PORT} -H "accept: */*" -H "Content-Type: application/json" \
     -d "{ \"utente\": \"Carlo\", \"recensore\": \"Roberto\"}"
echo 