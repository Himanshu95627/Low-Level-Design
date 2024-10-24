package WithDriveStretegy;

import WithDriveStretegy.stretegy.SimpleDriveStretegy;

public class Pessenger extends Vehicle {
    public Pessenger() {
        super(new SimpleDriveStretegy());
    }
}
