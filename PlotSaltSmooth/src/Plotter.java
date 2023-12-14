import java.util.ArrayList;

public class Plotter {
    //Goal of this class is, given a linear function:
    //solve for the functions coordinates
    //and export to csv file to make a graph

    //initialize arraylist of custom type Coords to hold the coordinates of a function
    ArrayList<Coord> coordinates = new ArrayList<Coord>();

    //The Function I'm testing is y = -(x/5)^2 + 10x
    public double myFunc(int x){
         return (((Math.pow(x, 2)/5)*-1)+(10*x));
    }

    //Takes in x range, applies myFunc, and adds coordinates to an ArrayList<Coords>.
    public ArrayList<Coord> findCoords(int start, int end){
        String x,y;

        for(int i=start; i<end+1; i++){
            //set x and y values
            x = String.valueOf(i);
            y = String.valueOf(myFunc(i));
            //create coords and add to an ArrayList<Coords>
            Coord coords = new Coord(x, y);
            coordinates.add(coords);
        }
        return coordinates; 
    }
    
    public void plot(){
        //create plot object and plot points from x range:0-50
        final Plotter p = new Plotter();
        //***Edit values of start and end to change range of x values***
        p.findCoords(0,50);
        //Writes coordinates of unsalted myFunc to CSV file
        CSV_Writer.writeCsvFile("Unsalted_Function.csv", p.coordinates);
    }

}
