package JZOffer.chapter2;

/**
 * 计算一个正数的二进制有多少1
 *
 * 此题的扩展题：
 * 1. 判断一个数是不是2的整数次方。一个数如果是二的整数次方的话。有个特点就是它的二进制只会有一个1。那么我们可以用(num - 1) & num是否等
 * 于0来进行判断。
 *
 * 2. 判断由某个整数转换为另一个整数需要改变多少个二进制值。这个问题可以转换为两个数进行与操作"异或"操作后再求有多少个1。
 */
public class BitOperation {

    public static void main(String[] args) {
        System.out.println(getOneNums(1000));
        System.out.println(getOneNums2(1000));
    }

    /**
     * 第一种方法
     * @param num
     * @return
     */
    public static int getOneNums(int num) {
        int count = 0;
        int tag = 1;

        while (tag != 0){
            if ((tag & num) != 0){
                count++;
            }
            tag = (tag << 1);
        }
        return count;
    }

    /**
     * 第二种方法
     * @param num
     * @return
     */
    public static int getOneNums2(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num = (num - 1) & num;
        }
        return count;
    }
}
