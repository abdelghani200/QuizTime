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
