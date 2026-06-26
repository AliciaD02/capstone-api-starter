package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Product;
import org.yearup.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService
{
    ////use to communicate with the database through the product repository
    private final ProductRepository productRepository;
// this is where spring auto provides the product repo
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }
//this method searches for products using optional filters.
    public List<Product> search(Integer categoryId, Double minPrice, Double maxPrice, String subCategory)
    {
        // if the user selected a category, get product from the category.
        List<Product> products = categoryId != null
                ? productRepository.findByCategoryId(categoryId)
                // returns all products.
                : productRepository.findAll();

        // .stream lets me go through the list of products
        return products.stream()
                            // this filters products minimum price.
                       .filter(p -> minPrice == null || p.getPrice() >= minPrice)
                           // this filters products maximum price.
                       .filter(p -> maxPrice == null || p.getPrice() <= maxPrice)
                            // this filter only shows products from the selected subcategory.
                       .filter(p -> subCategory == null || subCategory.equalsIgnoreCase(p.getSubCategory()))
                // bug.
                  // This filter was saying it is only showing featured products, once I deleted it, a lot more products showed up
                      // .filter(Product::isFeatured)
                       .toList();
    }

    // this method returns all the products that belong to the category
    public List<Product> listByCategoryId(int categoryId)
    {
        //
        return productRepository.findByCategoryId(categoryId);
    }

     // this method gets a product using its id.
    public Product getById(int productId)
    {
        //the repository method to search the database for a product with the matching id(if not found it will return null.
        return productRepository.findById(productId).orElse(null);
    }
 // method creates a new product and .saves it to the database
    public Product create(Product product)
    {
        // database auto generates ids, once's it is saved
        product.setProductId(0);
        return productRepository.save(product);
    }
//
    public Product update(int productId, Product product)
    {
        //searches for the product using the id from url
        //orelsethrow- throws an exception
        Product existing = productRepository.findById(productId).orElseThrow();
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setCategoryId(product.getCategoryId());
        existing.setDescription(product.getDescription());
        existing.setSubCategory(product.getSubCategory());
        existing.setFeatured(product.isFeatured());
        existing.setImageUrl(product.getImageUrl());
        // added a stock so the product quantity updates.
        existing.setStock(product.getStock());
        return productRepository.save(existing);
    }

    public void delete(int productId)
    {
        productRepository.deleteById(productId);
    }
}
