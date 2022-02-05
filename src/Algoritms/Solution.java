package Algoritms;//https://leetcode.com/litee/
import java.util.*;

public class Solution {

    // Task 59. Spiral Matrix II   https://leetcode.com/problems/spiral-matrix-ii/
    //Success
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    //Memory Usage: 34.4 MB, less than 8.33% of Java online submissions for Spiral Matrix II.
    public int[][] generateMatrix(int n) {
        int fillNum = 1;
        int[][] res = new int[n][n];
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;

        while (true) {
            if (left > right) break;
            for (int i = left; i <= right; i++) {  //up
                res[up][i] = fillNum++;
            }
            up++;

            if (up > down) break;
            for (int i = up; i <= down; i++) {    //right
                res[i][right] = fillNum++;
            }
            right--;

            if (left > right) break;
            for (int i = right; i >= left; i--) {  //down
                res[down][i] = fillNum++;
            }
            down--;

            if (up > down) break;
            for (int i = down; i >= up; i--) {     //left
                res[i][left] = fillNum++;
            }
            left++;
        }
        return res;
    }
//___________________________________________________________________________________________________________
    public int[][] merge(int[][] intervals) {
        List<IntervalsPoint> intervalsPoints = new ArrayList<>();
        List<IntervalsPoint> resList = new ArrayList<>();
        int[][] resArr;

        for (int i = 0; i < intervals.length; i++) {
            intervalsPoints.add(new IntervalsPoint(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(intervalsPoints);

        while (intervalsPoints.size() != 0) {
            IntervalsPoint firstCompare = intervalsPoints.get(0);
            intervalsPoints.remove(0);
            for (int i = 0; i < intervalsPoints.size(); i++) {
                if (firstCompare.inInterval(intervalsPoints.get(i))) {
                    firstCompare.expandPoints(intervalsPoints.get(i));
                    intervalsPoints.remove(i);
                    i--;
                }
            }
            resList.add(firstCompare);
        }

        resArr = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            resArr[i][0] = resList.get(i).leftPoint;
            resArr[i][1] = resList.get(i).rightPoint;
        }
        return resArr;
    }

    private class IntervalsPoint implements Comparable<IntervalsPoint> {
        public int leftPoint;
        public int rightPoint;

        public IntervalsPoint(int leftPoint, int rightPoint) {
            this.leftPoint = leftPoint;
            this.rightPoint = rightPoint;
        }

        @Override
        public int compareTo(IntervalsPoint o) {
            return leftPoint - o.leftPoint;
        }

        public boolean inInterval(IntervalsPoint intervalsPoint) {
            return (
                    (rightPoint >= intervalsPoint.leftPoint && rightPoint <= intervalsPoint.rightPoint) ||
                            (leftPoint <= intervalsPoint.rightPoint && leftPoint >= intervalsPoint.leftPoint)
            ) ||
                    (rightPoint < intervalsPoint.rightPoint && leftPoint > intervalsPoint.leftPoint) ||
                    (rightPoint > intervalsPoint.rightPoint && leftPoint < intervalsPoint.leftPoint);
        }

        public void expandPoints (IntervalsPoint intervalsPoint) {
            if (rightPoint < intervalsPoint.rightPoint) {
                rightPoint = intervalsPoint.rightPoint;
            }
            if (leftPoint > intervalsPoint.leftPoint) {
                leftPoint = intervalsPoint.leftPoint;
            }
        }

    }

    public boolean canJump(int[] nums) {
        int myPosition = 0;
        int maxWeightToAwealableJump = 0;
        int lastBestPosition = 0;
        while (true) {
            for (int i = 1; i < nums[myPosition] + 1; i++) {
                if (myPosition + i >= nums.length) {
                    break;
                }
                if (nums[myPosition + i] >= maxWeightToAwealableJump) {
                    maxWeightToAwealableJump = nums[myPosition + i];
                    lastBestPosition = myPosition + i;
                }
                if (myPosition + i == nums.length - 1) {
                    return true;
                }
            }
            maxWeightToAwealableJump = 0;
            myPosition = lastBestPosition;

            if (myPosition + nums[myPosition] >= nums.length - 1) {
                return true;
            }
            if (lastBestPosition == 0) {
                return false;
            }
            lastBestPosition = 0;
        }
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int right = matrix[0].length - 1;
        int left = 0;
        int up = 0;
        int down = matrix.length - 1;

        while (true) {
            if (left > right) break;
            for (int i = left; i <= right; i++) {     //up
                res.add(matrix[up][i]);
            }
            up++;

            if (up > down) break;
            for (int i = up; i <= down; i++) {        //right
                res.add(matrix[i][right]);
            }
            right--;


            if (right < left) break;
            for (int i = right; i >= left; i--) {     //down
                res.add(matrix[down][i]);
            }
            down--;

            if (down < up) break;
            for (int i = down; i >= up; i--) {        //left
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<PairStrings> listArg = new ArrayList<>();
        List<List<String>> listRes = new ArrayList<>();
        for (String str : strs) {
            listArg.add(new PairStrings(str));
        }
        Collections.sort(listArg);
        while (!listArg.isEmpty()) {
            PairStrings firstComp = listArg.get(0);
            listArg.remove(0);
            listRes.add(0, new ArrayList<>());
            listRes.get(0).add(firstComp.getOldString());
            while (!listArg.isEmpty()) {
                if (firstComp.equals(listArg.get(0))) {
                    listRes.get(0).add(listArg.get(0).getOldString());
                    listArg.remove(0);
                } else {
                    break;
                }
            }
        }
        return listRes;
    }

    private class PairStrings implements Comparable<PairStrings> {
        private String oldString;
        private String sortedString;

        public PairStrings(String str) {
            this.oldString = str;
            this.sortedString = sortString(str);
        }

        public String getSortedStr() {
            return sortedString;
        }

        public String getOldString() {
            return oldString;
        }

        private String sortString(String str) {
            List<String> listString = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                listString.add(str.substring(i, i + 1));
            }
            Collections.sort(listString);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < listString.size(); i++) {
                res.append(listString.get(i));
            }
            return res.toString();
        }

        @Override
        public String toString() {
            return "PairStrings{" +
                    "oldString='" + oldString + '\'' +
                    ", sortedString='" + sortedString + '\'' +
                    '}';
        }

        @Override
        public int compareTo(PairStrings argStr) {
            char[] thisChars = sortedString.toCharArray();
            char[] argChars = argStr.getSortedStr().toCharArray();

            int len1 = thisChars.length;
            int len2 = argChars.length;
            int lim = Math.min(len1, len2);
            char v1[] = thisChars;
            char v2[] = argChars;

            int k = 0;
            while (k < lim) {
                char c1 = v1[k];
                char c2 = v2[k];
                if (c1 != c2) {
                    return c1 - c2;
                }
                k++;
            }
            return len1 - len2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PairStrings that = (PairStrings) o;
            return Objects.equals(sortedString, that.sortedString);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sortedString);
        }
    }


    //TODO попробовать сделать на основе сортировки и сопостовления отсортированных слов и их оригиналов
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<String> listStrs = new ArrayList<>(Arrays.asList(strs));
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < listStrs.size(); i++) {
            if (listStrs.get(i).equals("")) {
                res.add(0, new ArrayList<>());
                for (int j = i; j < listStrs.size(); j++) {
                    if (listStrs.get(j).equals("")) {
                        res.get(0).add("");
                        listStrs.remove(j);
                        j--;
                        i = listStrs.size();
                    }
                }
            }
        }
        while (!listStrs.isEmpty()) {                                             // инициализируем первое слово(образец) для сравнения с другими и добавляем его в свою категорию
            res.add(0, new ArrayList<>());
            String compStr = listStrs.get(0);
            listStrs.remove(0);
            res.get(0).add(compStr);
            StringBuilder secondCompare;
            String secondCompareWithoutChenges;
            for (int i = 0; i < listStrs.size(); i++) {                           // выдаём по 1 слову для сравнения с первым образцом
                secondCompare = new StringBuilder(listStrs.get(i));
                secondCompareWithoutChenges = listStrs.get(i);
                int sucessComparedWords = 0;
                for (int j = 0; j < compStr.length(); j++) {                      // выдаём по 1 букве образца(к1) для сравнение
                    String strChar = compStr.substring(j, j + 1);


//                    if (new String(secondCompare).equals("dans") && compStr.equals("and")) {
//                        System.out.println();
//                    }

                    int beforeIncreaseSucessComparedWords = sucessComparedWords;
                    for (int k = 0; k < secondCompare.length(); k++) {            //осуществляем поиск буквы из к1 в в к2
                        if (strChar.equals(secondCompare.substring(k, k + 1))) {
                            sucessComparedWords++;
                            secondCompare.deleteCharAt(k);
                            k--;
                            break;
                        }
                    }
                    if (sucessComparedWords == beforeIncreaseSucessComparedWords) {
                        break;
                    }
                }
                if (sucessComparedWords == compStr.length() && secondCompareWithoutChenges.length() == sucessComparedWords) {
//                        if (compStr.equals("pun")) {
//                            System.out.println();
//                        }
                    res.get(0).add(listStrs.get(i));
                    listStrs.remove(i);
                    i--;
                }
            }
        }
        return res;
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 1) {
            return 1;
        }
        int nAbs;
        if (n == -2147483648) {
            nAbs = 2147483647;
        } else {
            nAbs = Math.abs(n);
        }
        double res = x;

        for (int i = 1; i < nAbs; i++) {
            double resBefore = res;
            res *= x;
            if (resBefore < res) {
                return 0;
            }
            if (res == 0) {
                return 0;
            }
        }
        if (n < 0) {
            if (res > Double.MAX_VALUE) {
                return 0;
            }
            return 1.0 / res;
        } else {
            return res;
        }
    }

    public void rotate(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int beginInd = 0;
        int endInd = matrix.length - 1;
        while (endInd - beginInd >= 0) {
            for (int i = beginInd; i <= endInd; i++) { //get top part
                arr.add(matrix[i][beginInd]);
            }
            for (int i = beginInd; i <= endInd; i++) { //get and setup right part
                if (i == beginInd) {
                    matrix[endInd][i] = arr.get(0);
                    arr.remove(0);
                    continue;
                }
                arr.add(matrix[endInd][i]);
                matrix[endInd][i] = arr.get(0);
                arr.remove(0);
            }
            for (int i = beginInd; i <= endInd; i++) {  //get and setup down part
                if (i == beginInd) {
                    continue;
                }
                arr.add(matrix[i][endInd]);
                matrix[i][endInd] = arr.get(0);
                arr.remove(0);
            }
            for (int i = beginInd; i <= endInd; i++) { //get and setup left part
                if (i == beginInd) {
                    continue;
                }
                if (i == endInd) {
                    matrix[endInd][i] = arr.get(0);
                    arr.remove(0);
                }
                arr.add(matrix[i][endInd]);
                matrix[i][endInd] = arr.get(0);
                arr.remove(0);
            }
            for (int i = beginInd; i <= endInd; i++) { //setup top part
                if (i == beginInd || i == endInd) {
                    continue;
                }
                matrix[endInd][i] = arr.get(0);
                arr.remove(0);
            }

            beginInd--;
            endInd--;
        }
    }

