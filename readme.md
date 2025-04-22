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
   ou exporter la bd presente.
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
Inteface du lancement de L'application.
![alt text](<Administrateur 21_04_2025 19_17_35.png>) 
Interface de connexion prevue mais pas encore operationnel pour le moment donc valider juste sur okay !
![alt text](<Administrateur 21_04_2025 19_16_35.png>) 
Fenetre de liste des etudiants  .
![alt text](<Administrateur 21_04_2025 19_16_29.png>) 
Dans le menu , dans etudiant pui gerer etudiant, vous le formulaire de lajout, modification dun etudiants.
![alt text](<Administrateur 21_04_2025 19_16_17.png>) 
Pour le moment le rafraichissement n'est pas auto donc il faudra relancer le serveur pour voir les dernieres insertions
![alt text](<Administrateur 21_04_2025 19_15_32.png>) 
![alt text](<Administrateur 21_04_2025 19_15_21.png>) 
![alt text](<App1.java - TPJAVA2 - Visual Studio Code 21_04_2025 19_14_56.png>)
    Auteurs
Nom : Tayou et Kamdoum
Email : -
Licence
Ce projet est sous licence MIT. Consultez le fichier LICENSE pour plus d'informations. ```