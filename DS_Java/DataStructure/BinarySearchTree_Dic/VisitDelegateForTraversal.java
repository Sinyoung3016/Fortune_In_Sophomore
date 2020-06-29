package DataStructure.BinarySearchTree_Dic;

public interface VisitDelegateForTraversal<Key, Obj> {

    //트리 탐색을 실행하는 함수에서 노드를 방문할때 마다, 실행할 콜백함수 사용법을 정의하기위한 인터페이스
    //이진 트리로 구현된 Dictionary 클래스와 사용자 클래스는 콜백을 위한 해당 인터페이스를 공유함
    //아래 함수의 매개변수로, 사용자는 트리를 탐색할 동안 노드를 방문할때 마다
    //방문 노드의 원소와 그 노드의 트리레벨 정보를 콜백함수를 통해 전달받게 됨

    public void visitForInorder(DictionaryElement<Key, Obj> anElement, int aLevel);
    public void visitForReverseOfInorder(DictionaryElement<Key, Obj> anElement, int aLevel);

}
