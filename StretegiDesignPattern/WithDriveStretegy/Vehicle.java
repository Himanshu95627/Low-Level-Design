package WithDriveStretegy;

import WithDriveStretegy.stretegy.DriveStretegy;

public class Vehicle {

    public DriveStretegy driveStretegy;

    public Vehicle(DriveStretegy driveStretegy) {
        this.driveStretegy = driveStretegy;
    }

    public void drive(){
        driveStretegy.drive();
    }
}
