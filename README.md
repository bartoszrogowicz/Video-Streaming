# VideoConference 

Web application for University of Technology in Gliwice for streaming video conferences. 
## Getting Started
Project was made using Spring Boot 2.0 and Angular 6. The server is created in accordance with the Rest API architecture. 
Client was made using Angular 6 Framework and bootstrap.
Client is sending requests to Rest API server in order to get/add datas about streams.

![alt text](http://i65.tinypic.com/2ztkped.jpg)

Rest API is using h2 Embedded database.

Credentials for Admin Panel: 
* login: admin 
* password: 1qazXSW@

## Build environment:
* install [Java 1.8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* install [nodeJS](https://nodejs.org/en/download/) 
* install [Gradle](https://gradle.org/install/#manually)
* npm install -g @angular/cli
* `cd src/main/webapp` and run `npm install`

## Build application
### Spring Boot server side:
In main project directory you have to run this command:
* `./gradlew bootRun`
* application is running on `localhost:8080`

### Angular 6 Frontend application:
Run Angular application with commands: 
* `cd src/main/webapp`
* `ng serve`  
* Application is running on `localhost:4200`

## Deployment
### Deploy Spring Boot application
Deploy Rest API as jar/war file
* `./gradlew build`
* `cd build/libs` 
* and run server with command `java -jar "name of built package"`

### Deploy Angular application
Deploy Angular app to java script
* `cd src/main/webapp`
* `ng build --prod`

Generated files are in `dist` directory

## Authors
* **Bartosz Rogowicz** - bartosz.rogowicz@gmail.com
* **Krystian Giżyński** - gizynski.krystian@gmail.com

# Dokumentacja w języku polskim

Projekt stworzony dla Politechniki Śląskiej w celu streamowania wideo konferencji.

## Opis projektu

Projekt jest stworzony przy użyciu dwóch webowych frameworków Spring Boot(serwer) i Angular 6(klient).
Serwer został napisany w języku Java, natomiast klient w języku TypeScript. 
Aplikacja działa na zasadzie połączenia klienta z serwerem. Klient wysyła zapytania do serwera w celu otrzymania z bazy danych lub dodania 
do bazy danych informacji o streamach.   

![alt text](http://i65.tinypic.com/2ztkped.jpg)

Login i hasło umożliwiające zalogowanie do panelu administratora na kliencie:
* login: admin 
* hasło: 1qazXSW@

**WAŻNE!! 
By aplikacja działałą poprawnie zawsze uruchomiony musi być jednocześnie Serwer i Klient
Dodatkowo proszę sprawdzić ustawienia Firewall - port 4200 oraz 8080 powinien byc odblokowany!!!**

## Instalacja potrzebnych narzędzi
* instalacja [Java 1.8 JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* instalacja [nodeJS](https://nodejs.org/en/download/) 
* instalacja [Gradle](https://gradle.org/install/#manually)
* instalacja Angular Clienta przy użyciu konsoli - proszę wprowadzić komendę `npm install -g @angular/cli`

## Pobranie projektu

![alt text](http://i66.tinypic.com/15ewfis.png)

## Uruchomienie aplikacji dla systemu operacyjnego Windows

### Uruchomienie serwera
1. Proszę pobrać projekt 
2. Proszę otworzyć terminal i dostać się do katalogu, w którym znajduję się projekt komendą systemową `cd scieżka/do/katalogu`
3. Gdy znajdziemy się w katalogu projektu proszę wpisać komendę w konsoli `gradlew build`
4. Dzięki tej komendzie zostanie wygenerowany nam plik .jar, który będzie można wykorzystać do uruchomienia serwera
5. Po ukończeniu procesu zostanie stworzony katalog `"build"`
6. Proszę wejść do katalogu `build` a następnie katalogu `libs` przy użyciu konsoli
7. Proszę wpisać komędę uruchamiającą serwer `java -jar rtc-0.0.1-SNAPSHOT.jar` 
8. Serwer działa na adresie `localhost:8080`
8. Sprawdzenie poprawności działania: 
     * proszę w przęglądarcę wpisać adress `localhost:8080/api/streams`
     * powinny zostać wyswietlone dane o streamach w formacie json  

### Uruchomienie klienta 
1. Proszę otworzyć terminal i dostać się do katalogu, w którym znajduję się projekt komendą systemową `cd scieżka/do/katalogu`
2. Proszę dostać się do katalogu za pomocą komendy `cd src/main/webapp`
2. Gdy znajdziemy się w katalogu `webapp` proszę wpisać komendę w konsoli `npm install`, po którym pojawi nam się katalog node_modules
    * WAŻNE!!! Krok ten należy wykonać tylko raz. Jeśli katalog node_modules istanieje, nie wymaga ponownego powtarzania kroku
4. Po zainstalowaniu pakietów node proszę wpisać komendę `ng serve`
5. Aplikacja działa na adresie `localhost:4200`

## Uruchomienie aplikacji dla systemu operacyjnego Linux

### Uruchomienie serwera
1. Proszę pobrać projekt 
2. Proszę otworzyć terminal i dostać się do katalogu, w którym znajduję się projekt komendą systemową `cd scieżka/do/katalogu`
3. Gdy znajdziemy się w katalogu projektu proszę wpisać komendę w konsoli `./gradlew build`
4. Dzięki tej komendzie zostanie wygenerowany nam plik .jar, który będzie można wykorzystać do uruchomienia serwera
5. Po ukończeniu procesu zostanie stworzony katalog `"build"`
6. Proszę wejść do katalogu `build` a następnie katalogu `libs` przy użyciu konsoli
7. Proszę wpisać komędę uruchamiającą serwer `java -jar rtc-0.0.1-SNAPSHOT.jar` 
8. Serwer działa na adresie `localhost:8080`
8. Sprawdzenie poprawności działania: 
     * proszę w przęglądarcę wpisać adress `localhost:8080/api/streams`
     * powinny zostać wyswietlone dane o streamach w formacie json  

### Uruchomienie klienta 
1. Proszę otworzyć terminal i dostać się do katalogu, w którym znajduję się projekt komendą systemową `cd scieżka/do/katalogu`
2. Proszę dostać się do katalogu za pomocą komendy `cd src/main/webapp`
2. Gdy znajdziemy się w katalogu `webapp` proszę wpisać komendę w konsoli `npm install`, po którym pojawi nam się katalog node_modules
    * WAŻNE!!! Krok ten należy wykonać tylko raz. Jeśli katalog node_modules istanieje, nie wymaga ponownego powtarzania kroku
4. Po zainstalowaniu pakietów node proszę wpisać komendę `ng serve`
5. Aplikacja działa na adresie `localhost:4200`
