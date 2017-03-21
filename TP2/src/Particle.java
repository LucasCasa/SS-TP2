import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/11/17.
 */
public class Particle {
    int id;
    double radius;
    double x;
    double y;
    List<Particle> neighbors;

    public Particle(int id,double radius, double x, double y){
        this.id = id;
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.neighbors = new ArrayList<Particle>();
    }

    public Particle(int id, double radius){
        this.id = id;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double dist2(Particle p1, Particle p2){
        return (p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y);
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Particula - Id: " + id + " Pos:(" +x+","+y+") Radio:"+radius;
    }
}
