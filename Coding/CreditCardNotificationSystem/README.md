# **Credit Card Notification System**

## **Overview**
The **Credit Card Notification System** is a modular, object-oriented Java application designed to send user notifications based on their preferences (e.g., Email, SMS, WhatsApp). It implements **SOLID principles**, ensuring extensibility, scalability, and maintainability using design patterns such as **Factory** and **Strategy**.

---

## **Key Features**
1. **Notification Types**:
    - Email
    - SMS
    - WhatsApp

2. **User Preference Handling**:
    - Sends notifications based on user preferences.
    - Defaults to **Email** in case of invalid or unsupported preferences.

3. **Error Handling**:
    - Manages unsupported notification types gracefully.

4. **Design Patterns Used**:
    - **Factory Pattern**: Dynamically creates notification objects based on user preferences.
    - **Strategy Pattern**: Decouples notification logic for each type.

---

## **Project Structure**
```plaintext
CreditCardNotificationSystem/
├── src/
│   ├── handlers/                   # Handles notification dispatch and errors
│   │   ├── NotificationErrorHandler.java
│   │   ├── NotificationHandler.java
│   │
│   ├── main/                       # Main program entry point
│   │   ├── Main.java
│   │
│   ├── models/                     # Data models
│   │   ├── NotificationContent.java
│   │   ├── User.java
│   │
│   ├── notifications/              # Notification implementations
│   │   ├── EmailNotification.java
│   │   ├── Notification.java       # Interface
│   │   ├── SMSNotification.java
│   │   ├── WhatsAppNotification.java
│   │
│   ├── utils/                      # Utility classes
│   │   ├── NotificationFactory.java
│   │
├── test/                           # Test cases
│   ├── NotificationTest.java
│
└── README.md                       # Documentation
```

## **Design Principles**

### **1. Object-Oriented Programming (OOP)**
The system uses the following OOP concepts:
- **Encapsulation**:  
   - Classes like `User` and `NotificationContent` encapsulate fields and provide public methods for access.  

- **Abstraction**:  
   - The `Notification` interface abstracts the behavior of different notification types.

- **Polymorphism**:  
   - Different notification types (`EmailNotification`, `SMSNotification`, `WhatsAppNotification`) implement the same interface, allowing polymorphic behavior.  

- **Inheritance**:  
   - Implementations of the `Notification` interface follow a common contract.

---

### **2. Design Patterns**
- **Factory Pattern**:  
   - `NotificationFactory` dynamically creates notification objects based on user preferences.  
   - Ensures easy extension for adding new notification types.

- **Strategy Pattern**:  
   - `NotificationHandler` selects the appropriate notification strategy (Email, SMS, or WhatsApp) at runtime.

- **Error Handling**:  
   - `NotificationErrorHandler` defaults to sending an Email if the user preference is unsupported or invalid.

---

## **Code Workflow**

1. **User Preference**:
   - The `User` model contains user details, including their notification preference (e.g., Email, SMS, WhatsApp).

2. **Factory Creation**:
   - `NotificationFactory` generates an instance of the appropriate notification type.

3. **Handler Logic**:
   - `NotificationHandler` calls the `send()` method of the appropriate notification implementation.

4. **Error Management**:
   - If an unsupported preference is encountered, `NotificationErrorHandler` ensures the notification is sent via **Email**.

5. **Output**:
   - The notification message is printed to the console.

---


