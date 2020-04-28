package DS_05;

public class Student {

    private static final int DEFAULT_SCORE = 0;

    private int _score;
    //<생성자 START>
    public Student(){
        this.setScore(Student.DEFAULT_SCORE);
    }
    public Student(int givenScore){
        this.setScore(givenScore);
    }
    //<생성자 END>


    //<GETTER SETTER START>
    public int score(){
        return this._score;
    }
    public void setScore(int newScore){
        this._score = newScore;
    }
    //<GETTER SETTER END>


    public boolean equals (Object aStudent){
        //aStudent의 데이터타입을 확실히 하기위해
        if(aStudent.getClass() != Student.class) return false;
        else return (this.score() == ((Student) aStudent).score());
    }
}
