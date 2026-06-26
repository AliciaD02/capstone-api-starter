EasyShop API
Overview

EasyShop is a RESTful e-commerce API built using Java, Spring Boot, and MySQL.
The application allows users to browse products, search by different filters, manage categories, 
register and log into their account, update their profile, and manage a shopping cart. 
Throughout this project, I learned how to build REST APIs using a layered architecture with controllers, services, repositories, and models while following Spring Boot best practices.
Features
User Authentication
Register a new user account.
Secure login using JWT authentication.
Access protected endpoints using a Bearer Token.
Product Management
View all available products.
Search products by:
Category
Price range
Color (Subcategory)
Featured products
View individual product information.
Category Management (Admin)
View all categories.
Create a new category.
Update an existing category.
Delete a category.
User Profile
View the currently logged-in user's profile.
Update profile information, including name, email, phone number, and address.
Uses the logged-in user's token to retrieve the correct profile.
Shopping Cart
View the current user's shopping cart.
Add products to the cart.
Update the quantity of products already in the cart.
Remove all items from the shopping cart.
Automatically calculate the total price of the shopping cart.

Testing
Tested all endpoints using Insomnia.
Verified CRUD operations and authentication.
Fixed bugs by testing and debugging each endpoint individually.
Technologies Used
Java 17
Spring Boot
Spring Security
Spring Data JPA
MySQL
Maven
IntelliJ IDEA
Insomnia
Git
GitHub
Project Structure

The project follows Spring Boot's layered architecture.

Controllers

Controllers receive HTTP requests from the client and return responses after communicating with the service layer.

Classes I worked on:

CategoriesController
ProductsController
ProfileController
ShoppingCartController
Services

Services contain the application's business logic and communicate with the repositories.

Classes I worked on:

CategoryService
ProductService
ProfileService
ShoppingCartService
UserService
Repositories

Repositories communicate directly with the MySQL database using Spring Data JPA.

Classes I worked on:

ProfileRepository
ShoppingCartRepository
Models

Models represent the application's data and database tables.

Classes I worked on:

Profile
ShoppingCart
ShoppingCartItem
CartItem
Challenges

One of the biggest challenges during this project was learning how each layer of a Spring Boot application works together. At first it was difficult to understand the responsibilities of controllers, services, repositories, and models, but after building new features and fixing bugs, I became much more comfortable with the overall architecture.

Another challenge was debugging issues throughout the application. I fixed problems with product filtering, completed the User Profile feature, and implemented the Shopping Cart feature by creating GET, POST, PUT, and DELETE endpoints. I also learned how to use Insomnia to test each endpoint, which helped me find and solve issues much faster.

What I Learned

This capstone helped me better understand how a full Spring Boot application is built. I learned how to create REST API endpoints, organize code using controllers, services, repositories, and models, and work with Spring Security and JWT authentication. I also became more confident using MySQL, testing APIs with Insomnia, debugging errors, and understanding why the code works instead of only focusing on making it run.

Future Improvements

If I continue working on this project, I would like to:

Complete the Checkout feature.
Improve validation and error handling.
Add unit and integration tests.
Improve the frontend user experience.
Add order history for users.
Author

Alicia Diaz