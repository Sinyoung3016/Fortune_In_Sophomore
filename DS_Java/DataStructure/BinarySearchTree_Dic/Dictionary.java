package DataStructure.BinarySearchTree_Dic;

//구현 방법 : List, Tree(BinarySearch, MultiWaySearch), HashTable
public class Dictionary <Key extends Comparable<Key>, Obj>{

    private int _size;
    private BinaryNode<DictionaryElement <Key, Obj>> _root;

    public Dictionary(){
        this._size = 0;
        this._root = null;
    }

    public boolean isEmpty(){ return (this.size() == 0); }
    public boolean isFull(){ return false; }
    public int size(){ return this._size; }

    public boolean keyDoesExist(Key aKey){
        //주어진 키가 사전에 존재하는 지 여부를 확인

        //****************************
        //nonRecursive
        boolean found = false;
        BinaryNode<DictionaryElement<Key, Obj>> currentRoot = this._root;
        while((!found)&&(currentRoot != null)){
            if(aKey.compareTo(currentRoot.element().key()) == 0)
                found = true;
            else if(aKey.compareTo(currentRoot.element().key()) < 0)
                currentRoot = currentRoot.left();
            else currentRoot = currentRoot.right();
        }
        return found;

        //****************************
        // Recursive
        // return this.keyDoesExistRecursively(this._root, aKey);


        //****************************
        //return (this.objectForKey(aKey) != null);
    }

    public boolean keyDoesExistRecursively( BinaryNode<DictionaryElement<Key, Obj>> currentRoot, Key aKey){
        if(currentRoot == null) return false;

        if(aKey.compareTo(currentRoot.element().key()) == 0)
            return true;
        else if(aKey.compareTo(currentRoot.element().key()) < 0)
            return this.keyDoesExistRecursively(currentRoot.left(), aKey);
        else
            return  this.keyDoesExistRecursively(currentRoot.right(), aKey);
    }

    public Obj objectForKey(Key aKey){
        //주어진 키를 갖는 객체를 반환

        //****************************
        //nonRecursive
        boolean found = false;
        BinaryNode<DictionaryElement <Key,Obj>> currentRoot  = this._root;
        while((!found)&&(currentRoot != null)) {
            //찾지못함 && 마지막 노드를 만날때까지
            if (aKey.compareTo(currentRoot.element().key()) == 0) {
                //키값 == 루트값, 찾음
                found = true;
            } else if (aKey.compareTo(currentRoot.element().key()) < 0) {
                //키값 < 루트값, 왼쪽 노드를 루트로
                currentRoot = currentRoot.left();
            } else {
                //키값 > 루트값, 오른쪽 노드를 루트로
                currentRoot = currentRoot.right();
            }
        }

        if(found) //찾았음
            return currentRoot.element().obj();
        else return null;
        //찾지 못하고 종료

        //****************************
        // Recursive
        // return this.objectForKeyRecursively(this._root, aKey);
    }

    private Obj objectForKeyRecursively(BinaryNode<DictionaryElement<Key, Obj>> currentRoot, Key aKey){
        if(currentRoot == null) return null;
        else{
            if(aKey.compareTo(currentRoot.element().key()) == 0)
                return currentRoot.element().obj();
            else if(aKey.compareTo(currentRoot.element().key()) < 0)
                return this.objectForKeyRecursively(currentRoot.left(), aKey);
            else
                return this.objectForKeyRecursively(currentRoot.right(), aKey);
        }
    }

