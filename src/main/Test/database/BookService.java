package database;

public class BookService {
    private int seatCount = 0;

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public boolean bookSeat(int numberOfPeople) {
        if (seatCount <= numberOfPeople) {
            seatCount -= numberOfPeople;
            return true;
        } else  {
            return false;
        }
    }
}