//    public List<List<Integer>> permute(int[] nums) {
//        List<Integer> insideRes = null;
//        List<List<Integer>> res = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            insideRes = new ArrayList<>();
//            for (int j = 0; j <)
//        }
//        return null;
//    }

    public int divide(int dividend, int divisor) {
        int sum = 0;
        int multiplyer = 0;
        if (dividend >= 0) {
            while (sum < dividend) {
                if (divisor > 0) {
                    int temp = sum;
                    sum += divisor;
                    if (sum < temp) {
                        return Integer.MAX_VALUE - 1;
                    }
                    multiplyer++;
                } else {
                    sum -= divisor;
                    multiplyer--;
                }
            }
        } else {
            while (sum > dividend) {
                if (divisor > 0) {
                    sum -= divisor;
                    multiplyer--;
                } else {
                    sum += divisor;
                    multiplyer++;
                }
            }
        }

        if (sum != dividend) {
            multiplyer -= 1;
        }
        if (dividend < 0 ^ divisor < 0) {
            return -multiplyer;
        } else {
            return multiplyer;
        }
    }

    public String multiply(String num1, String num2) {  //TODO
        List<String> listStrings = new ArrayList<>();
        listStrings.add(num1);
        listStrings.add(num2);

        List<List<Integer>> listIntegers = new ArrayList<>();
        listIntegers.add(new ArrayList<>());
        listIntegers.add(new ArrayList<>());

        for (int i = 0; i < listStrings.size(); i++) {
            for (int j = 0; j < listStrings.get(i).length(); j++) {
                listIntegers.get(i).add(Integer.valueOf(listStrings.get(i).substring(j, j + 1)));
            }
        }
        for (List<Integer> temp : listIntegers) {
            Collections.reverse(temp);
        }

        int carry = 0;
        List<Integer> sumOld = new ArrayList<>();
        sumOld.add(0);
        for (int i = 0; i < listIntegers.get(1).size(); i++) { //нижний множитель
            List<Integer> sum = new ArrayList<>();
            for (int j = 0; j < listIntegers.get(0).size(); j++) {  //верхний множитель
                int res = listIntegers.get(1).get(i) * listIntegers.get(0).get(j) + carry; //нижний перемножается с каждым верхним (формируется новое число)
                sum.add(0, res % 10);
                carry = res / 10;
            }
            if (carry != 0) {  // на случай если после перемножения останется остаток вне
                sum.add(0, carry);
            }

            Collections.reverse(sum);
            Collections.reverse(sumOld);
            List<Integer> sumRes = new ArrayList<>();
            int carrySum = 0;
            int maxSizeJ = Math.max(sumOld.size(), sum.size() + 1);
            for (int j = 0; j < maxSizeJ; j++) {
                int firstAddend = 0;   //слагаемое
                int secondAddend = 0;

                if (j < sumOld.size()) {
                    firstAddend = sumOld.get(j);
                }

                if (j - 1 < sum.size() && j - 1 >= 1) {
                    secondAddend = sum.get(j - 1);
                }

                int res = firstAddend + secondAddend + carrySum;
                sumRes.add(0, res % 10);
                carrySum = res / 10;
            }
            sumOld = sumRes;

//            List<Integer> smallestInteger = sumOld.size() <= sum.size() ? sumOld : sum;
//            List<Integer> biggestInteger = sum.size() >= sumOld.size() ? sum : sumOld;
//            int sumCarry = 0;

//            for (int sumI = 0; sumI < smallestInteger.size(); sumI++) {
//                int res = smallestInteger.get(sumI) + biggestInteger.get(sumI) + sumCarry;
//                biggestInteger.add(sumI, res % 10);
//                biggestInteger.remove(sumI + 1);
//                carry = res / 10;
//            }
//            int carryI = smallestInteger.size();
//            while (carry != 0) {
//                int res = biggestInteger.get(carryI) + carry;
//                biggestInteger.add(carryI, (res % 10));
//                biggestInteger.remove(carryI + 1);
//                carry = res / 10;
//                carryI++;
//            }
//            sumOld = biggestInteger;
        }

        return "";

//        List<Integer> tempIterator;
//        for (String nums : listInput) {
//            if (it.hasNext()) {
//                tempIterator = it.next();
//            }
//            else {
//                System.out.println("kurva");
//                break;
//            }
//            for (int i = 0; i < nums.length(); i++) {
//                tempIterator.add(Integer.valueOf(nums.substring(i, i + 1)));
//            }
//        }

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int maxI = (int) Math.log10(x);
        int res = 0;
        int muliplierPowTen = 0;
        for (int i = maxI; i >= 0; i--) {
            res += (x / (int) Math.pow(10, i) % 10) * (int) Math.pow(10, muliplierPowTen);
            muliplierPowTen++;
        }
        return res == x;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int res;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        while (l1 != null && l2 != null) {
            res = l1.val + l2.val + carry;
            l1.val = res % 10;

            carry = res / 10 == 0 ? 0 : 1;

            if (l2.next != null) {

            } else {
                int res2;
                while (carry == 1) {
                    if (l1.next == null) {
                        l1.next = new ListNode(1);
                        return dummy.next;
                    }
                    res2 = l1.next.val + carry;
                    l1.next.val = res2 % 10;

                    carry = res2 / 10 == 0 ? 0 : 1;
                    l1 = l1.next;
                }
                return dummy.next;
            }

            if (l1.next == null) {
                int res2;
                while (carry == 1 || l2.next != null) {
                    if (l2.next == null) {
                        l1.next = new ListNode(1);
                        return dummy.next;
                    }

                    res2 = l2.next.val + carry;
                    l1.next = new ListNode(res2 % 10);

                    carry = res2 / 10 == 0 ? 0 : 1;


                    l2 = l2.next;
                    l1 = l1.next;
                    //l2.next = l2.next.next;
                }
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long firstNum = 0;
        int pow = 0;
        while (l1 != null) {
            firstNum += l1.val * Math.pow(10, pow);
            pow++;
            l1 = l1.next;
        }

        long secondNum = 0;
        pow = 0;
        while (l2 != null) {
            secondNum += l2.val * Math.pow(10, pow);
            pow++;
            l2 = l2.next;
        }

        long res = firstNum + secondNum;

        if (res == 0 || res == 1) {
            return new ListNode((int) res);
        }

        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        for (int i = 0; i < (int) Math.log10(res) + 1; i++) {
            dummy.next = new ListNode((int) (res / (long) Math.pow(10, i) % 10));
            dummy = dummy.next;
        }
        return start.next;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }


        List<Integer> res = new ArrayList<>();
        int min = 0;
        int max = nums.length - 1;
        int mid = 0;
        while (nums[mid] != target) {
            mid = (min + max) / 2;
            if (nums[mid] < target) {
                min = mid + 1;
                if (min == nums.length) {
                    return new int[]{-1, -1};
                }
            } else if (nums[mid] > target) {
                max = mid - 1;
                if (max == -1) {
                    return new int[]{-1, -1};
                }
            }
            if (min > max) {
                return new int[]{-1, -1};
            }
        }


        //rightSearch
        int i = 1;

        while (mid - i >= 0 && nums[mid - i] == target) {
            res.add(mid - i);
            i++;
        }

        res.add(mid);

        //leftSearch
        i = 1;
        while (mid + i < nums.length && nums[mid + i] == target) {
            res.add(mid + i);
            i++;
        }

        Collections.sort(res);
        //createPrimitiveArray
        int[] resPrimitive = new int[2];
//        for (int j = 0; j < res.size(); j++) {
//            resPrimitive[j] = res.get(j);
//        }
        resPrimitive[0] = res.get(0);
        resPrimitive[1] = res.get(res.size() - 1);

        return resPrimitive;
    }
    //_________________________________

    public void printThreeSteps() {
        List<Boolean> list = new ArrayList<>();

        list.add(true);
        list.add(false);
        list.add(true);

        while (!list.get(0) || !list.get(1) || !list.get(2)) {
            list = new ArrayList<>();

            list.add(true);
            list.add(false);
            list.add(true);
            for (int i = 0; i < 3; i++) {

                List<Integer> uniqueId = getListRandomUniqueID();
                for (int j = 0; j <= 1; j++) {
                    boolean temp = list.get(uniqueId.get(j));
                    list.remove((int) uniqueId.get(j));
                    list.add(uniqueId.get(j), !temp);
                }
                System.out.println(list);
            }
        }
        System.out.print("<<<<");
        System.out.print(list);
        System.out.println(">>>");
        System.out.println("___________");
    }

    private List<Integer> getListRandomUniqueID() {
        List<Integer> listIntegers = new ArrayList<>();
        List<Integer> listIntegersOutput = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            listIntegers.add(i);
        }
        for (int i = 0; i < 2; i++) {
            int randomNum = new Random().nextInt(listIntegers.size());
            listIntegersOutput.add(listIntegers.get(randomNum));
            listIntegers.remove(randomNum);
        }
        return listIntegersOutput;
    }

    public void printMatrix() {
        int[][] arr = new int[6][6];
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                arr[i - 1][j - 1] = (i + j - 1) % 7;
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (!(haystack.length() >= i + needle.length())) {
                return -1;
            }

            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int searchInsert(int[] nums, int target) {
        final int fTarget = target;
        int min = 0;
        int max = nums.length - 1;
        int mid;

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        if (target == 0) {
            return 0;
        }

        do {
            mid = (int) (((double) min + (double) max) / 2);
            if (nums[mid] == fTarget) {
                return mid;
            }

            if (nums[mid] < target) {
                min = mid;
            } else {
                max = mid;
            }

            if (min + 1 == max || min == max) {
                if (fTarget <= nums[min]) {
                    return min;
                } else {
                    return max;
                }
            }
        } while (fTarget != min || fTarget != max);
        return max;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ArrayDeque<ListNode> kGroup = new ArrayDeque<>();

        while (true) {
            ListNode beforeKGroup = dummy;
            for (int i = 0; i < k; i++) {

                if (dummy.next == null) {
                    return start.next;
                }
                kGroup.addLast(dummy.next);
                dummy = dummy.next;
            }

            ListNode afterKGroup = dummy.next;

            for (int i = 0; i < k; i++) {
                ListNode buffer = kGroup.pollLast();
                buffer.next = null;
                beforeKGroup.next = buffer;
                beforeKGroup = beforeKGroup.next;
            }
            dummy = beforeKGroup;
            beforeKGroup.next = afterKGroup;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head.next == null) {
            return null;
        }

        int i = 0;
        ListNode startNode = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null) {
            if (i >= n) {
                dummy = dummy.next;
            }
            head = head.next;
            i++;
        }
        if (dummy.next == startNode) {
            return startNode.next;
        }
        dummy.next = dummy.next.next;

        return startNode;
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Boolean> mapIdToState = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            mapIdToState.put(i, true);
        }

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(0);
        sequence.add(0);
        for (int iFirst = 0; iFirst < nums.length; iFirst++) {

            sequence.set(0, nums[iFirst]);
            mapIdToState.put(iFirst, false);
            for (int iSecond = iFirst; iSecond < nums.length; iSecond++) {
                if (mapIdToState.get(iSecond) == true) {
                    sequence.set(1, nums[iSecond]);
                    mapIdToState.put(iSecond, false);
                } else {
                    continue;
                }
                for (int iThird = iSecond; iThird < nums.length; iThird++) {
                    if (mapIdToState.get(iThird) == true) {
                        sequence.set(2, nums[iThird]);
                        if (sequence.get(0) + sequence.get(1) + sequence.get(2) == 0) {
                            ans.add(new ArrayList<>(sequence));
                        }
                    } else {
                        continue;
                    }
                }
                mapIdToState.put(iSecond, true);
            }
            mapIdToState.put(iFirst, true);
        }
