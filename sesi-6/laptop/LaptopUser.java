package laptop;

public abstract class LaptopUser {
    protected Laptop laptop;

    public LaptopUser(Laptop laptop) {
        this.laptop = laptop;
    }

    public void turnOnLaptop() {
        laptop.powerOn();
    }

    public void turnOffLaptop() {
        laptop.powerOff();
    }

    public void makeLaptopLouder() {
        laptop.volumeUp();
    }

    public void makeLaptopSilence() {
        laptop.volumeDown();
    }
}