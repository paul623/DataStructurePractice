package LinearList.SqList;

import java.sql.SQLInput;

class SqList{
    int[] data;
    int maxSize, length;
    public SqList(int[] data){
        this.data = data;
    }
}
@SuppressWarnings("ALL")
public class P19 {
    public static void main(String[] args) {
        int[] data = {9,2,8,7,4,3,1,0,6,5};
        SqList L = new SqList(data);
        L.length = data.length;

//        System.out.println(deleteMinVal(L));

//        SqList reverseList = reverseElem(L);

//        SqList sqList = deleteXVal(L, 7);
//        int[] data2={1,2,3,4,5,6,7,8,9};
//        L = new SqList(data2);
//        L.length = data2.length;
//        deleteRangeVal(L,4,8);
//        SqList sqList = deleteRangSTVal(L, 2, 7);
        SqList sqList = reverseTwoSqlList(L, 3, 7);
        for(int i = 0; i < L.length; i++){
            System.out.print(sqList.data[i]+",");
        }

    }

    /**
     * 从顺序表中删除最小值元素，并且返回最小值，空出的位置由最后一个元素填补
     * @param L 顺序表
     * @return  最小值元素
     */
    public static int deleteMinVal(SqList L){
        if(L.length == 0){
            System.out.println("顺序表为空");
            System.exit(0);
        }
        int index = 0;
        int min = L.data[0];
        for(int i = 1; i < L.length; i++){
            if(L.data[i] < min){
                min = L.data[i];
                index = i;
            }
        }
        L.data[index] = L.data[L.length-1];
        return min;
    }

    /**
     * 将顺序表中的元素逆置，算法的空间复杂度为O(1)
     * @param L 顺序表
     * @return  逆置后的顺序表
     */
    public static SqList reverseElem(SqList L){
        if(L.length == 0){
            System.out.println("顺序表为空");
            return L;
        }else {
            for(int i = 0; i < L.length/2; i++){
                int temp = L.data[i];
                L.data[i] = L.data[L.length-1-i];
                L.data[L.length-1-i] = temp;
            }
        }
        return L;
    }

    /**
     * 编写时间复杂度为O(n)，空间复杂度为O(1)的算法，删除顺序表中所有值为X的数
     * @param L 顺序表
     * @param x 数
     * @return  顺序表
     */
    public static SqList deleteXVal(SqList L,int x){
        if(L.length == 0){
            System.out.println("顺序表为空");
            return L;
        }else {
            int k = 0;
            for(int i = 0; i < L.data.length; i++){
                if(L.data[i] == x){
                    k++;
                }else {
                    L.data[i-k] = L.data[i];
                }
            }
            L.length = L.length-k;
        }
        return L;
    }

    /**
     * 从有序表中删除给定值在s和t之间的所有元素
     * @param L 顺序表
     * @param s 起始元素
     * @param t 终止元素
     * @return SqlList
     */
    public static SqList deleteRangeVal(SqList L, int s, int t){
        if(L.length == 0 || s >=t){
            System.out.println("顺序表为空");
            return L;
        }
        int start = 0, end = 0;
        for(int i = 0; i < L.length; i++){
            if(L.data[i]>s){
                start = i;
            }
            if(L.data[i] > t ){
                end = i;
            }
        }
        for(;end<L.length;end++,start++){
            L.data[start] = L.data[end];
        }
        L.length = start;
        return L;
    }

    /**
     * 删除顺序表中值在s和t之间的元素
     * @param L
     * @param s
     * @param t
     * @return SqlList
     */
    public static SqList deleteRangSTVal(SqList L,int s, int t){
        if(L.length == 0 || s >= t){
            return L;
        }
        int k = 0;
        for(int i = 0; i < L.length; i++){
            if(L.data[i] >= s && L.data[i] <= t){
                k++;
            }else {
                L.data[i-k] = L.data[i];
            }
        }
        L.length -= k;
        return L;
    }

    /**
     * 删除有序顺序表中所有重复的元素
     * @param L 顺序表
     * @return
     */
    public static SqList deleteRepeatVal(SqList L){
        if(L.length == 0){
            return L;
        }
        int i , j;
        for(i = 0,j = 1; i < L.length; j++){
            if(L.data[i] != L.data[j]){
                L.data[++i] = L.data[j];
            }
        }
        L.length = i + 1;
        return L;
    }

    /**
     * 将两个有序顺序表合并为一个新的有序顺序表
     * @param A
     * @param B
     * @param C
     * @return
     */
    public static SqList combineSqList(SqList A, SqList B, SqList C){
        if(A.length + B.length > C.maxSize){
            return null;
        }
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length){
            if(A.data[i] <= B.data[j])
                C.data[k++] = A.data[i++];
            else
                C.data[k++] = B.data[j++];
        }
        while (i < A.length){
            C.data[k++] = A.data[i++];
        }
        while (j < B.length){
            C.data[k++] = B.data[j++];
        }
        C.length = k;
        return C;
    }

    public static SqList reverseLenElem(SqList L, int start, int end){
        if(L.length == 0 || start >= end){
            return L;
        }
        for(int i = 0; i < (end-start+1)/2; i++){
            int temp = L.data[start+i];
            L.data[start+i] = L.data[end-i];
            L.data[end-i] = temp;
        }
        return L;
    }

    /**
     * 一维数组A[m+n]中依次存放两个线性表(a1,a2,a3,...,am)和(b1,b2,b3,...bn),将b数列放在a数列的前面
     * @param L
     * @param m
     * @param n
     * @return
     */
    public static SqList reverseTwoSqlList(SqList L, int m, int n){
        if(L.length == 0){
            return L;
        }
        reverseLenElem(L,0,m-1);
        reverseLenElem(L,m,m+n-1);
        reverseLenElem(L,0,L.length-1);
        return L;
    }

    public static SqList searchExchangeInsert(SqList L, int x) {
        if(L.length == 0){
            return L;
        }
        int low = 0, high = L.length-1,mid = 0;
        while (low < high){
            mid = (low + high)/2;
            if(L.data[mid] == x)break;
            else if(L.data[mid] < x)low = mid + 1;
            else high = mid -1;
        }
        if(L.data[mid] == x && mid != L.length -1){
            int temp = L.data[mid];
            L.data[mid] = L.data[mid+1];
            L.data[mid+1] = temp;
        }
        if(low > high){
            int i;
            for(i = L.length - 1; i > high; i--){
                L.data[i+1] = L.data[i];
            }
            L.data[i+1] = x;
        }
        return L;
    }

}
