package Queue;

class SqStack{
    int[] data;
    int top;
    public SqStack(){data = new int[5]; top = -1;}
    public void pushElem(int c){data[++top] = c;}
    public int popElem(){return data[top--];}
}
class Queue{
    int[] data;
    int front = -1, rear = -1;
    public Queue(){data = new int[10];}
    public int[] getData(){
        return this.data;
    }
    public void enQueue(int x){
        if(this.rear == 9){
            System.out.println("队列满");
        }else {
            this.data[++rear] = x;
        }
    }
    public int deQueue(){
        if(this.rear == this.front){
            System.out.println("队列空");
            return 0;
        }else {
            int p = this.data[front++];
            return p;
        }
    }
}
class CircleLinkQueue{
    int[] data;
    int front = 0, rear = 0, tag = 0;
    public CircleLinkQueue(){data = new int[5];};

    /**
     * 循环队列进队算法
     * @param x
     * @return
     */
    public int enQueue(int x){
        if(this.tag == 1 && this.front == this.rear){
            System.out.println("队列已满");
            return 0;
        }
        this.data[this.rear] = x;
        this.rear = (this.rear + 1)%5;
        this.tag = 1;
        return 1;
    }

    /**
     * 循环队列出队算法
     * @return
     */
    public int deQueue(){
        if(this.tag == 0 && this.front == this.rear){
            System.out.println("队列为空");
            return 0;
        }
        int p = this.data[this.front];
        this.front = (this.front + 1)%5;
        this.tag = 0;
        return p;
    }

}
public class P85 {
    public static void main(String[] args) {

    }

    public static Queue reverseValInQueue(Queue Q, SqStack S){
        int count = Q.getData().length;
        for(int i = 0; i < count; i++){
            S.pushElem(Q.deQueue());
        }
        for(int i = 0; i < count; i++){
            Q.enQueue(S.popElem());
        }
        return Q;
    }
}
