package org.SmartWaste;

public class SensorData {
    private String date;
    private int hour;
    private double distance;
    private double pitch;
    private double roll;
    private double smoke;

    public SensorData() {}

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getHour() { return hour; }
    public void setHour(int hour) { this.hour = hour; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getPitch() { return pitch; }
    public void setPitch(double pitch) { this.pitch = pitch; }

    public double getRoll() { return roll; }
    public void setRoll(double roll) { this.roll = roll; }

    public double getSmoke() { return smoke; }
    public void setSmoke(double smoke) { this.smoke = smoke; }
}
