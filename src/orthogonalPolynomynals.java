public class orthogonalPolynomynals {
    double a, b, x, p, n, result;


    public orthogonalPolynomynals(double a, double b, double x, double p, int n) {
        this.a = a;
        this.b = b;
        this.x = x;
        this.p = p;
        this.n = n;

        Gx();
    }

    void Gx(){
        result = 0;
        for(int i = 0; i<n; i++){
            result += legrendePoly((double)i, x) * Cx((double)i);
        }
        System.out.println(result);
    }

    double Cx(double m){
        numericIntegration num1 = new numericIntegration(a, b, m, p, true);
        numericIntegration num2 = new numericIntegration(a, b, m, p, false);
        return num2.result/num1.result;
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
