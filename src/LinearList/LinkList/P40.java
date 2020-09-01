package LinearList.LinkList;

import com.sun.org.apache.bcel.internal.generic.LNEG;
import jdk.internal.org.objectweb.asm.tree.InnerClassNode;

import java.util.HashMap;

class LinkNode{
    int data;
    LinkNode next;
    public LinkNode(){}
    public LinkNode(int data){
        this.data = data;
    }
}

@SuppressWarnings("ALL")
public class P40 {
    public static void main(String[] args) {
        LinkNode list = new LinkNode(0);
        LinkNode node = new LinkNode(4);
        list.next = node;
        node = new LinkNode(5);
        list.next.next = node;
        node = new LinkNode(3);
        list.next.next.next = node;
        node = new LinkNode(4);
        list.next.next.next.next = node;
        node = new LinkNode(3);
        list.next.next.next.next.next = node;
        printList(list);
//        LinkNode resultList = deleteAllX(list, 3);
//        LinkNode resultList = deleteAllXCommonFun(list, 3);
//        LinkNode resultList = printReverseList(list);
//        LinkNode resultList = deleteMinVal(list);
//        LinkNode resultList = reverseList(list);
//        LinkNode resultList = reverseListFun2(list);
//        LinkNode resultList = deleteRangeVal(list,2,4);
//        printList(resultList.next);
//        increasePrintNodeVal(list);
//        LinkNode A = new LinkNode(), B = new LinkNode();
//        divideTwoList(list,A,B);
//        printList(A);
//        printList(B);
        LinkNode resultList = deleteRepeatValNode(list);
        printList(resultList);
    }

    /**
     * 打印单链表链表
     * @param list
     */
    public static void printList(LinkNode list){
        while (list != null){
            System.out.print(list.data + ",");
            list = list.next;
        }
        System.out.println("");
    }

    /**
     * 递归删除单链表中所有值为x的节点
     * @param list
     * @param x
     * @return
     */
    public static LinkNode deleteAllX(LinkNode list, int x){
        if(list == null){
            return list;
        }
        if(list.data == x){
            if(list.next != null){
                list = list.next;
            }else {
                list = null;
            }
        }
        if(list.next != null){
            list.next = deleteAllX(list.next,x);
        }
        return list;
    }

    /**
     * 删除带头结点的单链表L中所有值为x的节点
     * @param L
     * @param x
     * @return
     */
    public static LinkNode deleteAllXCommonFun(LinkNode L, int x){
        LinkNode prep = L, p = L.next;
        while (p != null){
            if(p.data == x){
                p = p.next;
                prep.next = p;
            }
            if(p != null){
                prep = p;
                p = p.next;
            }
        }
        return L;
    }

    /**
     * 反向输出带头单链表L的节点的值
     * @param L
     * @return
     */
    public static LinkNode printReverseList(LinkNode L){
        LinkNode head = new LinkNode(),p = L.next;
        while (p != null){
            LinkNode n = new LinkNode(p.data);
            n.next = head.next;
            head.next = n;
            p = p.next;
        }
        return head;
    }

    /**
     * 删除带头节点单链表L中的最小值节点
     * @param L
     * @return
     */
    public static LinkNode deleteMinVal(LinkNode L){
        LinkNode minPrep = L;
        LinkNode minNode = minPrep.next;
        LinkNode prep = L.next, p = prep.next;
        while (p != null){
            if(p.data < minNode.data){
                minPrep = prep;
                minNode = p;
            }
            prep = p;
            p = p.next;
        }
        minPrep.next = minNode.next;
        return L;
    }

    /**
     * 将带头单链表逆置，要求空间复杂度O(1)
     * @param L
     * @return
     */
    public static LinkNode reverseList(LinkNode L){
        LinkNode p = L.next, q;
        L.next = null;
        while (p != null){
            q = p.next;
            p.next = L.next;
            L.next = p;
            p = q;
        }
        return L;
    }

    /**
     * 将带头单链表逆置，要求空间复杂度O(1) 解法2
     * @param L
     * @return
     */
    public static LinkNode reverseListFun2(LinkNode L){
        LinkNode prep, p = L.next, r = p.next;
        p.next = null;
        while (r != null){
            prep = p;
            p = r;
            r = r.next;
            p.next = prep;
        }
        L.next = p;
        return  L;
    }

    /**
     * 对带头节点的单链表L递增排序
     * @param L
     * @return
     */
    public static LinkNode sortList(LinkNode L){
        LinkNode p = L.next, prep;
        LinkNode r = p.next;
        p.next = null;
        p = r;
        while (p!=null){
            r = p.next;
            prep = L;
            while (prep.next != null && prep.next.data < p.data){
                prep = prep.next;
            }
            p.next = prep.next;
            prep.next = p;
            p = r;
        }
        return L;
    }

