package com.fpt.t1911e.assignment_buoi7;

public class Temperature {
    private float Value;
    private Minimum Minimum;
    private Maximum Maximum;

    public Maximum getMaximum() {
        return Maximum;
    }

    public void setMaximum(Maximum maximum) {
        Maximum = maximum;
    }

    public Minimum getMinimum() {
        return Minimum;
    }

    public void setMinimum(Minimum minimum) {
        Minimum = minimum;
    }

    public float getValue() {
        return Value;
    }

    public void setValue(float value) {
        Value = value;
    }
}
