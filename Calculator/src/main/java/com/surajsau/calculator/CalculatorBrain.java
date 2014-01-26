package com.surajsau.calculator;

/**
 * Created by user on 1/24/14.
 */
public class CalculatorBrain {
    private double mOperand;
    private double mWaitingOperand;
    private double mCalculatorMemory;
    private String mWaitingOperator;

    //operator types
    public static final String ADD = "+";
    public static final String SUBTRACT = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";

    public static final String CLEAR = "C" ;
    public static final String CLEARMEMORY = "MC";
    public static final String ADDTOMEMORY = "M+";
    public static final String SUBTRACTFROMMEMORY = "M-";
    public static final String RECALLMEMORY = "MR";
    public static final String SQUAREROOT = "√";
    public static final String SQUARED = "x²";
    public static final String INVERT = "1/x";
    public static final String TOGGLESIGN = "+/-";
    public static final String SINE = "sin";
    public static final String COSINE = "cos";
    public static final String TANGENT = "tan";

    public CalculatorBrain(){
        mOperand =0;
        mWaitingOperand = 0;
        mWaitingOperator = "";
        mCalculatorMemory = 0;
    }

    public void setOperand(double operand){
        mOperand = operand;
    }

    public double getResult(){
        return mOperand;
    }

    //used on screen orientation change
    public void setMemory(double calculatorMemory){
        mCalculatorMemory = calculatorMemory;
    }

    public double getMemory(){
        return mCalculatorMemory;
    }

    public String toString(){
        return Double.toString(mOperand);
    }

    protected double performOperation(String operator){
        if (operator.equals(CLEAR)) {
            mOperand = 0;
            mWaitingOperator = "";
            mWaitingOperand = 0;
            // mCalculatorMemory = 0;
        } else if (operator.equals(CLEARMEMORY)) {
            mCalculatorMemory = 0;
            mOperand = 0;
        } else if (operator.equals(ADDTOMEMORY)) {
            mCalculatorMemory = mCalculatorMemory + mOperand;
        } else if (operator.equals(SUBTRACTFROMMEMORY)) {
            mCalculatorMemory = mCalculatorMemory - mOperand;
        } else if (operator.equals(RECALLMEMORY)) {
            mOperand = mCalculatorMemory;
        } else if (operator.equals(SQUAREROOT)) {
            mOperand = Math.sqrt(mOperand);

        } else if (operator.equals(SQUARED)) {
            mOperand = mOperand * mOperand;

        } else if (operator.equals(INVERT)) {
            if (mOperand != 0) {
                mOperand = 1 / mOperand;
            }
        } else if (operator.equals(TOGGLESIGN)) {
            mOperand = -mOperand;
        } else if (operator.equals(SINE)) {
            mOperand = Math.sin(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else if (operator.equals(COSINE)) {
            mOperand = Math.cos(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else if (operator.equals(TANGENT)) {
            mOperand = Math.tan(Math.toRadians(mOperand)); // Math.toRadians(mOperand) converts result to degrees
        } else {
            performWaitingOperation();
            mWaitingOperator = operator;
            mWaitingOperand = mOperand;
        }

        return mOperand;
    }

    protected void performWaitingOperation(){
        if(mWaitingOperator.equals(ADD))
            mOperand = mOperand + mWaitingOperand;
        else if(mWaitingOperator.equals(SUBTRACT))
            mOperand = mOperand - mWaitingOperand;
        else if(mWaitingOperator.equals(MULTIPLY))
            mOperand = mOperand*mWaitingOperand;
        else if(mWaitingOperator.equals(DIVIDE)){
            if(mOperand!=0)
                mOperand = mWaitingOperand/mOperand;
        }
    }
}
