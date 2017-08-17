	************************************
*****      	   Proxibanque v3 	        *****
	************************************

Concepteurs/développeurs:

	Sébastien Reymond-Laruinaz
	Pierre-Henri LEGOURD

Date : 17 août 2017

Version : version 3


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livrés sont :


1) Le dossier "conception" contenant le diagramme des cas d'utilisation, de classes, le diagramme du modèle en couche, et la maquette des écrans.

2) Le dossier "sources" contenant le lien GitHub du projet et le fichier .war

3) Le dossier "javadoc".

4) Le fichier readme3.txt



	************************************
*****  	    Description de l'application:   *****
	************************************

ProxibanqueSI est une application bancaire.
Après connexion à Proxibanque v3, le conseiller de clientèle peut créer, lire ou modifier les informations relatives à un client. Le logiciel permet également au conseiller de récupérer une liste de clients.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir accès à la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc', puis le dossier 'doc'.

2) Double cliquez sur 'index.html'.


	*****************************************
*****  	  Installation du serveur d'application Tomcat   *****
	*****************************************

Le serveur web Tomcat est nécessaire pour que fonctionne Proxibanque v3. Il assure le lien entre les parties Java, base de données et web de Proxibanque v3.

1) Télécharger le serveur d'application Tomcat version 8.0.45 sur le site suivant : http://tomcat.apache.org/
Pour le téléchargement, choisissez l'option zip dans la liste Core. Une fois le téléchargement effectué, dézippez l'archive zip.

2) Mettez à jour la variable d'environnement de la JDK : 
- Menu Démarrer, clic droit sur Ordinateur, clic gauche sur le champ "propriétés"
- Clic gauche sur le champ Paramètres système avancés, puis sur le bouton Variables d'environnement
- Sous le champ Variables utilisateur, clic gauche sur le bouton Nouvelle...
- Dans le champ Nom de la variable, entrez JAVA_HOME
- Dans le champ Valeur de la variable, entrez le chemin d'accès à la JDK.

3) Double-cliquez sur le fichier bin/startup.bat : la console s'ouvre, et Tomcat démarre.

4) Intégration de Tomcat dans l'interface Eclipse Entreprise :
- Cliquez sur l'onglet File, sélectionnez l'option New puis l'option Other
- Choisir Server/Server puis cliquez sur Next
- Choisir Apache/Tomcat v8.0 Server, puis cliquez sur Next
- Cliquez sur Browse puis naviguez jusqu'au répertoire d'installation de Tomcat
-Cliquez sur Finish.


	************************************
*****  	    Création de la base de données   	*****
	************************************

Pour créer la base de données de Proxibanque v3, l'installation de Xampp est nécessaire :

1) Télécharger la version du logiciel Xampp correspondant à votre système d'exploitation (Windows, Linux...) à l'adresse suivante : https://www.apachefriends.org/fr/index.html

2) Installer Xampp, en sélectionnant les modules Apache, MySQL, Tomcat, FileZilla et Mercury.

3) Ouvrir Xampp, et démarrer les modules Apache et MySQL.

4) L'application peut désormais être exécutée.

	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:
	
1) Copier le fichier .war dans le dossier de déploiement de Tomcat (apache-tomcat\webapps). 

2) Par défaut le login et mot de passe du conseiller sont initialisés à tomcat/test.