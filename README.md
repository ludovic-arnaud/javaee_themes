# javaee_themes

Projet JavaEE de créations de thèmes pour des activités de coatching.
L'application utilise Hibernate pour communiquer avec une base de données créée sous PostgreSQL.
Le front est géré par un front controller et est affiché grâce à des jsp.
Des tests unitaires avec Mockito ont été intégrés. Ainsi que la JavaDoc et des logs fichiers avec Log4j.

L'utilisateur doit se logger pour accéder à l'application. Après saisie et vérificatioin de son email et de son mot de passe, il est redirigé vers une page listant tous les thèmes existants.
Il peut alors pour chacun d'eux les modifier ou les supprimer.
Il peut également en créer de nouveaux.
Un bouton de déconnextion permet de fermer la session.
