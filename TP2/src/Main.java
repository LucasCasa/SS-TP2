import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by lcasagrande on 17/03/17.
 */
public class Main {


    public static void main(String[] args) {


        try {
            // COMIENZO - MANEJO DE ARCHIVOS
            File fs = new File("Static5000.txt");
            File ds = new File("Dynamic5000.txt");

            Scanner sc1 = new Scanner(fs);
            Scanner sc2 = new Scanner(ds);
            sc1.useLocale(Locale.US);
            sc2.useLocale(Locale.US);

            Integer n = sc1.nextInt();
            System.out.println("EL NUMERO DE PARTICULAS ES: " + n);
            Integer l = sc1.nextInt();
            System.out.println("LA LONGITUD ES " + l);

            List<Particle> ps = new ArrayList<>();

            int time = sc2.nextInt(); //--> para usos futuros
            double property; //--> para usos futuros
            // double maxRadius = 0;

            for (int i = 0; i < n; i++) {


                ps.add(new Particle(i+1,sc1.nextDouble() ,sc2.nextDouble() , sc2.nextDouble(), sc2.nextDouble(), sc2.nextDouble()));
                sc1.nextDouble();
            }
            Simulation s = new Simulation(ps,l,10,0.5);
            s.simulate();
        } catch (Exception e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
    }
}
