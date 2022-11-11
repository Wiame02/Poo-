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
* 
Graphe des zones :  

### Espèces de Monstres
* Mort-vivant
### Quêtes
> | Titre | Objectif | Récompense |
> |---|---|---|
>

<hr/>

## <u>Valkiem</u> (Passé)
### Zones
* 
Graphe des zones :  

### Espèces de Monstres
* Mammouth
### Quêtes
> | Titre | Objectif | Récompense |
> |---|---|---|
>

<hr/>

## <u>???</u> (Futur)
### Zones
* 
Graphe des zones :  

### Espèces de Monstres
### Quêtes
> | Villageois |Titre | Objectif | Récompense |
> |---|---|---|---|
> | Sorcière Alma |Herbe des rêves | Récolter l'herbe des rêves | Potion de la vie |
> | Chasseur |Molkur sauvage | Abattre un molkur | Arme ruklom|
  
  
<hr/>

## Jeu de test : Déplacement
> | Nom | Temporalité | Boss | Zones |
> | --- | --- | --- | --- |
> | "Univers-Cité" | `null` | `null` | \<Centre> |
> | "Valkiem" | `PASSÉ` | Bill | \<Premier, Deuxieme, Troisieme> |
### ※ <u>Localisation : Zones</u>
> | Nom | Monde | Entités |
> | --- | --- | --- |
> | "Centre" | Université | `null` |
> | "Premier" | Valkiem | `null` |
> | "Deuxieme" | Valkiem | `null` |
> | "Troisieme" | Valkiem | `null` |

<hr/>

## Jeu de test : Cas général
### ※ <u>Localisation : Mondes</u>
> | Nom | Temporalité | Boss | Zones |
> | --- | --- | --- | --- |
> | "Univers-Cité" | `null` | `null` | \<Centre> |
> | "Valkiem" | `PASSÉ` | Bill | \<Premier, Deuxieme, Troisieme, Quatrieme> |

### ※ <u>Localisation : Zones</u>
> | Nom | Monde | Entités |
> | --- | --- | --- |
> | "Centre" | Univers-Cité | `null` |
> | "Premier" | Valkiem | *random* |
> | "Deuxieme" | Valkiem | *random* |
> | "Troisieme" | Valkiem | *random* |
> | "Quatrieme" | Valkiem | *random* |

### ※ <u>Entités</u>
#### **Villageois**
> | Nom | Boss | Monde | Quête | Dialogues |
> | --- | --- | --- | --- | --- |
> | Bill | `true` | Valkiem | *tbd* | *tbd* |
> | Patrick | `false` | Valkiem | *tbd* | *tbd* |
#### **Monstres**
> | Nom | Type | Boss | Monde |
> | --- | --- | --- | --- |
> | Molkur | `GOBLIN` | `false` | Valkiem |


### ※ <u>Quêtes</u>
> | Titre | Est accomplie | Récompense | Objectif : \<Type> | 
> | --- | --- | --- | --- |
> | "Herbe des rêves" | `false` | *tbd* | Herbe des reves : Item |
> | "Molkur" | `false` | *tbd* | Molkur : Monstre |

<hr/>