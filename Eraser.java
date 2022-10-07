public class Eraser {
    public static <T extends Comparable<T>> void eraseDuplicates(List<T> list) {
        for (int i = list.first(); i != list.end(); i = list.next(i)) {
            for (int j = list.next(i); j != list.end(); j = list.next(j)) {
                if (list.retrieve(i).compareTo(list.retrieve(j)) == 0) {
                    list.delete(j);
                    if (j != list.end())
                        j = list.previous(j);
                    else break;
                }
            }
        }
    }
    //TODO: РАЗОБРАТЬСЯ  в этой куче(снова)DONE

    public static void main(String[] args) {
        List<Rational> l1 = new List<Rational>(new Rational [10]); //Список из RationalNumber
        l1.insert(new Rational(1, 3), l1.end());
        l1.insert(new Rational(17, -10), l1.end());//TODO не работает!!!
        l1.insert(new Rational(1, 3), l1.first());
        l1.insert(new Rational(0, 3), l1.locate(new Rational(1, 3)));
        l1.insert(new Rational(5, 4), l1.end());
        System.out.println("List 1:");
        l1.printList();
        eraseDuplicates(l1);
        System.out.println("List 1 without duplicates:");
        l1.printList();

        List<Integer> l2 = new List<Integer>(new Integer [10]); //Список типа Integer
        l2.insert(5, l2.end());
        l2.insert(2, l2.locate(223));
        l2.insert(2, l2.first());
        l2.insert(2, l2.end());
        l2.insert(7, l2.locate(2));
        System.out.println("List 2:");
        l2.printList();
        eraseDuplicates(l2);
        System.out.println("List 2 without duplicates:");
        l2.printList();

        List<String> l3 = new List<String>(new String [10]); //Символьный список
        l3.insert("a", l3.end());
        l3.insert("b", l3.end());
        l3.insert("c", l3.first());
        l3.insert("a", l3.locate("c"));
        l3.insert("d", l3.end());
        l3.insert("b", l3.end());
        l3.insert("e", l3.locate("$"));
        System.out.println("List 3:");
        l3.printList();
        eraseDuplicates(l3);
        System.out.println("List 3 without duplicates:");
        l3.printList();

    }
}
