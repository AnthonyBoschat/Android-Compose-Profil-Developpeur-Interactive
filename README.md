# Profil développeur interactif

## Description

Mon profil de développeur en appli Android.

On peut :
- chercher un projet (nom, description ou techno) ;
- mettre un projet en favori ;
- afficher seulement les favoris ;
- afficher seulement les projets terminés.

## États gérés par l'application

- le texte de recherche ;
- les projets favoris ;
- le filtre favoris ;
- le filtre projets terminés ;
- la liste affichée.

## État local

> Quel état avez-vous conservé directement dans un composable et pourquoi ?

La position du scroll.

Elle sert seulement à l'affichage, donc pas besoin de la mettre dans le ViewModel.

## State Hoisting

> Pourquoi votre composable d'écran principal peut-il être considéré comme stateless ?

`ProfileScreen` ne garde aucun état.

Il reçoit les données en paramètres et prévient le parent avec des callbacks quand l'utilisateur fait une action.

## ViewModel

> Quel est le rôle de votre ViewModel dans cette application ?

Il garde l'état de l'écran.

Il réagit aux actions de l'utilisateur et met à jour la liste des projets affichés.

## StateFlow

> Comment l'interface est-elle informée lorsqu'un état change ?

Le ViewModel expose l'état avec un `StateFlow`.

L'écran l'écoute avec `collectAsState()`. Quand l'état change, l'écran se met à jour tout seul.

## Organisation du code

- `ProfileViewModel` : l'état et la logique.
- `ProfileUiState` : les données de l'écran.
- `ProfileContainer` : relie le ViewModel à l'écran.
- `ProfileScreen` : l'écran principal.
- `ProjectCard` : l'affichage d'un projet.

## Capture d'écran

<img width="331" height="696" alt="image" src="https://github.com/user-attachments/assets/4227f88d-4773-4894-b9bc-842bd1437664" />

