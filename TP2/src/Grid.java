import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by root on 3/14/17.
 */
public abstract class Grid {
    Cell[][] grid;
    int size;
    int ammount;
    double cellSide;
    List<Particle> particles;

    public Grid(int size, double cellSide){
        this.grid = new Cell[(int)(size / cellSide)+1][(int)(size / cellSide)+1];
        this.size = size;
        this.cellSide = cellSide;

        for(int i=0; i < (int)(size / cellSide)+1; i++){
            for(int j=0; j< (int)(size / cellSide)+1; j++){
                grid[i][j] = new Cell(cellSide);
            }
        }

    }

    public void setCells(List<Particle> particles, int l){
        int x;
        int y;
        ammount = particles.size();
        this.particles = particles;
        for(Particle p: particles){
            x = (int)(p.getX() / cellSide);
            y = (int)(p.getY() / cellSide);

            this.grid[x][y].particleList.add(p);
        }

    }



    public abstract ArrayList<ArrayList<Integer>> checkNeighbors(double rc, int size);

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid.length;j++){
                System.out.println("Posicion: " + i + ", " + j);
                for(Particle p: grid[i][j].getParticleList()){
                    System.out.print(p + "  ");
                }
                System.out.println("");
            }
        }
    }

}
