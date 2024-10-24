package WithDriveStretegy;

import WithDriveStretegy.stretegy.SportsDriveStrategy;

public class Sports extends Vehicle {
    public Sports() {
        super(new SportsDriveStrategy());
    }
}
