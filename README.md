Magasin
============

Configuration
-----------------------
Modifier spring.xml et spring_test.xml pour configurer votre base de donnée.


Injection de bean
-----------------------
* Ajouter les anotations @Repository, @Service, @Autowired et @PersistenceContext
* Ajouter dans le spring.xml la ligne suivante : <context:component-scan base-package="com.package" /> pour chaque package qui contient un Repository ou un service.
* Modifier la servlet HelloServlet pour que magasinManager devient un attribut de classe. 

Spring MVC
---------------
* Modifier le site pour permettre l'ajout, la lecture, la modification et la suppression des différents éléments. Pour cela, vous allez devoir  crée des nouvelles servlets, jsp,... Prendre exemple sur HelloServlet.
Doc : http://www.tutorialspoint.com/spring/spring_mvc_hello_world_example.htm


Spring Sécurité (Pour les plus rapide)
-------------------------
* Aller voir la doc de spring sécurité (http://www.jtips.info/index.php?title=Spring_Security) et proteger vos pages.
