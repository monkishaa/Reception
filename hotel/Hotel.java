package hotel;

abstract class Hotel {
    private int storey;

    Hotel(int storey) {
        this.setStorey(storey);
    }

    public int getStorey() {
        return storey;
    }

    private void setStorey(int storey) {
        this.storey = storey;
    }
}
