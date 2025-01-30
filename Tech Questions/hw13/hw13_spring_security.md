## 1. List all annotations you learned from class and homework to annotations.md
      See Tech\ Question/hw13/[spring_annotations.md](spring_annotations.md)
## 2. Explain TLS, PKI, certificate, public key, private key, and signature.
      1. TLS (Transport Layer Security)
            Definition: TLS is a cryptographic protocol that provides secure communication over a network, such as between a browser and a web server.
            Purpose: Ensures:
            Encryption: Data transmitted is encrypted, making it unreadable to attackers.
            Authentication: Verifies the identity of the parties involved (e.g., the web server is who it claims to be).
            Integrity: Guarantees that the data hasn't been tampered with during transmission.
            Example: When you visit a website using https://, TLS ensures that your data (e.g., passwords, credit card numbers) is protected.
      2. PKI (Public Key Infrastructure)
            Definition: PKI is a framework for managing public and private keys and digital certificates, enabling secure communication.
            Purpose: Provides the foundation for securely distributing and verifying public keys in a scalable way.
            Components:
             - Certificate Authority (CA): Issues digital certificates to entities, verifying their identity.
             - Registration Authority (RA): Verifies the identity of entities before a certificate is issued by the CA.
             - Certificates: Bind public keys to an entity (e.g., a website or person).
             - Public/Private Key Pairs: Used for encryption, decryption, and signing.
      3. Certificate
            Definition: A digital document issued by a CA that binds a public key to an entity, such as a website or organization.
            Purpose: Confirms the identity of the certificate holder.
            Key Contents:
             - Entity's Public Key: Used for encryption and signature verification.
             - Identity Information: Name, domain, organization, etc.
             - Issuer Information: Details of the CA that issued the certificate.
             - Validity Period: The certificate's expiration date.
             - Digital Signature: A signature from the CA, proving the certificate's authenticity.
             - Example: A website's SSL/TLS certificate ensures it's trustworthy and secure.
      4. Public Key
            Definition: A cryptographic key that is shared publicly and used in public-key cryptography.
            Purpose:
             - Encrypts data: Data encrypted with a public key can only be decrypted with the corresponding private key.
             - Verifies signatures: Checks if a digital signature was created with the corresponding private key.
            Example: A browser uses a server's public key from its certificate to establish an encrypted TLS connection.
      5. Private Key
            Definition: A cryptographic key that is kept secret and used in public-key cryptography.
            Purpose:
             - Decrypts data: Data encrypted with the public key can be decrypted only with the private key.
             - Creates signatures: Generates digital signatures that can be verified with the corresponding public key.
            Example: A web server uses its private key to decrypt data sent by the browser or to prove its identity.
      6. Digital Signature
            Definition: A mathematical scheme for verifying the authenticity and integrity of a message or document.
            How It Works:
             - Signing: The sender hashes the message and encrypts the hash using their private key.
             - Verification: The receiver decrypts the signature using the sender’s public key and compares the hash to the hash of the received message.
            Purpose:
             - Authenticity: Ensures the message was sent by the claimed sender.
             - Integrity: Verifies that the message hasn't been altered in transit.
            Example: A CA uses its private key to digitally sign a certificate, proving it is trustworthy.
## 3. Write a Spring security based application, which provides https APIs (one simple get controller with empty response is good enough )instead of http, please generate a self-signed certificate to make your https TLS verification work.
      Tutorial: https://www.baeldung.com/spring-channel-security-https 
      see Coding/hw13/redbook/
      1. Pack your self-signed certificate in the form of jks file, as part of your application, name it properly
        see Coding/hw13/redbook/src/main/resources/mykeystore.jks
      2. Test if you can verify your HTTPs api without importing the self-signed certificate to your local
         certificate chain, if not, explain why.
        No. See Tech\ Question/hw13/hw13_3_1.png. The browser will show a warning "Your connection is not private". 
        If you proceed by clicking "Advanced" or an equivalent option, you can still access the endpoint, but the certificate remains unverified.
        Reason: 
            - Self-Signed Certificates Are Untrusted by Default:
                A self-signed certificate isn't issued by a trusted Certificate Authority (CA), so clients (like browsers or curl) cannot verify its authenticity.
                Trusted root certificates (used to verify other certificates) are pre-installed in client systems, but your self-signed certificate is not part of this chain.
            - TLS Verification Process:
                When a client connects to an HTTPS server, it checks the server’s certificate against a list of trusted root certificates in its trust store.
                If the server's certificate is not issued by a trusted CA or doesn't chain back to a trusted root certificate, the verification fails.
      3. Explain what did you do to make https call work, do NOT bypass TLS/SSL verification in Postman (this is cheating)!
        To verify the HTTPS API without errors, you need to import the self-signed certificate into the client's trust store.
        1. Export the Certificate from the Keystore Use the keytool command to export the certificate from your .jks file:
            keytool -exportcert -alias selfsigned -file selfsigned.crt -keystore mykeystore.jks
        2. Import into Local Computer's certificat stores
        See ech\ Question/hw13/hw13_3_3.png
