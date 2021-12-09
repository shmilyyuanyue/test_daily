package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Scanner;

public class Kunnan {

    /**
     *识别有效的IP地址和掩码并进行分类统计
     * 描述
     * 请解析IP地址和对应的掩码，进行分类识别。要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
     *
     * 所有的IP地址划分为 A,B,C,D,E五类
     *
     * A类地址1.0.0.0~126.255.255.255;
     *
     * B类地址128.0.0.0~191.255.255.255;
     *
     * C类地址192.0.0.0~223.255.255.255;
     *
     * D类地址224.0.0.0~239.255.255.255；
     *
     * E类地址240.0.0.0~255.255.255.255
     *
     *
     * 私网IP范围是：
     *
     * 10.0.0.0-10.255.255.255
     *
     * 172.16.0.0-172.31.255.255
     *
     * 192.168.0.0-192.168.255.255
     *
     *
     * 子网掩码为二进制下前面是连续的1，然后全是0。（例如：255.255.255.32就是一个非法的掩码）
     * 注意二进制下全是1或者全是0均为非法
     *
     * 注意：
     * 1. 类似于【0.*.*.*】和【127.*.*.*】的IP地址不属于上述输入的任意一类，也不属于不合法ip地址，计数时请忽略
     * 2. 私有IP地址和A,B,C,D,E类地址是不冲突的
     *
     * 输入描述：
     * 多行字符串。每行一个IP地址和掩码，用~隔开。
     *
     * 输出描述：
     * 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
     */
    public static void method1(){
        Scanner sc = new Scanner(System.in);
        int aNum = 0;
        int bNum = 0;
        int cNum = 0;
        int dNum = 0;
        int eNum = 0;
        int errNum = 0;
        int pNum = 0;
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strArr = str.split("~");
            int ipFirst = getIpSeg(strArr[0], 0);
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }
            if (maskIsInvaild(strArr[1])) {
                errNum++;
                continue;
            }
            if (ipIsInvaild(strArr[0])) {
                errNum++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                aNum++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                bNum++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                cNum++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                dNum++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                eNum++;
            }
            int ipSecond = getIpSeg(strArr[0], 1);
            if (ipFirst == 10 || (ipFirst == 172 && ipSecond >= 16 && ipSecond <=31) || (ipFirst == 192 && ipSecond == 168)) {
                pNum++;
            }
        }
        System.out.println(aNum + " " + bNum + " " + cNum + " " + dNum + " " + eNum + " " + errNum + " " + pNum);

    }
    public static boolean maskIsInvaild(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBinary(maskArr[0]) + toBinary(maskArr[1]) + toBinary(maskArr[2]) + toBinary(maskArr[3]);
        if (!maskBinary.matches("[1]{1,}[0]{1,}")) {
            return true;
        }
        return false;
    }

    public static String toBinary(String num) {
        String numBinary = Integer.toBinaryString(Integer.valueOf(num));
        while (numBinary.length() < 8) {
            numBinary = "0" + numBinary;
        }
        return numBinary;
    }

    public static boolean ipIsInvaild(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        if (Integer.valueOf(ipArr[0]) > 255 || Integer.valueOf(ipArr[1]) > 255 || Integer.valueOf(ipArr[2]) > 255 || Integer.valueOf(ipArr[3]) > 255) {
            return true;
        }
        return false;
    }
    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.valueOf(ipArr[index]);
    }
    /**
     *简单记错记录
     * 描述
     * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
     *
     *
     * 处理：
     *
     *
     * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）和行号完全匹配的记录才做算是”相同“的错误记录。
     * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
     * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，如果它们的名字的后16个字符相同，也被视为相同的错误记录
     * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
     *
     * 数据范围：错误记录数量满足  ，每条记录长度满足
     * 输入描述：
     * 每组只包含一个测试用例。一个测试用例包含一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
     *
     * 输出描述：
     * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
     */
    public static void method2()throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Map<String,Integer> map = new LinkedHashMap();
        String tstr = null;
        while((tstr = bf.readLine()) != null && !tstr.equals("")){
            String[] str = tstr.split("\\s+");
            String fname=str[0].substring(str[0].lastIndexOf("\\") + 1);
            fname = fname.substring(Math.max(fname.length()-16 ,0))+" "+str[1];
            Integer tmp = map.get(fname);
            if(tmp == null)
                map.put(fname,1);
            else
                map.put(fname, tmp+1);
        }
        int count = 0;
        for(Map.Entry<String,Integer> it : map.entrySet()){
            if(map.size() - count <= 8)
                System.out.println(it.getKey()+" "+it.getValue());
            count++;
        }
    }
    /**
     * 查找兄弟单词
     *描述
     * 定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
     * 兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
     * 现在给定你 n 个单词，另外再给你一个单词 str ，让你寻找 str 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
     * 注意：字典中可能有重复单词。本题含有多组输入数据。
     *
     * 数据范围：，输入的字符串长度满足  ，
     * 输入描述：
     * 先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
     * 输出描述：
     * 输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
     */
    public static void method3(){
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            String[] ss = scanner.nextLine().split(" ");
            Integer a = Integer.parseInt(ss[0]);
            String x = ss[ss.length-2];
            Integer k = Integer.parseInt(ss[ss.length-1]);
            List<String> list = new ArrayList<>();

            for (int i = 1; i <=a ; i++) {
                if (isBrother(x,ss[i])){
                    list.add(ss[i]);
                }
            }
            int size = list.size();
            System.out.println(size);
            if (size>=k){
                Collections.sort(list);
                System.out.println(list.get(k-1));
            }

        }
    }
    public static boolean isBrother(String x,String y){
        if (x.length()!=y.length()||y.equals(x)){
            return false;
        }
        char[] s = x.toCharArray();
        char[] j= y.toCharArray();
        Arrays.sort(s);
        Arrays.sort(j);
        return new String(s).equals(new String(j));


    }
    /**
     * 素数伴侣
     * 描述
     * 题目描述
     * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的 N （ N 为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
     *
     * 输入:
     *
     * 有一个正偶数 n ，表示待挑选的自然数的个数。后面给出 n 个具体的数字。
     *
     * 输出:
     *
     * 输出一个整数 K ，表示你求得的“最佳方案”组成“素数伴侣”的对数。
     *
     *
     * 数据范围：  ，输入的数据大小满足
     *
     * 本题有多组输入
     * 输入描述：
     * 输入说明
     * 1 输入一个正偶数 n
     * 2 输入 n 个整数
     * 题目有多组输入
     *
     * 输出描述：
     * 求得的“最佳方案”组成“素数伴侣”的对数。
     *
     */
    public static void method4(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> evens = new ArrayList();
            ArrayList<Integer> adds = new ArrayList();

            for (int i = 0; i < n; i++) {
                if ((arr[i] & 1) == 1) {
                    evens.add(arr[i]);
                } else {
                    adds.add(arr[i]);
                }
            }
            int[] evensMatch = new int[evens.size()];
            int count = 0;
            for (int i = 0; i < adds.size(); i++) {
                int[] used = new int[evens.size()];
                if (find(used, evens, adds.get(i), evensMatch))
                    count++;
            }
            System.out.println(count);

        }
    }
    public static boolean isPrime(int m) {
        for (int i = 2; i * i <= m; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(int[] used, ArrayList<Integer> evens, int num, int[] evensMatch) {
        for (int i = 0; i < evens.size(); i++) {
            if (isPrime(num + evens.get(i)) && used[i] == 0) {
                used[i] = 1;
                if (evensMatch[i] == 0 || find(used, evens, evensMatch[i], evensMatch)) {
                    evensMatch[i] = num;
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * sudoku
     *描述
     * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
     * 例如：
     * 输入
     *
     * 输出
     *
     *
     * 数据范围：输入一个 9*9 的矩阵
     * 输入描述：
     * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
     *
     * 输出描述：
     * 完整的9X9盘面数组
     */
    public static void method5(){
        Scanner in = new Scanner(System.in);
        int[][] board = new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j] = in.nextInt();
            }
        }
        solveSudoku(board);
        //输出二维矩阵
        for(int i=0;i<9;i++){
            for(int j=0;j<8;j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println(board[i][8]);//换行，每一行的最后一个数字
        }
    }
    public static boolean solveSudoku(int[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一***定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列
                if (board[i][j] != 0){ // 跳过原始数字
                    continue;
                }
                for (int k = 1; k <= 9; k++){ // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i, j, k, board)){
                        board[i][j] = k;//将k放在（i，j）
                        if (solveSudoku(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = 0;//回溯
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一***定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }
      //判断棋盘是否合法有如下三个维度:
      //   同行是否重复
      //    同列是否重复
     //     9宫格里是否重复
    public static boolean isValidSudoku(int row, int col, int val, int[][] board){
        // 同行是否重复
        for (int i = 0; i < 9; i++){
            if (board[row][i] == val){
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++){
            if (board[j][col] == val){
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++){
                if (board[i][j] == val){
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 将真分数分解为埃及分数
     *描述
     * 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
     * 注：真分数指分子小于分母的分数，分子和分母有可能gcd不为1！
     * 如有多个解，请输出任意一个。
     * 请注意本题含有多组样例输入！
     *
     *
     * 输入描述：
     * 输入一个真分数，String型
     *
     * 输出描述：
     * 输出分解后的string
     */
    public static void method6(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String res = "";
            String[] arr = in.nextLine().split("/");
            String pre = "";
            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);
            while (true){
                int c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }
            System.out.println(res);
        }
    }
    /**
     *24点运算法
     * 描述
     * 计算24点是一种扑克牌益智游戏，随机抽出4张扑克牌，通过加(+)，减(-)，乘(*), 除(/)四种运算法则计算得到整数24，本问题中，扑克牌通过如下字符或者字符串表示，其中，小写joker表示小王，大写JOKER表示大王：
     *
     * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
     *
     * 本程序要求实现：输入4张牌，输出一个算式，算式的结果为24点。
     *
     * 详细说明：
     *
     * 1.运算只考虑加减乘除运算，没有阶乘等特殊运算符号，没有括号，友情提醒，整数除法要当心，是属于整除，比如2/3=0，3/2=1；
     * 2.牌面2~10对应的权值为2~10, J、Q、K、A权值分别为为11、12、13、1；
     * 3.输入4张牌为字符串形式，以一个空格隔开，首尾无空格；如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
     * 4.输出的算式格式为4张牌通过+-
    四个运算符相连，中间无空格，4张牌出现顺序任意，只要结果正确；
            *5.输出算式的运算顺序从左至右，不包含括号，如1+2+3*4的结果为24，2A 9

    A不能变为(2+1)*(9-1)=24
            *6.如果存在多种算式都能计算得出24，只需输出一种即可，如果无法得出24，则输出“NONE”表示无解。
            *7.因为都是扑克牌，不存在单个牌为0的情况，且没有括号运算，

    除数(即分母)的数字不可能为0
     *
             *数据范围：一行由4张牌组成的字符串
     *输入描述：
            *输入4张牌为字符串形式，以一个空格隔开，首尾无空格；
            *
            *输出描述：
            *输出怎么运算得到24，如果无法得出24，则输出“NONE”表示无解，如果输入的4张牌中包含大小王，则输出字符串“ERROR”，表示无法运算；
     */
    public static void method7(){
        Scanner sc = new Scanner(System.in);
        //用于初步读取String储存
        LinkedList<String> list1 = new LinkedList<>();
        //用于将String转化成int储存
        LinkedList<Integer> list = new LinkedList<>();
        //用于还原：（1->A; 13->K）
        LinkedList<String> list2 = new LinkedList<>();

        list2.add("0");
        list2.add("A");
        for (int i = 2; i <= 10; i++){
            list2.add(Integer.toString(i));
        }
        list2.add("J");
        list2.add("Q");
        list2.add("K");
        //读取String：
        while (sc.hasNext()){
            list1.add(sc.next());
        }
        int flag = 0;
        //转换成Integer：//遇到JOKER 直接输出ERROR
        for (int i = 0; i < 4 ; i++){
            String cur = list1.get(i);
            if (cur.equals("JOKER") || cur.equals("joker")){
                System.out.println("ERROR");
                flag = -1;
                break;
            }else if (cur.equals("A")){
                list.add(1);
            }else if (cur.equals("K")){
                list.add(13);
            }else if (cur.equals("Q")){
                list.add(12);
            }else if (cur.equals("J")){
                list.add(11);
            }else{
                list.add(Integer.valueOf(cur));
            }
        }
        //暴力遍历四个数的排列组合：
        if (flag == 0){
            for (int i = 0; i < 4; i++){
                for (int j = 0; j < 4; j++){
                    if (j == i) continue;
                    if(flag == 1) break;
                    for (int k = 0; k < 4; k++){
                        if (k == i || k == j) continue;
                        if(flag == 1) break;
                        for (int p = 0; p < 4; p++){
                            if (p == i || p == j || p == k) continue;
                            if(flag == 1) break;
                            //将四个数给如helper function做判断：
                            String out = helper(list.get(i), list.get(j), list.get(k),list.get(p));
                            //输出非NONE，生成答案：
                            if (!out.equals("NONE")){
                                String res = "";
                                res += list2.get(list.get(i));
                                res += out.substring(0,1);
                                res += list2.get(list.get(j));
                                res += out.substring(1,2);
                                res += list2.get(list.get(k));
                                res += out.substring(2,3);
                                res += list2.get(list.get(p));
                                System.out.println(res);
                                flag = 1;
                            }
                        }
                    }
                }
            }
            //helepr function输出为NONE输出NONE：
            if (flag == 0) System.out.println("NONE");
        }
    }
    //类似于2-sum --> 3-sum -->4-sum思路：
    static public String helper(int a, int b){
        if (a * b == 24) return "*";
        else if (a + b == 24) return "+";
        else if (b != 0 && a % b == 0 && a / b == 24) return "/";
        else if (a - b == 24) return "-";
        else return "NONE";
    }
    //重载
    static public String helper(int a, int b, int c){
        if (!helper(a * b, c).equals("NONE")) return "*" + helper(a * b, c);
        else if (!helper(a + b, c).equals("NONE")) return "+" + helper(a + b, c);
        else if (!helper(a - b, c).equals("NONE")) return "-" + helper(a - b, c);
        else if (b != 0 && a % b == 0 && !helper(a / b, c).equals("NONE")) return "/" + helper(a * b, c);
        else return "NONE";
    }
    //重载：输出的是三个有序运算符号
    static public String helper(int a, int b, int c, int d){
        if (!helper(a * b, c, d).equals("NONE")) return "*" + helper(a * b, c, d);
        else if (!helper(a + b, c, d).equals("NONE")) return "+" + helper(a + b, c, d);
        else if (!helper(a - b, c, d).equals("NONE")) return "-" + helper(a - b, c, d);
        else if (b != 0 && a % b == 0 && !helper(a / b, c, d).equals("NONE")) return "/" + helper(a * b, c, d);
        else return "NONE";
    }


}
