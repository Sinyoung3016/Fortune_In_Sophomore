public class PairwiseDisjointSets {

    private static final int INITIAL_SINGLETON_SET_SIZE = 1;

    private int numberOfElements;
    private int [] parentTree;

    public PairwiseDisjointSets(int givenNumberOfElements){
        this.setNumberOfElements(givenNumberOfElements);
        this.setParentTree(new int[this.numberOfElements()]);

        for(int rootOfSingletonSet = 0; rootOfSingletonSet <  this.numberOfElements(); rootOfSingletonSet++)
            this.setSizeOfSetFor(rootOfSingletonSet, INITIAL_SINGLETON_SET_SIZE);
    }

    //Getter Setter Start
    private int numberOfElements(){
        return this.numberOfElements;
    }
    private void setNumberOfElements(int newNumberOfElement){
        this.numberOfElements = newNumberOfElement;
    }
    private int [] parentTree(){
        return this.parentTree;
    }
    private void setParentTree(int [] newParentTree){
        this.parentTree = newParentTree;
    }
    //Getter Setter End

    //Private methods Start
    private void setParentOf(int aChildMember, int newParentMember){
        this.parentTree()[aChildMember] = newParentMember;
    }
    private int parentOf(int aMember){
        return this.parentTree()[aMember];
    }
    private boolean parentDoesExist(int aMember){
        return (this.parentOf(aMember) >= 0);
    }

    private int sizeOfSetFor(int aRoot){
        return (-this.parentOf(aRoot));
    }
    private void setSizeOfSetFor(int aRoot, int newSize){
        this.setParentOf(aRoot, -newSize);
    }
    //Private methods End

    //Public methods Start
    public int find(int aMember){
        int rootCandidate = aMember;
        while(this.parentDoesExist(rootCandidate))
            rootCandidate = this.parentOf(rootCandidate);

        int root = rootCandidate;

        int child = aMember;
        int parent = this.parentOf(child);
        if(parent >= 0){
            while(parent != root){
                this.setParentOf(child, root);
                child = parent;
                parent = this.parentOf(child);
            }
        }

        return root;
    }
    public  void union(int aMemberA, int aMemberB){
        int rootOfSetA = find(aMemberA);
        int rootOfSetB = find(aMemberB);

        int sizeOfSetA = this.sizeOfSetFor(rootOfSetA);
        int sizeOfSetB = this.sizeOfSetFor(rootOfSetB);

        if(sizeOfSetA < sizeOfSetB){
            this.setParentOf(rootOfSetA, rootOfSetB);
            this.setSizeOfSetFor(rootOfSetB, sizeOfSetA + sizeOfSetB);
        }else{
            this.setParentOf(rootOfSetB, rootOfSetA);
            this.setSizeOfSetFor(rootOfSetA, sizeOfSetA + sizeOfSetB);
        }
    }

    //Public methods End
}