//        for (int iIndexSequence = 0; iIndexSequence < 3; iIndexSequence++) {
//            for (int iNums = 0; iNums < nums.length; iNums++) {
//
//            }
//        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Integer, String> buttons = new HashMap<>();
        buttons.put(2, "abc");
        buttons.put(3, "def");
        buttons.put(4, "ghi");
        buttons.put(5, "jkl");
        buttons.put(6, "mno");
        buttons.put(7, "pgrs");
        buttons.put(8, "tuv");
        buttons.put(9, "wxyz");

        List<String> strgs = new ArrayList<>();
        strgs.add("");

        int coutAddedElements = 0;
        for (int iInputDigits = 0; iInputDigits < digits.length(); iInputDigits++) {
            int digit = Character.getNumericValue(digits.charAt(iInputDigits));
            int strgsSize = strgs.size();
            for (int iExistsComb = 0; iExistsComb < strgsSize; iExistsComb++) {
                for (int iLettersButton = 0; iLettersButton < buttons.get(digit).length(); iLettersButton++) {
                    strgs.add(strgs.get(iExistsComb) + buttons.get(digit).substring(iLettersButton, iLettersButton + 1));
                    coutAddedElements++;
                }
            }

            int sizeBeforeClean = strgs.size();
            for (int i = 0; i < sizeBeforeClean - coutAddedElements; i++) {
                strgs.remove(0);
            }
            coutAddedElements = 0;
        }
        return strgs;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = "";

        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength, strs[i].length());
        }

        String newAns = "";
        while (ans.length() != minLength) {
            newAns = strs[0].substring(0, ans.length() + 1);
            for (int i = 0; i < strs.length; i++) {
                if (!newAns.equals(strs[i].substring(0, newAns.length()))) {
                    return ans;
                }
            }
            ans = newAns;
        }
        return ans;
    }


    Map<Integer, Integer> bitToIndex = new HashMap<>();
    List<String> indexToSimbol = new ArrayList<>();

    public Solution() {
        bitToIndex.put(1, 0);
        bitToIndex.put(5, 1);
        bitToIndex.put(10, 2);
        bitToIndex.put(50, 3);
        bitToIndex.put(100, 4);
        bitToIndex.put(500, 5);
        bitToIndex.put(1000, 6);

        indexToSimbol.add("I");
        indexToSimbol.add("V");
        indexToSimbol.add("X");
        indexToSimbol.add("L");
        indexToSimbol.add("C");
        indexToSimbol.add("D");
        indexToSimbol.add("M");
    }

    public String intToRoman(int num) {
        String ans = "";
        int bit = 1;
        while (num != 0) {
            String[] simbols = getSimbolsOfBitAndHiger(bit);
            String higher = simbols[2];
            String mid = simbols[1];
            String low = simbols[0];

            int convertNum = num % 10;
            if (convertNum <= 3) {
                for (int i = 0; i < convertNum; i++) {
                    ans = low + ans;
                }
            } else if (convertNum == 4) {
                ans = low + mid + ans;
            } else if (5 <= convertNum && convertNum <= 8) {
                for (int i = 5; i < convertNum; i++) {
                    ans = low + ans;
                }
                ans = mid + ans;
            } else if (convertNum == 9) {
                ans = low + higher + ans;
            }
            bit *= 10;
            num /= 10;
        }
        return ans;
    }

    public String[] getSimbolsOfBitAndHiger(int bit) {
        String[] arr = new String[3];
        int indexOfFirstSimbol = bitToIndex.get(bit);
        arr[0] = indexToSimbol.get(indexOfFirstSimbol);
        if (indexOfFirstSimbol + 1 < indexToSimbol.size()) {
            arr[1] = indexToSimbol.get(indexOfFirstSimbol + 1);
        }
        if (indexOfFirstSimbol + 2 < indexToSimbol.size()) {
            arr[2] = indexToSimbol.get(indexOfFirstSimbol + 2);
        }
        return arr;
    }


    public int maxArea(int[] height) {
        int startPoint = 0;
        int ans = 0;
        while (startPoint < height.length - 1) {
            for (int i = startPoint + 1; i < height.length; i++) {
                ans = Math.max(ans, Math.min(height[startPoint], height[i]) * (i - startPoint));
            }
            startPoint++;
        }
        return ans;
    }

    public int myAtoi(String str) {
        int minusMultiplier = 1;
        long ans = 0;
        boolean hasSign = false;
        boolean hasNum = false;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                break;
            } else if (str.charAt(i) == '-') {
                if (hasSign || hasNum) {
                    break;
                }
                minusMultiplier = -1;
                hasSign = true;
            } else if (str.charAt(i) == '+') {
                if (hasSign || hasNum) {
                    break;
                }
                hasSign = true;
                continue;
            } else if (str.charAt(i) == ' ') {
                if (hasNum || hasSign) {
                    break;
                }
                continue;
            } else if (Character.isDigit(str.charAt(i))) {
                if (Integer.MAX_VALUE < ans * 10 + Character.getNumericValue(str.charAt(i)) * minusMultiplier) {
                    return Integer.MAX_VALUE;
                } else if (Integer.MIN_VALUE > ans * 10 + Character.getNumericValue(str.charAt(i)) * minusMultiplier) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + Character.getNumericValue(str.charAt(i)) * minusMultiplier;
                hasNum = true;
            } else {
                break;
            }
        }
        return (int) ans;
    }


    public int reachNumber2(int target) {
        int n = 1;
        int nForMinus = -1;
        int multiplierMinus = target >= 0 ? 1 : -1;
        int myPosition = 0;

        while (myPosition != target) {
            n = 1;
            nForMinus++;
            myPosition = 0;

            for (int i = 0; i < nForMinus; i++) {
                myPosition += n * multiplierMinus * (-1);
                n++;
            }

            while (((target > 0) && (myPosition + n < target)) || (target < 0) && (myPosition - n > target)) {
                myPosition += n * multiplierMinus;
                if (Math.abs(myPosition) < Math.abs(target)) {
                    n++;
                }
            }

        }
        return n;
    }


    public int reachNumber(int target) {
        int n = 1;
        int multiplierMinus = target >= 0 ? 1 : -1;
        int myPosition = 0;

        while (Math.abs(myPosition) + n <= Math.abs(target)) {
            myPosition += n * multiplierMinus;
            if (Math.abs(myPosition) < Math.abs(target)) {
                n++;
            }
        }

        while (myPosition != target) {
            myPosition += n * multiplierMinus * -1;
            n++;
            myPosition += n * multiplierMinus;
            if (Math.abs(myPosition) < Math.abs(target)) {
                n++;
            }
        }
        return n;
    }

    public int reverse2(int x) {
        long ans = 0;

        while (x != 0) {
            long ansOld = ans;
            ans = (ans * 10) + x % 10;
            x /= 10;
            if (ans < Integer.MIN_VALUE || ans > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (ans);
    }


    public int reverse(int x) {
        String s = String.valueOf(x);
        String ans = "";
        if (s.substring(0, 1).equals("-")) {
            ans = ans.concat("-");
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                ans = ans.concat(s.substring(i, i + 1));
            }
        }

        try {
            return Integer.parseInt(ans);
        } catch (NumberFormatException ex) {
        }
        return 0;
    }


//__________________________________________________


    public String convert(String s, int numRows) {
        if (s.length() <= 1) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }

        String ans = "";
        int iterationPattern = -1;
        for (int iterationRow = 0; iterationRow < numRows; iterationRow++) {
            do {
                iterationPattern++;

                int firstElementNPattern = iterationPattern * ((numRows + numRows - 2));

                if (s.length() > firstElementNPattern + iterationRow) {
                    ans = ans.concat(s.substring(firstElementNPattern + iterationRow, firstElementNPattern + 1 + iterationRow));   //стобцы
                }

                if (iterationRow != 0 && iterationRow != numRows - 1) {
                    int lastElementColumnNPattern = firstElementNPattern + (numRows - 1);
                    int subStringBorder = lastElementColumnNPattern + (numRows - 1 - iterationRow);
                    if (s.length() > subStringBorder) {
                        ans = ans.concat(s.substring(subStringBorder, subStringBorder + 1));
                    }
                }
            }
            while ((s.length() - (numRows + (numRows - 2)) * iterationPattern) / (numRows + (numRows - 2)) != 0);
            iterationPattern = -1;
        }
        return ans;
    }


    public String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            int radius = 0;
            while (!(i - radius < 0) && !(i + radius >= s.length())) {                                                                        // до тех пор пока вписываемся в рамки
                if (s.substring(i - radius, i + 1).equals(String.valueOf(new StringBuffer(s.substring(i, i + 1 + radius)).reverse()))) {      // и когда зеркально равны
                    if (ans.length() < s.substring(i - radius, i + 1 + radius).length()) {                                                    // если больше топа - записываем
                        ans = s.substring(i - radius, i + 1 + radius);
                    }
                } else {
                    break;
                }
                radius++;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            int radius = 0;
            while (!(i - radius < 0) && !(i + 1 + radius >= s.length())) {                                                                        // до тех пор пока вписываемся в рамки
                if (s.substring(i - radius, i + 2).equals(String.valueOf(new StringBuffer(s.substring(i, i + 2 + radius)).reverse()))) {      // и когда зеркально равны
                    if (ans.length() < s.substring(i - radius, i + 2 + radius).length()) {                                                    // если больше топа - записываем
                        ans = s.substring(i - radius, i + 2 + radius);
                    }
                } else {
                    break;
                }
                radius++;
            }
        }


        return ans;
    }


    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring(String s) {
        List<String> includedLetter = new ArrayList<>();
        int biggestSequence = 0;
        for (int startPoint = 0; startPoint < s.length(); startPoint++) {
            int biggestSequenceInPass = 0;
            includedLetter = new ArrayList<>();
            for (int i = startPoint; i < s.length(); i++) {
                if (includedLetter.contains(s.substring(i, i + 1))) {
                    if (biggestSequence < biggestSequenceInPass) {
                        biggestSequence = biggestSequenceInPass;
                    }
                    break;
                } else {
                    includedLetter.add(s.substring(i, i + 1));
                    biggestSequenceInPass++;
                }
                if (biggestSequence < biggestSequenceInPass) {
                    biggestSequence = biggestSequenceInPass;
                }
            }

        }
        return biggestSequence;
    }

    private ListNode reverseListNodes(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        if (listNode.next == null) {
            return listNode;
        }
        ListNode currentNode = listNode;
        ListNode nextNode = listNode.next;
        ListNode prevNode = null;
        while (currentNode != null) {
            currentNode.next = prevNode;

            prevNode = currentNode;
            if (nextNode == null) {
                return currentNode;
            }
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        return currentNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(listNode1);
        ListNode reversedListNode = new Solution().reverseListNodes(listNode1);
        System.out.println(reversedListNode);
    }


    public void changeInt(Integer a) {
        a = 1;
    }

    public void changeArrInt(int[] arr) {
        arr[0] = 1;
    }
}
