// Find the nth prime number

public class NPrime {
    public int nPrime(int n) {
        if (n < 4) {
            return n;
        }

        int temp = 1;
        int count = 0;

        while (count < n) {
            if (isPrime(temp)) {
                count++;
            }
            if (count == n) {
                break;
            }
            temp++;
        }

        return temp;
    }

    private boolean isPrime(int n) {
        if (n < 4) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i < n/2; i+=2) {
            if (n%i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        NPrime test = new NPrime();
        System.out.println("1: " + test.nPrime(1));
        System.out.println("2: " + test.nPrime(2));
        System.out.println("3: " + test.nPrime(3));
        System.out.println("4: " + test.nPrime(4));
        System.out.println("5: " + test.nPrime(5));
        System.out.println("6: " + test.nPrime(6));
    }
}
