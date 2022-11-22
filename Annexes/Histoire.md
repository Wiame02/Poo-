 # Histoire

Le joueur commence dans l'Univers-Cité :  
Narrateur : "Bienvenue à L'Univers-Cité ! Mais... Tu n'es pas encore inscrit ma foi."  
-- Questions pour la création du personnage  
* Comment t'appelles-tu ?  
* Dans quel département veux-tu t'inscrire ? --> Affichage des différents départements 
 
-- Création du personnage  
Narrateur : "Bien bien... Maintenant que tu es inscrit... J'aurais un petit, tout petit service à te demander."  

<hr/>

## Les Mondes 
<hr/>

## <u>Univers-Cité</u>
### Zones
* Bibliothèque
* Cafétéria
Graphe des zones :  

### Quêtes
> | Titre | Objectif | Récompense |
> |---|---|---|
>

<hr/>

## <u>???</u> (Présent)
### Zones
* Tour des péchés (salle de la rédemption, 7 étages pour les 7 péchés capitaux : luxure, gourmandise, envie, avarice, )
*
Graphe des zones :  

### Espèces de Monstres
* Mort-vivant
* Goule
* Algoule
* Molosse
* Griffon
* Succube
### Quêtes
> | Villageois | Titre | Objectif | Récompense |
> |---|---|---|---|
> | Survivant Hugo | Epidémie | Abattre tout les zombies | Plastron de métal |
> | Bergère Aldine | Moutons en danger | Abbater un molosse | Laine de mouton |
> | Grand père Rodrigo | Tricot en périle | Lui rapporter de la laine | Bonnet douillet |

<hr/>

## <u>Valkïem</u> (Passé)
### Zones
* Pyramide (tombeau, )
* Forêt des éléments (lac, )
Graphe des zones :  

### Espèces de Monstres
* Mammouth
* Sphinx
* Djin
* Elementaire (feu,glace,terre,vent,lumière)
* Dragon
### Quêtes
> | Villageois | Titre | Objectif | Récompense |
> |---|---|---|---|
> | Vieillard Luc | Mammouth nourrissant | Rapporter de la viande de mammouth | Lance de l'ancien guerrier |

<hr/>

## <u>???</u> (Futur)
### Zones
* Manoir abandonné (salle à manger, salon, chambre 1, chambre 2, )
* 
Graphe des zones :  

### Espèces de Monstres
* Demon
* Elfes
* Saint
* Mecas
* Molkur

### Quêtes
> | Villageois |Titre | Objectif | Récompense |
> |---|---|---|---|
> | Sorcière Alma |Herbe des rêves | Récolter l'herbe des rêves | Potion de la vie |
> | Chasseur Robert |Molkur sauvage | Abattre un molkur | Arme ruklom|
  
  
<hr/>

## Jeu de test : Déplacement
> | Nom | Temporalité | Boss | Zones |
> | --- | --- | --- | --- |
> | "Univers-Cité" | `null` | `null` | \<Centre> |
> | "Valkïem" | `PASSÉ` | Bill | \<Premier, Deuxieme, Troisieme> |
### ※ <u>Localisation : Zones</u>
> | Nom | Monde | Entités |
> | --- | --- | --- |
> | "Centre" | Université | `null` |
> | "Premier" | Valkïem | `null` |
> | "Deuxieme" | Valkïem | `null` |
> | "Troisieme" | Valkïem | `null` |

<hr/>

## Jeu de test : Cas général
### ※ <u>Localisation : Mondes</u>
> | Nom | Temporalité | Boss | Zones |
> | --- | --- | --- | --- |
> | "Univers-Cité" | `null` | `null` | \<Centre> |
> | "Valkïem" | `PASSÉ` | Bill | \<Premier, Deuxieme, Troisieme, Quatrieme> |

### ※ <u>Localisation : Zones</u>
> | Nom | Monde | Entités |
> | --- | --- | --- |
> | "Centre" | Univers-Cité | `null` |
> | "Premier" | Valkïem | *random* |
> | "Deuxieme" | Valkïem | *random* |
> | "Troisieme" | Valkïem | *random* |
> | "Quatrieme" | Valkïem | *random* |

### ※ <u>Entités</u>
#### **Villageois**
> | Nom | Boss | Monde | Quête | Dialogues |
> | --- | --- | --- | --- | --- |
> | Bill | `true` | Valkïem | *tbd* | *tbd* |
> | Patrick | `false` | Valkïem | *tbd* | *tbd* |
#### **Monstres**
> | Nom | Type | Boss | Monde |
> | --- | --- | --- | --- |
> | Molkur | `GOBLIN` | `false` | Valkïem |


### ※ <u>Quêtes</u>
> | Titre | Est accomplie | Récompense | Objectif : \<Type> | 
> | --- | --- | --- | --- |
> | "Herbe des rêves" | `false` | *tbd* | Herbe des reves : Item |
> | "Molkur" | `false` | *tbd* | Molkur : Monstre |

<hr/>
