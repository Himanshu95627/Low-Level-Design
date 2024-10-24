package WithDriveStretegy;

import WithDriveStretegy.stretegy.SimpleDriveStretegy;

public class Goods extends Vehicle {

    public Goods() {
        super(new SimpleDriveStretegy());
    }
}
