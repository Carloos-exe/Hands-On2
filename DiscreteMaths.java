public class DiscreteMaths {
    public float sumX(float x[]) {
        float totalX = 0;
        for (int i = 0; i < x.length; i++)
            totalX = totalX + x[i];
        return totalX;
    }


    public float sumY(float y[]) {
        float totalY = 0;
        for (int i = 0; i < y.length; i++)
            totalY = totalY + y[i];
        return totalY;
    }

    public float sumXY(float x[], float y[]) {
        float totalXY = 0;
        for (int i = 0; i < x.length; i++)
            totalXY = totalXY + (x[i] * y[i]);
        return totalXY;
    }

    public float multiplySum(float x[], float y[]) {
        return sumX(x) * sumY(y);
    }

    public float xSquared(float x[]) {
        float xSquared = 0;
        for (int i = 0; i < x.length; i++) {
            xSquared += x[i] * x[i]; // Suma los cuadrados sin modificar el arreglo original
        }
        return xSquared;
    }





}