    public boolean addKeyAndObject (Key aKey, Obj anObj){
        //새로운 노드를 사전에 추가
        //1. 첫노드 인가요?
        //2. 다음 right 또는 left가 null값 인가요?yy

        if(this._root == null) {
            //첫 노드일때
            this._root = new BinaryNode(new DictionaryElement(aKey, anObj), null, null);
            this._size = 1;
            return true;
        }
        else {//첫노드가 아닐 때

            //****************************
            // nonRecursive

            BinaryNode<DictionaryElement<Key, Obj>> currentRoot = this._root;
            while(aKey.compareTo(currentRoot.element().key()) != 0){
                if(aKey.compareTo(currentRoot.element().key()) < 0 ){
                    //left
                    if(currentRoot.left() == null) {//삽입 가능
                        DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObj);
                        currentRoot.setLeft(new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd, null, null));
                        this._size++;
                        return true;
                    }
                    else { //삽입 불가
                        currentRoot = currentRoot.left();
                    }
                }else{
                    //right
                    if(currentRoot.right() == null) {//삽입 가능
                        DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObj);
                        currentRoot.setRight(new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd, null, null));
                        this._size++;
                        return true;
                    }
                    else { //삽입 불가
                        currentRoot = currentRoot.right();
                    }
                }
            }
            return false; //키값 == 노드값

            //****************************
            // Recursive
            // return this.addKeyAndObjectToSubtree(this._root, aKey, anObj);
        }
    }

    private boolean addKeyAndObjectToSubtree(BinaryNode<DictionaryElement<Key, Obj>> currentRoot, Key aKey, Obj anObj ){
        if(currentRoot.element().key().compareTo(aKey) == 0) return false;
        else if(aKey.compareTo(currentRoot.element().key()) < 0){
            if(currentRoot.left() == null) {//노드 == null, 삽입 가능
                DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObj);
                currentRoot.setLeft(new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd, null, null));
                this._size++;
                return true;
            }
            else {//노드 != null, 삽입 불가
                return this.addKeyAndObjectToSubtree(currentRoot.left(), aKey, anObj);
            }
        }//Left
        else{
            if(currentRoot.right() == null) {//노드 == null, 삽입 가능
                DictionaryElement<Key, Obj> elementForAdd = new DictionaryElement<Key, Obj>(aKey, anObj);
                currentRoot.setRight(new BinaryNode<DictionaryElement<Key, Obj>>(elementForAdd, null, null));
                this._size++;
                return true;
            }
            else {//노드 != null, 삽입 불가
                return this.addKeyAndObjectToSubtree(currentRoot.right(), aKey, anObj);
            }
        }  //Right
    }

    public Obj removeObjectForKey(Key aKey){
        //주어진 키값을 가지는 노드를 삭제
        Obj removedObject = null;
        if(this._root == null) return null;
        //첫노드를 삭제 할 때
        if(aKey.compareTo(this._root.element().key()) == 0){
            removedObject = this._root.element().obj();
            //obj값을 반환
            if((this._root.left() == null) && (this._root.right() == null)){
                //root만 있는 tree, child가 없어서 null
                this._root = null;
            }
            else if(this._root.left() == null){
                //root의 left가 없음, 따라서 right로
                this._root = this._root.right();
            }
            else if(this._root.right() == null){
                //root의 right가 없음, 따라서 left로
                this._root = this._root.left();
            }
            else{ //root의 left와 right가 있음
                this._root.setElement(this.removeRightMostElementOfLeftTree(this._root));
            }
            this._size--;
            return removedObject;
        }
        else{//첫노드가 아닌 노드를 삭제할때
            return this.removeObjectForKeyFromSubtree(this._root, aKey);
        }
    }

    private DictionaryElement<Key, Obj> removeRightMostElementOfLeftTree(BinaryNode currentRoot){
        //첫노드를 삭제 할때
        //목표 : currentRoot = 왼쪽 트리의 가장 오른쪽 노드

        BinaryNode<DictionaryElement<Key, Obj>> leftOfCurrentRoot = currentRoot.left();
        //currentRoot.left는 null이 아님(조건임)
        if(leftOfCurrentRoot.right() == null){
            //right에 값이 없음
            currentRoot.setLeft(leftOfCurrentRoot.left());
            //노드 연결
            return leftOfCurrentRoot.element();
            //leftOfCurrentRoot를 currentRoot로 반환
        }
        else{//right에 값이 있음
            BinaryNode<DictionaryElement<Key, Obj>> parentOfRightMost = leftOfCurrentRoot;
            BinaryNode<DictionaryElement<Key, Obj>> rightMost = leftOfCurrentRoot.right();
            while(rightMost.right() != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right();
            }
            parentOfRightMost.setRight(rightMost.left());
            //rightMost의 left값이 있을 수 있음, 노드 연결해주고 가야함

            return rightMost.element();
            //rightMost를 currentRoot로 반환
        }

    }

    private Obj removeObjectForKeyFromSubtree(BinaryNode <DictionaryElement<Key, Obj>> currentRoot, Key aKey) {
        //currentRoot는 null이 아니고, currentRoot의 key는 aKey와 일치하지 않음

        if (aKey.compareTo(currentRoot.element().key()) < 0) {
            //left
            BinaryNode<DictionaryElement<Key, Obj>> child = currentRoot.left();
            if (child == null) return null;
            else {
                if (aKey.compareTo(child.element().key()) == 0) {
                    Obj removedObject = child.element().obj();
                    if ((child.left() == null) && (child.right() == null))
                        currentRoot.setLeft(null);
                    else if (child.left() == null)
                        currentRoot.setLeft(child.right());
                    else if (child.right() == null)
                        currentRoot.setLeft(child.left());
                    else currentRoot.setElement(this.removeRightMostElementOfLeftTree(child));

                    this._size--;
                    return removedObject;
                }
                else{
                    return this.removeObjectForKeyFromSubtree(child, aKey);
                }
            }
        }
        else{ //right
            BinaryNode<DictionaryElement<Key, Obj>> child = currentRoot.right();
            if (child == null) return null;
            else {
                if (aKey.compareTo(child.element().key()) == 0) {
                    Obj removedObject = child.element().obj();
                    if ((child.left() == null) && (child.right() == null))
                        currentRoot.setRight(null);
                    else if (child.left() == null)
                        currentRoot.setRight(child.right());
                    else if (child.right() == null)
                        currentRoot.setRight(child.left());
                    else currentRoot.setElement(this.removeRightMostElementOfLeftTree(child));

                    this._size--;
                    return removedObject;
                }
                else{
                    return this.removeObjectForKeyFromSubtree(child, aKey);
                }
            }
        }
    }

    public boolean replaceObjectForKey(Key aKey, Obj objectForReplace){
        //주어진 키값을 가지는 노드를 다른 노드로 교체
        boolean found = false;
        BinaryNode<DictionaryElement<Key,Obj>> currentRoot = this._root;
        while ((!found) && (currentRoot != null)){
            if(aKey.compareTo(currentRoot.element().key()) < 0)
                currentRoot = currentRoot.left();
            else if(aKey.compareTo(currentRoot.element().key()) > 0)
                currentRoot = currentRoot.right();
            else found = true;
        }
        if(found){
            currentRoot.element().setObj(objectForReplace);
            return true;
        }
        else return false;

    }
    public void clear(){
        //사전의 모든 값들을 삭제하고 사전을 비움
        this._size = 0;
        this._root = null;
    }

}
