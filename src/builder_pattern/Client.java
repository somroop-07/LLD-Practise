package builder_pattern;

public class Client {
    public static void main(String[] args) {
    	Car car = new Car.CarBuilder("Kia Sonet", "white", "1234").setHasAirBags(true).setHasBackupCameras(true).build();
    	System.out.println(car);
    }
}
