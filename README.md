# # QuizTime
# API d’une plateforme d’examens et de quiz
* Développer un module d’examens et de quiz paramétrables avec spring boot

# Contexte du projet
Dans le but de répondre à un besoin croissant d'automatisation des examens et des quiz d'évaluation des acquis, votre entreprise décide de développer en interne une application YouQuiz, qui compte commercialiser auprès de ses différents clients et demandeurs de services dans le domaine de l’éducation et de l’enseignement.
Ce premier module sera réalisé dans le cadre d’une plateforme complète de ELearning.

# Les contraints et les exigences fonctionnelles :

* Un test concerne un ou plusieurs sujets.
* Un test(Examen) est proposé/rédigé par un formateur.
* Un sujet peut sous et super sujet d’un autre.
* Une question est attachée à un sujet unique.
* Une question appartienne à un niveau.
* Une question à plusieurs réponses(Correctes et fausses).
* Une même question peut être temporisée dans un test et non temporisée dans un autre.
* Un étudiant pour passer le même test plusieurs fois après demande au formateur en précisant la raison de la demande un test doit être programmé entre deux dates/heures.
* Le formateur peut programmer les tests pour les étudiants à des dates/heures différentes.
* Le système doit enregistrer toutes les réponses à toutes les questions dans tous les tests pour tous les étudiants en précisant le nombre de points obtenus pour chaque question.
* Un test est caractérisé par: score de réussite, droit de visualiser les réponses, droit de voir le résultat à la fin du test, le nombre de chances, remarques et consignes.
* Une question est caractérisés par: nombre de réponses, nombre de réponses correctes, texte de la question, images, figures, sons, vidéos, type(une ou plusieurs réponses), le nombre de points.
* Un niveau est caractérisé par: description , nombre de points maximum et minimum.
* Une réponse est caractérisée par le texte de réponse.
* Une réponse peut être correcte pour une question et fausse pour une autre question.
* Un sujet est caractérisé par un intitulé.
* Un étudiant est caractérisé par un nom, prénom, date de naissance, adresse, et une date d’inscription.
* Un formateur est aussi caractérisé par un nom, prénom, date de naissance, adresse et une spécialité.
* Le système doit enregistrer pour un passage d’un test les informations suivantes: score obtenu, le numéro de la tentative, résultat final.


# Les contraints et les exigences techniques:

* L'application doit être développée en utilisant le framework Spring Boot.
* L'architecture de l'application doit suivre le modèle MVC (Modèle-Vue-Contrôleur).
* L'application doit utiliser une base de données relationnelle (postgresql).
* Les opérations ORM doivent être implémentées avec spring Data.
* La sécurisation de l’API ne sera pas traitée dans ce premier module.
* Les fonctionnalités critiques de l’application doivent être testées.

# # Lien de diagramme de classe :

https://lucid.app/lucidchart/99a24783-8875-4570-9a50-31792887c1e1/edit?viewport_loc=1568%2C1455%2C1948%2C820%2CHWEp-vi-RSFO&invitationId=inv_ebb9cde3-3f37-4151-882e-a3648e3e8ddc


# Levels API Documentation

## Overview

L'API Levels fournit des informations sur les différents niveaux de réussite au sein du système. Chaque niveau est caractérisé par un identifiant unique, une description et des seuils de points indiquant l'étendue des réalisations.

## Base URL

`http://localhost:9091/levels`

## Endpoints

### 1. Récupérer tous les niveaux

#### Request

- **Method:** GET
- **URL:** `/levels`

#### Response

La réponse sera un tableau JSON contenant des objets avec les propriétés suivantes :

- **id** (integer):  Identifiant unique du niveau.
- **description** (string): Une description concise du niveau.
- **maxPoints** (float): Le nombre maximum de points réalisable pour ce niveau.
- **minPoints** (float): Le nombre minimum de points requis pour atteindre ce niveau.




##### Example Response:

