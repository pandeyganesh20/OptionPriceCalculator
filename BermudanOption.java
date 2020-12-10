
class BermudanOption extends Derivative {
        public double window_begin;
        public double window_end;

        public BermudanOption(String Bermuda, String Option, double Strike, double Time, double begin, double end) {
                S1 = Bermuda;
                S2 = Option;
                k = Strike;
                T = Time;
                window_begin = begin;
                window_end = end;
        }


        public void terminalCondition(Node n) {
                n.fugit = T;
                if (S1.equalsIgnoreCase("Bermuda")) {
                        if ((S2.equalsIgnoreCase("Call"))) {
                                if (n.Stock < k) {
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

                if (S1.equalsIgnoreCase("Bermuda")) {
                        if ((S2.equalsIgnoreCase("Call")) || (S2.equalsIgnoreCase("Put"))) {

                                double m = n.fugit;
                                double x = n.Payoff;
                                if ((((n.chkFugit) - (window_end)) <= 0.1) && ((n.chkFugit) - (window_begin) >= 0.001)) {


                                        if (n.Intrengic > n.Payoff) {
                                                n.Payoff = n.Intrengic;
                                                System.out.println("Pay 2 "  + n.Payoff);
                                                n.fugit = n.chkFugit;

                                        }
                                        if (n.Intrengic < n.Payoff) {
                                                n.fugit = m;
                                                n.Payoff=x;

                                        }

                                } else {
                                        n.fugit = m;
                                }

                        }

                }
        }
}