## 4. list all http status codes that related to authentication and authorization failures.
      1. 401 Unauthorized - The client has not authenticated, or the authentication credentials are invalid.
      2. 407 Proxy Authentication Required - The client must authenticate with a proxy before accessing the requested resource.
      3. 403 Forbidden - The server understands the request but refuses to authorize it. (The user does not have sufficient permissions to access the resource.)
      4. 400 Bad Request - The request is malformed, which may include invalid credentials.
      5. 429 Too Many Requests - he client has sent too many requests in a given time.
      6. 419 Page Expired (Non-Standard) -  A session token or CSRF token has expired.
## 5. Compare authentication and authorization? Name and explain important components in Spring security that undertake authentication and authorization
| Aspect             | Authentication                                         | Authorization                                                             |
|--------------------|--------------------------------------------------------|---------------------------------------------------------------------------|
| Definition	        | Process of verifying the identity of a user or system. | 	Process of granting or denying access to resources based on permissions. |
| Purpose	           | Confirms "Who are you?"                                | 	Determines "What are you allowed to do?"                                 |
| Input	             | Credentials such as username and password, or tokens.	 | Roles, permissions, or policies defined for authenticated users.          |
| When it Happens    | 	Happens before authorization.	                        | Happens after authentication is successful.                               |
| Result of Failure	 | 401 Unauthorized (client is unauthenticated).	         | 403 Forbidden (client lacks sufficient permissions).                      |
| Example            | 	Logging into an application with valid credentials.	  | Accessing admin-only pages after logging in as a regular user.            |
    1. Authentication
       Authentication is handled through components that validate the user’s identity.
        - AuthenticationManager
            Purpose: Central interface for authenticating user credentials.
            How It Works:
                Receives an Authentication object with credentials.
                Checks the credentials using a configured AuthenticationProvider.
                Returns a fully authenticated Authentication object if successful.
        - AuthenticationProvider
            Purpose: Validates user credentials against a specific data source (e.g., database, LDAP).
            Common Implementations:
                DaoAuthenticationProvider: Checks user credentials stored in a database using UserDetailsService.
                LdapAuthenticationProvider: For LDAP-based authentication.
                Custom Providers: You can create a custom AuthenticationProvider for non-standard credential verification.
        - UserDetailsService
            Purpose: Loads user details from a data source (e.g., database).
            How It Works:
                Fetches a UserDetails object by username.
                UserDetails contains information like username, password, and roles.
            Custom Implementation: You can override UserDetailsService to customize user retrieval logic.
        - SecurityContextHolder
            Purpose: Stores the Authentication object for the currently authenticated user.
            How It Works:
                Holds the Authentication in a thread-local storage.
            This allows access to authentication data across the application during the request lifecycle.
```java
package com.example.auth.config;

import com.example.auth.provider.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .antMatchers("/public/**").permitAll() // Public endpoint
                .antMatchers("/user/**").hasRole("USER") // Secured endpoint for USER role
                .anyRequest().authenticated() // All other endpoints require authentication
            )
            .formLogin(form -> form
                .permitAll() // Enable form-based login
            )
            .logout(logout -> logout
                .permitAll() // Enable logout functionality
            );

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(CustomAuthenticationProvider customAuthenticationProvider) {
        // Register the custom AuthenticationProvider
        return new ProviderManager(Collections.singletonList(customAuthenticationProvider));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```
