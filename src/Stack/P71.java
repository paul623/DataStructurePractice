package Stack;

class SqStack{
    char[] data;
    int top;
    public SqStack(){data = new char[50]; top = -1;}
    public void pushElem(char c){data[++top] = c;}
    public char popElem(){return data[top--];}
}
class ShareStack{
    int[] data;
    int[] top;
    public ShareStack(){data = new int[5];top = new int[2];};

    /**
     * 共享栈的输入元素
     * @param i
     * @param val
     * @return
     */
    public boolean push(int i, int val){
        if(i != 0 || i != 1){
            System.out.println("栈号输入不对");
            return false;
        }
        if(this.top[1] - this.top[0] == 1){
            System.out.println("栈已满");
            return false;
        }
        switch (i){
            case 0 :
                this.data[++this.top[0]] = val;
                return true;
            case 1:
                this.data[--this.data[1]] = val;
                return true;
            default:
                break;
        }
        return false;
    }

    /**
     * 共享栈的输出元素
     * @param i
     * @return
     */
    int pop(int i){
        if(i != 0 || i != 1){
            System.out.println("栈号输入不对");
            return -1;
        }
        switch (i){
            case 0:
                if(this.top[0] == -1){
                    System.out.println("栈空");
                    return -1;
                }else {
                    return this.data[this.top[0]--];
                }
            case 1:
                if(this.top[1] == 5){
                    System.out.println("栈空");
                    return -1;
                }else {
                    return this.data[this.top[1]--];
                }
        }
        return -1;
    }

}
class LinkNode{
    char data;
    LinkNode next;
    public LinkNode(){}
    public LinkNode(char data){
        this.data = data;
    }
}
@SuppressWarnings("ALL")
public class P71 {
    public static void main(String[] args) {
//        char[] arr = {'I','O','I','I','O','I','O','O'};
//        char[] arr1 = {'I','0','0','I','O','I','I','O'};
//        char[] arr2 = {'I','I','I','O','I','O','I','O'};
//        char[] arr3 = {'I','I','I','O','O','I','O','O'};
//        System.out.println(stackOptIsLegal(arr));
//        System.out.println(stackOptIsLegal(arr1));
//        System.out.println(stackOptIsLegal(arr2));
//        System.out.println(stackOptIsLegal(arr3));
        LinkNode list = new LinkNode(' ');
        LinkNode node = new LinkNode('x');
        list.next = node;
        node = new LinkNode('y');
        list.next.next = node;
        node = new LinkNode('y');
        list.next.next.next = node;
        node = new LinkNode('x');
        list.next.next.next.next = node;
        System.out.println(listIsSymmetrical(list,4));

    }

    /**
     * I和O表示入栈和出栈操作，栈的初态和终态都为空，可以操作的序列为合法序列，判断操作序列是否为合法序列
     * @param arr 操作数组
     * @return 布尔
     */
    public static boolean stackOptIsLegal(char[] arr){
        if(arr.length == 0){
            return false;
        }
        int elemNums = 0;
        for (char c : arr) {
            if(c == 'O' && elemNums == 0){
                return false;
            }
            if (c == 'O') {
                elemNums--;
            }
            if (c == 'I') {
                elemNums++;
            }
        }
        return elemNums == 0;
    }

    /**
     * 通过给出的单链表判断n个字符是否中心对成，例如xyx，xyyx
     * @param L
     * @param n
     * @return
     */
    public static boolean listIsSymmetrical(LinkNode L, int n){
        int i = n/2;
        LinkNode p = L.next;
        SqStack sqStack = new SqStack();
        while (sqStack.top != i - 1){
            sqStack.pushElem(p.data);
            p = p.next;
        }
        if(n % 2 != 0){
            p = p.next;
        }
        while (p != null){
            if(sqStack.popElem() != p.data){
                return false;
            }
            p = p.next;
        }
        return sqStack.top == -1;
    }
}
