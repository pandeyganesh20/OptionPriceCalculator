

import java.util.*;
final class Output
{
    public double FV;      // fair value
    public double fugit;   // fugit
    public double impvol;  // implied volatility
    public int num_iter;   // number of iterations to compute implied volatility

Output()
{
    FV =0;
    fugit=0;
    impvol =0;
    num_iter=0;

}


Output(double fv,double fugit, double impvol, int num_iter)
{
    this.FV=fv;
    this.fugit =fugit;
    this.impvol= impvol;
    this.num_iter = num_iter;
}


}
