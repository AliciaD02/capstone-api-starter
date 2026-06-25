package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.CartItem;
import org.yearup.models.Product;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.repository.ShoppingCartRepository;

import java.util.List;

@Service
public class ShoppingCartService {


    // a shopping cart is built from cart rows plus a product lookup for each row
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductService productService;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository, ProductService productService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productService = productService;
    }

    public ShoppingCart getByUserId(int userId) {
        // this will get the items in the users shopping cart.
        List<CartItem> cartItems = shoppingCartRepository.findByUserId(userId);
        // load the user's cart rows, look up each product, and build the ShoppingCart
        // store the user's items
        ShoppingCart shoppingCart = new ShoppingCart();

        //goes through each item in the shopping cart
        for (CartItem cartItem : cartItems) {
            // Gets the full product info using the prduct if
            Product product = productService.getById(cartItem.getProductId());

            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setProduct(product);
            shoppingCartItem.setQuantity(cartItem.getQuantity());
            shoppingCart.add(shoppingCartItem);
        }
        // returns hte completed shopping cart.
        return shoppingCart;
    }

    // add additional methods here
}
