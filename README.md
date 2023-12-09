# Exercice 11 : Vins Et Spiritueux
## durée : 240'
## Objectifs visés :
Maîtrise de MVC ; Maitriser les diagrammes de séquence ; Maitriser les diagrammes de classes ; Savoir se référer à la Javadoc.

## Travail à réaliser
Lisez avec attention les informations fournies ci-après sous diverses formes (diagramme de classe, javadoc, diagrammes de séquence, …) car vous y trouverez toutes les informations utiles afin de finaliser le projet Java « **VinsEtSpiritueux** ».

## Résultat à obtenir
Si votre code est correctement implémenté selon les directives reçues, vous devriez obtenir une application fonctionnelle ressemblant à cela :

![interface](images/interface_final.png)

## Fonctionnalités de l’application
Trois boutons permettent de charger les trois configurations différentes de trois entreprises distinctes :

| Entreprises | Locaux | Armoires | Bouteilles |
|:---|:---|:---:|:---|
|A|Salle A01|A01A|Leroy Chambertin Grand Cru de 2003 / 3 900,00 Frs<br>Montrachet Grand Cru de 2004 / 1 499,00 Frs<br>Château Lafite-Rothschild de 2006 / 989,50 Frs|
|A|Salle A01|A01B|Romanée Conti Grand Cru de 2001 / 14 000,00 Frs<br>Romanee-Conti Montrachet Grand Cru de 2004 / 5 100,00 Frs<br>Petrus de 2005 / 2 350,00 Frs|
|B|Cave en pierre|C-01|Montrachet Grand Cru de 2004 / 1 499,00 Frs<br>Château Lafite-Rothschild de 2006 / 989,50 Frs<br>Romanée Conti Grand Cru de 2001 / 14 000,00 Frs<br>Petrus de 2005 / 2 350,00 Frs|
|B|Halle de stockage|H-01|Dôle de Salquenen de 2010 / 39,90 Frs<br>Dôle blanche de 2019 / 29,90 Frs<br>Malvoisie de 2018 / 24,90 Frs|
|B|Halle de stockage|H-02|Pinot noir de 2016 / 19,90 Frs|
|C|(vide)|(vide)|(vide)|



**Autres boutons** :
Trois autres boutons permettent d’afficher différentes informations sur l’entreprise actuellement chargée. Pour l’entreprise B, l’utilisation de ces boutons vous affichera les informations ci-dessous sur la console :

![Rapport timbrage](images/bouton1.png)
```
=======================
Contenu du local : Cave en pierre
  Armoire : C-01
    Montrachet Grand Cru de 2004 / 1 499,00 Frs
    Château Lafite-Rothschild de 2006 / 989,50 Frs
    Romanée Conti Grand Cru de 2001 / 14 000,00 Frs
    Petrus de 2005 / 2 350,00 Frs
Contenu du local : Halle de stockage
  Armoire : H-01
    Dôle de Salquenen de 2010 / 39,90 Frs
    Dôle blanche de 2019 / 29,90 Frs
    Malvoisie de 2018 / 24,90 Frs
  Armoire : H-02
    Pinot noir de 2016 / 19,90 Frs
=======================
```
---
![Rapport détails employés](images/bouton2.png)
```
Statistiques du local : Cave en pierre
 => plus cher   : Romanée Conti Grand Cru de 2001 / 14 000,00 Frs
 => moins cher  : Château Lafite-Rothschild de 2006 / 989,50 Frs
 => Nbre        : 4
 => Prix moyen  : 4709.625
  Statistiques de l'armoire : C-01
   => plus cher   : Romanée Conti Grand Cru de 2001 / 14 000,00 Frs
   => moins cher  : Château Lafite-Rothschild de 2006 / 989,50 Frs
   => Nbre        : 4
   => Prix moyen  : 4709.625
Statistiques du local : Halle de stockage
 => plus cher   : Dôle de Salquenen de 2010 / 39,90 Frs
 => moins cher  : Pinot noir de 2016 / 19,90 Frs
 => Nbre        : 4
 => Prix moyen  : 28.65
  Statistiques de l'armoire : H-01
   => plus cher   : Dôle de Salquenen de 2010 / 39,90 Frs
   => moins cher  : Malvoisie de 2018 / 24,90 Frs
   => Nbre        : 3
   => Prix moyen  : 31.566666666666663
  Statistiques de l'armoire : H-02
   => plus cher   : Pinot noir de 2016 / 19,90 Frs
   => moins cher  : Pinot noir de 2016 / 19,90 Frs
   => Nbre        : 1
   => Prix moyen  : 19.9
```
---
![Rapport employés disponibles](images/bouton3.png) 
```
=======================
Valeur totale du stock 
=======================
Local : Cave en pierre => 18 838,50 Frs
Local : Halle de stockage => 114,60 Frs
-----------------------
Total : 18 953,10 Frs
=======================

```

## Diagramme de classes

