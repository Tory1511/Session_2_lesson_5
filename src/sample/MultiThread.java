package sample;
import java.lang.*;

public class MultiThread
{
    static final int size = 10000000;
    static final int arrayHalfSize = size / 2;
    float[] arr = new float[size];

    float[] a1 = new float[arrayHalfSize];
    float[] a2 = new float[arrayHalfSize];

    public MultiThread() {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = 1;
        }
    }

    public void countTime() {
        long a = System.currentTimeMillis();

        System.arraycopy(this.arr, 0, this.a1, 0, arrayHalfSize);
        System.arraycopy(this.arr, arrayHalfSize, this.a2, 0, arrayHalfSize);

        Thread t1 = new Thread(() -> makeCalcs(this.a1 , 0));
        Thread t2 = new Thread(() -> makeCalcs(this.a2, arrayHalfSize));

        t1.start();
        t2.start();

        try
        {
            t1.join();
            t2.join();
        }

        catch(Exception ex)
        {
            System.out.println("Exception has " +
                    "been caught" + ex);
        }

        System.arraycopy(this.a1, 0, this.arr, 0, arrayHalfSize);
        System.arraycopy(this.a2, 0, this.arr, arrayHalfSize, arrayHalfSize);

        //System.currentTimeMillis();
        System.out.println("Multi thread running time is " + (System.currentTimeMillis() - a));
    }

    public void makeCalcs(float[] a, int offset)
    {
        for (int i = 0; i < a.length; i++)
        {
            int j = i + offset;
            a[i] = (float)(a[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
        }
    }
}