```json
[
    {
        "id": 7,
        "description": "lorem lorem lorem lorem31",
        "maxPoints": 1.15,
        "minPoints": 0.5
    },
    {
        "id": 9,
        "description": "lorem lorem lorem lorem",
        "maxPoints": 1.5,
        "minPoints": 0.5
    }
    
]
```


### 2. Détails du niveau:

#### Request

- **Method:** GET
- **URL:** `/levels/{id}`
- Remplacez {id} par l'identifiant spécifique du niveau.

#### Response

La réponse sera un objet JSON avec les détails du niveau.

##### Example Response

```json

{
    "id": 7,
    "description": "lorem lorem lorem lorem31",
    "maxPoints": 1.15,
    "minPoints": 0.5
}

```



### 3. Créer un nouveau niveau:


#### Request

- **Method:** POST
- **URL:** `/levels`
- **Corps:** Objet JSON avec les propriétés suivantes :
  Une description concise du nouveau niveau.
  maxPoints (nombre décimal) : Le nombre maximum de points réalisable pour le nouveau niveau.
  minPoints (nombre décimal) : Le nombre minimum de points requis pour atteindre le nouveau niveau.

#### Exemple de requête

```json
{
    "description": "Nouveau niveau",
    "maxPoints": 2.0,
    "minPoints": 1.0
}

```
#### Example Response

La réponse sera un objet JSON confirmant la création du nouveau niveau.

```json

{
    "id": 10,
    "description": "Nouveau niveau",
    "maxPoints": 2.0,
    "minPoints": 1.0
}
```


### 4. Mettre à jour un niveau

#### Request

- **Method:** PUT
- **URL:** `/levels/{id}`
- **Corps:** Objet JSON avec les propriétés suivantes :
  description (chaîne de caractères) : La description mise à jour du niveau.
  maxPoints (nombre décimal) : Le nombre maximum de points réalisable pour le niveau mis à jour.
  minPoints (nombre décimal) : Le nombre minimum de points requis pour atteindre le niveau mis à jour.

#### Exemple de requête

```json
{
    "description": "Niveau mis à jour",
    "maxPoints": 2.5,
    "minPoints": 1.2
}

```

#### Example Response

La réponse sera un objet JSON confirmant la mise à jour du niveau.

```json
{
    "id": 10,
    "description": "Niveau mis à jour",
    "maxPoints": 2.5,
    "minPoints": 1.2
}
```


#### 5. Supprimer un niveau

#### Request

- **Method:** DELETE
- **URL:** `/levels/{id}`
  Remplacez {id} par l'identifiant spécifique du niveau.

#### Response
La réponse sera un objet JSON confirmant la suppression du niveau.

```json
{
"message": "Niveau avec l'identifiant 10 supprimé avec succès."
}
```

#### Utilisation Exemplaire
Vous pouvez utiliser l'API Levels pour intégrer des niveaux d'accomplissement dans votre application. Par exemple, vous pourriez afficher le niveau actuel d'un utilisateur en fonction de ses points accumulés.

### Plages de niveaux
- **Niveau 1** : Points entre 0,75 et 2,0
- **Niveau 2** : Points entre 0,5 et 1,75
- **Niveau 3** : Points entre 0,5 et 3,0 
### Codes d'état de réponse
- **200 OK** : Requête réussie.
- **201 Créé** : Création réussie d'un nouveau niveau.
- **204 Pas de contenu** : Mise à jour ou suppression réussie d'un niveau.
- **404 Non trouvé** : Niveau non trouvé.


# Questions API Documentation

## Overview
L'API Questions fournit des informations sur différentes questions, y compris leur contenu, type, niveau d'association, score possible, sujet, et médias associés.

## Base URL

`http://localhost:9091/questions`

## Endpoints

### 1. Récupérer toutes les questions

###   Request


- **Method:** GET
- **URL:** `/questions`

###  Response

   La réponse sera un tableau JSON contenant des objets avec les propriétés suivantes :

