package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Cette interface sert à faire le lien entre notre couche métier(application) et notre couche données(BDD par ex)
// Ici on fait le lien avec la classe ProductDaoImpl.
// On va faire la liste des fonctions qui vont être interfacées, on précise la fonction mais pas son contenu

@Repository // C'est ce Repository qui va nous indiquer les méthodes qui permettront de manipuler les données dans la BDD
public interface ProductDaoInterface extends JpaRepository<Product, Integer> { //JpaRepository permet d'accéder à un certain nombre de méthodes déja prédéfinies

    Product findById(int id); //Ici le findBy est une commande déjà connue de JpaRepository, on lui indique qu'ici la colonne concernée est Id.

}
