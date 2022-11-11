# Guide GIT, Java et Javadoc
## GIT
| Ordre | Commande | Description |
| ------| -------- | ------------|
|1| `git add @file `| Ajoute des fichiers modifiés sur la scène |
|2| `git commit -m "message"`| Valide les changements mis sur la scène |
|(3)| `git pull`| Récupère toutes les mises à jour envoyés sur le serveur public et les fusionnes avec le contenu de notre serveur local |
|4| `git push` | Publie les changements locaux vers le serveur local |

<hr/>

## Java
### Importation
```java
import otherPackage.*;          //Importer toutes les classes de otherPackage
import otherPackage.oneClass;   //Importer la classe oneClass de otherPackage
```

<hr>

## Javadoc
| Tag | Description |
| --- | ----------- |
|`@author Prenom NOM`| Indique l'auteur du fichier |
|`@see PackageName.OneClass#OneFunction() Description de la fonction`| Ajoute un lien vers la fonction décrite |
|`@param var Description du paramètre`| Décrit un paramètre d'une fonction/procédure |
|`@return Description valeur de retour`| Décrit la valeur de retour d'une fonction |

### <u>Exemple</u>

```java
package myPackage;
import otherPackage.*;          //Importer tout de otherPackage

/**
 * Description de votre classe
 * @author Prenom NOM
 */

public class myClass {
    private int attributs;
    
    /**
     * Role de votre methode
     * @see otherPackage.oneClass#oneFunction() Description d'une fonction par exemple qui provient d'une autre classe qui vous semble important de mentionner
     * @param oneParam Description de votre parametre
     * @return Description valeur de retour
     */
    public int oneMethod(double oneParam) {
        int something = 0;
        return something;
    }
}
```