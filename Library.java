import java.util.*;

        final class Library {

            Output binom(final Derivative deriv, final MarketData mkt, int n) {

                Node X[][] = new Node[(n + 1)][(n + 1)];


                double volatality = (mkt.sigma) / 100;
                double rate = (mkt.r) / 100;
                double deltaT = (deriv.T - mkt.t0) / n;
                 System.out.println("deltaT " +deltaT);


                double pow = Math.sqrt(deltaT);
                double uDis = Math.exp(volatality * (pow));
                double dDis = 1 / uDis;

                      System.out.println("dDis " +dDis);


                double uProb = ((Math.exp(rate * deltaT) - dDis) / (uDis - dDis));
                double dProb = (1 - uProb);
                double pV = Math.exp(-rate * deltaT);

                for (int j = 0; j <= n; j++) {
                    for (int i = j; i <= n; i++) {
                        X[i][j] = new Node();
                        X[i][j].Stock = mkt.S * (Math.pow(dDis, (2 * j - i)));
                       System.out.println("Stock at [" +i+ "," +j+ "]is :"+  X[i][j].Stock);
                    }
                }



                    for (int j = 0; j < n + 1; j++) {

                        deriv.terminalCondition(X[n][j]);
                        System.out.println("Payoff at [ "+n+ "," +j+" ] is: "+X[n][j].Payoff);
                        System.out.println("Fugit at ["+n+ "," +j+" ] is: "+X[n][j].fugit);

                    }



                for (int i = n - 1; i >= 0; i--) {
                    for (int j = i; j >= 0; j--) {

                        X[i][j].Payoff = (pV * ((uProb * X[i + 1][j].Payoff) + (dProb * X[i + 1][j + 1].Payoff)));


                        if( (deriv.S1.equalsIgnoreCase("American"))||(deriv.S1.equalsIgnoreCase("Bermuda"))) {
                            if (deriv.S2.equalsIgnoreCase("Call")) {
                                X[i][j].Intrengic = ((X[i][j].Stock - deriv.k));

                            }

                            if (deriv.S2.equalsIgnoreCase("Put")) {
                                X[i][j].Intrengic = ((deriv.k-X[i][j].Stock));
                            }




                            X[i][j].fugit = ((uProb * X[i + 1][j].fugit) + (dProb * X[i + 1][j + 1].fugit));

                            X[i][j].chkFugit  = (i * deltaT);


                        }


                        deriv.valuationTest(X[i][j]);
                        System.out.println("Payoff at [" +i+ "," +j+ " ] is: "+X[i][j].Payoff);
                        System.out.println("Fugit at  [ " +i+ "," +j+" ] is: "+X[i][j].fugit);

                    }
                }

                 double a = X[0][0].Payoff;
                 double b = X[0][0].fugit;
                Output output = new Output(a,b,0,0);
                return output;


            }




    int impvol(final Derivative deriv, final MarketData mkt, int n,
             int max_iter, double tol, Output out)
   {

        Output output;
        double down = 1;
        double up = 200;
        double temp;
        double diff;
        int itr = 0;


        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");
        System.out.println("**************************************************************************");

        while(itr < max_iter){
            
        	mkt.sigma=down;

        output = binom(deriv, mkt, n);
        diff = output.FV-mkt.Price;         
        if(Math.abs(diff)< 0.000001){
            out.impvol = down;
            out.num_iter = itr;
            return 0;
            }



        mkt.sigma=up;
        output = binom(deriv, mkt, n);
        diff = output.FV-mkt.Price;
        if(Math.abs(diff)< 0.000001){
            out.impvol = up;
            out.num_iter = itr;
            return 0;
        }

        temp = ((down+up)/2);
        mkt.sigma= temp;
       

        output = binom(deriv, mkt, n);
        diff = output.FV-mkt.Price;
        if(diff < 0) {
            down = temp;
        }
        else {
            up = temp;
        }
        itr ++;
        
    }
        

        Output XX = new Output();
        XX.impvol =XX.num_iter=0;
        
        return 1; 
        }




    }

