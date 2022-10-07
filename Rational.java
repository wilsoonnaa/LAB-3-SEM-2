public class Rational implements Comparable<Rational>{
    //числитель
    private int a;
    //знаменатель
    private int q;

    //конструктор
    public Rational(int a, int q) {
        if (q == 0) throw new ArithmeticException();
        this.a = a * (q > 0 ? 1 : -1);
        this.q = Math.abs(q);
        //Наибольший Общий Делитель(НОД)
        int nod = EuclideanAlgorithm(Math.abs(a), Math.abs(q));
        this.a /= nod;
        this.q /= nod;
    }

    //сравнивает
    public int compareTo(Rational b) { //сравнение двух рациональных чисел
        return this.a*b.q - this.q*b.a;
    }

    public String toString() {
        if (a == 0)
            return "0";
        else if (a < q)
            //правильная дробь
            return a + "/" + q;
        else if (a == q)
            return "1";
        else
            //неправильная дробь
            return (a/q) + "." + (a - q*(a/q)) + "/" + q;
    }

    //алгоритм Евклида - нужен для НОДа
    private int EuclideanAlgorithm(int a, int q) {
        int remain;
        do {
            remain = a % q;
            a = q;
            q = remain;
        } while (remain != 0);
        return a;
    }
}