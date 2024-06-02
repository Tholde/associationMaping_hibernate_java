Mapping d’une entité
Pour rélier les classes dans entity aux tables

2.1 Utilisation Annotation JAVA
Voici la liste des annotation JPA hibernate les plus utilisés dans un entité dans le pakage javax.persistence

Annotation	Description
@Entity	Marque une classe comme une entité Hibernate.
@Table	Permet de spécifier le nom de la table associée à l’entité dans la base de données.
@Id	Définit une clé primaire pour l’entité.
@GeneratedValue	Spécifie la stratégie de génération de valeurs pour les clés primaires automatiques.
@Column	Permet de spécifier le mappage entre un champ de l’entité et une colonne de la table.
@Temporal	Utilisée pour spécifier le type de mapping d’un champ de type java.util.Date ou java.util.Calendar.
@Enumerated	Indique que le champ de l’entité est une énumération, et spécifie comment cette énumération doit être stockée.
@Transient	Marque un champ comme non persistant, c’est-à-dire qu’il ne sera pas sauvegardé dans la base de données.
@OneToMany	Définit une relation un-à-plusieurs entre deux entités.
@ManyToOne	Définit une relation plusieurs-à-un entre deux entités.
@ManyToMany	Définit une relation plusieurs-à-plusieurs entre deux entités.
@JoinColumn	Permet de spécifier la colonne de la table qui est utilisée pour le mappage dans une relation.
@JoinTable	Utilisée pour spécifier les détails de la table d’association dans une relation many-to-many.
@Cascade	Spécifie les opérations de cascade qui doivent être propagées à l’entité associée.
@Fetch	Définit la stratégie de chargement pour l’association entre les entités.
@Cacheable	Indique si l’entité doit être mise en cache.
Inheritance	spécifier la stratégie d’héritage (SINGLE_TABLE, TABLE_PER_CLASS, JOINED)

4.3 Exclure une propriété avec @Transient
pour exclure une proprieté (à ne pas considerer comme colonne de sa table) d’un entité on utilise @Transient
5. Associations
5.1 ManytoOne
Bien sûr ! En Hibernate 5, l’annotation @ManyToOne est utilisée pour établir une association Many-to-One entre deux entités. Cette annotation est placée du côté de l’entité propriétaire et indique que plusieurs instances de l’entité propriétaire sont associées à une instance de l’entité référencée.Voici un exemple simple :

5.1.1 Lazy Loading…
Le chargement paresseux signifie que les données liées à une association ne sont chargées depuis la base de données que lorsque cette association est effectivement utilisée pour la première fois dans le code. En d’autres termes, si vous avez une entité A qui est associée à une entité B avec FetchType.Lazy, les données de B ne seront chargées qu’au moment où vous accéderez effectivement à l’entité B à partir de l’entité A.

Cela offre l’avantage de ne charger que les données nécessaires, ce qui peut améliorer les performances en évitant le chargement inutile de données. Cependant, il est important de noter que le chargement paresseux peut entraîner des exceptions de type “LazyInitializationException” si la session Hibernate n’est pas active lors de la tentative d’accès à l’association.
5.1.1 Initializer Proxy
En Hibernate, un “proxy” fait référence à un objet Java dynamiquement généré qui agit comme un substitut ou une représentation temporaire d’une entité persistante. Les proxies sont souvent utilisés en conjonction avec le chargement paresseux (Lazy Loading) pour améliorer les performances lors de l’accès aux associations entre entités.

5.2 OnetoOne
La relation One-to-One (Un-à-Un) en Hibernate se réfère à une association entre deux entités où chaque instance d’une entité est associée à une et une seule instance de l’autre entité, et vice versa. Cela signifie qu’il existe une correspondance biunivoque entre les instances des deux entités.

5.2 Manytomany
La relation Many-to-Many (Plusieurs-à-Plusieurs) en Hibernate représente une association entre deux entités où chaque instance d’une entité peut être associée à plusieurs instances de l’autre entité, et vice versa. Contrairement à la relation One-to-Many, où une entité possède une collection d’entités associées, la relation Many-to-Many implique une table d’association intermédiaire qui stocke les liaisons entre les deux entités.
