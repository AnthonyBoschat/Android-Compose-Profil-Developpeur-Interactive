## Titre
Profil Développeur Anthony

## Capture Avant

<img width="1047" height="1068" alt="{1B99285B-54D5-4C74-AC6F-758CE4F8761C}" src="https://github.com/user-attachments/assets/c2806e50-4322-4b1b-8cc3-bdfbf8d3c80b" />


## Capture après

<img width="386" height="742" alt="image" src="https://github.com/user-attachments/assets/dc410506-4386-4dd4-aa9b-fcb7b283ea9a" />

## Description courte
Affiche dans une card le profil d'un développeur, en l'occurrence ici le mien.

Contient le nom du profil, un avatar, une liste de compétences, une liste de projets, des informations de contact, la disponibilité, et un bouton pour permettre à terme de contacter le développeur.

## Notions utilisées

- Composants réutilisables : Composable
- Modifier pour le style et le positionnement
- Previews pour afficher le rendu en temps réel
- Padding externe / interne
- Callbacks
- Paramètres de composants
- Accessibilité de base
- Layouts : Column, Row, Box (badge sur l'avatar), Spacer, Surface
- Liste moderne : LazyRow pour les compétences
- Card pour les compétences et les projets
- OutlinedTextField en lecture seule pour le contact
- Icon dans le bouton
- Material 3 : couleurs personnalisées (rouge sombre), thème clair et sombre

## Liste affichée
Les compétences sont affichées dans une `LazyRow`, une liste horizontale qu'on fait défiler. Chaque compétence utilise le composable réutilisable `Skill`, qui l'affiche dans une `Card`.

## Choix du thème
- **Couleurs** : un rouge sombre comme couleur principale, utilisé pour le titre et le bouton.
- **Typographie** : les styles de `MaterialTheme.typography` (headline, title, body).
- **Clair / sombre** : une palette pour chaque mode, visibles dans les deux previews.

## Notions du chapitre Compose UI réutilisées
Composables réutilisables avec paramètres, `Modifier`, padding externe et interne, callback sur le bouton, previews, et accessibilité de base.

## Explication courte

#### Quels composables avez-vous créés ?

> - Profile : Le composant de profil général
> - ProfileCard : La carte du profil
> - ProfileHeader : L'en-tête du profil
> - Avatar : L'image de profil avec un badge, et le nom
> - SectionTitle : Le titre d'une section
> - Skill : Une compétence, affichée dans une Card
> - ProjectCard : Un projet (nom + description), affiché dans une Card
> - Information : Un champ en lecture seule (titre + valeur)
> - Action : Le bouton d'action du profil
> - ProfileLightPreview / ProfileDarkPreview : Les previews en mode clair et sombre

#### Quel composable représente l'écran principal ?

> Profile(), appelé depuis MainActivity.

#### Où utilisez-vous un padding externe ?

> Dans MainActivity, lors de l'appel au composant Profile.

#### Où utilisez-vous un padding interne ?

> Dans ProfileCard : le Column à l'intérieur de la Surface a un padding de 20.dp, qui espace le contenu du bord de la carte.

#### Quel composant reçoit un callback ?

> Le composant Action (bouton).

#### Quelle information d'accessibilité avez-vous ajoutée ?

> - Le composant Button, qui indique à un lecteur d'écran que la zone est cliquable.
> - Le contentDescription de l'avatar, qui permet au lecteur d'écran de décrire l'image.

#### Pourquoi vos composants peuvent-ils être considérés comme réutilisables ?

> Ce sont les parents qui définissent le contenu, le style et le positionnement.
> Un composant peut être appelé plusieurs fois avec des paramètres différents, et il s'adapte.
