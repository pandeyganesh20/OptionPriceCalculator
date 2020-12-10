

class VanillaOption extends Derivative {


    public VanillaOption(String Region, String Option, double Strike, double Time)
    {
        S1 = Region;
        S2= Option;
        k= Strike;
        T=Time;
    }



    public void terminalCondition(Node n) {
        n.fugit =T;

        if ((S1.equalsIgnoreCase("European")) || (S1.equalsIgnoreCase("American"))) {


            if ((S2.equalsIgnoreCase("Call"))) {
                System.out.println("s"+n.Stock);
                System.out.println("k"+k);
                if (n.Stock < k) {
                    System.out.println("s"+n.Stock);

                    n.Payoff = 0;
                } else {
                    n.Payoff = (n.Stock - k);

                }
            }

            if ((S2.equalsIgnoreCase("Put"))) {
                if (n.Stock > k) {
                    n.Payoff = 0;
                } else {
                    n.Payoff = (k - n.Stock);

                }

            }


        }

    }


    public void valuationTest(Node n) {


        if ((S1.equalsIgnoreCase("European"))) {
            if ((S2.equalsIgnoreCase("Call")) || ((S2.equalsIgnoreCase("Put")))) {
                n.fugit= T;
                return;

            }
        }
        if ((S1.equalsIgnoreCase("American"))) {

            if (n.Intrengic> n.Payoff) {
                n.Payoff = Math.max(n.Payoff, n.Intrengic);
                n.fugit = n.chkFugit;
            }
            }
        }




        }
