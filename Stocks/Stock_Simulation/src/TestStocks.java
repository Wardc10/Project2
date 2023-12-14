import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class TestStocks {

    public static int shares = 0;
    public static double money = 10000.00;
    public static double starting_money = money;
    public static double prev_open = 0.00;
    public static double prev_close = 0.00;
    public static double last_buy_price = 0.00;

    //to fomat printing of values without floating decimal points
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static ArrayList<Coord> coords = new ArrayList<Coord>();

    public static ArrayList<Coord> makeCoords(ArrayList<Stock> s){
        String x,y;
        for(int i=0; i<s.size(); i++){
            //Dates are in mm/dd/yyyy format
            x = s.get(i).getDate();
            y = String.valueOf(s.get(i).getOpen());
            Coord c = new Coord(x, y);
            coords.add(c);
        }
        return coords;
    }

    /*method that should return an int in the format:
        "+n" = buy n shares
        "-n" = sell n shares
        "0" = do nothing
    */
    //For now, uses my imperfect algorithm to make stock decisions day by day on the stockData array
    public static void tradeEvaluator(ArrayList<Coord> c){
        for(int i=0; i<c.size(); i++){
            //if avg price is greater than current opening price, buy shares
            if(c.get(i).getY() > (Stock_Reader.stockData.get(i).getOpen())){
                //only buy shares if you have the money to buy 5
                if(money > (Stock_Reader.stockData.get(i).getOpen()*5)){
                    money -= Stock_Reader.stockData.get(i).getOpen()*5;
                    last_buy_price = Stock_Reader.stockData.get(i).getOpen();
                    shares += 5;
                }
            }
            //sell if shares are worth at least 5% more than yesterday
            else if(Stock_Reader.stockData.get(i).getOpen() >= c.get(i).getY()*1.05){
                money += Stock_Reader.stockData.get(i).getOpen()*shares;
                shares = 0;
            }
            //sell if the avg is 10% lower than last time we bought
            else if(c.get(i).getY() <= last_buy_price*.9){
                money += Stock_Reader.stockData.get(i).getOpen()*shares;
                shares = 0;
            }
            prev_open = Stock_Reader.stockData.get(i).getOpen();
            prev_close = Stock_Reader.stockData.get(i).getClose();
        }
        //old algorithm without using smoothed data
        // for(int i = 0; i<Stock_Reader.stockData.size(); i++){
        //     //if opening stock price is greater 
        //     if((Stock_Reader.stockData.get(i).getOpen() > prev_open) && (prev_close > prev_open)) {
        //         if(money > Stock_Reader.stockData.get(i).getOpen()*5){
        //         	money = money - Stock_Reader.stockData.get(i).getOpen()*5;
        //         	shares += 5;
        //         	}
        //         }

        //         //if opening price is greater than the previous day by at least 7%, sell all stock for profit
        //         else if(Stock_Reader.stockData.get(i).getOpen() >= prev_open*1.07){
        //             money += Stock_Reader.stockData.get(i).getOpen()*shares;
        //         	shares = 0;
        //         }
        //     prev_open = Stock_Reader.stockData.get(i).getOpen();
        //     prev_close = Stock_Reader.stockData.get(i).getClose();
        // }
    }
    public static void print_Stock_Info(){
        int data_size = Stock_Reader.stockData.size();
        System.out.println("-=This is a Real Life Stock Simulation Using Stock Data From Yahoo Finance=-");
        System.out.println("If you started with $"+starting_money+":");
        System.out.println("After "+Stock_Reader.stockData.get(0).getDate()+""+Stock_Reader.stockData.get(data_size-1).getDate()+":");
        System.out.println("You'd be left with "+shares+" shares, worth: $"+df.format(shares*prev_close));
		System.out.println("Un-realized gains, worth: $"+df.format((shares*prev_close)-starting_money));
        System.out.println("And you'd still have $"+df.format(money)+ " left.");
        System.out.println("For a total profit of: $"+df.format(((shares*prev_close)-starting_money)+money)+"");
    }

    public static void main(String[] args) throws IOException{
        //set csv to read from file path
        String csvFile = "C:/Users/wardc/Documents/AMZN.csv";
        //read csv data and store in: ArrayList<Stock> stockData
        Stock_Reader.read_csv(csvFile);
        //converts stockData array to type Coord for PPS usability
        //makeCoords(Stock_Reader.stockData);
        //smooths the stock open prices
        Smoother sm = new Smoother();
        sm.smooth(csvFile, 3);
        //read output of smoother, array name is unsmoothed but after using smoother it contains smoothed coordinated
        //Take values from csv file, and evaluates stock options day by day
        tradeEvaluator(sm.unsmoothed);
        //print stock info at end of csv file
        print_Stock_Info();
    }

}
