package CodingQuestions.Random.ParkingLot;

public class ParkingLot {
    int [] parkingSlot;

    public static void main(String[] args) {
        ParkingLot test = new ParkingLot(4,5);
        test.park(2);
        test.remove(2);
        test.getSlot();
    }

    public ParkingLot (int n, int m) {
        parkingSlot = new int [n];
    }

    public void park(int n) {
        if (parkingSlot[n] == 1) {
            System.out.println("Parking full" + n);
        } else {
            parkingSlot[n] = 1;
        }
    }
    public void remove (int n) {
        if (parkingSlot[n] == 1) {
            parkingSlot[n] = 0;
            System.out.println("Car" + n + "is removed from parking");
        } else {
            System.out.println(n +" not found");
        }
    }
    public void getSlot() {
        for (int i = 0; i < parkingSlot.length; i++) {
            if (parkingSlot[i] == 0) {
                System.out.println("Slot" + i +"is empty");
            }
        }
    }
}
