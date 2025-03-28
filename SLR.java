import java.util.Arrays;


public class SLR {
    private float beta0;
    private float beta1;
    private DataSet dataSet;
    private DiscreteMaths discreteMaths;

    public SLR(DataSet dataSet, DiscreteMaths discreteMaths) {
        beta0 = 0;
        beta1 = 0;
        this.dataSet = dataSet;
        this.discreteMaths = discreteMaths;
    }

    public float calculateIntersection() {
        int n = dataSet.getX().length; // Número de puntos de datos
        beta0 = (discreteMaths.sumY(dataSet.getY()) - (beta1 * discreteMaths.sumX(dataSet.getX()))) / n;
       // System.out.println("Beta0 (Intersection): " + beta0);
        return beta0;
    }

    public float calculateSlope() {
        int n = dataSet.getX().length; // Número de puntos de datos
        float numerator = (n * discreteMaths.sumXY(dataSet.getX(), dataSet.getY())) -
                (discreteMaths.sumX(dataSet.getX()) * discreteMaths.sumY(dataSet.getY()));
        float denominator = (n * discreteMaths.xSquared(dataSet.getX())) -
                (discreteMaths.sumX(dataSet.getX()) * discreteMaths.sumX(dataSet.getX()));
        beta1 = numerator / denominator;
//        System.out.println("Beta1 (Slope): " + beta1);
        return beta1;
    }

    public void printRegEquation(){
        System.out.println("Regression equation: y = " + beta0 + " + " + beta1 + "x");
    }

    public float predict(float x) {
        return beta0 + (beta1 * x);
    }

    public float xSquared(float x[]) {
        float xSquared = 0;
        for (int i = 0; i < x.length; i++) {
            xSquared += x[i] * x[i]; // Suma los cuadrados sin modificar el arreglo original
        }
        return xSquared;
    }

    public double correlation(float[] x, float[] y){
       double r = 0;
        if (x.length == y.length) {
            float sumaX = discreteMaths.sumX(x);
            float sumaY = discreteMaths.sumY(y);
            float mediaX = sumaX / x.length;
            float mediaY = sumaY / y.length;
            float desviacionX[] = new float[x.length];
            float desviacionY[] = new float[y.length];
            double num = 0;
            double den = 0;

            for (int i = 0; i < x.length; i++) {
                desviacionX[i] = x[i] - mediaX;
                desviacionY[i] = y[i] - mediaY;
                num += desviacionX[i] * desviacionY[i];
            }
            float squareX = discreteMaths.xSquared(desviacionX);
            float squareY = discreteMaths.xSquared(desviacionY);

            den = Math.sqrt(squareX) * Math.sqrt(squareY);

            r = num/den;
        }
        return r;
    }

    public double determination(float x[], float y[]){
        double R = 0;
        if (x.length == y.length){
            float sumaY = discreteMaths.sumY(y);
            float mediaY = sumaY / y.length;
           // SLR slr = new SLR(dataSet, discreteMaths);
            float b0,b1;
            double residuo,total;
            residuo = 0;
            total = 0;
            b1 = calculateSlope();
          b0 = calculateIntersection();
            for (int i = 0; i<y.length;i++){
                float predicT = b0 + b1 * x[i];
                residuo += Math.pow(y[i] - predicT, 2);
                total += Math.pow(y[i] - mediaY, 2);
            }
            R =  (1 - (residuo/total));
        }
        return R;
    }
}