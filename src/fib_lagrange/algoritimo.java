package fib_lagrange;

import javafx.util.Pair;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class algoritimo {

    private Double aphaX2, aphaX, aphaN;
    private Double betaX2, betaX, betaN;
    private Double omegaX2, omegaX, omegaN;

    private DecimalFormat df;

    private void calc_alpha(Double y, Double x0, Double x1, Double x2){

        Double div = (x0 - x1) * (x0 -x2);

        this.aphaX2 = y / div;

        this.aphaX = (y * ((-x1) + (-x2))) / div;

        this.aphaN = (y * ((-x1) * (-x2))) / div;

    }

    private void calc_beta(Double y, Double x0, Double x1, Double x2){

        Double div = (x1 - x0) * (x1 -x2);

        this.betaX2 = y / div;

        this.betaX = (y * ((-x0) + (-x2))) / div;

        this.betaN = (y * ((-x0) * (-x2))) / div;

    }

    private void calc_omega(Double y, Double x0, Double x1, Double x2){

        Double div = (x2 - x0) * (x2 -x1);

        this.omegaX2 = y / div;

        this.omegaX = (y * ((-x0) + (-x1))) / div;

        this.omegaN = (y * ((-x0) * (-x1))) / div;

    }

    public void equacaoSegundo (double x0, double y0, double x1, double y1, double x2, double y2){

        df = new DecimalFormat("###,##0.00");

        calc_alpha(y0,x0,x1,x2);

        calc_beta(y1,x0,x1,x2);

        calc_omega(y2,x0,x1,x2);

        Pair<String, Double> finalx2;
        Pair<String, Double> finalx;
        Pair<String, Double> finaln;

        double resultX2 = this.aphaX2 + this.betaX2 + this.omegaX2;
        double resultX = this.aphaX + this.betaX + this.omegaX;
        double resultN = this.aphaN + this.betaN + this.omegaN;

        if (resultX2 >= 0)
           finalx2 = new Pair<>("", resultX2);
        else
            finalx2 = new Pair<>("", resultX2);


        if (resultX >= 0)
            finalx = new Pair<>("+", resultX);
        else
            finalx = new Pair<>("", resultX);


        if (resultN >= 0)
            finaln = new Pair<>("+", resultN);
        else
            finaln = new Pair<>("", resultN);

        System.out.println("Resultado: " + finalx2.getKey() + df.format(finalx2.getValue()) + "x² "
                                         + finalx.getKey() + " "  + df.format(finalx.getValue()) + "x "
                                         + finaln.getKey() + " "  + df.format(finaln.getValue()));

    }


}
