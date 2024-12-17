# WonderBoot
### A Travel social network web app, made in spring boot

### Docker 
The Docker file has been configured.
Now, to build the image of our application, run the following command:

    docker build -t wonderboot .

Finally, to run the image, use the following command:

    docker run -d -p 8080:8080 wonderboot


## Features Implemented

### 1. **User Registration**
- **HTML Form**:
    - Includes fields for `username`, `name`, `surname`, `email`, `password`, `repeat password`, and `date of birth`.
    - Form validation is implemented with annotations in the `RegistrationUserDTO` class.
- **Back-end Logic**:
    - Passwords are encoded using Argon2 for security.
    - Data is saved to a relational database using JPA.
    - `WonderbootUserRepository` interface provides CRUD operations for user data.

### 2. **User Login**
- **HTML Form**:
    - Simple login page to authenticate users using a `username` and `password`.
    - Redirects to the registration page if the user is not signed up.
- **Spring Security Integration**:
    - `CustomUserDetails` service fetches user information from the database.
    - Encoded passwords are verified against user input.

### 3. **Front-End**
- **Thymeleaf Templates**:
    - Dynamic HTML pages for user registration (`signup.html`) and login (`login.html`).
    - Templates styled with CSS stored in `src/main/resources/static/css`.
- **Responsive UI**:
    - Login and registration forms are styled for a clean and user-friendly design.

### 4. **Back-End**
- **Spring Security**:
    - Secures the application using a custom `SecurityConfig`.
    - Only the `/login` and `/signup` endpoints are accessible without authentication.
- **DTO and Entity Separation**:
    - Data transfer is handled using the `RegistrationUserDTO` class, which separates validation from the entity `WonderbootUser`.

---

## Project Structure

```plaintext
src/
├── main
│   ├── java
│   │   └── com
│   │       └── marcosfa
│   │           └── wonderboot
│   │               ├── WonderbootApplication.java
│   │               ├── authentication
│   │               │   └── login
│   │               │       └── CustomUserDetails.java
│   │               ├── config
│   │               │   └── SecurityConfig.java
│   │               ├── web
│   │               │   └── registration
│   │               │       ├── RegistrationController.java
│   │               │       ├── WonderbootUser.java
│   │               │       ├── WonderbootUserRepository.java
│   │               │       └── dto
│   │               │           └── RegistrationUserDTO.java
│   └── resources
│       ├── static
│       │   ├── css
│       │   │   └── login_signup_styles.css
│       │   └── img
│       ├── templates
│       │   ├── login.html
│       │   └── signup.html
└── test
    └── java
        └── com
            └── marcosfa
                └── wonderboot
                    └── WonderbootApplicationTests.java
```
