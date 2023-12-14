public class Stock {
    String date, open, close;

    Stock(String date, String open, String close) {
        this.date = date;
        this.open = open;
        this.close = close;
    }
    public String getDate() {
        return date;
    }
    public double getOpen() {
        return Double.parseDouble(open);
    }
    public double getClose() {
        return Double.parseDouble(close);
    }

@Override
public String toString() {
    return (date+" "+open+" "+close);
}

}
