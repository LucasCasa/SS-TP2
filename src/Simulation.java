import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

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
            double xSum;
            double ySum;
            double va ;

            System.out.println("CUANTO VALE TIMES? " + times);
            FileWriter dist = new FileWriter("out.txt");
        for(int i = 0; i<times; i++){
            updatePosition();
            grid.setCells(particles);
            List<ArrayList<Particle>> n = grid.checkNeighbors(1);
            updateParticles(n);
            dist.write(particles.size() + "\n" + grid.size+"\n");
            xSum = 0.0;
            ySum = 0.0;
                for(Particle p : particles){
                    dist.write(p.getX()+"\t"+ p.getY()+"\t"+ p.getRadius()+"\t255\t255\t255\n");
                    //System.out.println("CUANTO VALE EL MODULO DE SPEED? " + p.getSpeed().getModule());
                    xSum += p.speed.module*Math.cos(Math.toRadians(p.speed.angle));
                    ySum += p.speed.module*Math.sin(Math.toRadians(p.speed.angle));



                }
                System.out.println("xSum vale = " + xSum);
                System.out.println("ySum vale = " + ySum);

            va = (Math.sqrt(Math.pow(xSum,2)+Math.pow(ySum,2)))/(particles.size()*0.03);
            System.out.println("VA VALE: " + va);
        }
            dist.close();

            System.out.println("N VALE: " + particles.size());


            //System.out.println("EL PARAMETRO DE ORDEN VALE: " +va);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updatePosition(){
        for(Particle p : particles){
            p.setX((p.getX() + p.speed.module*Math.cos(Math.toRadians(p.speed.angle))));
            p.setY((p.getY() + p.speed.module*Math.sin(Math.toRadians(p.speed.angle))));

            if(p.getX() > grid.size){
                p.setX((p.getX() - grid.size) + p.speed.module*Math.cos(Math.toRadians(p.speed.angle)));
            }
            if(p.getY() > grid.size){
                p.setY((p.getY() - grid.size) + p.speed.module*Math.sin(Math.toRadians(p.speed.angle)));
            }

            if(p.getX() < 0){
                p.setX((p.getX() + grid.size) + p.speed.module*Math.cos(Math.toRadians(p.speed.angle)));
            }

            if(p.getY() < 0){
                p.setY((p.getY() + grid.size) + p.speed.module*Math.sin(Math.toRadians(p.speed.angle)));
            }
        }
    }
    public void updateParticles(List<ArrayList<Particle>> n){
        for(int i = 0; i<n.size();i++){
            Particle p = particles.get(i);
            double avg = getAverageAngle(p,n.get(i));
            p.speed.angle =  Math.toDegrees((avg + (Math.random()-0.5)*noise));
        }
    }

    private double getAverageAngle(Particle p, List<Particle> n){
        double totalSin = Math.sin(Math.toRadians(p.getSpeed().getAngle()));
        double totalCos = Math.cos(Math.toRadians(p.getSpeed().getAngle()));
        for(Particle o: n){
              totalSin += Math.sin(Math.toRadians(o.getSpeed().getAngle()));
              totalCos += Math.cos(Math.toRadians(o.getSpeed().getAngle()));
        }
        totalSin /= n.size()+1;
        totalCos /= n.size()+1;
        return Math.atan2(totalSin,totalCos);
    }
}