- **id** (integer): Identifiant unique de la question.
- **answerNumber** (integer): Nombre total de réponses possibles.
- **answerCorrectNumber** (integer): Nombre de réponses correctes.
- **text** (string): Le texte de la question.
- **type** (string): Le type de question (par exemple, "multiple" pour une question à choix multiple).
- **scorePoints** (float): Le nombre de points attribués pour une réponse correcte.
- **level** (object): Les détails du niveau associé à la question.
- **id** (integer): Identifiant unique du niveau.
- **description** (string): Description du niveau.
- **maxPoints** (float): Le nombre maximum de points réalisable pour ce niveau.
- **minPoints** (float): Le nombre minimum de points requis pour atteindre ce niveau.
- **subject** (object): Les détails du sujet associé à la question.
- **id** (integer): Identifiant unique du sujet.
- **title** (string): Titre du sujet.
- **parent_id** (integer): Identifiant du sujet parent, le cas échéant.
- **medias** (array): Tableau d'objets médias associés à la question.
- **id** (integer): Identifiant unique du média.
- **link** (string): Lien vers le média.
- **type** (string): Type de média (par exemple, "image" ou "son").


### Example Response:

```json

[
    {
        "id": 32,
        "answerNumber": 4,
        "answerCorrectNumber": 3,
        "text": "What is the capital of Maroc122?",
        "type": "multiple",
        "scorePoints": 10.0,
        "level": {
            "id": 11,
            "description": "level level 2 pour les youcoders lorem23",
            "maxPoints": 1.75,
            "minPoints": 0.75
        },
        "subject": {
            "id": 12,
            "title": "Sujet principal 3",
            "parent_id": null
        },
        "medias": [
            {
                "id": 11,
                "link": "https://example.com/image2.jpg",
                "type": "image"
            },
            {
                "id": 12,
                "link": "https://example.com/audio2.mp3",
                "type": "son"
            }
        ]
    }
]

```

### 2. Détails de la question:


###  Request

- **Method:** GET
- **URL:** `/questions/{id}`

- Remplacez {id} par l'identifiant spécifique de la question.


###   Response

   La réponse sera un objet JSON avec les détails de la question.

### Example Response

```json
[
  {
    "id": 32,
    "answerNumber": 4,
    "answerCorrectNumber": 3,
    "text": "What is the capital of Maroc122?",
    "type": "multiple",
    "scorePoints": 10.0,
    "level": {
      "id": 11,
      "description": "level level 2 pour les youcoders lorem23",
      "maxPoints": 1.75,
      "minPoints": 0.75
    },
    "subject": {
      "id": 12,
      "title": "Sujet principal 3",
      "parent_id": null
    },
    "medias": [
      {
        "id": 11,
        "link": "https://example.com/image2.jpg",
        "type": "image"
      },
      {
        "id": 12,
        "link": "https://example.com/audio2.mp3",
        "type": "son"
      }
    ]
  }
]

```

### 3. Créer une nouvelle question:

###   Request

