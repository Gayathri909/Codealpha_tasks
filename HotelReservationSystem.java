import java.util.ArrayList;
import java.util.Scanner;
class Room{
    private int roomNumber;
    private String category;
    private double price;
    private boolean isBooked;
    public Room(int roomNumber,String category,double  price){
        this.roomNumber=roomNumber;
        this.category=category;
        this.isBooked=false;
        this.price=price;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public boolean isBooked(){
        return isBooked;
    }
    public void bookRoom(){
        isBooked=true;
    }
    public void displayRoomDetails(){
        System.out.println("Roomm Number:"+roomNumber+",Category:"+category+",Price:"+price+",Status:"+(isBooked?"Booked":"Available"));
    }
}
class Reservation{
    private String customerName;
    private Room room;
    private double amountPaid;
    public Reservation(String customerName,Room room,double amountPaid){
        this.customerName=customerName;
        this.room=room;
        this.amountPaid=amountPaid;
    }
    public void displayReservationDetails(){
        System.out.println("Reservation Details:");
        System.out.println("Customer Name:"+customerName);
        System.out.println("Room Number:"+room.getRoomNumber());
        System.out.println("Room Category:"+room.getCategory());
        System.out.println("Amount Paid:"+amountPaid);
    }
}
class Hotel{
    private ArrayList<Room> rooms=new ArrayList<>();
    private ArrayList<Reservation> reservations=new ArrayList<>();
    public Hotel(){
        rooms.add(new Room(101,"single",5000));
        rooms.add(new Room(102,"Double",8000));
        rooms.add(new Room(103,"single",5000));
        rooms.add(new Room(104,"Double",8000));
    }
    public void searchAvailableRooms(){
        System.out.println("\n Available Rooms:");
        for(Room room:rooms){
            if(!room.isBooked())
            room.displayRoomDetails();
        }
    }
    public void makeReservation(String customerName,int roomNumber){
        for(Room room:rooms){
            if(room.getRoomNumber()==roomNumber && !room.isBooked()){
                room.bookRoom();
                reservations.add(new Reservation(customerName,room, room.getPrice()));
                System.out.println("Room "+roomNumber+" successfully booked!");
                return;
            }
        }
        System.out.println("Room not available");
    }
    public void viewReservations(){
        if(reservations.isEmpty())
        System.out.println("No reservations made yet.");
        else{
            for(Reservation reservation:reservations){
                reservation.displayReservationDetails();
                System.out.println("--------------------------");
            }
        }
    }
}
public class HotelReservationSystem {
     public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        Hotel hotel=new Hotel();
        boolean exit=false;
        System.out.println("Welcome to the Hotel Reservation System!");
        while(!exit){
            System.out.println("\n-------Menu---------");
            System.out.println("1.Search Available Rooms");
            System.out.println("2.Make a Reservation");
            System.out.println("3.View Booking Details");
            System.out.println("4.exit");
            System.out.println("Choose an option:");
            int choice=s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:hotel.searchAvailableRooms();
                break;
                case 2:System.out.println("Enter your name:");
                String name=s.nextLine();
                System.out.println("Enter room number to book");
                int roomNumber=s.nextInt();
                hotel.makeReservation(name, roomNumber);
                break;
                case 3:hotel.viewReservations();
                break;
                case 4: System.out.println("Thankyou for using the Hotel Reservation System");
                exit=true;
                break;
                default:
                System.out.println("Invalid choice.Please try again.");
            }
        }
        s.close();
     }
}