    /**
     * 删除值无序的带头单链表中节点数据介于给定两个值范围之间的所有节点
     * @param L
     * @param m
     * @param n
     * @return
     */
    public static LinkNode deleteRangeVal(LinkNode L, int m, int n){
        if(n <= m){
            return L;
        }
        LinkNode prep = L, p = L.next, r = p.next;
        while (r != null){
            if(p.data > m && p.data < n){
                prep.next = p.next;
                p = r;
                r = r.next;
            }
            prep = prep.next;
            p = p.next;
            r = r.next;
        }
        if(p.data > m && p.data < n){
            prep.next = p.next;
        }
        return L;
    }

    /**
     * 找出两个链表的第一个公共节点
     * @param A
     * @param B
     * @return
     */
    public static LinkNode findCommonNode(LinkNode A, LinkNode B){
        int a = 0, b = 0;
        LinkNode headA = A.next, headB = B.next;
        while (headA != null){
            a++;
            headA = headA.next;
        }
        while (headB != null){
            b++;
            headB = headB.next;
        }
        if( a == 0 || b == 0){
            return null;
        }
        int m = 0;
        LinkNode p = A.next;
        if(a > b){
            m = a-b;
        }else if(a == b) {
            return A;
        }else {
            m = b -a;
        }
        while (m > 0){
            m--;
            p = p.next;
        }
        return p;
    }

    /**
     * 按照元素大小递增的顺序输出每个节点的数据，不允许使用数组作为辅助空间
     * @param L
     */
    public static void increasePrintNodeVal(LinkNode L){
        LinkNode  p = L.next, prep;
        LinkNode r = p.next;
        p.next = null;
        p = r;
        while (p != null){
            r = p.next;
            prep = L;
            while (prep.next != null && prep.next.data < p.data){
                prep = prep.next;
            }
            p.next = prep.next;
            prep.next = p;
            p = r;
        }
        printList(L);
    }

    /**
     * 将带头节点单链表A分为两个带头节点单链表A和B，使得A中具有原来链表中序号为
     * @param L
     * @param A
     * @param B
     */
    public static void divideTwoList(LinkNode L, LinkNode A, LinkNode B){
        int a = 2;
        A.next = L.next;
        L.next = L.next.next;
        LinkNode p = L.next, r = p.next;
        LinkNode pA = A.next, pB = B;
        while (p != null){
            if(a % 2 == 0){
                p.next = null;
                pB.next = p;
                pB = p;
                p = r;
                if(r != null){
                    r = r.next;
                    a++;
                }
            }else {
                p.next = null;
                pA.next = p;
                pA = p;
                p = r;
                if(r != null){
                    r = r.next;
                    a++;
                }
            }
        }
    }

    /**
     * 将带头节点单链表A分为两个带头节点单链表A和B，使得{a1,b1,a2,b2,...,an,bn}变为{a1,a2,...,an}和{b1,b2,...bn}
     * @param L
     * @param A
     * @param B
     */
    public static void divideTwoList2(LinkNode L, LinkNode A, LinkNode B){
        int a = 2;
        A.next = L.next;
        L.next = L.next.next;
        LinkNode p = L.next, r = p.next;
        LinkNode pA = A.next, pB = B;
        while (p != null){
            if(a % 2 == 0){
                p.next = null;
                pB.next = p;
                pB = p;
                p = r;
                if(r != null){
                    r = r.next;
                    a++;
                }
            }else {
                p.next = null;
                pA.next = p;
                pA = p;
                p = r;
                if(r != null){
                    r = r.next;
                    a++;
                }
            }
        }
    }

    /**
     * 在递增有序的单链表中删除重复的元素
     * @param L
     * @return
     */
    public static LinkNode deleteRepeatValNode(LinkNode L){
        LinkNode prep = L, p = L.next, r = p.next;
        HashMap<Integer, LinkNode> map = new HashMap<>();
        while (p != null){
            if(!map.containsKey(p.data)){
                map.put(p.data, prep);
                prep = prep.next;
                p = p.next;
            }else {
                prep.next = p.next;
                p = r;
            }
            if(r != null) {
                r = r.next;
            }
        }
        return L;
    }

    /**
     * 两个递增有序的单链表合成一个递减的单链表，要求利用原来的两个单链表中的节点存放归并后的单链表
     * @param A
     * @param B
     * @return
     */
    public static LinkNode combineTwoList(LinkNode A, LinkNode B){
        LinkNode pA = A.next,rA = pA.next, pB = B.next, rB = pB.next;
        LinkNode L = new LinkNode(0);
        while ( pA != null || pB != null){
            if(pA.data <= pB.data){
                pA.next = L.next;
                L.next = pA;
                pA = rA;
                if(rA != null){
                    rA = rA.next;
                }
            }else {
                pB.next = L.next;
                L.next = pB;
                pB = rB;
                if(rB != null){
                    rB = rB.next;
                }
            }
        }
        if(pA != null){
            pA.next = L.next;
            L.next = pA;
            pA = rA;
            if(rA != null){
                rA = rA.next;
            }
        }
        if(pB != null){
            pB.next = L.next;
            L.next = pB;
            pB = rB;
            if(rB != null){
                rB = rB.next;
            }
        }
        return L;
    }

}
