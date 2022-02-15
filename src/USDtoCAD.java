public class USDtoCAD extends CADtoUSD implements Conversion{
    public USDtoCAD(double ConversionRate, double Amount) {
        super(ConversionRate, Amount);
    }
    @Override
    public double Convert() {
        double x = Math.round(100*(getRate()*getAmount()));
        return x/100;
    }
}
