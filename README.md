# **Les nouveautés de Java 17 par rapport à Java 11**

Java 17 est une _version majeure_ de Java,
publiée en **septembre 2021**, qui apporte plusieurs améliorations
et fonctionnalités par rapport à _Java 11_, qui est sorti en
septembre 2018.

###### Voici un aperçu des principales nouveautés.

## 1. Pattern Matching for instanceof ([JEP 394](https://openjdk.org/jeps/394))

_Java 16_ introduit une nouvelle syntaxe pour les expressions instanceof qui facilite l'écriture de code plus concis et
plus expressif en utilisant des motifs.

Voici un exemple :

```java 
if (obj instanceof String s) {
    System.out.println("Length of string is " + s.length());
} else {
    System.out.println("Object is not a string");
}
```

Dans cet exemple, l'expression instanceof est suivie d'une variable s
qui est liée à l'objet obj si celui-ci est une instance de String.
Cette variable peut ensuite être utilisée dans le bloc de code suivant
pour effectuer des opérations spécifiques à l'objet String.

## 2. Sealed Classes ([JEP 409](https://openjdk.org/jeps/409))

Les classes scellées sont une nouvelle fonctionnalité de _Java 17_ qui permettent de restreindre les sous-classes
autorisées pour une classe donnée. Voici un exemple :

```java
public abstract sealed class Shape permits Circle, Rectangle {
// ...
}

public final class Circle extends Shape {
// ...
}

public final class Rectangle extends Shape {
// ...
}
```

Dans cet exemple, la classe abstraite Shape est scellée et permet uniquement les sous-classes Circle et Rectangle. Cela
permet de garantir que toutes les sous-classes sont connues à l'avance et peuvent être gérées de manière appropriée dans
le code.

## 3. Records ([JEP 395](https://openjdk.org/jeps/395))

Les enregistrements sont une nouvelle fonctionnalité de _Java 16_ qui permettent de définir des classes de données
immuables de manière concise. Voici un exemple :

```java

public record Person(String name, int age) {
}
    Person p = new Person("John Doe", 30);
System.out.println(p.name()); // John Doe
        System.out.println(p.age()); // 30

```

Dans cet exemple, la classe Person est définie comme un enregistrement avec deux champs : name et age. Lorsqu'un nouvel
objet Person est créé, les valeurs des champs sont définies dans le constructeur. Les méthodes d'accès sont générées
automatiquement pour les champs, ce qui facilite l'accès aux données.

## 4. Text Blocks ([JEP 378](https://openjdk.org/jeps/378))

Les blocs de texte sont une nouvelle fonctionnalité de _Java 15_ qui permettent d'écrire des chaînes de caractères
multi-lignes plus facilement et avec moins de bruit. Voici un exemple :

```java
String html="""
    <html>
        <body>
            <h1>Hello, world!</h1>
        </body>
    </html>
""";
```

Dans cet exemple, la chaîne de caractères html est définie en utilisant un bloc de texte, ce qui permet d'écrire la
chaîne multi-lignes sans avoir à échapper les caractères de fin de ligne ou à utiliser des caractères spéciaux.

## 5. Switch Expressions [JEP 361](https://openjdk.org/jeps/361)

Dans la version java 14 les expressions switch permettent de retourner une valeur à partir d'une instruction switch,
ce qui réduit la duplication de code.

Java 14 introduit également la possibilité de déclarer plusieurs étiquettes de cas pour une même instruction switch.
Cela permet traiter plusieurs cas avec la même logique, ce qui peut rendre le code plus clair et plus concis.

Voici un exemple :

````java

int dayOfWeek=1;
        String dayName=switch(dayOfWeek){
        case 1,2,3,4,5->"weekday";
        case 6,7->"weekend";
default ->"unknown";
        };
        System.out.println("The day is a "+dayName);
````

Dans cet exemple, nous avons plusieurs étiquettes de cas pour les jours de la semaine, ce qui nous permet de traiter
tous les jours de la semaine de la même manière.

### Les fonctionnalités en mode preview

[JEP 406](https://openjdk.org/jeps/406): Pattern Matching for switch

* Amélioration du switch pour prendre en charge pour utiliser le pattern matching pour les types (comme instanceof)
* Prise en charge du cas null
* Support des guard où l'on peut utiliser une expression booléenne comme case.

Pour pouvoir utiliser ces fonctionnalités il faut activer le mode preview.