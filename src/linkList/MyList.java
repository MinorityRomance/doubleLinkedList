package linkList;

/**
 * 自定义双向链表类
 * @param <T> 泛型
 */

public class MyList<T>  {
    private Node<T> head;
    private Node<T> last;

    /**
     * 链表初始化
     */
    public MyList(){
        this(null,null);
    }

    /**
     * 创建链表实例
     * @param head 头节点
     */
    public MyList(Node<T> head,Node<T> last){
        this.setHead(head);
        this.setLast(last);
    }

    /**
     * 返回头节点
     * @return 头节点
     */
    public Node<T> getHead() {
        return this.head;
    }

    /**
     * 设置头节点
     * @param head 头节点
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }

    /**
     * 返回尾结点
     * @return 尾结点
     */
    public Node<T> getLast() {
        return last;
    }

    /**
     * 改变尾结点
     * @param last 尾结点
     */
    public void setLast(Node<T> last) {
        this.last = last;
    }

    /**
     * 实现链表内容添家
     * @param node 需要传入的节点
     */
    public void addList(Node<T> node){

    }

    /**
     * 得到链表的长度
     * @return 链表的长度
     */
    public int size() throws NullPointerException{
        Node<T> temp = this.head;
        int i = 0 ;
        try {
            while (!(temp == null)){
                i++;
                temp = temp.getNext();
            }
        }catch (NullPointerException e){
            throw e;
        }finally {
            return i;
        }
    }

    /**
     * 实现链表遍历
     */
    public void traversal(){
        //用temp作为中转
        Node<T> temp = this.head;
        for(int i = 0 ; i < this.size()  ; i++ ){
            System.out.print(temp.getData()+",");
            temp = temp.getNext();
        }
    }

    /**
     * 实现链表删除节点
     * @param index 需要删除第几个节点
     */
    public void delete(int index) throws IndexOutOfBoundsException{
        try {
            check(index);
        }catch (IndexOutOfBoundsException e){
            throw e;
        }

        Node<T> temp = get(index);
        Node<T> left = temp.getPre();
        Node<T> right = temp.getNext();

        //分三种情况,删除节点在首位，在中间位置，或者在末尾
        if (left == null) {

            head = right;
        }
        //最后的位置
        else if (right == null) {
            last = left;
        }
        //中间位置
        else if (left != null && right != null) {
            left.setNext(right);
            right.setPre(left);
        }
    }

    /**
     * 实现链表插入
     * @param index 插入作为第n个节点
     * @param contend 需插入的节点数据
     */
    public void insert(T contend,int index) throws IndexOutOfBoundsException{
        try {
            check(index);
        }catch (IndexOutOfBoundsException e){
            throw e;
        }

        Node<T> objectNode = new Node<T>(contend);

        //插入在第一个位置时
        if(index == 1){
            Node<T> previousHead = head ;
            head = objectNode;

            head.setPre(null);
            head.setNext(previousHead);
        }
        //中间位置时
        else if( index <= this.size() && index > 1){
            //需要插入节点之后的一个节点
            Node<T> after = get(index);
            //需插入节点之前
            Node<T> before = get(index-1);
            //需插入的目标节点
            after.setPre(objectNode);
            before.setNext(objectNode);
            objectNode.setPre(before);
            objectNode.setNext(after);

        }
        //最后的位置时
        else if( index == size()+1 ) {
            Node<T> previousLast = last;
            last = objectNode;

            previousLast.setNext(last);
            last.setPre(previousLast);
            last.setNext(null);

        }
    }

    /**
     * 实现链表查询
     * @param keys 用来查询节点数据的关键词
     * @return 返回在第n个节点处
     */
    public int search(T keys){
        Node<T> temp = this.head;
        //for循环只能查询到this.size()-1个节点的具体数据
        for(int i = 0 ; i < this.size() ; i++ ){
           //如果相等返回第n个节点处
           if(temp.getData().equals(keys)){
               return i+1;
           }
           temp = temp.getNext();
        }
        //如果是最后一个节点处
        if(temp.getData().equals(keys)){
            return this.size();
        }
        else {
            return -1;
        }
    }

    /**
     * 实现链表的翻转
     */
    public void reversal() {
        int i = 0 ;
        int j = size();

        Node<T> temp1 = this.get(j);
        for(int a = 0 ; a < j ; a++ ){
            System.out.print(temp1.getData()+",");
            temp1 = temp1.getPre();
        }
    }



    /**
     * 获取index位置对应的结点对象
     * @param index 需要获取的节点
     * @return
     */
    public Node<T> get(int index) throws IndexOutOfBoundsException {
        try {
            check(index);
        }
        catch (IndexOutOfBoundsException e){
            throw e;
        }

        //在链表的前半部分
        if(index < ( (double)size() ) / 2 ){
            Node<T> temp = head;//index = 4
            for(int i = 0 ; i < index - 1  ; i++){
                temp = temp.getNext();
            }
            return temp;
        }
        //在链表的后半部分
        else{

            Node<T> temp = last;
            for( int i = this.size()  ; i > index  ; i--){
                temp = temp.getPre();
            }
            return temp;
        }
    }

    /**
     * 检查index是否在最大节点范围内
     *  @param index 需要获取的节点位置
     */
    public void check(int index) throws IndexOutOfBoundsException{
        try{
            if(this.size()+1 < index || index < 0){

            }
        }catch (IndexOutOfBoundsException e){
            throw e;
        }
    }
}