```java
package com.example.auth.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;

    // Simulated in-memory user database
    private final List<User> users = new ArrayList<>();

    public CustomAuthenticationProvider(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        // Add some test users
        users.add(new User("user", passwordEncoder.encode("password"), "ROLE_USER"));
        users.add(new User("admin", passwordEncoder.encode("admin123"), "ROLE_ADMIN"));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // Validate user credentials
        User user = users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new BadCredentialsException("Invalid username or password"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid username or password");
        }

        // Create and return an authenticated token
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRole()));
        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    // Helper class to represent a user
    private static class User {
        private final String username;
        private final String password;
        private final String role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }
    }
}
```
    2. Authorization
        Authorization ensures that authenticated users can access resources based on their permissions.
        - AccessDecisionManager
            Purpose: Makes final decisions on whether a user has access to a resource.
            How It Works:
                Evaluates access rules defined for a resource.
            Uses AccessDecisionVoter to make a decision (e.g., grant or deny access).
        - GrantedAuthority
            Purpose: Represents permissions or roles assigned to the user.
            How It Works:
                Each user has a collection of GrantedAuthority objects.
            Example: Roles like ROLE_ADMIN or ROLE_USER.
        - PreAuthorize/PostAuthorize Annotations
            Purpose: Used to apply method-level authorization.
        - FilterSecurityInterceptor
            Purpose: Intercepts HTTP requests and enforces access control rules.
            How It Works:
                Uses SecurityMetadataSource to fetch metadata (e.g., role requirements for URLs).
            Delegates to AccessDecisionManager to decide whether access should be granted.
## 6. Explain HTTP Session?
    An HTTP session is a way to persist user data across multiple requests in the inherently stateless HTTP protocol. 
    It allows web servers to remember who the user is and maintain information such as authentication status, user preferences, 
    and shopping cart details throughout a user's interaction with a web application.
    Session Creation:
        When a user interacts with a web application for the first time (e.g., logging in), the server generates a session ID.
        The session ID is a unique identifier for that particular user’s session.
    Session Tracking:
        The session ID is sent back to the client and stored, usually in:
        Cookies (default method in most frameworks, including Spring).
        URL parameters (less secure and rarely used now).
    Hidden fields in forms.
        For subsequent requests, the client sends the session ID back to the server, allowing the server to retrieve the session data.
    Session Store:
        The server maintains a session store (often in memory, a database, or a distributed cache) to map session IDs to session data.
## 7. Explain Cookie?
    A cookie is a small piece of data stored on a user's device (browser) by a website. 
    Cookies enable websites to remember information about the user across multiple requests, providing a way to add state to the stateless HTTP protocol.
    - Set by the Server:
        When a user visits a website, the server sends a cookie to the user's browser as part of the HTTP response. The browser stores this cookie locally.
    - Sent by the Browser:
        For subsequent requests to the same domain, the browser includes the cookie in the HTTP headers of the request.
    - Persistent or Temporary:
        Some cookies expire when the browser is closed (session cookies).
        Others have a specified expiration time and persist across browser sessions (persistent cookies).
## 8. Compare Session and Cookie?
| Feature      | 	Cookie                                            | 	Session                                   |
|--------------|----------------------------------------------------|--------------------------------------------|
| Data Storage | 	Stored on the client (browser).	                  | Stored on the server.                      |
| Lifetime	    | Can persist across sessions (persistent cookies).	 | Exists until the session expires.          |
| Security	    | Vulnerable if stored insecurely.	                  | More secure (data stays on the server).    |
| Size Limit   | 	Typically limited to 4KB per cookie.	             | Server-side storage has no such limit.     |
| Use Case	    | Save lightweight client-side data.                 | Store sensitive or large server-side data. |
## 9. Find at least TWO websites who can be logged in using your Google Account, explain in detail on how Google SSO works with screenshots like below, find SSO-related Rest calls in Chrome developer tool:
    1. Gmail
    2. Spotify
    3. How it works:
        - User clicks "Log in with Google":
            The user navigates to a service (like Spotify or Gmail) and clicks the "Log in with Google" button.
        - Redirect to Google Authentication:
            The application redirects the user to Google's authentication page, where they must grant permission for the service to access their Google profile information.
            If the user is already signed in to Google, the authentication process is skipped, and they are asked to consent to any requested permissions.
        - Google Redirects Back to the App:
            After the user grants permission, Google redirects them back to the application, providing an authorization code.
        - Application Exchanges the Code for Tokens:
            The application sends the authorization code to Google's token endpoint to receive an ID Token and Access Token.
            The ID token contains user information (e.g., name, email) in a securely signed format, while the access token is used to make authorized API requests on behalf of the user.
        - User Logged In:
            The application uses the ID token to identify the user and grant access to its services.
    4. Calls:
        https://accounts.google.com
