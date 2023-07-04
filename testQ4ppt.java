public class testQ4ppt {


        public static int get_Largest(int a, int b, int c) {
        int largest;

        if (a >= b) {
            if (a >= c) {
                largest = a;
            } else {
                largest = c;
            }
        } else {
            if (b >= c) {
                largest = b;
            } else {
                largest = c;
            }
        }

        return largest;
    }

    public static void main(String[] args) {
          System.out.println( get_Largest(1, 2, 3));
    }
}
