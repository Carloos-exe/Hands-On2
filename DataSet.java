import java.util.Arrays;

public class DataSet {
    private float[] x;
    private  float[] y;


    public DataSet() {
        this.x = new float[]{23, 26, 30, 34, 43, 48, 52, 57, 58};
        this.y = new float[]{651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
    }

    public DataSet(float[] x, float[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Error de tamaño");
        }
        this.x = x.clone(); //
        this.y = y.clone();
    }

    // Métodos para obtener los arreglos
    public float[] getX() {
        return x.clone(); // Devolver una copia para evitar modificaciones externas
    }

    public float[] getY() {
        return y.clone(); // Devolver una copia para evitar modificaciones externas
    }



    //3 sets, training set, testing set and validation set.
    //Datos de entrenamiento deben ser mayores que los otros 2 sets
    public void split(float x[], float y[]){
        int splX = (int) (x.length * 0.7);
        int splY = (int) (y.length * 0.7);

        float nx[] = Arrays.copyOfRange(this.x,0,splX);
        float ny[] = Arrays.copyOfRange(this.y,0,splY);

//        System.out.println("Nuevo data Set");
//        System.out.println(Arrays.toString(nx));
        this.x = nx;
        this.y = ny;

    }

}

