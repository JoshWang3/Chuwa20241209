package com.example.hw11project;

import com.example.hw11project.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw11ProjectApplication implements CommandLineRunner {

	@Autowired
	private NotificationClient notificationClient;

	@Autowired
	private ConstructorInjectionClient constructorInjectionClient;

	@Autowired
	private SetterInjectionClient setterInjectionClient;

	@Autowired
	private FieldInjectionClient fieldInjectionClient;

	@Autowired
	private ServiceClient serviceClient;

	public static void main(String[] args) {
		SpringApplication.run(Hw11ProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Demonstrating Constructor Injection:");
		constructorInjectionClient.process("Hello via Constructor Injection!");

		System.out.println("\nDemonstrating Setter Injection:");
		setterInjectionClient.process("Hello via Setter Injection!");

		System.out.println("\nDemonstrating Field Injection:");
		fieldInjectionClient.process("Hello via Field Injection!");

		/**
		 * Demonstrating Constructor Injection:
		 * Email Notification Sent: Hello via Constructor Injection!
		 *
		 * Demonstrating Setter Injection:
		 * Email Notification Sent: Hello via Setter Injection!
		 *
		 * Demonstrating Field Injection:
		 * Email Notification Sent: Hello via Field Injection!
		 */



		System.out.println("Dependency Injection Demo:");

		System.out.println("\nSending Default Notification:");
		notificationClient.sendDefaultNotification("Hello via Default Service!");

		System.out.println("\nSending Email Notification:");
		notificationClient.sendEmailNotification("Hello via Email Service!");

		System.out.println("\nSending SMS Notification:");
		notificationClient.sendSMSNotification("Hello via SMS Service!");

		System.out.println("\nListing All Available Services:");
		notificationClient.printAllNotifications(null);

		/**
		 * Dependency Injection Demo:
		 *
		 * Sending Default Notification:
		 * Email Notification Sent: Hello via Default Service!
		 *
		 * Sending Email Notification:
		 * Email Notification Sent: Hello via Email Service!
		 *
		 * Sending SMS Notification:
		 * SMS Notification Sent: Hello via SMS Service!
		 *
		 * Listing All Available Services:
		 * Available Notification Services:
		 * - EmailNotification
		 * - SMSNotification
		 */



		serviceClient.printMessages();
		/**
		 * Message from ComponentService
		 * Message from BeanService
		 */


	}
}
