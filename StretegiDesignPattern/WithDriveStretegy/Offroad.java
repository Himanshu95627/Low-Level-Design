package WithDriveStretegy;

import WithDriveStretegy.stretegy.SportsDriveStrategy;

public class Offroad extends Vehicle {

    public Offroad() {
        super(new SportsDriveStrategy());
    }
}
