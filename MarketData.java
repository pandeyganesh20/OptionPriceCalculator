
 final class MarketData {
    public  double Price;  // market price of security
    public  double S;  // stock price
    public  double r;   // interest rate
    public   double sigma;  // volatility
    public  double t0;   // current time
    public  double  k;  //Strike price


    public MarketData() {
        Price = 0;
        S = 100;
        r = 0;
        sigma = 0;
        t0 = 0;
    }

    public MarketData( double Price,double Stock, double rate, double Sigma, double intitalTime) {
        this.Price =Price;
        this.S = Stock;
        this.r = rate;
        this.sigma = Sigma;
        this.t0 = intitalTime;


    }



}

