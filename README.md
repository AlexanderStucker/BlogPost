# Quarkus-Projekt BlogPost

## Beschreibung
TBD

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

## Links

 - [Quarkus Documentation](https://quarkus.io/guides/)
