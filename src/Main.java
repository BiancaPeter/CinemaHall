public class Main {
    public static void main(String[] args) {
        CinemaHall cinemaHall = new CinemaHall(10, 10);
        cinemaHall.initializeGridWithEmptySeats();
        cinemaHall.printGrid();
        cinemaHall.showStatistics();
        cinemaHall.getPrice(4);

        try {
            cinemaHall.buyTicket(2, 3);
        } catch (InvalidSeatException e) {
            System.out.println(e.getMessage());
        }
        cinemaHall.printGrid();

        try {
            cinemaHall.buyTicket(2, 3);
        } catch (InvalidSeatException e) {
            System.out.println(e.getMessage());
        }

        try {
            cinemaHall.buyTicket(12, 3);
        } catch (InvalidSeatException e) {
            System.out.println(e.getMessage());
        }
    }
}