## 10. How do we use session and cookie to keep user information across the application?
    Many Server -- distributed session storage 
| Feature      | 	Cookie                                            | 	Session                                   |
|--------------|----------------------------------------------------|--------------------------------------------|
| Data Storage | 	Stored on the client (browser).	                  | Stored on the server.                      |
| Lifetime	    | Can persist across sessions (persistent cookies).	 | Exists until the session expires.          |
| Security	    | Vulnerable if stored insecurely.	                  | More secure (data stays on the server).    |
| Size Limit   | 	Typically limited to 4KB per cookie.	             | Server-side storage has no such limit.     |
| Use Case	    | Save lightweight client-side data.                 | Store sensitive or large server-side data. |
## 11. What is the spring security filter?
    Spring Security uses a filter chain—a sequence of filters that are executed in a defined order for each incoming HTTP request. 
    Each filter in the chain can examine or modify the request and response, and decide whether to allow or deny the request or pass it to the next filter in the chain.
    Key Characteristics of Spring Security Filters:
        Request Interception: Filters intercept HTTP requests before they reach the servlet and perform security-related processing on the request.
        Chain of Responsibility: Filters are arranged in a chain, and each filter can either pass the request to the next filter or terminate the request by sending a response back to the client.
        Security Operations: Filters typically perform tasks like authentication, authorization, CSRF protection, session management, and more.
    Common Spring Security Filter Chain Sequence:
        By default, Spring Security applies the following filters in this sequence:
            - SecurityContextPersistenceFilter: Initializes the security context for the request.
            - LogoutFilter: Handles the logout process.
            - UsernamePasswordAuthenticationFilter: Processes username/password authentication.
            - BasicAuthenticationFilter: Handles HTTP Basic Authentication.
            - CsrfFilter: Protects against CSRF attacks.
            - ExceptionTranslationFilter: Handles security-related exceptions.
            - FilterSecurityInterceptor: Final filter that performs authorization checks.
    Example:
```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/api/**").authenticated())
            .httpBasic(withDefaults())
            .build();
}
```    
## 12. Explain bearer token and how JWT works.
    1. A Bearer Token is a credential that allows the bearer (the client or user) to authenticate and authorize a request without needing to send the user’s credentials (like username and password) every time.
    2. JWT (JSON Web Token) is an open standard (RFC 7519) that defines a compact and self-contained method for securely transmitting information between parties as a JSON object. 
        It is widely used for authentication and authorization, particularly in stateless applications and single sign-on (SSO) systems.
        A JWT consists of three parts, separated by periods (.):
            - Header: Contains metadata about the token, such as the algorithm used to sign the token (e.g., HS256, RS256).
            - Payload: Contains the claims, which are the statements about an entity (usually the user) and additional metadata. Claims can be:
                - Registered Claims (like sub for subject, iat for issued at, exp for expiration time).
                - Public Claims (claims that can be defined by the user).
                - Private Claims (custom claims between the parties).
            - Signature: Ensures that the token has not been tampered with. The signature is created by combining the encoded header and payload, then signing it with a secret key or private key.
## 13. Explain how do we store sensitive user information such as password and credit card number in DB?
    1. Storing Passwords
        Hashing and Salting Passwords
            - Hashing is a one-way cryptographic function that converts the password into a fixed-length string of characters (the hash). Hashing makes it nearly impossible to recover the original password from the hash.
            - Salting involves adding a unique random value (a "salt") to each password before hashing. This prevents attackers from using precomputed hash tables (like rainbow tables) to reverse the hash.
        Steps to Securely Store Passwords:
            - Choose a strong cryptographic hash function (e.g., bcrypt, PBKDF2, or Argon2). These functions are designed to be slow, which makes brute-force attacks harder.
            - Generate a unique salt for each password. The salt should be long and random. Many modern password hashing algorithms, such as bcrypt, handle salting internally, so you don’t need to manually add the salt.
            - Hash the password with the salt using the chosen hashing algorithm. The result will be a unique hash for each password, even if two users have the same password.
            - Store the salt and hash in the database. Ensure the salt and hash are securely stored (in separate columns, for example).
