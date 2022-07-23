package test;

/**
 * 用于封装
 * @author Jay Zhou
 * @version 1.0
 */
public class Driver {
    /**
     * 用于封装
     * @param args String数组引用
     */
    public static void main(String[]args){
        try{
        Helper.helper();}
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
}
