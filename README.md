# GOODBOOKS

Progetto del corso di Analisi e progettazione del software per l'anno accademico 2022-2023. 

La variante eseguibile con Docker è disponibile nella branch [docker](https://github.com/lorenzopollastrini/asw-goodbooks/tree/docker).

La variante eseguibile con Kubernetes è disponibile nella branch [kubernetes](https://github.com/lorenzopollastrini/asw-goodbooks/tree/kubernetes).


## Descrizione di questo progetto 

Questo progetto contiene il il codice di *GoodBooks*, 
un semplice social network per la condivisione di recensioni di libri.  
Gli utenti del sistema possono pubblicare delle recensioni. 
Possono poi seguire le recensioni di specifici recensori e di specifici autori di libri.  
Quando un utente accede alla pagina delle recensioni che segue, gli vengono mostrate le recensioni dei recensori e degli autori di libri che segue. 

L'applicazione *GoodBooks* è composta dai seguenti microservizi: 

* Il servizio *recensioni* gestisce le recensioni. 
  Ogni recensione ha un recensore, il titolo del libro e l'autore del libro a cui si riferisce, nonché il testo della recensione. 
  
  Un esempio di recensione: 
  * recensore: Woody
  * titolo libro: Guerra e Pace 
  * autore libro: Tolstoj
  * testo recensione: Parla della Russia
  
  Operazioni: 
  * `POST /recensioni` aggiunge una nuova recensione (dati recensore, titolo libro, autore libro e testo recensione)
  * `GET /recensioni/{id}` trova una recensione, dato l'id 
  * `GET /recensioni` trova tutte le recensioni
  * `GET /cercarecensioni/recensore/{recensore}` trova tutte le recensioni di un certo recensore
  * `GET /cercarecensioni/recensori/{insieme-di-recensori}` trova tutte le recensioni di un insieme di recensori 
  * `GET /cercarecensioni/titolo/{titolo}` trova tutte le recensioni di un certo libro
  * `GET /cercarecensioni/autore/{autore}` trova tutte le recensioni di un certo autore di libri
  * `GET /cercarecensioni/autori/{insieme-di-autori}` trova tutte le recensioni di un insieme di autori di libri 
  
* Il servizio *connessioni* gestisce le connessioni degli utenti con gli autori di libri e con i recensori che essi seguono. 
  Le connessioni sono delle coppie *utente-recensore* oppure *utente-autore*. 
  Operazioni: 
  * `POST /connessioniautore` aggiunge una nuova connessione utente-autore (dati utente e autore)
  * `GET /connessioniautore` trova tutte le connessioni utente-autore
  * `GET /connessioniautore/{utente}` trova tutte le connessioni utente-autore di un certo utente
  * `POST /connessionirecensore` aggiunge una nuova connessione utente-recensore (dati utente e recensore)
  * `GET /connessionirecensore` trova tutte le connessioni utente-recensore
  * `GET /connessionirecensore/{utente}` trova tutte le connessioni utente-recensore di un certo utente

* Il servizio *recensioni-seguite* consente a un utente di trovare le recensioni di tutti gli autori di libri e i recensori che segue. 
  Operazioni: 
  * `GET /recensioniseguite/{utente}` trova tutti le recensioni seguite da un certo utente, ovvero le renesioni di autori di libri e di recensori seguiti da quell'utente
  
* Il servizio *api-gateway* (esposto sulla porta *8080*) è l'API gateway dell'applicazione che: 
  * espone il servizio *recensioni* sul path `/recensioni` - ad esempio, `GET /recensioni/recensioni`
  * espone il servizio *connessioni* sul path `/connessioni` - ad esempio, `GET /connessioni/connessioniautore/{utente}`
  * espone il servizio *recensioni-seguite* sul path `/recensioni-seguite` - ad esempio, `GET /recensioni-seguite/recensioniseguite/{utente}`


## Descrizione delle attività da svolgere 

Si veda la descrizione del progetto sul sito web del corso di [Architettura dei sistemi software](http://cabibbo.dia.uniroma3.it/asw/).

Questo progetto realizza:
* La variante più complessa della sezione "Modifica del codice e della configurazione dell’applicazione"
* Tutte le varianti della sezione "Modifica della modalità di rilascio dell’applicazione" (nelle branch [docker](https://github.com/lorenzopollastrini/asw-goodbooks/tree/docker) e [kubernetes](https://github.com/lorenzopollastrini/asw-goodbooks/tree/kubernetes))