```java
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class SaltedPasswordStorage {

    // Method to generate a random salt
    private static byte[] generateSalt() throws Exception {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[16]; // Salt length is 16 bytes
        secureRandom.nextBytes(salt);
        return salt;
    }

    // Method to hash the password with salt
    private static String hashPasswordWithSalt(String password, byte[] salt) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); // Use SHA-256 for hashing
        messageDigest.update(salt); // Apply the salt
        byte[] hashedPassword = messageDigest.digest(password.getBytes()); // Hash the password with the salt
        return Base64.getEncoder().encodeToString(hashedPassword); // Convert to Base64 string for storage
    }

    // Main method to demonstrate storing a salted password
    public static void main(String[] args) throws Exception {
        String password = "mySuperSecretPassword"; // The user's plain password

        // Step 1: Generate a random salt
        byte[] salt = generateSalt();

        // Step 2: Hash the password with the salt
        String hashedPassword = hashPasswordWithSalt(password, salt);

        // Step 3: Store the salt and hashed password (we'll print them here for demonstration)
        System.out.println("Salt (Base64): " + Base64.getEncoder().encodeToString(salt));
        System.out.println("Hashed Password (Base64): " + hashedPassword);

        // Step 4: In a real application, store the salt and hashed password in the database
    }
}
```
    2. Storing Credit Card
        Steps to Securely Store Credit Card Numbers:
        - Encrypt the Credit Card Data:
            Use strong encryption to protect credit card numbers. AES (Advanced Encryption Standard) with a key length of at least 256 bits is recommended for encrypting sensitive data at rest.
            Always use secure key management to manage encryption keys. This ensures that the keys are protected and not stored alongside the encrypted data.
        - Tokenization:
            Instead of storing the full credit card number, consider using tokenization, which replaces the actual credit card number with a token. The token can be used for transactions but has no value outside the system.
            Tokenization reduces the scope of PCI DSS compliance, as the token is useless without access to the tokenization system.
        - Limit Access to Sensitive Data:
            Restrict access to credit card information based on user roles and use access controls to prevent unauthorized access.
            Only allow access to encrypted credit card data when it's necessary (e.g., during a payment transaction).
        - Use a Secure Payment Gateway:
            It's often recommended to use a trusted third-party payment gateway to handle credit card transactions. This way, your application doesn't need to store or process sensitive card information directly, reducing the security risks.
```java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class CreditCardEncryptionExample {

    public static void main(String[] args) throws Exception {
        String creditCardNumber = "1234-5678-9876-5432";

        // Generate AES key
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // 256-bit AES key
        SecretKey secretKey = keyGenerator.generateKey();

        // Encrypt the credit card number
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(creditCardNumber.getBytes());

        // Convert the encrypted bytes to Base64 to store in the database
        String encryptedCreditCard = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Credit Card: " + encryptedCreditCard);
    }
}
```
## 14. Compare UserDetailService, AuthenticationProvider, AuthenticationManager, AuthenticationFilter?
    1. UserDetailsService
        Role: The primary interface for loading user-specific data during the authentication process.
        Purpose: It is responsible for retrieving user details from a data source (e.g., a database or LDAP). The UserDetailsService interface is typically implemented to retrieve a user's information (like username, password, roles) and return a UserDetails object.
        Main Methods:
            loadUserByUsername(String username): This method is used to fetch user details based on the provided username. It is called by AuthenticationManager during authentication.
        Usage: Typically, a custom implementation of UserDetailsService will interact with a database or an external service to load the user's information.
