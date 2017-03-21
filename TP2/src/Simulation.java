import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by lcasagrande on 21/03/17.
 */
public class Simulation {
    Grid grid;
    int times;
    double noise;
    List<Particle> particles;
    public Simulation(List<Particle> p,int size, int times,double noise){
        grid = new CircularGrid(size,1);
        particles = p;
        this.times = times;
        this.noise = noise;

    }

    public void simulate(){
        try {
        FileWriter dist = new FileWriter("out.txt");
        for(int i = 0; i<times; i++){
            updatePosition();
            grid.setCells(particles);
            List<ArrayList<Particle>> n = grid.checkNeighbors(1);
            updateParticles(n);
            dist.write(particles.size() + "\n" + grid.size+"\n");
                for(Particle p : particles){
                    dist.write(p.getX()+"\t"+ p.getY()+"\t"+ p.getRadius()+"\t255\t255\t255\n");
                }
        }
            dist.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updatePosition(){
        for(Particle p : particles){
            p.setX((p.getX() + p.speed.module*Math.cos(p.speed.angle)));
            p.setY((p.getY() + p.speed.module*Math.sin(p.speed.angle)));
            if(p.getX() > grid.size){
                p.setX(p.getX() - grid.size);
            }
            if(p.getY() > grid.size){
                p.setY(p.getY() - grid.size);
            }
        }
    }
    public void updateParticles(List<ArrayList<Particle>> n){
        for(int i = 0; i<n.size();i++){
            Particle p = particles.get(i);
            double avg = getAverageAngle(p,n.get(i));
            p.speed.angle = (avg + (Math.random()-0.5)*noise);
        }
    }

    private double getAverageAngle(Particle p, List<Particle> n){
        double totalSin = Math.sin(p.getSpeed().getAngle());
        double totalCos = Math.cos(p.getSpeed().getAngle());
        for(Particle o: n){
              totalSin += Math.sin(o.getSpeed().getAngle());
              totalCos += Math.cos(o.getSpeed().getAngle());
        }
        totalSin /= n.size()+1;
        totalCos /= n.size()+1;
        return Math.atan2(totalSin,totalCos);
    }
}
