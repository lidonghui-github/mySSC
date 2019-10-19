package cn.hd.algorithm;

/**
 * 一个字符串中是否包含另一个字符串
 */
public class KMP算法 {
    /**
     * KMP算法：指针回溯法
     *
     * @param s
     * @param m
     * @return
     */
    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0; // 主串的位置
        int mi = 0;// 模式串的位置
        int[] next = getNextArray(ms);
        while (si < ss.length && mi < ms.length) {
            if (ss[si] == ms[mi]) {  // 当j为-1时，要移动的是i，当然j也要归0
                si++;
                mi++;
            } else if (next[mi] == -1) {
                si++;
            } else {
                // i不需要回溯了
                // i = i - j + 1;
                mi = next[mi];
            }
        }
        return mi == ms.length ? si - mi : -1;
    }

    public static int[] getNextArray(char[] ms) {
        if (ms.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length) {
            if (ms[pos - 1] == ms[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcabcabbaccc";
        String match = "ababra";
        System.out.println(getIndexOf(str, match));
        System.out.println(bf(str, match));

    }


    /**
     * 暴力破解法
     *
     * @param ts 主串
     * @param ps 模式串
     * @return 如果找到，返回在主串中第一个字符出现的下标，否则为-1
     */

    public static int bf(String ts, String ps) {
        char[] t = ts.toCharArray();
        char[] p = ps.toCharArray();
        int i = 0; // 主串的位置
        int j = 0; // 模式串的位置
        while (i < t.length && j < p.length) {
            if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1; // 一旦不匹配，i后退
                j = 0; // j归0
            }
        }
        if (j == p.length) {
            return i - j;
        } else {
            return -1;
        }
    }
}
