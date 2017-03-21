/**
 * Created by lucas on 12/03/17.
 */
public class CellIndex {

   /* public static void calculateNeighbors(List<Particle> particles, double rc, int l,double maxRadius){


        checkNeighbors(setCells(particles, l, (int)(l/(rc+maxRadius))),rc,particles.size());


    }*/

    /*public static void checkNeighbors(Cell[][] grid,double rc,int size){
        StringBuilder[] neigh = new StringBuilder[size];
        for(int i = 0; i< size;i++){
            neigh[i] = new StringBuilder();
            neigh[i].append(i+1);
        }
            for(int i = 0; i<grid.length;i++){
                for(int j = 0; j<grid.length;j++){
                    for(int k = 0;k<grid[i][j].getParticleList().size();k++){
                        Particle p = grid[i][j].getParticleList().get(k);
                        for(int l =k+1;l<grid[i][j].getParticleList().size();l++){
                            Particle p1 = grid[i][j].getParticleList().get(l);
                            if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                neigh[p.getId()-1].append(",").append(p1.getId());
                                neigh[p1.getId()-1].append(",").append(p.getId());
                            }
                        }

                        if(i+1 <= grid.length -1) {
                            for (Particle p1 : grid[i + 1][j].getParticleList()) {
                                if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                    neigh[p.getId()-1].append(",").append(p1.getId());
                                    neigh[p1.getId()-1].append(",").append(p.getId());
                                }
                            }
                        }
                        if(i-1 >= 0 && j+1 <= grid.length-1) {
                            for (Particle p1 : grid[i - 1][j + 1].getParticleList()) {
                                if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                    neigh[p.getId()-1].append(",").append(p1.getId());
                                    neigh[p1.getId()-1].append(",").append(p.getId());
                                }
                            }

                        }
                        if(j+1 <= grid.length-1) {
                            for (Particle p1 : grid[i][j + 1].getParticleList()) {
                                if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                    neigh[p.getId()-1].append(",").append(p1.getId());
                                    neigh[p1.getId()-1].append(",").append(p.getId());
                                }
                            }
                        }
                        if(j+1 <= grid.length -1 && i+1 <= grid.length-1) {
                            for (Particle p1 : grid[i + 1][j + 1].getParticleList()) {
                                if (Particle.dist2(p, p1) < (p.radius + p1.radius + rc)*(p.radius + p1.radius + rc)) {
                                    neigh[p.getId()-1].append(",").append(p1.getId());
                                    neigh[p1.getId()-1].append(",").append(p.getId());
                                }
                            }
                        }
                    }
                }
            }

        // GENERO EL ARCHIVO DE SALIDA

        try {

            FileWriter file = new FileWriter("output.txt");

            for(StringBuilder sb : neigh){
                System.out.println(sb);
                file.write(sb.toString());
                file.write("\n");
            }


            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // FIN




    }

   /* private static Cell[][] setCells(List<Particle> particles, int l, int m){
        Cell[][] grid = new Cell[m][m];
        double cellSide = (double)l/m;

        for(int i=0; i< m; i++){
            for(int j=0; j<m; j++){
                grid[i][j] = new Cell(cellSide);
            }
        }

        int x;
        int y;
        for(Particle p: particles){
            x = (int)(p.getX() / cellSide);
            y = (int)(p.getY() / cellSide);

            grid[x][y].particleList.add(p);
        }

        for(int i=0; i < m; i++){
            for(int j=0; j< m; j++){
                System.out.println("La celda: " + i + "  " + j + "  contiene las siguientes particulas: " + grid[i][j].particleList);
                System.out.println("===========================");
            }
        }
        return grid;
    }*/
}
