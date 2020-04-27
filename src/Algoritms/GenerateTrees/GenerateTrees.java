package Algoritms.GenerateTrees;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    public int numTrees(int n) {
        if (n == 1) {
            return 1;
        }
        n--;
        int res = 0;
        Layer startLayer = new Layer(1, null);
        Layer currentLayer = startLayer;
        while (true) {
            if (n > 0 && currentLayer.getNextLayer() == null) { //если уровни ещё не простроены(есть свободные узлы) и последний уровень не использован
                Layer nextLayer = new Layer(currentLayer.getCountOfChildrens(), currentLayer);
                currentLayer = nextLayer;
                n--;
                if (n == 0) {
                    res++;
                }
            } else { //
                List<Integer> tempNewNum = PlusOneBinary.plusOne(n, currentLayer.getCurrentNum());
                if (tempNewNum == null) { // узлы закончились, пытаемся плюсануть текущий
                    if (currentLayer != startLayer) {
                        currentLayer.getPreviousLayer().setNextLayer(currentLayer); //пометка, что слой уже использован, следовательно предыдущий нужно плюсануть
                        n += Layer.getOneCount(currentLayer.getCurrentNum());
                        currentLayer = currentLayer.getPreviousLayer();
                        //res++;
                    } else {
                        break;
                    }
                } else { // плюсование
                    n += Layer.getOneCount(currentLayer.getCurrentNum()) - Layer.getOneCount(tempNewNum);
                    currentLayer.setCurrentNum(tempNewNum);
                    if (n == 0) {
                        res++;
                    }
                    if (currentLayer.getNextLayer() != null) {
                        currentLayer.setNextLayer(null);
                    }
                }
            }
        }
        return res;
    }
}


class Layer {
    private List<Integer> currentNum = new ArrayList<>();
    private Layer previous = null;
    private Layer next = null;

    public Layer(int size, Layer previous) {
        this.previous = previous;
        for (int i = 0; i < size - 1; i++) {
            currentNum.add(0);
        }
        currentNum.add(1);
    }

//    public static String plusOneBinary(int availableNodes, String currentNum) {
//        int oneCount = getOneCount(currentNum);
//        int size = currentNum.length();
//
//        do {
//            currentNum = Integer.toBinaryString(Integer.parseInt(currentNum, 2) + 1);
//            for (int i = currentNum.length(); i < size; i++) {
//                currentNum = "0".concat(currentNum);
//            }
//            if (currentNum.length() > size) {
//                return null;
//            }
//        } while ((oneCount + availableNodes) < getOneCount(currentNum));
//
//        return currentNum;
//    }

    /**
     * возвращает количество единиц в номере
     *
     * @param binaryNum - бинарный номер
     */
    public static int getOneCount(List<Integer> binaryNum) {
        int oneCount = 0;
        for (int i = 0; i < binaryNum.size(); i++) {
            if (binaryNum.get(i) == 1) {
                oneCount++;
            }
        }
        return oneCount;
    }

    public int getCountOfChildrens() {
        return getOneCount(currentNum) * 2;
    }

    public List<Integer> getCurrentNum() {
        return currentNum;
    }

    public Layer getPreviousLayer() {
        return previous;
    }

    public Layer getNextLayer() {
        return next;
    }

    public void setNextLayer(Layer next) {
        this.next = next;
    }

    public void setCurrentNum(List<Integer> newNum) {
        currentNum = newNum;
    }
}

class PlusOneBinary {
    public static List<Integer> plusOne(int aviableNodes, List<Integer> argNum) {
        List<Integer> num= new ArrayList<>(argNum);
        int startOneCount = Layer.getOneCount(num);
        do {
            for (int i = num.size() - 1; i >= 0; i--) {
                int plusOne = num.get(i) + 1;
                if (plusOne == 2) {
                    num.set(i, 0);
                } else {
                    num.set(i, plusOne);
                    break;
                }
                if (i == 0) {
                    return null; // превышение исходного количества цифр
                }
            }

        } while (startOneCount + aviableNodes < Layer.getOneCount(num));
        return num;
    }

//    public static void main(String[] args) {
//        List<Integer> num = new ArrayList<>();
//        num.add(0, 0);
//        num.add(1, 1);
//        num.add(2, 0);
//        System.out.println(PlusOneBinary.plusOne(0, num));
//    }
}