```java
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }
}
```
    2. AuthenticationProvider
        Role: Used for authenticating a user by validating the provided credentials.
        Purpose: An AuthenticationProvider is responsible for validating the user’s credentials (like username and password) during authentication. It can be configured to work with multiple authentication mechanisms, such as in-memory authentication, database authentication, or LDAP authentication.
        Main Methods:
            authenticate(Authentication authentication): This method is used to perform the actual authentication. It checks the validity of the credentials (e.g., password matching, role checking).
            supports(Class<?> authentication): This method is used to check if the provider supports the type of authentication being passed.
        Usage: Spring Security typically uses AuthenticationProvider to authenticate users against a data store (like a database). If you need custom authentication logic (e.g., validating credentials using a third-party service), you can create a custom implementation of AuthenticationProvider.
```java
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        
        // Validate password (can add custom logic here)
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }
        
        // Return the authenticated token
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
```
    3. AuthenticationManager
        Role: The central component that coordinates the authentication process.
        Purpose: 
            AuthenticationManager is responsible for managing the authentication logic. 
            It typically delegates the actual authentication process to an AuthenticationProvider to check the validity of credentials. 
            It’s the main interface for authenticating users.
        Main Methods:
            authenticate(Authentication authentication): This method attempts to authenticate the user by calling the authenticate method of the AuthenticationProvider(s).
        Usage: AuthenticationManager is configured in the SecurityConfig class and used by AuthenticationFilter (or similar filters) to authenticate users during HTTP requests. It can delegate authentication to multiple AuthenticationProvider beans.
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin();
    }
}
```
    4. AuthenticationFilter
        Role: A filter that intercepts HTTP requests and triggers authentication.
        Purpose: 
            The AuthenticationFilter (e.g., UsernamePasswordAuthenticationFilter) is responsible for intercepting HTTP requests and performing authentication 
            when a user attempts to log in. It takes the credentials (username and password) from the request (typically from a form or token), 
            and passes them to the AuthenticationManager for validation.
        Main Methods:
            doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain): This method intercepts the request, extracts credentials, and initiates authentication using AuthenticationManager. It also proceeds with the request chain after authentication is complete.
        Usage: You can configure AuthenticationFilter in your Spring Security configuration to intercept authentication requests, like form submissions, and authenticate the user.
```java
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        return getAuthenticationManager().authenticate(authRequest);
    }
}
```
## 15. What is the disadvantage of Session? how to overcome the disadvantage?
    Scalability Issues:
        Description: Session data is typically stored on the server (in-memory or in a database), and this can lead to scalability problems as the application grows. 
            Each new request requires the server to retrieve and manage the session data, which can become a bottleneck.
        Cause: If you're running your application across multiple instances (e.g., in a clustered or distributed environment), 
            managing sessions across multiple servers can be difficult and inefficient.
        Solution:
            1. Distributed Session Management -- Redis to store sessions
            2. Use Stateless Authentication (JWT): all authentication information is stored in a token that is sent with each request, and no session data is stored on the server. 
    Server Memory Consumption:
        Description: Storing session data on the server requires memory, and if you have many active users or large sessions, 
            this can quickly consume server resources, affecting performance.
        Cause: Sessions often store user-specific data, which can grow significantly in size, especially if large objects are stored (e.g., shopping carts, user preferences).
        Solution: Store only necessary and small amounts of data in the session to minimize memory consumption. 
    Session Timeout and Expiration:
        Description: Sessions can expire after a certain time of inactivity, which can cause users to lose their data unexpectedly if the session times out.
        Cause: Sessions are managed on the server, and the server must track when a session was last used. 
            This can create an additional challenge of configuring session timeouts properly.
        Solution: Implement proper session timeout policies and configure them according to your application's needs. You can configure session timeout in Spring Security or in your application server 
    Session Fixation Attack:
        Description: If session IDs are predictable or can be intercepted, an attacker can exploit this and impersonate a legitimate user. 
            Session fixation happens when an attacker sets a user's session ID, and then the user unknowingly authenticates with the attacker’s session.
        Cause: This occurs if session IDs are not generated securely or if sessions are not properly invalidated after login.
        Solution: Secure the session ID and always use HTTPS to prevent interception of session data. Additionally, regenerate session IDs after user login to prevent session fixation attacks.
    Session Hijacking:
        Description: If session data is not transmitted securely over HTTPS or if a session ID is intercepted, 
            an attacker can hijack the session and perform actions on behalf of the legitimate user.
        Cause: When session data is sent over insecure connections (e.g., HTTP instead of HTTPS), attackers can intercept session IDs via man-in-the-middle (MITM) attacks.
        Solution: Secure the session ID and always use HTTPS to prevent interception of session data. Additionally, regenerate session IDs after user login to prevent session fixation attacks.
## 16. How to get value from application.properties in Spring security?
    @Value Annotation: Used to inject individual property values into Spring beans.
    @ConfigurationProperties: Used to bind a group of related properties into a Java object for cleaner and more maintainable code.
    Environment: Provides programmatic access to properties at runtime.
```java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.login-url}")
    private String loginUrl;

    @Value("${security.logout-url}")
    private String logoutUrl;

    @Value("${security.default-role}")
    private String defaultRole;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers(loginUrl).permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage(loginUrl)
            .and()
            .logout()
                .logoutUrl(logoutUrl)
            .and()
            .csrf().disable();
    }
}

