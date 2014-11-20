banque-junit
============

JUNIT
---------------------
* Lancer les tests JUNIT et vérifier que vous avez bien un test qui fonctionne.
* A l’aide de JUnit, compléter la classe de test ArticleDAOImplMemoryTest pour que les 5 tests passe au vert
* Créer une classe de test pour chacun des DAO développé ci-dessus. (Toutes les possibilités doivent être testées, y compris, validation de paramètres, exceptions, etc...). Les tests resterons rouges, car les classes testés ne sont pas implementer.
* Implemennter certaine classe pour faire passer les tests au vert pour ArticleDAO.
* Vérifier à l’aide d’Emma que l’ensemble des cas sont couverts (http://www.eclemma.org/installation.html).
* Compléter vos tests si besoin


Mockito 
-------------------
Ajouter la dépendance à Mockito (scope test).
    
On décide à présent d’implémenter BanqueManger, ce service s’appuie sur les DAO précédemment développés. On décide de tester ce service (commencer par la méthode addClient)à l’aide de mocks.
On va donc écrire une test qui s’appuie sur Mockito : qui crée les mocks des DAO et les injecte (dans une méthode @Before)

Aide : http://blog.soat.fr/2013/07/mockito-ou-comment-faciliter-lecriture-de-tests-unitaires/

Base De Données
-----------------
On décide maintenant d’implémenter une version “base de données” de nos DAOs. Ecrire de nouveaux DAOs qui effectue les lectures/ecritures dans une base de données relationnelle (à l'aide de JPA).

Tests d’intégration
----------------------
Nous allons maintenant créer des tests d’intégration. Créer des tests d’intégration (suffixés IT au lieu de Test) qui effectuent directement les appels (tests boite noire), sans Mock. 
