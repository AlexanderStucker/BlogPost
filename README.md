# Quarkus-Projekt BlogPost

## Beschreibung
Das Quarkus-Projekt BlogPost ist eine RESTful API-Anwendung, die es Benutzern ermöglicht, Blog-Posts zu erstellen, zu lesen, zu aktualisieren und zu löschen (CRUD-Funktionen). Die Anwendung nutzt Keycloak als Authentifizierungslösung und implementiert ein robustes Berechtigungskonzept, das verschiedene Benutzerrollen wie Gast, Benutzer und Administratoren unterstützt.

Dieses Projekt dient als Demonstration moderner Java-Anwendungsentwicklung mit Quarkus und zeigt, wie eine Microservice-Anwendung effizient in einem Container betrieben werden kann.

## Features
- Erstellen, Lesen, Aktualisieren und Löschen von Blog-Posts

## Technologien
- **Quarkus**
- **Maven** 
- **Java**

## Installation & Anwendung starten

### Schritte zur Einrichtung
1. **Repository klonen:**
   Klonen Sie das Repository auf Ihren lokalen Rechner, indem Sie folgenden Befehl ausführen:
   ```bash
   git clone https://github.com/AlexanderStucker/BlogPost.git
   cd [Projektverzeichnis]
   ```

2. Abhängigkeiten installieren:

    ```bash
    ./mvnw clean install
    ```
3. Anwendung Starten: 
    ```bash
    ./mvnw compile quarkus:dev
    ```

## Weitere nützliche Commands

Tests überspringen: 
  ```bash
  ./mvnw quarkus:dev -DskipTests
  ```
Abhängigkeiten aktualisieren
  ```bash
  ./mvnw versions:display-dependency-updates
  ```

## Berechtigungskonzept für die Blog-API

### Öffentliche Methoden
- **GET /blogs**: Öffentlich zugänglich. Zeigt eine Liste aller Blogs.
- **GET /blogs/{id}**: Öffentlich zugänglich. Zeigt Details zu einem bestimmten Blog.

### Benutzerrollen
- **Gast**: Hat nur Lesezugriff auf öffentliche Methoden.
- **Benutzer**: Kann eigene Blogs erstellen und bearbeiten.
- **Admin**: Hat volle Kontrolle über alle Blogs und Benutzer.

### Methoden mit Login- oder Rollenanforderungen
- **POST /blogs**: Erfordert Login und Rolle "Benutzer" oder "Admin".
- **PUT /blogs/{id}**: Erfordert Login und Rolle "Benutzer" (für eigene Blogs) oder "Admin".
- **PATCH /blogs/{id}**: Erfordert Login und Rolle "Benutzer" (für eigene Blogs) oder "Admin".
- **DELETE /blogs/{title}**: Erfordert Rolle "Admin". (Vielleicht auch auf Benutzer ausweiten für eigene Blogs?)

## Docker Images

### Voraussetzungen

- Docker muss auf deinem System installiert und lauffähig sein.

### Iamges Pull
- docker pull ghcr.io/alexanderstucker/keycloak:22.0.1
- docker pull ghcr.io/alexanderstucker/hello-quarkus:latest

### Quarkus-Container starten
- docker network create blog-nw 
- docker run --name keycloak --network blog-nw -p 8180:8180 ghcr.io/alexanderstucker/keycloak:22.0.1
- docker run --name hello-quarkus --network blog-nw -p 8080:8080 ghcr.io/alexanderstucker/hello-quarkus:latest

### Keycloak und Quarkus prüfen

- Keycloak: http://localhost:8180 in deinem Browser öffnen und mit den Standard-Anmeldedaten admin/admin anmelden.
- Quarkus Swagger-UI: API-Dokumentation abrufen, indem http://localhost:8080/q/swagger-ui/ im Browser geöffnet wird. Beispielsweise kann Blog-Einträge abgerufen werden (Ohne TOken) oder, nach Eingabe eines gültigen Authorization-Tokens, geschützte Endpunkte abrufen.


## Links

 - [Quarkus Documentation](https://quarkus.io/guides/)
