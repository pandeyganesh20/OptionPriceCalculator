

public  class main {

    public static void main(String[] args) {

        MarketData M1 = new MarketData(10,100,10,40,0);  //needed for all // no need to change first value price
        Library L1 = new Library();  //needed to declare // don't change this
        /**
         *    
         *   
         *   //double Price; market price of security 10 
         public MarketData( double Price,double Stock, double rate, double Sigma, double intitalTime) 
         public VanillaOption(String Region, String Option, double Strike, double Time)
        */

                                            //strike // T = expiration
    Derivative  x1 = new VanillaOption("American","Call",100,1);
     Output q = L1.binom(x1,M1,4);
      //L1.impvol(x1, M1, 4, 100, 0.001, q);

      

//System.out.println(L1.impvol(x1, M1, 4, 100, 0.001, L1.binom(x1,M1,4)));
//    System.out.println("------------------------------------------------");
  //  System.out.println("------------------------------------------------");
  //  System.out.println("------------------------------------------------");
//System.out.println("Above is Implied Volatility");
System.out.println();



    }
}