@Component
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private String loginUrl;
    private String logoutUrl;
    private String defaultRole;

    // Getters and setters

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getLogoutUrl() {
        return logoutUrl;
    }

    public void setLogoutUrl(String logoutUrl) {
        this.logoutUrl = logoutUrl;
    }

    public String getDefaultRole() {
        return defaultRole;
    }

    public void setDefaultRole(String defaultRole) {
        this.defaultRole = defaultRole;
    }
}

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements EnvironmentAware {

    private Environment environment;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String loginUrl = environment.getProperty("security.login-url");
        String logoutUrl = environment.getProperty("security.logout-url");

        http
                .authorizeRequests()
                .antMatchers(loginUrl).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(loginUrl)
                .and()
                .logout()
                .logoutUrl(logoutUrl)
                .and()
                .csrf().disable();
    }
}
```
## 17. What is the role of configure(HttpSecurity http) and configure(AuthenticationManagerBuilder auth)?
    1. configure(HttpSecurity http)
        This method is used to configure HTTP security settings, such as:
            Securing URLs with authentication and authorization rules.
            Enabling form-based login, basic authentication, or other authentication mechanisms.
            Configuring session management.
            Configuring security-related headers like CSRF, CORS, and others.
        You use this method to customize how the application handles HTTP requests and applies security policies.

        Common Configurations in configure(HttpSecurity http):
            URL-based Authorization: You can define which URLs should be publicly accessible or require authentication.
            Login Configuration: You can set up custom login forms, login URLs, or use default Spring Security login mechanisms.
            Logout Configuration: You can define custom logout URLs or actions after logout.
            CSRF Protection: You can enable or disable Cross-Site Request Forgery protection.
            Session Management: You can define session timeout policies or use stateless authentication (e.g., JWT).
```java
@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/public/**").permitAll() // Allow access to public URLs
            .anyRequest().authenticated()         // Require authentication for all other URLs
        .and()
        .formLogin()                              // Enable form-based login
            .loginPage("/login")                  // Custom login page
            .permitAll()                          // Allow anyone to access the login page
        .and()
        .logout()                                 // Enable logout
            .permitAll();                        // Allow anyone to logout
}
```
    2. configure(AuthenticationManagerBuilder auth)
        This method is used to configure authentication mechanisms, specifically how Spring Security will authenticate users (i.e., how credentials are validated). You can set up different authentication providers (e.g., in-memory, JDBC, LDAP, custom authentication provider).
        Common Configurations in configure(AuthenticationManagerBuilder auth):
            In-memory Authentication: You can define users with roles directly in memory.
            JDBC Authentication: You can configure Spring Security to authenticate users using a relational database.
            Custom Authentication: You can define custom authentication logic by implementing your own AuthenticationProvider.
            Password Encoding: You can specify how passwords are encoded (e.g., using BCrypt).
```java
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
        .jdbcAuthentication()
            .dataSource(dataSource)        // Provide the data source to query the DB
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
            .authoritiesByUsernameQuery("SELECT username, role FROM user_roles WHERE username=?")
            .passwordEncoder(passwordEncoder()); // Define a password encoder (e.g., BCrypt)
}
```
## 18. Reading, 泛读⼀下即可，⾃⼰觉得是重点的，可以多看两眼。https://www.interviewbit.com/spring-security-interview-questions/#is-security-a-cross-cutting-concern
    1. 1-12
    2. 17 - 30