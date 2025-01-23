package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> users = new HashMap<>();
        users.put(1, new User("Alice", new Address("123 Main St")));
        users.put(2, new User("Bob", null));
        users.put(3, new User("Charlie", new Address("456 Second St")));

        String street = "UNKNOWN";

        // without optional
        User user = users.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                street = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + street);

        // Optional
        street = Optional.ofNullable(users.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("UNKNOWN");
        System.out.println("Street name without Optional: " + street);
    }
}
class Address {
    private String street;

    public Address(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street;
    }
}

class User {
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