```mermaid 
classDiagram

class Application {
    main(String[] args) void$    
}

class ServiceGestionVins {
    -Controller refController
    +ServiceGestionVins()
    +afficherStatistiques(Local[] locaux) void
    +afficherTout(Local[] locaux) void
    +afficherValeurStock(Local[] locaux) void
    +getRefCtrl() Controller
    +setRefCtrl(Controller refController) void
}

class Controller {
    -Local[] locaux
    -View refView
    -ServiceGestionVins refService
    +Controller()
    +start() void
    +viewExiting() void
    +actionAfficherStatistiques() void
    +actionAfficherTout() void
    +actionChargerEntrepriseA() void
    +actionChargerEntrepriseB() void
    +actionChargerEntrepriseC() void
    +getRefServiceGestionVins() ServiceGestionVins
    +setRefServiceGestionVins(ServiceGestionVins service) void
    +getRefView() View
    +setRefView(View view) void
}

class View {
    -Controller refController
    +View()
    +viewStart() void
    +messageInformation(String message) void
    +messageErreur(String message) void
    +messageQuestion(String message) boolean
    +getRefCtrl() Controller
    +setRefCtrl(Controller ctrl)
    -viewExiting() void
    -initComponents() void
    -jButtonAfficherStatistiquesActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonAfficherToutActionActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonAfficherValeurStockActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonChargerEntrepriseAActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonChargerEntrepriseBActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonChargerEntrepriseCActionPerformed(java.awt.event.ActionEvent event) void
    -jButtonQuitterActionPerformed(java.awt.event.ActionEvent event) void
}

class Local {
    -Armoire[] armoires
    -String nom
    +Local(String nom)
    +ajouterArmoire(Armoire armoire) void
    +enleverArmoire(Armoire armoire) boolean
    +calculerStatistiques() Statistique
    +valeurTotaleStock() double
    +getArmoires() Armoire[]
    +getNom() String
}

Controller o--> "1" ServiceGestionVins : -refService
ServiceGestionVins o--> "1" Controller : -refController
View o--> "1" Controller : -refController
Controller o--> "1" View : -refView
Controller o--> "0..*" Local : -locaux
```
## Diagramme de classes : les modèles

```mermaid 
classDiagram

class Local {
    -Armoire[] armoires
    -String nom
    +Local(String nom)
    +ajouterArmoire(Armoire armoire) void
    +enleverArmoire(Armoire armoire) boolean
    +calculerStatistiques() Statistique
    +valeurTotaleStock() double
    +getArmoires() Armoire[]
    +getNom() String
}

class Armoire {
    -Bouteille[] contenu
    -String nom
    +Armoire(String nom, int nbreMaxBouteilles)
    +ajouterBouteille(Bouteille bouteille) boolean
    +enleverBouteille(Bouteille bouteille) booolean
    +armoireEstPleine() boolean
    +calculerStatistiques() Statistique
    +valeurTotaleStock() double
    +getBouteilles() Bouteille[]
    +getNom() String
}

class Bouteille {
    -annee int
    -nom String
    -prix double
    +Bouteille(String nom, int annee, double prix)
    +getAnnee() int
    +getNom() String
    +getPrix() double
    +toString() String
}

class Statistique {
    -Bouteille laMouinsChere
    -Bouteille laPlusChere
    -int nbreBouteilles
    -double prixMoyen
    +Statistique(Bouteille laPlusChere, Bouteille laMoinsChere, int nbreBouteille, double prixMoyen)
    +getLaMoinsChere() Bouteille
    +getLaPlusChere() Bouteille
    +getNbreBouteilles() int
    +getPrixMoyen() double
}


Local o--> "0..*" Armoire : -armoires
Armoire o--> "0..*" Bouteille : -contenu
Statistique o--> "0..1" Bouteille : -laPlusChere
Statistique o--> "0..1" Bouteille : -laMoinsChere

```
### Structure des packages Java
Voici la structure des packages pour chaque classe du projet
```mermaid
classDiagram
namespace app {
    class Application
}
namespace ctrl {
    class Controller
}
namespace service {
    class ServiceGestionVins
}
namespace models {
    class Bouteille
    class Armoire
    class Statistique
    class Local
}
namespace view {
    class View
}
```
### Diagramme de séquence
Voici le diagramme de séquence de la méthode de la méthode `main()` de la classe `Application` du package `app` :
```mermaid
sequenceDiagram
    participant main
    main->>Controller: new Controller()
    Controller-->>main: refController=
    main->>ServiceGestionVins: new ServiceGestionVins()
    ServiceGestionVins-->>main: refService=
    main->>Controller: setRefServiceGestionVins(refService)
    main->>View: new View()
    View-->>main: refView=
    main->>Controller: setRefView(refView)
    main->>View: setRefCtrl(refController)
    main->>ServiceGestionVins: setRefCtrl(refController)
    main->>Controller: start()
```
### Javadoc
Vous pouvez cliquer sur [ce lien pour obtenir la JavaDoc en HTML](javadoc/index.html) de l'application **VinsEtSpiritueux**.
