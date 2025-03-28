import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de DataSet y DiscreteMaths
        DataSet dataSet = new DataSet();
        DiscreteMaths discreteMaths = new DiscreteMaths();
      //  System.out.println("X: " + Arrays.toString(dataSet.getX()));
       // System.out.println("Y: " + Arrays.toString(dataSet.getY()));
        // Crear instancia de SLR
        SLR slr = new SLR(dataSet, discreteMaths);
        // Calcular la pendiente (beta1)
        System.out.println("Beta1 (Slope):" + slr.calculateSlope());
        System.out.println("Beta 0 (Intersection): " + slr.calculateIntersection());
        slr.calculateIntersection();
//        System.out.println("Regresion abajo");
        // Imprimir la ecuación de regresión
        slr.printRegEquation();
        // Ejemplo de predicción
        float x = 22; // Valor de x para predecir y
        float predictedY = slr.predict(x);
        System.out.println("Prediction for x = " + x + ": y = " + predictedY);
        System.out.println("Coeficiente de Correlación: "+ slr.correlation(dataSet.getX(), dataSet.getY()));
        System.out.println("Coeficiente de Determinación: " + slr.determination(dataSet.getX(), dataSet.getY()));

        System.out.println("----------------------------------------------");
        System.out.println("SplitDataSet");
        DataSet splitData = new DataSet();
        splitData.split(splitData.getX(), splitData.getY());
      //  System.out.println("X: " + Arrays.toString(splitData.getX()));
       // System.out.println("Y: " + Arrays.toString(splitData.getY()));
        SLR slrSplit = new SLR(splitData, discreteMaths);
        System.out.println("Beta1 (Slope): " + slrSplit.calculateSlope());
        System.out.println("Beta 0 (Intersection): " + slrSplit.calculateIntersection());
        // Imprimir la ecuación de regresión
        slrSplit.printRegEquation();
        float j = 4;
        float predictj = slrSplit.predict(j);
        System.out.println("Prediction for x = " + j + ": y = " + predictj);
        System.out.println("Coeficiente de Correlación: " + slrSplit.correlation(splitData.getX(), splitData.getY()));
        System.out.println("Coeficiente de Determinación: " + slrSplit.determination(splitData.getX(), splitData.getY()) );

    }
}