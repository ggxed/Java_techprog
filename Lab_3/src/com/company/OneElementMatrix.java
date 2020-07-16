package com.company;


public class OneElementMatrix extends Matrix{
    
    private int ElementValue;

    OneElementMatrix (int a, int b, int Value)
    {
        super(a,b);
        ElementValue = Value;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer((this.dlina * this.viisota * 2));
        for (int i = 0; i < viisota; ++i) {
            for (int j = 0; j < dlina ; ++j) {
                sb.append(ElementValue + " ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
   public int getElement(int row, int column) {
        if(row < 0 || column < 0 || row > dlina || column > viisota)
        throw new RuntimeExceptionPlus("Error, The length of one matrix does not match the other");

      return  ElementValue;
    }
   


}