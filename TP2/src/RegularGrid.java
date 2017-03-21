import java.io.FileWriter;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by root on 3/14/17.
 */
public class RegularGrid extends Grid {

    public RegularGrid(int size, double cellSide){
        super(size, cellSide);
    }

    @Override
    public ArrayList<ArrayList<Integer>> checkNeighbors(double rc, int size) {
        ArrayList<ArrayList<Integer>> neigh = new ArrayList<>();
        for(int i = 0; i< size;i++){
            neigh.add(new ArrayList<>(200));
        }
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid.length;j++){
                for(int k = 0;k<grid[i][j].getParticleList().size();k++){
                    Particle p = grid[i][j].getParticleList().get(k);
                    for(int l =k+1;l<grid[i][j].getParticleList().size();l++){
                        Particle p1 = grid[i][j].getParticleList().get(l);
                        if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                            neigh.get(p.getId() - 1).add(p1.getId());
                            neigh.get(p1.getId() - 1).add(p.getId());
                        }
                    }

                    if(i+1 <= grid.length -1) {
                        for (Particle p1 : grid[i + 1][j].getParticleList()) {
                            if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1.getId());
                                neigh.get(p1.getId() - 1).add(p.getId());
                            }
                        }
                    }
                    if(i-1 >= 0 && j+1 <= grid.length-1) {
                        for (Particle p1 : grid[i - 1][j + 1].getParticleList()) {
                            if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1.getId());
                                neigh.get(p1.getId() - 1).add(p.getId());
                            }
                        }

                    }
                    if(j+1 <= grid.length-1) {
                        for (Particle p1 : grid[i][j + 1].getParticleList()) {
                            if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1.getId());
                                neigh.get(p1.getId() - 1).add(p.getId());
                            }
                        }
                    }
                    if(j+1 <= grid.length -1 && i+1 <= grid.length-1) {
                        for (Particle p1 : grid[i + 1][j + 1].getParticleList()) {
                            if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                neigh.get(p.getId() - 1).add(p1.getId());
                                neigh.get(p1.getId() - 1).add(p.getId());
                            }
                        }
                    }
                }
            }
        }
        return neigh;

    }


}
