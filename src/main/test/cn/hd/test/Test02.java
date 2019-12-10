package cn.hd.test;

public class Test02 {
    public static void main(String[] args) {
        int a =0;
        try{
            a = Integer.parseInt(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(a);
    }

}
