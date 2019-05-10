package containers;

public class Container {

    private double capacity;
    private double volume;

    public Container(double capacity) {
        if (capacity > 0.0) {
            this.capacity = capacity;
        } else {
            this.capacity = 0.0;
        }

        this.volume = 0.0;
    }


    public double getVolume() {
        return this.volume;
    }

    public double getOriginalCapacity() {
        return this.capacity;
    }

    public double getCurrentCapacity() {
        return this.capacity - this.volume;
    }

    public void addToTheContainer(double amount) {
        if (amount < 0) {
            return;
        }
        if (amount <= getCurrentCapacity()) {
            this.volume += amount;
        } else {
            this.volume = this.capacity;
        }
    }

    public double takeFromTheContainer(double amount) {
        if (amount < 0) {
            return 0.0;
        }
        if (amount > this.volume) {
            double everything = this.volume;
            this.volume = 0.0;
            return everything;
        }

        this.volume -= amount;
        return amount;
    }

    @Override
    public String toString() {
        return "volume = " + this.volume + ", free space " + getCurrentCapacity();
    }
}
