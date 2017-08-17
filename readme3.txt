	************************************
*****      	   Proxibanque v3 	        *****
	************************************

Concepteurs/d�veloppeurs:

	S�bastien Reymond-Laruinaz
	Pierre-Henri LEGOURD

Date : 17 ao�t 2017

Version : version 3


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livr�s sont :


1) Le dossier "conception" contenant le diagramme des cas d'utilisation, de classes, le diagramme du mod�le en couche, et la maquette des �crans.

2) Le dossier "sources" contenant le lien GitHub du projet et le fichier .war

3) Le dossier "javadoc".

4) Le fichier readme3.txt



	************************************
*****  	    Description de l'application:   *****
	************************************

ProxibanqueSI est une application bancaire.
Apr�s connexion � Proxibanque v3, le conseiller de client�le peut cr�er, lire ou modifier les informations relatives � un client. Le logiciel permet �galement au conseiller de r�cup�rer une liste de clients.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir acc�s � la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc', puis le dossier 'doc'.

2) Double cliquez sur 'index.html'.


	*****************************************
*****  	  Installation du serveur d'application Tomcat   *****
	*****************************************

Le serveur web Tomcat est n�cessaire pour que fonctionne Proxibanque v3. Il assure le lien entre les parties Java, base de donn�es et web de Proxibanque v3.

1) T�l�charger le serveur d'application Tomcat version 8.0.45 sur le site suivant : http://tomcat.apache.org/
Pour le t�l�chargement, choisissez l'option zip dans la liste Core. Une fois le t�l�chargement effectu�, d�zippez l'archive zip.

2) Mettez � jour la variable d'environnement de la JDK : 
- Menu D�marrer, clic droit sur Ordinateur, clic gauche sur le champ "propri�t�s"
- Clic gauche sur le champ Param�tres syst�me avanc�s, puis sur le bouton Variables d'environnement
- Sous le champ Variables utilisateur, clic gauche sur le bouton Nouvelle...
- Dans le champ Nom de la variable, entrez JAVA_HOME
- Dans le champ Valeur de la variable, entrez le chemin d'acc�s � la JDK.

3) Double-cliquez sur le fichier bin/startup.bat : la console s'ouvre, et Tomcat d�marre.

4) Int�gration de Tomcat dans l'interface Eclipse Entreprise :
- Cliquez sur l'onglet File, s�lectionnez l'option New puis l'option Other
- Choisir Server/Server puis cliquez sur Next
- Choisir Apache/Tomcat v8.0 Server, puis cliquez sur Next
- Cliquez sur Browse puis naviguez jusqu'au r�pertoire d'installation de Tomcat
-Cliquez sur Finish.


	************************************
*****  	    Cr�ation de la base de donn�es   	*****
	************************************

Pour cr�er la base de donn�es de Proxibanque v3, l'installation de Xampp est n�cessaire :

1) T�l�charger la version du logiciel Xampp correspondant � votre syst�me d'exploitation (Windows, Linux...) � l'adresse suivante : https://www.apachefriends.org/fr/index.html

2) Installer Xampp, en s�lectionnant les modules Apache, MySQL, Tomcat, FileZilla et Mercury.

3) Ouvrir Xampp, et d�marrer les modules Apache et MySQL.

4) L'application peut d�sormais �tre ex�cut�e.

	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:
	
1) Copier le fichier .war dans le dossier de d�ploiement de Tomcat (apache-tomcat\webapps). 

2) Par d�faut le login et mot de passe du conseiller sont initialis�s � tomcat/test.