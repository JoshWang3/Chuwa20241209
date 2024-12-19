package design_pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("Intel")
                .screen("Samsung")
                .memory("KINGSTON")
                .motherBoard("ASU")
                .build();

        System.out.println(phone.toString());
    }
}
