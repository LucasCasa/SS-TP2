import java.util.ArrayList;
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

    }

    public void setCells(List<Particle> particles){
        for(int i=0; i < (int)(size / cellSide)+1; i++){
            for(int j=0; j< (int)(size / cellSide)+1; j++){
                grid[i][j] = new Cell(cellSide);
            }
        }
        int x;
        int y;
        ammount = particles.size();
        this.particles = particles;
        for(Particle p: particles){

            //System.out.println("LA POSICION EN X VALE: " + p.getX());
            //System.out.println("LA POSICION EN Y VALE: " + p.getY());
            x = (int)(p.getX() / cellSide);
            y = (int)(p.getY() / cellSide);
            //System.out.println("CELDA X: " + x);
            //System.out.println("CELDA Y: " + y);

            this.grid[x][y].particleList.add(p);
        }

    }



    public abstract ArrayList<ArrayList<Particle>> checkNeighbors(double rc);

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
