#!/bin/bash

SERVICE_HOST=goodbooks
CLUSTER=kube-cluster
INGRESS_PORT=31080

# trova tutte le recensioni 

echo "# trova tutte le recensioni" 
echo $(curl -s ${SERVICE_HOST}:8080/recensioni/recensioni --connect-to ${SERVICE_HOST}:80:${CLUSTER}:${INGRESS_PORT})
echo 

