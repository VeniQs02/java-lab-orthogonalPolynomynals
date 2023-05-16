import static java.lang.Math.cos;
import static java.lang.Math.pow;

public class numericIntegration {
    double a, b, m, p, h, result;
    boolean lambda;

    numericIntegration(double a, double b, double m, double p, boolean lambda){
        this.a = a;
        this.b = b;
        this.m = m;
        this.p = p;
        this.lambda = lambda;
        this.h = 0.01;

        calc_sum();
    }
    void calc_sum(){
        result = h * ((calc(a)/2) + calcIterating() + (calc(b)/2));
    }
    double calcIterating(){
        double resultCalc = 0;

        for(double i = a+h; i < b; i += h){
            resultCalc += calc(i);
        }

        return resultCalc;
    }
    double calc(double x){
        if(lambda){
            return p * (pow(legrendePoly(m, x), 2));
        }
        else{
            return p * legrendePoly(m, x) * pow((4*x*x) + 3, 0.5);
        }
    }

    double legrendePoly(double m, double xx){
        if(m == 0){
            return 1;
        } else if (m == 1) {
            return xx;
        } else{
            return ( legrendePoly(m-1, xx) * (1/(m)) * (2*m-1) * xx ) - (legrendePoly(m-2, xx) * (m-1)/(m));

        }
    }
}