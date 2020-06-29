package DataStructure.List;

public class main {
    public static void main(String[] args) {
        ArrayList<Integer> mylist = new ArrayList(5);
        for(int i = 0; i < 5; i++)
            mylist.list()[i] = i;

        int sum = 0;
        Iterator<Integer> e = mylist.iterator();
        while(e.hasNext())
            sum += e.next();

        System.out.println(sum);
    }
}
