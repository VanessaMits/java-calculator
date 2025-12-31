package org.example.Logic;

import org.example.Models.Polynomial;

import java.util.HashMap;
import java.util.Map;

public class Operation {

    public Operation() {
    }

    public Polynomial add(Polynomial poly1, Polynomial poly2) {
        Polynomial result = new Polynomial();

        Map<Integer, Double> terms1 = poly1.getPolynomialMap();
        Map<Integer, Double> terms2 = poly2.getPolynomialMap();

        for (int exponent : terms1.keySet()) {
            double coefficient = terms1.get(exponent);
            result.addTerm(exponent, coefficient);
        }

        for (int exponent : terms2.keySet()) {
            double coefficient = terms2.get(exponent);
            result.addTerm(exponent, result.getCoefficient(exponent) + coefficient);
        }

        return result;
    }

    public Polynomial subtract(Polynomial poly1, Polynomial poly2) {
        Polynomial result = new Polynomial();

        Map<Integer, Double> terms1 = poly1.getPolynomialMap();
        Map<Integer, Double> terms2 = poly2.getPolynomialMap();

        for (int exponent : terms1.keySet()) {
            result.addTerm(exponent, terms1.get(exponent));
        }

        for (int exponent : terms2.keySet()) {
            double coefficient = result.getCoefficient(exponent) - terms2.get(exponent);
            result.addTerm(exponent, coefficient);
        }

        return result;
    }
}
