# Fatothin

Fatothin est un projet de logiciel de suivi de diète et de sport.  
Le logiciel, dans un premier temps, va tourner en local sur un ordinateur.  
Il sera possible de l’utiliser en ligne dans un second temps (ILU3 ou ILU4).

## IHM

### Diète

| Action          | Description                                                                                                                                               |
|-----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| add(aliment)    | Ajouter un aliment à la base de données. Il est possible de spécifier diverses informations sur l’aliment (calories, protéines, glucides, lipides, etc.). |
| add(recipe)     | Ajouter une recette à la base de données. Une recette est une liste d’aliments avec des quantités ainsi que des instructions de préparation.              |
| add(meal)       | Ajouter un repas à la base de données. Un repas est une recette avec une un jour de la semaine et soit “matin”, “midi” ou “soir”.                         |
| add(diet)       | Ajouter un diète à la base de données. Un diète est une liste de repas sans collision de jour et de moment de la journée.                                 |
| remove(aliment) | Supprimer un aliment de la base de données.                                                                                                               |
| remove(recipe)  | Supprimer une recette de la base de données.                                                                                                              |
| remove(meal)    | Supprimer un repas de la base de données.                                                                                                                 |
| remove(diet)    | Supprimer un diète de la base de données.                                                                                                                 |
| update(aliment) | Mettre à jour un aliment de la base de données.                                                                                                           |
| update(recipe)  | Mettre à jour une recette de la base de données.                                                                                                          |
| update(meal)    | Mettre à jour un repas de la base de données.                                                                                                             |
| update(diet)    | Mettre à jour un diète de la base de données.                                                                                                             |

### Sport

| Action           | Description                                                                                                                                                                                                |
|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| add(exercise)    | Ajouter un exercice à la base de données. Il est possible de spécifier diverses informations sur l’exercice (calories brûlées, muscles sollicités, etc.) et d’y ajouter une ou plusieurs images ou vidéos. |
| add(workout)     | Ajouter un entraînement à la base de données. Un entraînement est une liste d’exercices avec des séries et des répétitions.                                                                                |
| add(session)     | Ajouter une séance à la base de données. Une séance est un entraînement avec une date et une heure de réalisation.                                                                                         |
| add(program)     | Ajouter un programme à la base de données. Un programme est une liste de séances.                                                                                                                          |
| remove(exercise) | Supprimer un exercice de la base de données.                                                                                                                                                               |
| remove(workout)  | Supprimer un entraînement de la base de données.                                                                                                                                                           |
| remove(session)  | Supprimer une séance de la base de données.                                                                                                                                                                |
| remove(program)  | Supprimer un programme de la base de données.                                                                                                                                                              |
| update(exercise) | Mettre à jour un exercice de la base de données.                                                                                                                                                           |
| update(workout)  | Mettre à jour un entraînement de la base de données.                                                                                                                                                       |
| update(session)  | Mettre à jour une séance de la base de données.                                                                                                                                                            |
| update(program)  | Mettre à jour un programme de la base de données.                                                                                                                                                          |

## TEST

### Diète

| ID    | Description                                                                                      |
|-------|--------------------------------------------------------------------------------------------------|
| def1  | Aliment = {String name, float calories, float proteins, float carbohydrates, float lipids}       |
| 1     | L’user peut ajouter un aliment à la base de données.                                             |
| def2  | recipe = {String name, Aliment[] aliments, String[] instructions}                                |
| 2     | L’user peut ajouter une recette à la base de données.                                            |
| def3  | meal = {String name, recipe recipe, String day, String time}                                     |
| 3     | L’user peut ajouter un repas à la base de données.                                               |
| def4  | diet = {String name, meal[] meals}                                                               |
| 4     | L’user peut ajouter un diète à la base de données.                                               |
| 5     | L’user peut supprimer un aliment de la base de données.                                          |
| 6     | L’user peut supprimer une recette de la base de données.                                         |
| 7     | L’user peut supprimer un repas de la base de données.                                            |
| 8     | L’user peut supprimer un diète de la base de données.                                            |
| 9     | L’user peut mettre à jour un aliment de la base de données.                                      |
| 10    | L’user peut mettre à jour une recette de la base de données.                                     |
| 11    | L’user peut mettre à jour un repas de la base de données.                                        |
| 12    | L’user peut mettre à jour un diète de la base de données.                                        |
| 13    | La page d’accueil affiche la liste des diètes.                                                   |
| 14    | La page d’accueil contient un header.                                                            |
| 15    | Le header contient un menu pour accéder à la liste des aliments.                                 |
| 16    | Le header contient un menu pour accéder à la liste des recettes.                                 |
| 17    | Le header contient un menu pour accéder à la liste des repas.                                    |

### Sport

| ID    | Description                                                                                    |
|-------|------------------------------------------------------------------------------------------------|
| def1  | exercise = {String name, float calories, String[] muscles, String[] images, String[] videos}   |
| 1     | L’user peut ajouter un exercice à la base de données.                                          |
| def2  | workout = {String name, exercise[] exercises, int[] series, int[] repetitions}                 |
| 2     | L’user peut ajouter un entraînement à la base de données.                                      |
| def3  | session = {String name, workout workout, String date, String time}                             |
| 3     | L’user peut ajouter une séance à la base de données.                                           |
| def4  | program = {String name, session[] sessions}                                                    |
| 4     | L’user peut ajouter un programme à la base de données.                                         |
| 5     | L’user peut supprimer un exercice de la base de données.                                       |
| 6     | L’user peut supprimer un entraînement de la base de données.                                   |
| 7     | L’user peut supprimer une séance de la base de données.                                        |
| 8     | L’user peut supprimer un programme de la base de données.                                      |
| 9     | L’user peut mettre à jour un exercice de la base de données.                                   |
| 10    | L’user peut mettre à jour un entraînement de la base de données.                               |
| 11    | L’user peut mettre à jour une séance de la base de données.                                    |
| 12    | L’user peut mettre à jour un programme de la base de données.                                  |
| 13    | La page d’accueil affiche la liste des programmes.                                             |
| 14    | La page d’accueil contient un header.                                                          |
| 15    | Le header contient un menu pour accéder à la liste des exercices.                              |
| 16    | Le header contient un menu pour accéder à la liste des entraînements.                          |
| 17    | Le header contient un menu pour accéder à la liste des séances.                                |

## POO

### Implémentation

Le projet sera implémenté en Java.  
Les données sont stockées dans des fichiers CSV.  
La lecture des données se fera de manière paresseuse pour éviter de charger en mémoire des données inutiles.  
Nous utiliserons l’interface graphique JavaSwing ou GTK (selon la possibilité de compilation pour Windows 10).  
La lecture des bases de données se fera à l’aide de la librairie OpenCSV.  
Les classes du projet sont les suivantes :

- `Activity` : représente une activité.
- `Plan` : représente un plan.
- `Database<T>` : gère la base de données.

- `Aliment` : représente un aliment.
- `Recipe` : représente une recette.
- `Recipe.Instructions` : représente les instructions de préparation d'une recette.
- `Meal(Activity)` : représente un repas.
- `Diet(Plan)` : représente une diète.

- `Exercise` : représente un exercice.
- `Exercise.Display` : représente les images et vidéos d'un exercice.
- `Workout` : représente un entraînement.
- `Session(Activity)` : représente une séance.
- `Program(Plan)` : représente un programme.

### Tests

Les tests seront réalisés à l’aide de JUnit 5.  
Les tests seront écrits dans le même package que les classes à tester, mais dans le répertoire `test`.
