package Planes;

import java.util.Objects;

abstract public class Plane {
    String planeModel;
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.planeModel = planeModel;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String GetPlaneModel() {
        return planeModel;
    }

    public int GetMaxSpeed() {
        return maxSpeed;
    }

    public int GetMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int GetMinLoadCapacity() {
        int result = this.maxLoadCapacity;
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + planeModel + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxFlightDistance=" + maxFlightDistance +
                ", maxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Plane plane = (Plane)obj;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(planeModel, plane.planeModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
