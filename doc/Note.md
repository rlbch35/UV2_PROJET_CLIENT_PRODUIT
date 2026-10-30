Microservice en couche produit

| Action | Méthode | URL | RAW Data | Réponse attendu | Controle | ITEM GIT | Fonctionnel |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Créer un produit | POST | localhost:808X/api/produits | {"nom": "PC Portable", "description": "16Go RAM", "prix": 1200.0} | 201 : Created |  | 1 | OK |
| Lister les produits | GET | localhost:808X/api/produits | vide | 200 OK + Liste des produits |  | 2 | OK |
| Consulter un produit | GET | localhost:808X/api/produits/{idproduits} | vide | 200 OK + Objet produit | vérifier qu'il existe | 3 | OK sans controle |
| Supprimer un produit | DELETE | localhost:808X/api/produits/{idproduits} | vide | 204 | Vérifier qu'il existe avant suppression | 4 | OK |
| Modifier un produit | PUT | localhost:808X/api/produits/{idproduits} | {"nom": "PC Portable", "description": "16Go RAM", "prix": 1200.0} | 200 OK | Vérifier qu'il existe avant modification | 5 | OK |

| Action | Méthode | URL | RAW Data | Réponse attendu | Controle | ITEM GIT |  |
| --- | --- | --- | --- | --- | --- | --- | --- |
| Créer un client | POST | localhost:808X/api/clients | {"nom": "Dupont", "prenom": "Jean", "mail": "jean@mail.com", "telephone": "0600000000"} | 201 created |  | 6 | ok |
| Lister les clients | GET | localhost:808X/api/clients | Aucun | liste Objet client |  | 7 | OK |
| Consulter un client | GET | localhost:808X/api/clients/{idclient} | Aucun | 200 OK + un objet client | Si client existe | 8 | OK sans controle |
| Supprimer un client | DELETE | localhost:808X/api/clients/{idclient} | Aucun | 204 No content | Si client existe | 9 | OK |
| Modifier un client | PUT | localhost:808X/api/clients/{idclient} | {"nom": "Dupont", "prenom": "Jean", "mail": "jean@mail.com", "telephone": "0600000000"} | 200 OK | Si client existe | 10 |  |
| Associer un article à un client | POST | localhost:808X/api/clients/{idclient}/produits/{idproduits} | Aucun | 204 No content | si client existe, si produit existe dans le microservices | 11 |  |
| Dissocier un article à un client | DELETE | localhost:808X/api/clients/{idclient}/produits/{idproduits} | Aucun | 204 No content | si client existe, si produit existe | 12 |  |
| Lister les articles d'un client | GET | localhost:808X/api/clients/{idclient}/produits | Aucun | 200OK + liste articles | si client existe | 13 |  |


https://tomee.apache.org/jakartaee-9.0/javadoc/jakarta/ws/rs/core/Response.Status.html

https://herbertograca.com/2017/11/16/explicit-architecture-01-ddd-hexagonal-onion-clean-cqrs-how-i-put-it-all-together/

https://reflectoring.io/spring-hexagonal/

https://jivimberg.io/blog/2020/02/01/hexagonal-architecture-on-spring-boot/

