package DS_07;

public class Ban extends UnsortedArrayList<Student> {

    //<CONSTURUTOR START>
    public Ban(){ super(); }
    public Ban(int givenCapacity){ super(givenCapacity); }
    //<CONSTURUTOR END>

    //<최소값 출력 START>
    public Student lowest(){
        if(this.isEmpty())
            return null;
        else
            return this.lowestRecursively(0,this.size()-1);
    }
    private Student lowestRecursively(int left, int right){
        if(left == right)
            return this.elementAt(left);
        else{
            Student lowestFromRights = lowestRecursively(left+1, right);
            if(lowestFromRights.compareTo(this.elementAt(left)) <= 0)
                return lowestFromRights;
            else
                return this.elementAt(left);
        }
    }
    //<최소값 출력 END>

    //<최대값 출력 START>
    public Student highest(){
        if(this.isEmpty())
            return null;
        else
            return this.highestRecursively(0,this.size()-1);
    }
    private Student highestRecursively(int left, int right){
        if(left == right)
            return this.elementAt(left);
        else{
            Student highestFromRights = highestRecursively(left+1, right);
            if(highestFromRights.compareTo(this.elementAt(left)) >= 0)
                return highestFromRights;
            else
                return this.elementAt(left);
        }
    }
    //<최대값 출력 END>

    //<반의 평균 관련 START>
    private int sumOfScoreRecursively(int left, int right){
        //반의 전체 점수의 합
        int mid = (left + right) / 2;
        if(left == right)
            return this.elementAt(left).score();
        else{
            int leftSum = this.sumOfScoreRecursively(left, mid);
            int rightSum = this.sumOfScoreRecursively(mid+1,right);
            return (leftSum + rightSum);
        }
    }
    public int sum(){
        if(this.isEmpty()) return 0;
        else return this.sumOfScoreRecursively(0, this.size()-1);
    }
    public double average(){
        if(this.isEmpty()) return 0;
        else return (((double) this.sum())/((double) this.size()));
    }
    public int numberOfStudentsAboveAverage(){
        double average = this.average();
        int numberOfStudentAboveAverage = 0;
        Iterator <Student> iterator = this.iterator();
        while(iterator.hasNext()){
            Student student = iterator.next();
            if(student.score() >= average)
                numberOfStudentAboveAverage++;
        }
        return numberOfStudentAboveAverage;
    }
    //<반의 평균 관련 END>

    //<반을 quicksort로 정렬 START>
    public void sortByScore(){
        if(this.size() > 1){
            int maxLoc = 0;
            for(int i = 1; i< this.size(); i++){
                if(this.elementAt(i).score() > this.elementAt(maxLoc).score())
                    maxLoc = i;
            }
            this.swap(maxLoc, this.size()-1);
            this.quickSortRecursively(0, this.size()-2);
        }
    }
    public void quickSortRecursively(int left, int right) {
        if (left < right) { //탈출조건
            int mid = partition(left, right); //DIVIDE
            quickSortRecursively(left, mid-1); //CONQUER
            quickSortRecursively(mid+1, right); //CONQUER
        }
    }
    public int partition(int left, int right){
        //pivot을 기준으로 왼쪽에는 작은 수, 오른쪽에는 큰 수를 정렬
        int pivot = left;
        int toRight = left;
        int toLeft = right+1;
        do {
            do {
                toRight++;
            } while (this.elementAt(toRight).score() < this.elementAt(pivot).score());
            do {
                toLeft--;
            } while (this.elementAt(toLeft).score() > this.elementAt(pivot).score());
            if (toRight < toLeft) this.swap(toRight, toLeft);
        }while(toRight < toLeft);

        this.swap(pivot, toLeft); //pivot == left
        return toLeft; //pivot = toLeft
    }
    private void swap(int p, int q){
        Student temp = this.elementAt(p);
        this.setElementAt(p, this.elementAt(q));
        this.setElementAt(q, temp);
    }
    //<반을 quicksort로 정렬 END>

    //<성적 출력 START>
    public GradeCounter countGrades(){
        GradeCounter gradeCounter = new GradeCounter();
        Iterator<Student> iterator = this.iterator();
        while( iterator.hasNext()){
            Student student = iterator.next();
            char grade = Ban.scoreToGrade(student.score());
            gradeCounter.count(grade);
        }
        return gradeCounter;
    }
    private static char scoreToGrade(int aScore){
        //점수에 따른 학점 출력
        if(aScore >= 90) return 'A';
        else if(aScore >= 80) return 'B';
        else if(aScore >= 70) return 'C';
        else if(aScore >= 60) return 'D';
        else return 'F';
    }
    //<성적 출력 END>

}