- **Method:** POST
- **URL:** `/questions`
- **Corps:** Objet JSON avec les propriétés suivantes :
   answerNumber (nombre entier) : Nombre total de réponses possibles.
   answerCorrectNumber (nombre entier) : Nombre de réponses correctes.
   text (chaîne de caractères) : Le texte de la nouvelle question.
   type (chaîne de caractères) : Le type de question (par exemple, "multiple" pour une question à choix multiple).
   scorePoints (nombre décimal) : Le nombre de points attribués pour une réponse correcte.
   levelId (nombre entier) : L'identifiant du niveau associé à la question.
   subjectId (nombre entier) : L'identifiant du sujet associé à la question.
   medias (tableau d'objets) : Tableau d'objets médias associés à la question.
   link (chaîne de caractères) : Lien vers le média.
   type (chaîne de caractères) : Type de média (par exemple, "image" ou "son").

### Exemple de requête:

```json
{
  "answerNumber": 4,
  "answerCorrectNumber": 3,
  "text": "Nouvelle question",
  "type": "multiple",
  "scorePoints": 8.0,
  "levelId": 11,
  "subjectId": 12,
  "medias": [
  {
    "link": "https://example.com/image3.jpg",
    "type": "image"
  }
  ]
}

```

### Example Response

La réponse sera un objet JSON confirmant la création de la nouvelle question.

```json

{
    "id": 33,
    "answerNumber": 4,
    "answerCorrectNumber": 3,
    "text": "Nouvelle question",
    "type": "multiple",
    "scorePoints": 8.0,
    "level": {
        "id": 11,
        "description": "level level 2 pour les youcoders lorem23",
        "maxPoints": 1.75,
        "minPoints": 0.75
    },
    "subject": {
        "id": 12,
        "title": "Sujet principal 3"
    },
    "medias": [
        {
            "id": 13,
            "link": "https://example.com/image3.jpg",
            "type": "image"
        }
    ]
}

```

### 4. Mettre à jour une question

### Request

- **Method:** PUT
- **URL:** `/questions/{id}`

### Exemple de requête:

```json
{
  "answerNumber": 5,
  "answerCorrectNumber": 4,
  "text": "Question mise à jour",
  "type": "single",
  "scorePoints": 9.0,
  "levelId": 12,
  "subjectId": 13,
  "medias": [
  {
    "link": "https://example.com/image4.jpg",
    "type": "image"
  }
  ]
}

```

### Example Response:
La réponse sera un objet JSON confirmant la mise à jour de la question.

```json

{
    "id": 33,
    "answerNumber": 5,
    "answerCorrectNumber": 4,
    "text": "Question mise à jour",
    "type": "single",
    "scorePoints": 9.0,
    "level": {
        "id": 12,
        "description": "Nouveau niveau lorem",
        "maxPoints": 2.0,
        "minPoints": 1.0
    },
    "subject": {
        "id": 13,
        "title": "Sujet mis à jour",
        "parent_id": null
    },
    "medias": [
        {
            "id": 14,
            "link": "https://example.com/image4.jpg",
            "type": "image"
        }
    ]
}

```

### 5. Supprimer une question

###   Request


- **Method:** DELETE
- **URL:** ` /questions/{id}`

   Remplacez {id} par l'identifiant spécifique de la question.

### Response
   La réponse sera un objet JSON confirmant la suppression de la question.


### Quiz API Documentation


### Overview

L'API Quiz fournit des informations sur différents quiz, y compris leur titre, dates de début et de fin, score de réussite, nombre maximal de tentatives, instructions, et enseignant associé.

### Base URL

`http://localhost:9091/quiz`

### Endpoints

### 1. Récupérer tous les quiz:


### Request


- **Method:** GET
- **URL:** /quiz
   
### Response

   La réponse sera un tableau JSON contenant des objets avec les propriétés suivantes :

- **id** (integer): Identifiant unique du quiz.
- **title** (string): Le titre du quiz.
- **end_Date** (string): La date et l'heure de fin du quiz au format ISO 8601.
- **start_Date** (string): La date et l'heure de début du quiz au format ISO 8601.
- **successScore** (string): Le score de réussite nécessaire pour réussir le quiz (par exemple, "80%").
- **viewAnswer** (boolean): Indique si les réponses doivent être affichées après avoir répondu au quiz.
- **maxAttempts** (integer): Le nombre maximal de tentatives autorisées pour le quiz.
- **remarks**(string): Remarques ou commentaires sur le quiz.
- **instructions** (string): Instructions pour les participants au quiz.

- **teacher** (object): Les détails de l'enseignant associé au quiz.
- **id** (integer): Identifiant unique de l'enseignant.
- **firstName** (string): Prénom de l'enseignant.
- **lastName** (string): Nom de famille de l'enseignant.
- **dateOfBirth** (string): Date de naissance de l'enseignant au format ISO 8601.
- **address** (string): Adresse de l'enseignant.
- **speciality** (string): Spécialité ou domaine d'expertise de l'enseignant.


### Example Response:

```json

[
    {
        "id": 1,
        "title": "Sample Quiz 1",
        "start_Date": "2023-12-15T08:00:00",
        "end_Date": "2023-12-15T18:00:00",
        "successScore": "80%",
        "viewAnswer": true,
        "maxAttempts": 3,
        "remarks": "This is a sample quiz for testing.",
        "instructions": "Read the questions carefully before answering.",
        "teacher": {
            "id": 1,
            "firstName": "Lita",
            "lastName": "Johnson",
            "dateOfBirth": "2004-08-27",
            "address": "Suite 751 654 Kathi Rapids, New Sammie, UT 91318",
            "speciality": "firefighter"
        }
    },
    {
        "id": 2,
        "title": "Sample Quiz 2",
        "start_Date": "2023-12-15T08:00:00",
        "end_Date": "2023-12-15T18:00:00",
        "successScore": "80%",
        "viewAnswer": true,
        "maxAttempts": 3,
        "remarks": "This is a sample quiz for testing.",
        "instructions": "Read the questions carefully before answering.",
        "teacher": {
            "id": 3,
            "firstName": "Salome",
            "lastName": "Zemlak",
            "dateOfBirth": "1986-05-12",
            "address": "292 Grimes Shore, West Robertfort, VA 31935",
            "speciality": "agriculturist"
        }
    },
    {
        "id": 3,
        "title": "hd",
        "start_Date": "2023-12-15T19:00:00",
        "end_Date": "2023-12-15T18:00:00",
        "successScore": "90%",
        "viewAnswer": true,
        "maxAttempts": 2,
        "remarks": "jdjdjd",
        "instructions": "dddhd",
        "teacher": {
            "id": 4,
            "firstName": "Un",
            "lastName": "Hegmann",
            "dateOfBirth": "1983-05-09",
            "address": "79200 Eusebio Unions, North Nustad, RI 09313",
            "speciality": "coach"
        }
    }
]

```

### 2. Détails du quiz:

### Request

- **Method:** GET
- **URL:** `/quiz/{id}`
   
  Remplacez {id} par l'identifiant spécifique du quiz.


### Response

   La réponse sera un objet JSON avec les détails du quiz.

### Example Response:

```json

{
    "id": 2,
    "title": "Sample Quiz 1",
    "start_Date": "2023-12-15T08:00:00",
    "end_Date": "2023-12-15T18:00:00",
    "successScore": "80%",
    "viewAnswer": true,
    "maxAttempts": 3,
    "remarks": "This is a sample quiz for testing.",
    "instructions": "Read the questions carefully before answering.",
    "teacher": {
        "id": 1,
        "firstName": "Lita",
        "lastName": "Johnson",
        "dateOfBirth": "2004-08-27",
        "address": "Suite 751 654 Kathi Rapids, New Sammie, UT 91318",
        "speciality": "firefighter"
    }
}
```

### 3. Créer un nouveau quiz:

### Request

- **Method:** POST
- **URL:** /quiz
- **Corps:** Objet JSON avec les propriétés suivantes :

   title (chaîne de caractères) : Le titre du nouveau quiz.
   start_Date (string) : La date et l'heure de début du quiz au format ISO 8601.
   end_Date (string) : La date et l'heure de fin du quiz au format ISO 8601.
   successScore (string) : Le score de réussite nécessaire pour réussir le quiz (par exemple, "80%").
   viewAnswer (boolean) : Indique si les réponses doivent être affichées après avoir répondu au quiz.
   maxAttempts (integer) : Le nombre maximal de tentatives autorisées pour le quiz.
   remarks (string) : Remarques ou commentaires sur le quiz.
   instructions (string) : Instructions pour les participants au quiz.
   teacherId (nombre entier) : L'identifiant de l'enseignant associé au quiz.


### Exemple de requête:


```json

{
    "title": "Nouveau Quiz",
    "start_Date": "2023-12-16T10:00:00",
    "end_Date": "2023-12-16T12:00:00",
    "successScore": "85%",
    "viewAnswer": true,
    "maxAttempts": 2,
    "remarks": "Ceci est un nouveau quiz pour test.",
    "instructions": "Lisez attentivement les questions avant de répondre.",
    "teacherId": 5
}

```

### Example Response:

La réponse sera un objet JSON confirmant la création du nouveau quiz.

```json
{
    "id": 4,
    "title": "Nouveau Quiz",
    "start_Date": "2023-12-16T10:00:00",
    "end_Date": "2023-12-16T12:00:00",
    "successScore": "85%",
    "viewAnswer": true,
    "maxAttempts": 2,
    "remarks": "Ceci est un nouveau quiz pour test.",
    "instructions": "Lisez attentivement les questions avant de répondre.",
    "teacher": {
        "id": 5,
        "firstName": "Nouvel",
        "lastName": "Enseignant",
        "dateOfBirth": "1990-03-21",
        "address": "123 Nouvelle Rue, Ville Nouvelle, NC 12345",
        "speciality": "informaticien"
    }
}
```

### 4. Mettre à jour un quiz:

### Request

- **Method:** PUT
- **URL:** /quiz/{id}
  
### Exemple de requête:

```json
{
    "title": "Quiz mis à jour",
    "start_Date": "2023-12-17T14:00:00",
    "end_Date": "2023-12-17T16:00:00",
    "successScore": "90%",
    "viewAnswer": true,
    "maxAttempts": 1,
    "remarks": "Ceci est une mise à jour du quiz.",
    "instructions": "Lisez attentivement les questions avant de répondre.",
    "teacherId": 6
}
```

### Example Response:
La réponse sera un objet JSON confirmant la mise à jour du quiz.

```json
{
    "id": 4,
    "title": "Quiz mis à jour",
    "start_Date": "2023-12-17T14:00:00",
    "end_Date": "2023-12-17T16:00:00",
    "successScore": "90%",
    "viewAnswer": true,
    "maxAttempts": 1,
    "remarks": "Ceci est une mise à jour du quiz.",
    "instructions": "Lisez attentivement les questions avant de répondre.",
    "teacher": {
        "id": 6,
        "firstName": "Mise à jour",
        "lastName": "Enseignant",
        "dateOfBirth": "1985-10-15",
        "address": "456 Rue Mise à Jour, Ville Mise à Jour, CA 67890",
        "speciality": "éducateur"
    }
}

```


### 5. Supprimer un quiz:

### Request

- **Method:** DELETE
- **URL:** `/quiz/{id}`
   
`Remplacez {id} par l'identifiant spécifique du quiz.`
   
### Response:
La réponse sera un objet JSON confirmant la suppression du quiz.


### Answers API Documentation:

### Overview

The Answers API provides information about different answers, including their text.

### Base URL

 `http://localhost:9091/answers`

### Endpoints

### 1. Retrieve all answers:

### Request

- **Method:** GET
- **URL:** `/answers`


### Response

   The response will be a JSON array containing objects with the following properties:

 **id** (integer): Unique identifier of the answer.
 **answerText** (string): The text of the answer.

### Example Response:

```json

[
    {
        "id": 3,
        "answerText": "Nulla ipsa qui consequatur et ratione illo atque."
    },
    {
        "id": 5,
        "answerText": "Ad voluptatum sint quae odit perspiciatis."
    },
    {
        "id": 29,
        "answerText": "This is the answer text 21 update"
    },
    {
        "id": 2,
        "answerText": "Architecto nihil dolores update."
    },
    {
        "id": 4,
        "answerText": "Non ea perspiciatis id ex13 update."
    }
]

```

### 2. Update an answer:

### Request

- **Method:** PUT
- **URL:** `/answers/{id}`

   `Replace {id} with the specific identifier of the answer.`

### Example Request:

```json
{
  "answerText": "Updated answer text."
}
```

### Example Response:
The response will be a JSON object confirming the update of the answer.

```json
{
    "id": 3,
    "answerText": "Updated answer text."
}
```

### 3. Delete an answer:

### Request

- **Method:** DELETE
- **URL:** `/answers/{id}`

   Replace {id} with the specific identifier of the answer.

### Response:

The response will be a JSON object confirming the deletion of the answer.

### Assignments API Documentation

### Overview

The Assignments API provides information about different assignments, including their start and end dates, reason, score, attempt number, final score, associated students, and the related quiz.

### Base URL

 ``http://localhost:9091/assign``

### Endpoints

### 1. Retrieve all assignments:

### Request

- **Method:** GET
- **URL:** `/assign`

### Response

   The response will be a JSON array containing objects with the following properties:

- **id** (integer): Unique identifier of the assignment.
- **date_debut** (string): The start date and time of the assignment in ISO 8601 format.
- **date_fin** (string): The end date and time of the assignment in ISO 8601 format.
- **raison** (string): The reason or description of the assignment.
- **score** (float): The initial score of the assignment.
- **attempt_number** (integer): The number of attempts made on the assignment.
- **score_final** (float): The final score achieved on the assignment.
- **students** (array): An array of student objects, each containing the following properties:
- **id** (integer): Unique identifier of the student.
- **firstName** (string): First name of the student.
- **lastName** (string): Last name of the student.
- **dateOfBirth** (string): Date of birth of the student in ISO 8601 format.
- **address** (string): Address of the student.
- **registrationDate** (string): Registration date of the student in ISO 8601 format.
- **quiz** (object): Details of the associated quiz, containing the following properties:
- **id** (integer): Unique identifier of the quiz.
- **title** (string): Title of the quiz.
- **start_Date** (string): Start date and time of the quiz in ISO 8601 format.
- **end_Date** (string): End date and time of the quiz in ISO 8601 format.
- **successScore** (string): Success score required for the quiz (e.g., "80%").
- **viewAnswer** (boolean): Indicates whether answers should be displayed after completing the quiz.
- **maxAttempts** (integer): Maximum allowed attempts for the quiz.
- **remarks** (string): Remarks or comments on the quiz.
- **instructions** (string): Instructions for participants in the quiz.
- **teacher** (object): Details of the teacher associated with the quiz, containing the following properties:
- **id** (integer): Unique identifier of the teacher.
- **firstName** (string): First name of the teacher.
- **lastName** (string): Last name of the teacher.
- **dateOfBirth** (string): Date of birth of the teacher in ISO 8601 format.
- **address** (string): Address of the teacher.
- **speciality** (string): Speciality or expertise of the teacher.
- **subject** (object): Details of the subject related to the quiz, containing the following properties:
- **id** (integer): Unique identifier of the subject.
- **title** (string): Title of the subject.
- **parent_id** (null): Parent identifier of the subject (null for top-level subjects).

### Example Response:

```json

{
  "id": 44,
  "date_debut": "2023-11-20T12:00:00",
  "date_fin": "2023-11-20T14:00:00",
  "raison": "Updated Test Quiz",
  "score": 1.0,
  "attempt_number": 1,
  "score_final": 90.0,
  "students": [
    {
      "id": 4,
      "firstName": "Sidney",
      "lastName": "Rodriguez",
      "dateOfBirth": "1965-11-16",
      "address": "Suite 720 6614 Alise Pines, South Renna, CA 15113",
      "registrationDate": "2023-11-06"
    }
  ],
  "quiz": {
    "id": 2,
    "title": "Sample Quiz 1  update hdhd !!",
    "start_Date": "2023-12-15T08:00:00",
    "end_Date": "2023-12-15T18:00:00",
    "successScore": "80%",
    "viewAnswer": true,
    "maxAttempts": 3,
    "remarks": "This is a sample quiz for testing.",
    "instructions": "Read the questions carefully before answering.",
    "teacher": {
      "id": 1,
      "firstName": "Lita",
      "lastName": "Johnson",
      "dateOfBirth": "2004-08-27",
      "address": "Suite 751 654 Kathi Rapids, New Sammie, UT 91318",
      "speciality": "firefighter"
    },
    "subject": {
      "id": 4,
      "title": "vero",
      "parent_id": null
    }
  }
}

```