public class Receipt {
    public static void displayReceipt(ParkingTicket ticket, double fare, long totalHoursParked) {
        System.out.println("\nReceipt:");
        System.out.println("Ticket Number: " + ticket.getTicketNumber());
        System.out.println("Vehicle Type: " + ticket.getVehicle().getType());
        System.out.println("Entry Time: " + ticket.getEntryTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Exit Time: " + ticket.getExitTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Total Hours Parked: " + totalHoursParked);
        System.out.println("Fare: $" + fare);
    }
}
