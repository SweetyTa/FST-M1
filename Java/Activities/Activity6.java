package Activities;


public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Ram");
        plane.onboard("Shyam");
        plane.onboard("Man");
        System.out.println("Plane tookoff at: " + plane.takeOff());
        System.out.println("List of passengers: " + plane.getPassengers());
        Thread.sleep(5000);
        plane.land();
        System.out.println("Time of plane landing is:" + plane.getLastTimeLanded());
    }
}
