package DataStructure.BinarySearchTree_Dic;

public class DictionaryElement <Key, Obj> {
    private Key _key;
    private Obj _obj;
    public Key key(){ return this._key; }
    public void setKey(Key newKey){ this._key = newKey; }
    public Obj obj(){ return this._obj; }
    public void setObj(Obj newObj){ this._obj = newObj; }

    public DictionaryElement (){
        this(null, null);
    }
    public DictionaryElement (Key givenKey, Obj givenObj){
        this.setKey(givenKey);
        this.setObj(givenObj);
    }
}
