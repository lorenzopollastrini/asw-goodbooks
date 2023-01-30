#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# esegue un insieme di interrogazioni di esempio 

echo "# tutte le recensioni"  
echo $(curl -s ${SERVICE_HOST}/recensioni/recensioni --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# la recensione 1" 
echo $(curl -s ${SERVICE_HOST}/recensioni/recensioni/1 --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le recensioni del recensore Woody" 
echo $(curl -s ${SERVICE_HOST}/recensioni/cercarecensioni/recensore/Woody --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le recensioni de I promessi sposi" 
echo $(curl -s ${SERVICE_HOST}/recensioni/cercarecensioni/titolo/I%20promessi%20sposi --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le recensioni dei libri di Tolstoj" 
echo $(curl -s ${SERVICE_HOST}/recensioni/cercarecensioni/autore/Tolstoj --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le connessioni" 
echo $(curl -s ${SERVICE_HOST}/connessioni/connessioniautore --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
echo $(curl -s ${SERVICE_HOST}/connessioni/connessionirecensore --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# tutte le connessioni di Alice" 
echo $(curl -s ${SERVICE_HOST}/connessioni/connessioniautore/Alice --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 
echo $(curl -s ${SERVICE_HOST}/connessioni/connessionirecensore/Alice --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# le recensioni seguite da Alice" 
echo $(curl -s ${SERVICE_HOST}/recensioni-seguite/recensioniseguite/Alice --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# le recensioni seguite da Bob" 
echo $(curl -s ${SERVICE_HOST}/recensioni-seguite/recensioniseguite/Bob --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

echo "# le recensioni seguite da Carlo" 
echo $(curl -s ${SERVICE_HOST}/recensioni-seguite/recensioniseguite/Carlo --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

