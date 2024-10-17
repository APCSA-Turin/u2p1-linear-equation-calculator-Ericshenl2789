package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coordinate1, String coordinate2){ // <--add 2 string parameters to this constructor
        int comma1 = coordinate1.indexOf(",");
        int comma2 = coordinate2.indexOf(",");
        x1 = Integer.parseInt(coordinate1.substring(1, comma1));//coverting String to int using parse source: https://stackoverflow.com/questions/5585779/how-do-i-convert-a-string-to-an-int-in-java
        x2 = Integer.parseInt(coordinate2.substring(1, comma2));
        y1 = Integer.parseInt(coordinate1.substring(comma1 + 1, coordinate1.length() - 1));
        y2 = Integer.parseInt(coordinate2.substring(comma2 + 1, coordinate2.length() - 1));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newX1){
        x1 = newX1;
    }
    public void setY1(int newY1){
        y1 = newY1;
    }
    public void setX2(int newX2){
        x2 = newX2;
    }
    public void setY2(int newY2){
        y2 = newY2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        return roundedToHundredth(Math.sqrt((double) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))));//distance formula
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        int temp = y1*-1;
        if (slope() == -999.99){
            return -999.99;
        } else {
            return roundedToHundredth((x1 * -1 * slope()) - temp);//using point-slope form to calculate the y-intercept
        } 
        
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        if (x2 - x1 == 0){
            return -999.99;
        }
        return roundedToHundredth((double) (y2 - y1)/(x2 - x1)); // slope formula
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        String equation = "y=";
        if (slope() == -999.99){
            return "undefined";
        } 
        if (slope() != (double) 0){
            equation += slope() + "x";
        }
        if (yInt() != (double) 0 && slope() ==0) {
            equation +=  yInt();
        } else if (yInt() != (double) 0){
            if (yInt()>0){
                equation += "+" +yInt();
            } else if (yInt() < 0){
                equation += yInt();
            }
        }
        return equation;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x*100) / 100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}