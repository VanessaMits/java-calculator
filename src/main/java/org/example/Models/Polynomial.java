package org.example.Models;

import java.util.Map;
import java.util.TreeMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Polynomial {

    private final Map<Integer, Double> polynomialMap;

    public Polynomial() {
        polynomialMap = new TreeMap<>();
    }

    public void addTerm(int exponent, double coefficient) {
        polynomialMap.put(exponent, coefficient);
    }

    public void removeTerm(int exponent) {
        polynomialMap.remove(exponent);
    }

    public Map<Integer, Double> getPolynomialMap() {
        return polynomialMap;
    }

    public double getCoefficient(int exponent) {
        return polynomialMap.getOrDefault(exponent, 0.0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean isFirstTerm = true;

        List<Integer> exponents = new ArrayList<>(polynomialMap.keySet());
        Collections.sort(exponents, Collections.reverseOrder());
        for (int exponent : exponents) {
            double coefficient = polynomialMap.get(exponent);
            if (coefficient != 0) {
                if (!isFirstTerm) {
                    sb.append(" + ");
                } else {
                    isFirstTerm = false;
                }
                sb.append(coefficient);
                if (exponent > 0) {
                    sb.append("x");
                    if (exponent > 1) {
                        sb.append("^").append(exponent);
                    }
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("0");
        }

        return sb.toString();
    }
}
