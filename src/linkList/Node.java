package linkList;

/**\
 * 节点类
 * @param <T> 泛型
 */
public class Node<T> {
    private Node<T> next;
    private Node<T> pre;
    private T data;

    /**
     * 初始化
     */
    public Node(){
        this(null);
    }

    /**
     * 创建节点实例
     * @param data 节点数据
     */
    public Node(T data){
        this.setData(data);
    }

    public Node(Node<T> pre,Node<T> next ){
        this.setNext(next);
        this.setPre(pre);
    }

    /**
     * 返回节点
     * @return 返回节点
     */
    public Node<T> getNext() {
        return this.next;
    }

    /**
     * 设置节点
     * @param next 下一个节点
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * 返回节点数据
     * @return 节点数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置节点数据
     * @param data 节点数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回前一个节点地址
     * @return 前一个节点地址
     */
    public Node<T> getPre() {
        return this.pre;
    }

    /**
     * 改变前一个节点地址
     * @param pre 前一个节点地址
     */
    public void setPre(Node<T> pre) {
        this.pre = pre;
    }
}
