public class Car {
    private String carNumber;
    private String model;


    //Constructer For Initializing
    public Car(String carNumber, String model) {
        this.carNumber = carNumber;
        this.model = model;
    }


    public String getCarNumber() {
        return carNumber;
    }

    public String getModel() {
        return model;
    }
}