public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        return Math.sqrt(Math.pow(this.xxPos - b.xxPos, 2) + Math.pow(this.yyPos - b.yyPos, 2));
    }

    public double calcForceExertedBy(Planet b) {
        return this.mass * b.mass * (6.67 * Math.pow(10, -11)) / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Planet b) {
        return calcForceExertedBy(b) * (this.xxPos - b.xxPos == 0 ? 0 : -(this.xxPos - b.xxPos)) / calcDistance(b);
    }

    public double calcForceExertedByY(Planet b) {
        return calcForceExertedBy(b) * (this.yyPos - b.yyPos == 0 ? 0 : -(this.yyPos - b.yyPos)) / calcDistance(b);
    }

    public double calcNetForceExertedByX(Planet[] allPlanet) {
        double sum = 0;
        for (Planet p : allPlanet) {
            if (!this.equals(p)) {
                sum += this.calcForceExertedByX(p);
            }
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] allPlanet) {
        double sum = 0;
        for (Planet p : allPlanet) {
            if (!this.equals(p)) {
                sum += this.calcForceExertedByY(p);
            }
        }
        return sum;
    }

    public void update(double dt, double fx, double fy) {
        double accX = fx / this.mass;
        double accY = fy / this.mass;
        this.xxVel = this.xxVel + dt * accX;
        this.yyVel = this.yyVel + dt * accY;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}
