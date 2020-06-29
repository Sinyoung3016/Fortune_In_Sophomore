package DataStructure.List;

public interface Iterator<T> {

    public boolean hasNext();
    //다음 원소가 존재하는 지

    public T next();
    //다음 원소를 얻어내고, 없으면 null값을 출력

}
