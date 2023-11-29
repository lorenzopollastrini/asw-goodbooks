# GOODBOOKS

## Esecuzione con Docker 

Questo progetto può essere eseguito nell'ambiente di esecuzione *workstation* del corso di Architettura dei Sistemi Software (2022/2023).

Per eseguire questo progetto: 

* Collegarsi alla macchina virtuale *workstation* tramite SSH
* Spostarsi nella directory contenente il progetto 
* Compilare il codice sorgente con il comando `gradle build` 
* Effettuare il rilascio dell'applicazione eseguendo lo script `run-goodbooks-docker.sh`
* Attendere che in ogni container si sia completato l'avvio del rispettivo contenuto
* Inizializzare le basi di dati con dei dati di esempio eseguendo gli script `do-init-connessioni.sh` e `do-init-recensioni.sh`

Le varie operazioni dell'applicazione possono essere eseguite con i seguenti script: 

* Lo script `run-curl-client.sh` esegue un insieme di interrogazioni di esempio 
* Lo script `do-get-recensioni.sh` trova tutte le recensioni 
* Lo script `do-get-recensione.sh` trova una recensione 
* Lo script `do-get-recensioni-per-autore.sh` trova tutte le recensioni di un certo autore 
* Lo script `do-get-recensioni-per-autori.sh` trova tutte le recensioni di un insieme di autori  
* Lo script `do-get-recensioni-per-titolo.sh` trova tutte le recensioni di un certo libro
* Lo script `do-get-recensioni-per-recensore.sh` trova tutte le recensioni di un certo recensore 
* Lo script `do-get-recensioni-per-recensori.sh` trova tutte le recensioni di un insieme di recensori  
* Lo script `do-get-connessioni.sh` trova tutte le connessioni 
* Lo script `do-get-recensioni-seguite.sh` trova tutte le recensioni seguite da un certo utente 

L'applicazione può essere arrestata eseguendo lo script `stop-goodbooks-docker.sh`. 
