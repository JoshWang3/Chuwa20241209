## **Problem :**

**Credit Card Notification.**

We need to send notifications to users by notification preference like email/SMS, etc., handle errors appropriately when the preference given does not match. Write a simple Java program using design patterns, program to interface, and error handling concepts to solve the above problem.

- **Notification type**: email/SMS/WhatsApp
- **Call notification module to send notification**
- **Integrate with notification module to notify depending on preference**  
   - If A prefers EMAIL, then we notify A by EMAIL  
- **Pass user details and other data points to send email**  
   - **Notification content**:  
      - Hey firstName, you have successfully registered to add and here is your, please use this for future references.  
- **Broadcast public notification to all users**  
   - 40% off when you buy Popeyes between 06/13 - 06/19