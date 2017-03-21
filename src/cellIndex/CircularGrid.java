import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by root on 3/14/17.
 */
public class CircularGrid extends Grid {

    public CircularGrid(int size, double cellSide){
        super(size, cellSide);
    }

    @Override
    public ArrayList<ArrayList<Particle>> checkNeighbors(double rc) {
        ArrayList<ArrayList<Particle>> neigh = new ArrayList<>(particles.size());
        for(int i = 0; i< particles.size();i++){
            neigh.add(new ArrayList<>(200));
        }

        for(int i = 0; i<grid.length;i++) {
            for (int j = 0; j < grid.length; j++) {
                for (int k = 0; k < grid[i][j].getParticleList().size(); k++) {
                    Particle p = grid[i][j].getParticleList().get(k);
                    for (int l = k + 1; l < grid[i][j].getParticleList().size(); l++) {
                        Particle p1 = grid[i][j].getParticleList().get(l);
                        if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                            neigh.get(p.getId() - 1).add(p1);
                            neigh.get(p1.getId() - 1).add(p);
                        }
                    }

                    if (i + 1 <= grid.length - 1) {
                        for (Particle p1 : grid[i + 1][j].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                    }
                    if (i - 1 >= 0 && j + 1 <= grid.length - 1) {
                        for (Particle p1 : grid[i - 1][j + 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }

                    }
                    if (j + 1 <= grid.length - 1) {
                        for (Particle p1 : grid[i][j + 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                    }
                    if (j + 1 <= grid.length - 1 && i + 1 <= grid.length - 1) {
                        for (Particle p1 : grid[i + 1][j + 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                    }
                    if (j - 1 < 0) {
                        for (Particle p1 : grid[Math.floorMod(i - 1, grid.length) ][grid.length - 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                        for (Particle p1 : grid[Math.floorMod(i , grid.length)][grid.length - 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                        for (Particle p1 : grid[Math.floorMod(i + 1, grid.length)][grid.length - 1].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                    }
                    if (i - 1 < 0) {
                        for (Particle p1 : grid[grid.length - 1][Math.floorMod(j - 1, grid.length)].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                        for (Particle p1 : grid[grid.length - 1][Math.floorMod(j, grid.length)].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                        for (Particle p1 : grid[grid.length - 1][(j + 1) % grid.length].getParticleList()) {
                            if (dist2mod(p, p1) < (p.radius + p1.radius + rc) * (p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1);
                                neigh.get(p1.getId() - 1).add(p);
                            }
                        }
                    }

                }
            }
        }
        return neigh;
    }

    public double dist2mod(Particle p1, Particle p2){
        double diffx = Math.min(p2.x-p1.x,size-(p2.x-p1.x));
        double diffy = Math.min(p2.y-p1.y,size-(p2.y-p1.y));
        return diffx*diffx + diffy*diffy;
    }

}
