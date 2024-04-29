# Project Title

A brief description of what this project does and who it's for

# Quarkus-Projekt BlogPost

## Beschreibung
TBD

## Features
TBD

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

## Links

 - [Quarkus Documentation](https://quarkus.io/guides/)