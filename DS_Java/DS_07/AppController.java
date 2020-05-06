package DS_07;

public class AppController {
    private static final int VALID_MAX_SCORE = 100;
    private static final int VALID_MIN_SCORE = 0;

    private static final int BAN_CAPACITY = 10;

    private Ban _ban;
    private GradeCounter _gradeCounter;

    //<GETTER SETTER START>
    private Ban ban() { return this._ban; }
    private void setBan(Ban newBan) { this._ban = newBan; }
    private GradeCounter gradeCounter(){ return this._gradeCounter; }
    private void setGradesCounter(GradeCounter newGradeCounter) {this._gradeCounter = newGradeCounter;}
    //<GETTER SETTER END>

    public AppController(){}

    public void run(){
        AppView.outputLine("");
        AppView.outputLine("<<< 학급 성적 처리를 시작합니다 >>>");

        this.setBan(new Ban(AppController.BAN_CAPACITY));

        this.inputAndScoreStudents();

        if(this.ban().isEmpty()){
            AppView.outputLine("");
            AppView.outputLine("(경고) 입력된 성적이 없습니다.");
        }
        else{
            this.showStatistics();
            this.showGradeCounts();
            this.showStudentsSortedByScore();
        }
    }

    private void inputAndScoreStudents(){
        //ban에 학생들 추가
        AppView.outputLine("");
        boolean storingAStudentWasSuccessful = true;
        while(storingAStudentWasSuccessful && AppView.doesContinueToInputStudent()){
            Student student = AppController.inputStudent();
            //점수 입력 받은 학생 객체
            if(!this.ban().add(student)){
                AppView.outputLine("[경고] 입력에 오류가 있습니다. 학급에 더이상 학생을 넣을 공간이 없습니다.");
                storingAStudentWasSuccessful = false;
            }
        }
        AppView.outputLine("! 성적 입력을 마칩니다.");
    }

    private static Student inputStudent() {
        //범위내 점수를 받아서 해당 점수를 가진 학생 객체를 생성
        int score = AppView.inputScore();
        while(!AppController.scoreIsValid(score)){
            //score이 범위 안에 해당할때까지 반복
            AppView.outputLine("[오류] "
                    + AppController.VALID_MIN_SCORE + " 보다 작거나 "
                    + AppController.VALID_MAX_SCORE + " 보다 커서, 정상적인 점수가 아닙니다.");
            score = AppView.inputScore();
        }
        Student student = new Student();
        student.setScore(score);
        //score을 가진 학생을 생성
        return student;
    }

    private static boolean scoreIsValid(int aScore) {
        //입력받은 aScore이 범위에 해당하는지 확인
        return ((AppController.VALID_MIN_SCORE <= aScore) && (aScore <= AppController.VALID_MAX_SCORE));
    }

    private void showStatistics(){
        //학급 성적 통계 출력
        AppView.outputLine("");
        AppView.outputLine("[학급 성적 통계]");

        AppView.outputNumberOfStudents(this.ban().size());//반 크기
        AppView.outputHighestScore(this.ban().highest().score());//반 최고점
        AppView.outputLowestScore(this.ban().lowest().score());//반 최하점
        AppView.outputAverageScore(this.ban().average());//반 평균
        AppView.outputNumberOfStudentsAboveAverage(this.ban().numberOfStudentsAboveAverage());//반 평균 이상의 학생 수
    }

    private void showGradeCounts(){
        // 학점별 학생수 출력
        AppView.outputLine("");
        AppView.outputLine("[학점별 학생수]");

        this.setGradesCounter(this.ban().countGrades());

        AppView.outputNumberOfStudentsForGrade('A', this.gradeCounter().numberOfA());
        AppView.outputNumberOfStudentsForGrade('B', this.gradeCounter().numberOfB());
        AppView.outputNumberOfStudentsForGrade('C', this.gradeCounter().numberOfC());
        AppView.outputNumberOfStudentsForGrade('D', this.gradeCounter().numberOfD());
        AppView.outputNumberOfStudentsForGrade('F', this.gradeCounter().numberOfF());
    }

    private void showStudentsSortedByScore(){
        // 학생들 성적순 목록
        AppView.outputLine("");
        AppView.outputLine("[학생들의 성적순 목록]");

        this.ban().sortByScore();//반을 quicksort로 정렬

        Iterator<Student> iterator = this.ban().iterator();
        Student student = null;
        while(iterator.hasNext()){
            student = iterator.next();
            AppView.outputScore(student.score());
        }
    }




}
