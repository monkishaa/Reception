package hotel;
import guest.Guest;

public class Storey extends Hotel {
    private int howManyPeople;
    private Guest[] rooms;
    private double priceForRoom;

    public Storey(int storey, int howManyPeople, Guest[] rooms, double priceForRoom) {
        super(storey);
        this.setHowManyPeople(howManyPeople);
        this.setRooms(rooms);
        this.setPriceForRoom(priceForRoom);
    }

    public int getHowManyPeople() {
        return howManyPeople;
    }

    private void setHowManyPeople(int howManyPeople) {
        this.howManyPeople = howManyPeople;
    }

    public Guest[] getRooms() {
        return rooms;
    }

    private void setRooms(Guest[] rooms) {
        this.rooms = rooms;
    }

    public double getPriceForRoom() {
        return priceForRoom;
    }

    private void setPriceForRoom(double priceForRoom) {
        this.priceForRoom = priceForRoom;
    }
}
