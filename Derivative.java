
abstract class Derivative
{

    public double k;
    public String S1; //american or european or bermudan
    public String S2; //put or call

    public double T;  // data member
   abstract public void terminalCondition(Node n); // virtual function
   abstract public void valuationTest(Node n) ;    // virtual function



}
