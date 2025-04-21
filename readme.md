# Gestion des Étudiants

Ce projet est une application Java pour la gestion des étudiants. Elle permet d'ajouter, modifier, supprimer, rechercher et afficher des étudiants en java dans une base de données MySQL.

## Structure du Projet

. ├── .classpath ├── .project ├── bin/ │ └── tppoo/ │ ├── App1.class │ ├── DbConnection.class │ └── JPassField.class ├── src/ │ └── tppoo/ │ ├── App1.java │ ├── DbConnection.java │ └── JPassField.java

## Fonctionnalités

- **Connexion à la base de données** : La classe [`DbConnection`](src/tppoo/DbConnection.java) gère la connexion à une base de données MySQL.
- **Interface utilisateur** : La classe [`App1`](src/tppoo/App1.java) fournit une interface graphique pour interagir avec les données des étudiants.
- **Gestion des étudiants** :
  - Ajouter un étudiant
  - Modifier les informations d'un étudiant
  - Supprimer un étudiant
  - Rechercher un étudiant
  - Afficher la liste des étudiants

## Prérequis

- **Java** : JDK 8 ou supérieur
- **MySQL** : Une instance MySQL fonctionnelle
- **Bibliothèque JDBC** : Le fichier `mysql-connector-j-8.0.33.jar` doit être inclus dans le classpath.

## Configuration

1. **Base de données** :
   - Créez une base de données MySQL nommée `tpjava2`.
   - Ajoutez une table `etudiant` avec les colonnes suivantes :
     - `matricule` (VARCHAR)
     - `nom` (VARCHAR)
     - `prenom` (VARCHAR)
     - `sexe` (VARCHAR)
     - `age` (INT)
     - `filiere` (VARCHAR)

2. **Connexion à la base de données** :
   - Modifiez les informations de connexion dans [`DbConnection`](src/tppoo/DbConnection.java) si nécessaire :
     ```java
     String url = "jdbc:mysql://localhost:3306/tpjava2";
     String user = "root";
     String passwd = "";
     ```

3. **Bibliothèque JDBC** :
   - Assurez-vous que le fichier `mysql-connector-j-8.0.33.jar` est présent et configuré dans le classpath.

## Lancement

1. Compilez le projet :
   ```bash
   javac -d bin -cp "D:/TPJAVA/mysql-connector-j-8.0.33.jar" src/tppoo/*.java
2. Exécutez l'application :
```bat
    java -cp "bin;D:/TPJAVA/mysql-connector-j-8.0.33.jar" tppoo.App1
```
    Auteurs
Nom : Tayou et Kamdoum
Email : -
Licence
Ce projet est sous licence MIT. Consultez le fichier LICENSE pour plus d'informations. ```