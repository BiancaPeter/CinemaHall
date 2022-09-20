public class CinemaHall {
    private int numberOfRows;
    private int numberOfColons;
    private char[][] grid;

    public CinemaHall(int numberOfRows, int numberOfColons) {
        this.numberOfRows = numberOfRows;
        this.numberOfColons = numberOfColons;
        this.grid = new char[numberOfRows][numberOfColons];
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfColons() {
        return numberOfColons;
    }

    public void setNumberOfColons(int numberOfColons) {
        this.numberOfColons = numberOfColons;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }


    public void initializeGridWithEmptySeats() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColons; j++) {
                grid[i][j] = 'e';
            }
        }
    }

    public void showStatistics() {
        double percentOfOccupiedSeats;
        int amount = 0;
        int maxAmount = 0;

        int numberOfTicketsSold = getNumberOfTicketsSold();
        System.out.println("The number of tickets sold is " + numberOfTicketsSold);

        percentOfOccupiedSeats = (numberOfTicketsSold * 100) / (numberOfRows * numberOfColons);
        System.out.println("The percentage of occupied seats is " + percentOfOccupiedSeats);

        if (((numberOfRows * numberOfColons) - numberOfTicketsSold) < 60) {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColons; j++) {
                    if (grid[i][j] == 'b') {
                        amount += 10;
                    }
                }
            }
        } else {
            for (int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColons; j++) {
                    if ((grid[i][j] == 'b') && (i < numberOfRows / 2)) {
                        amount += 10;
                    } else {
                        amount += 5;
                    }
                }
            }
        }
        System.out.println("The amount obtained from the sale " + amount);

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColons; j++) {
                maxAmount += 10;
            }
        }
        System.out.println("The maximum amount that can be obtained from sales " + maxAmount);

    }

    public int getNumberOfTicketsSold() {
        int numberOfTicketsSold = 0;
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColons; j++) {
                if (grid[i][j] == 'b') {
                    numberOfTicketsSold++;
                }
            }
        }
        return numberOfTicketsSold;
    }

    public void printGrid() {
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColons; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getPrice(int row) {
        int numberOfTicketsSold = getNumberOfTicketsSold();
        if (numberOfTicketsSold <= 60) {
            System.out.println("Price of ticket is 10 ");
        } else if (row <= numberOfRows / 2) {
            System.out.println("Price of ticket is 10 ");
        } else {
            System.out.println("Price of ticket is 8 ");
        }
    }

    public void buyTicket(int row, int colon) throws InvalidSeatException {
        if (row <= numberOfRows && colon <= numberOfColons) {
            if (grid[row][colon] == 'e') {
                grid[row][colon] = 'b';
            } else {
                throw new InvalidSeatException("This seat is taken. ");
            }
        } else {
            throw new InvalidSeatException("This seat does not exist. ");
        }

    }
}
