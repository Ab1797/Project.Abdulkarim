package Day2.Student;


public class Student {

    String name;
    private double mark;
    static int fullMark;

    public Student(String name, double mark){

        this.name = name;
        this.mark = mark;

    }

    public double getPersent(){

        return mark/fullMark * 100;

    }

    public String getGrade(){

        double pct = getPersent();
        if(pct > 85) return "Exellent";
        else if (pct > 75) return "Very Good";
        else if (pct > 65) return "Good";
        else if (pct >= 50) return "pass";
        else return "Fail";
    }
    //  get set
    public double getMark(){
        return mark;
    }

    public void serMark(double value){
        if(value >=0 ){
            this.mark = value;
        }
    }
    // end get set
}