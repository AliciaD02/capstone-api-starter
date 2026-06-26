package org.yearup.service;

import org.springframework.stereotype.Service;
import org.yearup.models.Category;
import org.yearup.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService
{
    //We need to be able to communicate with the repository in order to communicate with the database
    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository)
    {
        this.categoryRepository = categoryRepository;
    }


    // this method will return a list of the categories from the database.
    public List<Category> getAllCategories()
    {
        //.findAll() gets all the categories from the database.
        return categoryRepository.findAll();
    }

    public Category getById(int categoryId)
    {
        // get category by id
        return categoryRepository.findById(categoryId)
                .orElse(null);
    }

    // create a new category and save it to the database.
    public Category create(Category category)
    {

          // saves the new category in the database
        //save() to store the new category, and then it returns the saved category.
        return categoryRepository.save(category);
    }

    public Category update(int categoryId, Category category)
    {
        // update category and return the updated category(save)
        category.setCategoryId(categoryId);
        //save() to store the new category.
        return categoryRepository.save(category);
    }


    // this method is void because after deleting it nothing returns.
    public void delete(int categoryId)
    {
        // this method will delete a category from the database.
        categoryRepository.deleteById(categoryId);
    }
}
