public class CADtoUSD implements Conversion{
    private double Rate;
    private double Amount;
    public CADtoUSD(double ConversionRate,double Amount){
        Rate = ConversionRate;
        this.Amount=Amount;
    }
    @Override
    public double Convert() {
        double x = Math.round(100*(1/Rate*Amount));
        return x/100;
    }
    public double getRate(){
        return Rate;
    }
    public double getAmount(){
        return Amount;
    }
}
