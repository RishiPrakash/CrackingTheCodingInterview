public class ZAlgorithm {
    public void buildZArray(char[] input, int[] Z) {
        int L = 0;
        int R = 0;
        for (int k = 1; k < input.length; k++) {
            if (k > R) {
                L = k;
                R = k;
                while (R < input.length && input[R] == input[R - L]) {
                    R++;
                }
                Z[k] = R - L;
                R--;
            } else {
                int k1 = k - L;
                if (Z[k1] < R-k+1) {
                    Z[k] = Z[k1];
                } else {


                    L = k;
                    while (R < input.length && input[R] == input[R - L]) {
                        R++;
                    }
                    Z[k] = R - L;
                    R--;

                }
            }
        }
    }

    public void computeMatch(String inputString, String toBeSearched) {
        int i1 = inputString.length() + toBeSearched.length() + 1;
        char[] input = new char[i1];
        int[] Z = new int[i1];
        int i = 0;
        for (; i < toBeSearched.length(); i++) {
            input[i] = toBeSearched.charAt(i);
        }
        input[i++] = '$';
        for (; i < input.length; i++) {
            input[i] = inputString.charAt(i-toBeSearched.length()-1);
        }
        buildZArray(input, Z);
        for (int j = 0; j < Z.length; j++) {
            System.out.print(Z[j]+" ");
            if (Z[j] == toBeSearched.length()) {
                System.out.println("Found at : " + j + " index");
            }
        }
    }

    public static void main(String[] args) {
        String input = "xyzabxyabcxz";
        String toBeSearched = "abc";
        new ZAlgorithm().computeMatch(input, toBeSearched);
    }



}
