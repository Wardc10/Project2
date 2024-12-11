package src;
public class Pair {
    
    private String x,y;

    Pair(String x, String y){
        setX(x);
        setY(y);
    }
    public double toDouble(String s){
        return Double.parseDouble(s);
    }
    public String getX(){
        return x;
    }
    public void setX(String x){
        this.x = x;
    }
    public double getY(){
        return toDouble(y);
    }
    public void setY(String y){
        this.y = y;
    }

    @Override
    public String toString() {
        return x+","+y;
    }
}
