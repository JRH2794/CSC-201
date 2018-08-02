package com.company;


public class AClass
{
    protected int x;
    protected int y;

    public AClass() {}

    public AClass(int a, int b)
    {
        x = a;
        y = b;
    }

    public int addEm( )
    {
        return x + y;
    }

    public void changeEm( )
    {
        x++;
        y--;
    }

    public String toString( )
    {
        return "" + x + "   " + y;
    }
}