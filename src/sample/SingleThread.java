package sample;

public class SingleThread
{
    static final int size = 10000000;
    static final int arrayHalfSize = size / 2;
    float[] arr = new float[size];

    public SingleThread() {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = 1;
        }
    }

    public void countTime()
    {
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        //System.currentTimeMillis();
        System.out.println("Single thread running time is " + (System.currentTimeMillis() - a));
    }



}
