package greg.lab3;

import greg.lab3.noun.Location;
import greg.lab3.noun.Time;

public class Sentence {
    private String base;
    private Time time;
    private Location location;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Sentence(String base, Time time, Location location) {
        this.base = base;
        this.time = time;
        this.location = location;
    }

    public Sentence(String base, Location location) {
        this.base = base;
        this.location = location;
    }
    public Sentence(String base, Time time) {
        this.base = base;
        this.time = time;
    }
    public Sentence(String base) {
        this.base = base;

    }

    @Override
    public String toString() {
       if(time != null){
           if(location!=null){
               return base + " " + time.toString() + " " + location.toString();
           }
           else {
               return base + " " + time.toString();
           }
       }
       else {
           if(location!=null){
               return base + " " + location.toString();
           }
           else {
               return base;
           }
       }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
