public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        Planet[] manyPlanets = new Planet[num];
        in.readDouble();
        for (int i = 0; i < num; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String Name = in.readString();
            manyPlanets[i] = new Planet(xP, yP, xV, yV, mass, Name);
        }
        return manyPlanets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] allPlanets = readPlanets(filename);
        String starfield = "images/starfield.jpg";
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        double time = 0.0;
        int size=(int)(T/dt);
        double[] xForces = new double[5];
        double[] yForces = new double[5];
        int xindex = 0;
        int yindex = 0;
        while (time < T) {
            xForces[0] = allPlanets[0].calcNetForceExertedByX(new Planet[]{allPlanets[1], allPlanets[2], allPlanets[3], allPlanets[4]});
            xForces[1] = allPlanets[1].calcNetForceExertedByX(new Planet[]{allPlanets[0], allPlanets[2], allPlanets[3], allPlanets[4]});
            xForces[2] = allPlanets[2].calcNetForceExertedByX(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[3], allPlanets[4]});
            xForces[3] = allPlanets[3].calcNetForceExertedByX(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[2], allPlanets[4]});
            xForces[4] = allPlanets[4].calcNetForceExertedByX(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[2], allPlanets[3]});
            yForces[0] = allPlanets[0].calcNetForceExertedByY(new Planet[]{allPlanets[1], allPlanets[2], allPlanets[3], allPlanets[4]});
            yForces[1] = allPlanets[1].calcNetForceExertedByY(new Planet[]{allPlanets[0], allPlanets[2], allPlanets[3], allPlanets[4]});
            yForces[2] = allPlanets[2].calcNetForceExertedByY(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[3], allPlanets[4]});
            yForces[3] = allPlanets[3].calcNetForceExertedByY(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[2], allPlanets[4]});
            yForces[4] = allPlanets[4].calcNetForceExertedByY(new Planet[]{allPlanets[0], allPlanets[1], allPlanets[2], allPlanets[3]});
            for (int i = 0; i < allPlanets.length; i++) {
                allPlanets[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 75, starfield);
            for (Planet p : allPlanets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                    allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
        }
    }


}