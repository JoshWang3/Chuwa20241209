2. Explain TLS, PKI, certificate, public key, private key, and signature.
> TLS/SSl, transport layer security, a protocol to secure communication, encrypt data between a server and a client
> PKI is the system that manages digital certificates, use CAs to verify public keys.
> certificate: A digital document that binds a public key to an entity (like a website or individual). It's like an official ID card for the public key. Prove identity. contain public key and is signed by CA.
> public key, encrypt data, shared with everyone
> private key, decrypt data, kept secret
> digital signature, verify authenticity, use private key to sign messages.
3. Write a Spring security based application, which provides https APIs (one simple get controller with empty
   response is good enough )instead of http, please generate a self-signed certificate to make your https
   TLS verfication work.
1. Pack your self-signed certificate in the form of jks file, as part of your application, name it properly
2. Test if you can verify your HTTPs api without importing the self-signed certificate to your local
   certificate chain, if not, explain why.
3. Explain what did you do to make https call work, do NOT bypass TLS/SSL verfication in Postman (this
   is cheating)!
   Tutorial: https://www.baeldung.com/spring-channel-security-https
4. list all http status codes that related to authentication and authorization failures.
> 401 unauthorized
> 403 forbidden, authenticated but no access
> 419 authentication timeout
> 405 method not allowed
5. Compare authentication and authorization? Name and explain important components in Spring
   security that undertake authentication and authorization
> authentication - who you are, Oauth, JWT, password, 401
> authorization - what you can do, policies, api permissions, 403
> authentication manager, userDetailService, authorization manager, JWT filter, security context
> Authentication is handled by components like AuthenticationManager, AuthenticationProvider, and UserDetailsService.
>Authorization is managed by components like AccessDecisionManager, AccessDecisionVoter, and FilterSecurityInterceptor.
>Filters and annotations provide additional layers of security for web requests and method-level access control.
6. Explain HTTP Session?
> A way to track user interactions across multiple requests. It allows server to store user-specific data temporarily.
> Sessions are server-side storage mechanisms.
> Session data is typically stored in memory, a database, or a distributed cache (e.g., Redis).
> Sessions are used to maintain state in stateless HTTP protocols.
7. Explain Cookie?
> A cookie is a small piece of data stored on the client's browser.
> It is sent by the server to the browser and is included in subsequent requests to the same domain.
8. Compare Session and Cookie?
>When a user visits a website, the server creates a unique session ID for that user.
The session ID is stored on the server and sent to the client (browser) as a cookie.
The browser sends the session ID back to the server with each subsequent request.
The server uses the session ID to retrieve the user's session data.
Limited to 4KB per cookie
Use sessions for sensitive data (e.g., user credentials).
Use cookies for non-sensitive data (e.g., user preferences).
>
9. Find at least TWO websites who can be logged in using your Google Account, explain in detail on how
   Google SSO works with screenshots like below, find SSO-related Rest calls in Chrome developer tool: