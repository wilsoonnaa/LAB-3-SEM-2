public class List<T extends Comparable<T>> {
    //обощённый массив
    private T[] a;
    //индекс последней (первой пустой) позиции в массиве
    private int end;

    //конструктор
    public List(T[] a) {
        this.a = a;
        end = 0;
    }

    //первый свободный индекс
    public int end() {
        return end;
    }

    //вставка объекта Т в массив
    public void insert(T x, int p) {
        if (p >= 0 && p <= end) {
            //смещение элементов
            for (int i = end; i > p; i--)
                a[i] = a[i-1];
            a[p] = x;
            end++;
        }
    }

    //нахождение индекса элемента
    public int locate(T x) {
        for (int i = 0; i < end; i++) {
            if (x.compareTo((T) a[i]) == 0) return i;
        }
        return end;
    }

    //получение Р-го элемента
    public T retrieve(int p) throws IllegalArgumentException {
        //неркорректное знач. Р
        if (!checkPosition(p)) throw new IllegalArgumentException();
        return (T) a[p];
    }

    //удаление элемента с инд. р
    public void delete(int p) {
        if (!checkPosition(p)) throw new IllegalArgumentException();
        for (int i = p; i < end - 1; i++)
            a[i] = a[i+1];
        end--;
    }

    private boolean checkPosition(int p) { //проверка позици на корректность
        return !(p < 0 || p >= end);
    }

    //следующий за Р индекс
    public int next(int p) {
        if (!checkPosition(p)) throw new IllegalArgumentException();
        return p + 1;
    }

    //предыдущий индекс
    public int previous(int p) {
        if (!checkPosition(p)) throw new IllegalArgumentException();
        return p - 1;
    }

    //индекс первого элемента
    public int first() {return 0;}//TODO: реализовать условие при пустом списке(не нужно?)DONE

    //TODO: создать makenull метод НЕ НАДО
    //метод, делающий наш список пустым(по новой)
    public void makenull(){}

    public void printList() {
        for (int i = 0; i < end; i++) System.out.print(a[i] + " ");
        System.out.println();
    }
}
