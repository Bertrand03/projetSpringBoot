package com.ecommerce.microcommerce.controller;

// C'est ici où l'on va avoir toutes les méthodes qui répondent au URI de notre micro sercvice.

import com.ecommerce.microcommerce.dao.ProductDaoInterface;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

// On indique à Spring que c'est ici qu'on mettra nos méthodes avec RestController.
// Méthodes GET, POST, PUT, DELETE...
@RestController
public class ProductController {


    //Pour lui indiquer que l'on a une couche d'accès aux données qu'il devra instancier automatiquement
    @Autowired
    private ProductDaoInterface productDaoInterface;

    //Produits
    @GetMapping("Produits")
    public List<Product> afficheTousProduits(){
        return productDaoInterface.findAll();
    }

    //Produits/{id}

    // Méthode appelée uniquement si on reçoit une méthode de type GET
    @GetMapping(value = "Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id){ //On précise que la méthode doit prendre un paramètre "id" défini dans le GetMapping

        return productDaoInterface.findById(id);
    }

    //Pour ajouter un produit
    @PostMapping(value = "/Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product){ //ResponseEntity est une classe qui se charge d'envoyer une réponse statut code http
        Product product1 = productDaoInterface.save(product);

        // Dans le cas où ça ne marche pas : pas de produit trouvé.
        if (product == null){
            return ResponseEntity.noContent().build();
        }
        // Pour constituer l'URL du nouveau produit ajouté
        URI location = ServletUriComponentsBuilder         //Permet de créer un lien à partir d'une requête
                .fromCurrentRequest()  // A partir de la requête actuelle
                .path("/{id}")  // On prend en paramètre l'id du produit
                .buildAndExpand(product1.getId())// Permet de remplacer l'id par son contenu
                .toUri(); // commande pour dire qu'on transforme tout ça en URI

        return ResponseEntity.created(location).build(); // ".created" prend en paramètre une URI que l'on passe en paramètre puis un build pour construire.
    }
}
