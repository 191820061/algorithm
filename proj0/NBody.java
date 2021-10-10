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
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double mass=in.readDouble();
            String Name=in.readString();
            manyPlanets[i]=new Planet(xP,yP,xV,yV,mass,Name);
        }
        return manyPlanets;
    }

    public static void main(String[] args){
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] allPlanets=readPlanets(filename);
        String starfield="images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 75, starfield);
        for (Planet p:allPlanets){
            p.draw();
        }
        StdDraw.show();
        StdDraw.pause(2000);

    }



}