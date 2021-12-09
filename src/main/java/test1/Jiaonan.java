package test1;

import java.io.*;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Jiaonan {



    /**
     * 字符串最后一个单词的长度
     * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
     * （注：字符串末尾不以空格为结尾）
     * 输入描述：
     * 输入一行，代表要计算的字符串，非空，长度小于5000。
     *
     * 输出描述：
     * 输出一个整数，表示输入字符串最后一个单词的长度。
     */
    public static void method1(){
        //标准输入
        Scanner sc=new Scanner(System.in);
        //键盘输入字符串
        String s=sc.nextLine();
        //定义指针变量
        int index=-1;
        for(int i=s.length()-1;i>=0;i--){
            //从后往前第一个空格的位置
            if(s.charAt(i)==' '){
                index=i;
                break;
            }
        }
        //总长度减去指针到开头一段的长度，即得到最后一个单词的长度
        System.out.println(s.length()-index-1);
    }

    /**
     * 计算某字符出现次数
     *描述
     * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
     *
     * 数据范围：  ，输入的数据有可能包含大小写字母、数字和空格
     * 输入描述：
     * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
     *
     * 输出描述：
     * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
     */
    public static void method2(){
        Scanner s = new Scanner(System.in);
        String input1= s.nextLine();
        String input2 = s.nextLine();
        String split3 = input1.toUpperCase().replaceAll(input2.toUpperCase(),"");
        System.out.println(input1.length() - split3.length());
    }
    /**
     * 明明的随机数
     *描述
     * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了 N 个 1 到 1000 之间的随机整数（ N≤1000 ），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
     *
     *
     * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
     *
     * 当没有新的输入时，说明输入结束。
     *
     * 数据范围：  ，输入的数字大小满足
     * 输入描述：
     * 注意：输入可能有多组数据(用于不同的调查)。每组数据都包括多行，第一行先输入随机整数的个数 N ，接下来的 N 行再输入相应个数的整数。具体格式请看下面的"示例"。
     *
     * 输出描述：
     * 返回多行，处理后的结果
     */
    public static void method3(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = in.nextInt();    //随机数总数
            int[] data = new int[count];
            for(int i=0; i < count; i++)    //读入生成的随机数
                data[i] = in.nextInt();

            Arrays.sort(data);    //使用库函数排序
            System.out.println(data[0]);    //打印排序后的第一个数（必不重复）
            for(int i=1; i < count; i++){    //打印其他数字，需与前面数字比较，不重复才能打印
                if(data[i] != data[i-1])
                    System.out.println(data[i]);
            }
        }

    }
    /**
     * 字符串分割
     *描述
     * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
     * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
     *
     * 输入描述：
     * 连续输入字符串(输入多次,每个字符串长度小于等于100)
     *
     * 输出描述：
     * 依次输出所有分割后的长度为8的新字符串
     */
    public static void method4(){
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String s = input.nextLine();
            split(s);
        }
    }
    public static void split(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0,8));
            s=s.substring(8);
        }
        if(s.length()<8 && s.length()>0){
            s+="00000000";
            System.out.println(s.substring(0,8));
        }
    }
    /**
     * 句子逆序
     * 描述
     *将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
     * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
     *
     * 数据范围：输入的字符串长度满足
     *
     * 注意本题有多组输入
     * 输入描述：
     * 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
     *
     * 输出描述：
     * 得到逆序的句子
     */
    public static void method5(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String inputstr = in.nextLine();

            String[] splitstr = inputstr.split("\\s+");
            StringBuffer reversestr = new StringBuffer();

            for(int i=splitstr.length-1;i>=0;i--){
                reversestr.append(splitstr[i]).append(" ");
            }

            System.out.println(reversestr);
        }
    }
    /**
     *坐标移动
     * 描述
     * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
     *
     * 输入：
     *
     * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
     *
     * 坐标之间以;分隔。
     *
     * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
     *
     * 下面是一个简单的例子 如：
     *
     * A10;S20;W10;D30;X;A1A;B10A11;;A10;
     *
     * 处理过程：
     *
     * 起点（0,0）
     *
     * +   A10   =  （-10,0）
     *
     * +   S20   =  (-10,-20)
     *
     * +   W10  =  (-10,-10)
     *
     * +   D30  =  (20,-10)
     *
     * +   x    =  无效
     *
     * +   A1A   =  无效
     *
     * +   B10A11   =  无效
     *
     * +  一个空 不影响
     *
     * +   A10  =  (10,-10)
     *
     * 结果 （10， -10）
     * 数据范围：每组输入的字符串长度满足  ，坐标保证满足  ，且数字部分仅含正数
     *
     * 注意请处理多组输入输出
     *
     * 输入描述：
     * 一行字符串
     *
     * 输出描述：
     * 最终坐标，以逗号分隔
     */
    public static void method6(){
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        while(scanner.hasNext()) {
            String s = scanner.nextLine();
            int x = 0 , y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            for(int i = 0;i < sArray.length;i ++) {
                if(sArray[i].matches(res))
                    map.put(sArray[i].charAt(0),map.getOrDefault(sArray[i].charAt(0), 0)+Integer.valueOf(sArray[i].substring(1)));
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x+","+y);
            map.clear();
        }
        scanner.close();
    }
    /**
     *密码验证合格程序
     * 描述
     * 密码要求:
     *
     * 1.长度超过8位
     *
     * 2.包括大小写字母.数字.其它符号,以上四种至少三种
     *
     * 3.不能有长度大于2的不含公共元素的子串重复 （注：其他符号不含空格或换行）
     *
     * 数据范围：输入的字符串长度满足
     *
     * 本题有多组输入
     * 输入描述：
     * 一组或多组字符串。每组占一行
     *
     * 输出描述：
     * 如果符合要求输出：OK，否则输出NG
     */
    public static void method7 ()throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            if (verify(s)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }
        br.close();
    }
    public static boolean verify(String s) {
        // 检查密码长度
        if (s.length() <= 8) {
            return false;
        }

        // 检查密码字符种类
        char[] cs = s.toCharArray();
        int[] checkChar = new int[4];
        for (char c: cs) {
            if ('a' <= c && c <= 'z') {
                checkChar[0] = 1;
            } else if ('A' <= c && c <= 'Z') {
                checkChar[1] = 1;
            } else if ('0' <= c && c <= '9') {
                checkChar[2] = 1;
            } else {
                checkChar[3] = 1;
            }
        }
        int coun = 0;
        for(int n: checkChar) {
            coun += n;
        }
        if (coun < 3) {
            return false;
        }

        // 检查重复子串
        int slow = 0, fast = 0;
        while (slow < cs.length - 5) {
            fast = slow + 3;
            while (fast < cs.length - 2 && cs[fast] != cs[slow]) {
                fast++;
            }
            if (fast != cs.length - 2) {
                boolean check2 = cs[slow+1] == cs[fast+1];
                boolean check3 = cs[slow+2] == cs[fast+2];
                if (check2 && check3) {
                    return false;
                }
            }
            slow++;
        }

        return true;
    }
    /**
     * 删除字符串中出现次数最少的字符
     *描述
     * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
     * 注意每个输入文件有多组输入，即多个字符串用回车隔开
     *
     * 数据范围：输入的字符串长度满足  ，保证输入的字符串中仅出现小写字母
     * 输入描述：
     * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
     *
     * 输出描述：
     * 删除字符串中出现次数最少的字符后的字符串。
     */
    public static void method8(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] array = str.split("");
            List<String> lsrString = Arrays.asList(array);
            Set<Integer> set = new HashSet<>();
            Map<String, Integer> map = new HashMap<>();
            for (String s : array) {
                if (!map.containsKey(s)) {
                    map.put(s, 0);
                }
                map.put(s, map.get(s)+1);
            }
            map.forEach((k, v) -> {
                set.add(v);
            });
            if (set.size() == 1) {
                System.out.println(str);
            } else {
                int num = Integer.parseInt(String.valueOf(set.toArray()[0]));
                List<String> lst = new ArrayList<>();
                map.forEach((k, v) ->{
                    if (v == num) {
                        lst.add(k);
                    }
                });
                String result = lsrString.stream().filter(s -> !lst.contains(s)).collect(Collectors.joining());
                System.out.println(result);
            }
        }
    }
    /**
     *合唱队
     * 描述
     * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
     *
     * 说明：
     *
     * N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，使得剩下的 K 位同学排成合唱队形。
     * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 T1，T2，…，TK ，   则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
     *
     * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
     *
     * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
     * 请注意处理多组输入输出！
     *
     * 数据范围：
     *
     * 输入描述：
     * 有多组用例，每组都包含两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
     *
     * 输出描述：
     * 最少需要几位同学出列
     */
    public static void method9(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] arrL = new int[n]; // 左侧小于arr[i]的个数
            int[] arrR = new int[n]; // 右侧大于arr[i]的个数
            for(int i = 0; i < n; ++i){
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i < n; ++i){
                arrL[i] = 0; // 所以默认初始是0,,对于第一个数来说， 在arr[0]的左侧小于arr[0]的个数是0。
                for(int j = 0; j < i; ++j){
                    if(arr[i] > arr[j]){
                        arrL[i] = Math.max(arrL[j] + 1, arrL[i]);
                    }
                }
            }

            for(int i = n - 1; i >= 0; --i){
                arrR[i] = 0; // 所以默认初始是0,,对于最后一个数来说， 在arr[n - 1]的右侧小于arr[0]的个数是0。
                for(int j = n - 1; j > i; --j){
                    if(arr[i] > arr[j]){
                        arrR[i] = Math.max(arrR[j] + 1, arrR[i]);
                    }
                }
            }

            int maxValue = 0;
            for(int i = 0; i < n; ++i){
                maxValue = Math.max(maxValue, arrR[i] + arrL[i] + 1);
            }

            System.out.println(n - maxValue);
        }
    }
    /**
     *数据分类处理
     * 描述
     * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
     *
     * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
     *
     * 请注意本题有多组输入用例。
     *
     * 数据范围： ，输入的整数大小满足
     * 输入描述：
     * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~(2^31)-1，序列个数不限
     *
     * 输出描述：
     * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I：
     *
     * I整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I为231，那么I包含了R<i>，条件满足 。
     *
     * 按R<i>从小到大的顺序:
     *
     * (1)先输出R<i>；
     *
     * (2)再输出满足条件的I的个数；
     *
     * (3)然后输出满足条件的I在I序列中的位置索引(从0开始)；
     *
     * (4)最后再输出I。
     *
     * 附加条件：
     * 1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I，索引大的需要过滤掉
     *
     * (2)如果没有满足条件的I，对应的R<i>不用输出
     *
     * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
     *
     *
     *
     * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
     *
     * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
     *
     * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
     *
     * 说明：
     *
     * 30----后续有30个整数
     *
     * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I，不输出0，而下一个R<i>是3
     *
     * 6--- 存在6个包含3的I
     *
     * 0--- 123所在的原序号为0
     *
     * 123--- 123包含3，满足条件
     */
    public static void method10() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=null;
        while((s=br.readLine())!=null){
            String s1=br.readLine();
            String str2[]=s1.split(" ");
            int a2[]=new int[str2.length-1];
            for(int i=1;i<str2.length;i++){
                a2[i-1]=Integer.valueOf(str2[i]);
            }
            int R=Integer.valueOf(str2[0]);
            String str1[]=s.split(" ");
            String a1[]=new String[str1.length-1];
            for(int i=1;i<str1.length;i++){
                a1[i-1]=str1[i];
            }
            int I=Integer.valueOf(str1[0]);
            Arrays.sort(a2);
            Set<Integer> set=new LinkedHashSet<Integer>();
            for(int i=0;i<a2.length;i++){
                set.add(a2[i]);
            }
            String[] str3=new String[set.size()];
            int l=0;
            for(Integer scale:set){
                str3[l]=String.valueOf(scale);
                l++;
            }
            StringBuilder sb=new StringBuilder();
            int count1=0;
            for(int i=0;i<str3.length;i++){
                int count=0;
                for(int j=0;j<I;j++){
                    if(a1[j].contains(str3[i])){
                        count++;
                    }
                }
                if(count!=0) {
                    sb.append(str3[i]+" ");
                    sb.append(count+" ");
                    count1=count1+2;
                }//sb.insert(sb.length()-count,count+"    ");
                for(int j=0;j<I;j++){
                    if(a1[j].contains(str3[i])){
                        sb.append(j+" "+a1[j]+" ");
                        count1=count1+2;
                    }
                }
            }
            sb.insert(0,count1+" ");
            char[] chars=s.toCharArray();
            System.out.println(sb);
        }
    }
    /**
     *字符串加解密
     * 描述
     * 1、对输入的字符串进行加解密，并输出。
     *
     * 2、加密方法为：
     *
     * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
     *
     * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
     *
     * 其他字符不做变化。
     *
     * 3、解密方法为加密的逆过程。
     *
     * 本题含有多组样例输入。
     *
     * 数据范围：输入的两个字符串长度满足  ，保证输入的字符串都是大小写字母或者数字
     * 输入描述：
     * 输入说明
     * 输入一串要加密的密码
     * 输入一串加过密的密码
     *
     * 输出描述：
     * 输出说明
     * 输出加密后的字符
     * 输出解密后的字符
     */
    public static void method11(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            System.out.println(encrypt(str1));
            String str2 = sc.nextLine();
            System.out.println(decrypt(str2));
        }


    }
    public static String encrypt(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='a'&&ch<'z'){
                sb.append((char)(ch-'a'+'A'+1));
            }
            else if(ch=='z'){
                sb.append('A');
            }
            else if(ch>='A'&&ch<'Z'){
                sb.append((char)(ch-'A'+'a'+1));
            }
            else if(ch=='Z'){
                sb.append('a');
            }
            else if(ch>='0'&&ch<'9'){
                sb.append((char)(ch+1));
            }
            else if(ch=='9'){
                sb.append('0');
            }
        }
        return sb.toString();
    }
    public static String decrypt(String str){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>'a'&&ch<='z'){
                sb.append((char)(ch-'a'+'A'-1));
            }
            else if(ch=='a'){
                sb.append('Z');
            }
            else if(ch>'A'&&ch<='Z'){
                sb.append((char)(ch-'A'+'a'-1));
            }
            else if(ch=='A'){
                sb.append('z');
            }
            else if(ch>'0'&&ch<='9'){
                sb.append((char)(ch-1));
            }
            else if(ch=='0'){
                sb.append('9');
            }
        }
        return sb.toString();
    }
    /**
     *字符串合并处理
     * 描述
     * 按照指定规则对输入的字符串进行处理。
     *
     * 详细描述：
     *
     * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成的字符串为 "decfab"
     *
     * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标的意思是字符在字符串中的位置。注意排序后在新串中仍需要保持原来的奇偶性。例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
     *
     * 第三步：对排序后的字符串中的'0'~'9'、'A'~'F'和'a'~'f'字符，需要进行转换操作。
     * 转换规则如下：
     * 对以上需要进行转换的字符所代表的十六进制用二进制表示并倒序，然后再转换成对应的十六进制大写字符（注：字符 a~f 的十六进制对应十进制的10~15，大写同理）。
     * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
     * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是14，转换为十六进制的大写字母为 'E'。
     * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
     * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"
     *
     *
     * 注意本题含有多组样例输入。
     *
     * 数据范围：输入的字符串长度满足
     * 输入描述：
     * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
     *
     * 输出描述：
     * 输出转化后的结果。每组样例输出一行。
     */
    public static void method12(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1  = sc.nextLine();
            String str = str1.replaceAll(" ", "");
            String[] array = str.split("");

            String[] sortArray = paixu(array);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sortArray.length; i++) {
                // ->10->2->10->16
                if (sortArray[i].matches("[0-9]")) {
                    StringBuilder sbBin = new StringBuilder(Integer.toBinaryString(Integer.parseInt(sortArray[i])));
                    int len = sbBin.length();
                    if (len < 4) {
                        StringBuilder sb0 = new StringBuilder();
                        for (int j = 0; j < 4-len; j++) {
                            sb0.append(0);
                        }
                        sbBin = sb0.append(sbBin);
                    }
                    int tenNum = Integer.parseInt(sbBin.reverse().toString(), 2);
                    sb.append(Integer.toHexString(tenNum).toUpperCase());
                } else if (sortArray[i].matches("[a-fA-F]")){
                    int tenNum = Integer.parseInt(sortArray[i], 16);
                    StringBuilder sbBin = new StringBuilder(Integer.toBinaryString(tenNum));
                    int tenNum2 = Integer.parseInt(sbBin.reverse().toString(), 2);
                    sb.append(Integer.toHexString(tenNum2).toUpperCase());
                } else {
                    sb.append(sortArray[i]);
                }
            }
            System.out.println(sb.toString());
        }
    }
    public static String[] paixu(String[] array) {
        List<String> lstO = new ArrayList<>();
        List<String> lstJ = new ArrayList<>();
        for (int i = 0; i< array.length; i++) {
            if ((i+1)%2 == 0) {
                lstO.add(array[i]);
            } else {
                lstJ.add(array[i]);
            }
        }
        List<String> newLstO = lstO.stream().sorted().collect(Collectors.toList());
        List<String> newLstJ = lstJ.stream().sorted().collect(Collectors.toList());
        for (int i = newLstO.size()-1; i >=0; i--) {
            if (i+1 >= newLstJ.size()) {
                newLstJ.add(newLstO.get(i));
            } else {
                newLstJ.add(i+1, newLstO.get(i));
            }
        }
        return String.join("", newLstJ).split("");
    }
    /**
     *密码截取
     * 描述
     * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
     *
     * 数据范围：字符串长度满足
     * 输入描述：
     * 输入一个字符串（字符串的长度不超过2500）
     *
     * 输出描述：
     * 返回有效密码串的最大长度
     */
    public static void method13(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.length() == 1) {
                System.out.println(1);
                return;
            }
            int ama = Math.max(maxLength1(str), maxLength2(str));
            System.out.println(ama);
        }
    }
    private static int maxLength2(String str) {
        int max = 0;
        for (int a = 0; a < str.length(); a++) {
            if (a > str.length() - 2) {
                break;
            }
            if (str.charAt(a) != str.charAt(a + 1)) {
                continue;
            }
            int maxCount = 2; // 本次找到得最长长度
            int bMax = Math.max(str.length() - a, a);
            for (int b = 1; b < bMax; b++) {
                if (a + b + 1 >= str.length()) {
                    break;
                }
                if (a - b < 0) {
                    break;
                }
                if (str.charAt(a - b) == str.charAt(a + b + 1)) {
                    maxCount += 2;
                    if (max < maxCount) {
                        max = maxCount;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }
    private static int maxLength1(String str) {
        int max = 0;
        for (int a = 1; a < str.length(); a++) {
            int maxCount = 1; //本次找到得最长长度
            int bMax = Math.max(str.length() - a, a);
            for (int b = 1; b < bMax; b++) {
                if (a + b > str.length() - 1) {
                    break;
                }
                if (a - b < 0) {
                    break;
                }
                if (str.charAt(a - b) == str.charAt(a + b)) {
                    maxCount += 2;
                    if (max < maxCount) {
                        max = maxCount;
                    }
                } else {
                    break;
                }
            }
        }
        return max;
    }
    /**
     *整数与IP地址间的转换
     * 描述
     * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
     * 一个长整数。
     * 举例：一个ip地址为10.0.3.193
     * 每段数字             相对应的二进制数
     * 10                   00001010
     * 0                    00000000
     * 3                    00000011
     * 193                  11000001
     *
     * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
     *
     * 本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
     *
     * 数据范围：保证输入的是合法的 IP 序列
     *
     *
     * 输入描述：
     * 输入
     * 1 输入IP地址
     * 2 输入10进制型的IP地址
     *
     * 输出描述：
     * 输出
     * 1 输出转换成10进制的IP地址
     * 2 输出转换后的IP地址
     */
    public static void method14(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String ip = sc.nextLine();
            long ipDeci = Long.parseLong(sc.nextLine());
            System.out.println(transferToIpDecimal(ip));
            System.out.println(transferToIpAddress(ipDeci));
        }
    }
    // ip转成10进制数
    public static long transferToIpDecimal(String ip) {
        String[] ips = ip.split("\\.");
        long res = 0;
        for (int i = ips.length - 1, n = 0; i >= 0; i--) {
            res += Integer.parseInt(ips[i]) * Math.pow(2, n);
            n += 8;
        }
        return res;
    }
    // 10进制数转成ip
    public static String transferToIpAddress(long ipDeci) {
        StringBuilder sb = new StringBuilder();
        long ipi = 0;
        while (ipDeci > 0) {
            ipi = ipDeci % (long) Math.pow(2, 8);
            ipDeci = ipDeci / (long) Math.pow(2, 8);
            if (sb.length() == 0) {
                sb = sb.append(ipi);
            } else {
                sb = new StringBuilder().append(ipi).append(".").append(sb);
            }
        }
        return sb.toString();
    }
    /**
     *判断两个IP是否属于同一主网
     * 描述
     * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
     * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
     *
     * 示例：
     * I P 地址　 192.168.0.1
     * 子网掩码　 255.255.255.0
     *
     * 转化为二进制进行运算：
     *
     * I P 地址　  11000000.10101000.00000000.00000001
     * 子网掩码　11111111.11111111.11111111.00000000
     *
     * AND运算   11000000.10101000.00000000.00000000
     *
     * 转化为十进制后为：
     * 192.168.0.0
     *
     *
     * I P 地址　 192.168.0.254
     * 子网掩码　 255.255.255.0
     *
     *
     * 转化为二进制进行运算：
     *
     * I P 地址　11000000.10101000.00000000.11111110
     * 子网掩码  11111111.11111111.11111111.00000000
     *
     * AND运算  11000000.10101000.00000000.00000000
     *
     * 转化为十进制后为：
     * 192.168.0.0
     * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
     *
     * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
     * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
     *
     * 注:
     * 有效掩码与IP的性质为：
     * 1. 掩码与IP每一段在 0 - 255 之间
     * 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
     *
     * 本题有多组输入
     *
     * 输入描述：
     * 多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
     *
     * 输出描述：
     * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
     */
    public static void method15(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String yanma=sc.nextLine();
            String ip1=sc.nextLine();
            String ip2=sc.nextLine();
            System.out.println(choice(yanma,ip1,ip2));;
        }
    }
    private static int choice(String yanma, String ip1, String ip2) {
        String[] yanma1=yanma.split("\\.");
        String[] ip11=ip1.split("\\.");
        String[] ip21=ip2.split("\\.");
        int[] yanmanum=new int[4];
        int[] ip1num=new int[4];
        int[] ip2num=new int[4];

        int[] num1=new int[4];
        int[] num2=new int[4];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<4;i++){
            yanmanum[i]=Integer.parseInt(yanma1[i]);
            ip1num[i]=Integer.parseInt(ip11[i]);
            ip2num[i]=Integer.parseInt(ip21[i]);
            int len=Integer.toBinaryString(yanmanum[i]).length();
            for(int j=8;j>0;j--){
                if(len>=j){
                    sb.append(Integer.toBinaryString(yanmanum[i]));
                    break;
                }else {
                    sb.append("0");
                }
            }
        }
        char[] cs=sb.toString().toCharArray();
        Arrays.sort(cs);
        String css=new String(cs);
        String bss=new String(sb.reverse());
        if(!bss.equals(css)){
            return 1;
        }

        for(int i=0;i<4;i++){
            num1[i]=yanmanum[i]&ip1num[i];
            num2[i]=yanmanum[i]&ip2num[i];
            if(ip1num[i]<0||ip1num[i]>255||ip2num[i]<0||ip2num[i]>255||yanmanum[i]<0||yanmanum[i]>255){
                return 1;
            }
        }
        for(int i=0;i<4;i++){
            if(num1[i]!=num2[i]){
                return 2;
            }
        }
        return 0;
    }
    /**
     * 称砝码
     *描述
     * 现有一组砝码，重量互不相等，分别为 m1,m2,m3…mn ；
     * 每种砝码对应的数量为 x1,x2,x3...xn 。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
     *
     *
     * 注：
     *
     * 称重重量包括 0
     *
     * 本题有多组输入
     *
     * 数据范围：每组输入数据满足  ，  ，
     * 输入描述：
     * 输入包含多组测试数据。
     * 对于每组测试数据：
     * 第一行：n --- 砝码数(范围[1,10])
     * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
     * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
     * 输出描述：
     * 利用给定的砝码可以称出的不同的重量数
     */
    public static void method16(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            HashSet<Integer> set = new HashSet<>();//存放所有可能的结果，不用担心重复问题
            set.add(0);//初始化为0
            int n = in.nextInt();//个数
            int[] w = new int[n];
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                w[i] = in.nextInt();//砝码的重量
            }
            for(int i=0;i<n;i++){
                nums[i] = in.nextInt();//砝码个数
            }
            for(int i=0;i<n;i++){//遍历砝码
                ArrayList<Integer> list = new ArrayList<>(set);//取当前所有的结果
                for(int j=1;j<=nums[i];j++){//遍历个数
                    for(int k=0;k<list.size();k++){
                        set.add(list.get(k) + w[i] * j);
                    }
                }
            }
            System.out.println(set.size());
        }
    }/**
     *学英语
     * 描述
     * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
     *
     * 具体规则如下:
     * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
     * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
     * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X. 每个X分别代表三位数或两位数或一位数。
     * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
     *
     * 下面再看几个数字例句：
     * 22: twenty two
     * 100:  one hundred
     * 145:  one hundred and forty five
     * 1,234:  one thousand two hundred and thirty four
     * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
     * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
     * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
     *
     * 说明：
     * 数字为正整数，不考虑小数，转化结果为英文小写；
     * 保证输入的数据合法
     * 关键字提示：and，billion，million，thousand，hundred。
     *
     * 数据范围：
     *
     * 本题含有多组输入数据。
     *
     * 输入描述：
     * 输入多行long型整数
     *
     * 输出描述：
     * 输出相应的英文写法
     */
    public static void method17(){
        Scanner in = new Scanner(System.in);
        String[] NUMS = {"zero", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty"};
        String[] NUMSSHI = {"zero", "ten", "twenty", "thirty", "forty", "fifty",
                "sixty", "seventy", "eighty", "ninety"};
        String[] POWER = {"", "hundred", "thousand", "million", "billion"};
        while(in.hasNext()){
            String line = in.nextLine();
            StringBuilder sb = new StringBuilder();
            ArrayList<String> lists = new ArrayList<>();
            if(!line.matches("\\d+")){//如果匹配的不是数字
                System.out.println("error");
            }
            int linenum = Integer.parseInt(line);
            int power = 1;//单位
            while(linenum != 0){
                if(power != 1){
                    lists.add(POWER[power]);//添加单位
                }
                int t = linenum % 1000;//取低三位
                //注意小于20，直接读
                if(t % 100 <= 20){
                    if(t % 100 != 0){//十位和个位是零的话就不需要读数了
                        lists.add(NUMS[t % 100]);
                    }
                    if(t / 100 != 0){//有百位
                        if(t % 100 != 0){//十位和个位是零的话就不需要添加and了
                            lists.add("and");
                        }
                        lists.add("hundred");
                        lists.add(NUMS[t / 100]);
                    }
                }else{//大于20
                    // 有个位
                    if(t % 10 != 0){
                        lists.add(NUMS[t % 10]);
                    }
                    t /= 10;
                    // 有十位
                    if(t % 10 != 0){
                        lists.add(NUMSSHI[t % 10]);
                    }
                    t /= 10;
                    // 有百位
                    if(t % 10 != 0){
                        lists.add("and");
                        lists.add("hundred");
                        lists.add(NUMS[t % 10]);
                    }
                }
                linenum /= 1000;//每次缩小1000倍
                power++;//单位*1000
            }
            //添加的时候，先添加低位，读数的时候先读高位，倒着读
            for(int i = lists.size() - 1; i >= 0; i--){
                if(i!=0){
                    sb.append(lists.get(i) + " ");
                }else{
                    sb.append(lists.get(i));//最后一个不加空格
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     *输出单向链表中倒数低N个节点
     * 描述
     * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
     *
     * 链表结点定义如下：
     *
     * struct ListNode
     *
     * {
     *
     * int       m_nKey;
     *
     * ListNode* m_pNext;
     *
     * };
     *
     *
     *
     * 正常返回倒数第k个结点指针，异常返回空指针
     *
     * 数据范围：链表长度满足  ，  ，链表中数据满足
     *
     * 本题有多组样例输入。
     *
     *
     * 输入描述：
     * 输入说明
     * 1 输入链表结点个数
     * 2 输入链表的值
     * 3 输入k的值
     *
     * 输出描述：
     * 输出一个整数
     */
    public static void method18(){
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int len = in.nextInt();
            StringBuilder s = new StringBuilder();
            for(int i=0;i<len;++i){
                s.append(in.nextInt()+" ");
            }
            int k = in.nextInt();
            if(k<1||k>len) System.out.println(0);
            else {
                String str = s.toString();
                String []ss = str.split(" ");
                int count = 0;
                for(int i=0;i<ss.length;++i){
                    if(i>=k){
                        ++count;
                    }
                }
                System.out.println(ss[count]);
            }
        }
    }
    /**
     * 输入n个整数，输出其中最小的k个
     *描述
     * 输入n个整数，输出其中最小的k个整数并按升序输出
     *
     * 本题有多组输入样例
     *
     * 数据范围： ，输入的整数满足
     * 输入描述：
     * 第一行输入两个整数n和k
     * 第二行输入一个整数数组
     *
     * 输出描述：
     * 输出一个从小到大排序的整数数组
     */
    public static void method19(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int key = in.nextInt();
            String s = Integer.toBinaryString(key);


            String[] split = s.split("0");

            int count[] = new int[150];

            for (int i = 0; i < split.length; i++) {
                int length = split[i].length();
                count[i] = length;
            }
            Arrays.sort(count);

            System.out.println(count[count.length - 1]);

        }
    }
    /**
     * 成绩排序
     *描述
     * 查找和排序
     *
     * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
     * 都按先录入排列在前的规则处理。
     *
     * 例示：
     * jack      70
     * peter     96
     * Tom       70
     * smith     67
     *
     * 从高到低  成绩
     * peter     96
     * jack      70
     * Tom       70
     * smith     67
     *
     * 从低到高
     *
     * smith     67
     *
     * jack      70
     *
     * Tom       70
     * peter     96
     *
     * 注：0代表从高到低，1代表从低到高
     *
     * 注意：本题含有多组输入数据！
     * 数据范围：人数：，数据组数：
     * 进阶：时间复杂度：，空间复杂度：
     * 输入描述：
     * 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开
     *
     * 输出描述：
     * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
     */
    public static void method20(){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>();
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            int flag = Integer.parseInt(sc.nextLine());//1是升序，0是降序
            int[][] score = new int[n][2];//姓名编号，成绩
            for(int i=0;i<n;i++){
                String[] nameAndScore = sc.nextLine().split("\\s+");
                score[i][0] = i;
                score[i][1] = Integer.parseInt(nameAndScore[1]);
                map.put(i,nameAndScore[0]);
            }
            Arrays.sort(score,(o1,o2) ->{
                if(flag==0){
                    return o2[1] - o1[1];//按第二列降序排列,如果相等的话，返回0，顺序不变
                }else{
                    return o1[1] - o2[1];//按第二列升序
                }
            });
            for(int i=0;i<n;i++){
                System.out.println(map.get(score[i][0]) + " " + score[i][1]);
            }
        }
    }
    /**
     *火车进站
     * 描述
     * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
     * 要求输出所有火车出站的方案，以字典序排序输出。
     * 数据范围：
     * 进阶：时间复杂度：，空间复杂度：
     * 输入描述：
     * 有多组测试用例，每一组第一行输入一个正整数N（0
     *
     * 输出描述：
     * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
     */
    public static void method21(){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            // 未进站的火车
            Queue<Integer> queue = new LinkedList<>();
            // 已进站的火车
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < n; i++) {
                queue.offer(sc.nextInt());
            }

            List<String> outQueueList = new ArrayList<>();

            // 获取所有出站队列保存到outQueueList
            processOutQueue(queue, stack, "", outQueueList);

            // 排序
            Collections.sort(outQueueList);
            for (String str : outQueueList) {
                System.out.println(str);
            }

        }
    }
    private static void processOutQueue(Queue<Integer> queue, Stack<Integer> stack, String outQueue, List<String> outQueueList) {
        // 如果队列和栈都为空，则保存出站信息
        if (queue.isEmpty() && stack.isEmpty()) {
            outQueueList.add(outQueue.trim());
            return;
        }

        // 队列和栈有两种情况：出栈或进栈
        // 一：出栈
        if (!stack.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            String tempOutQueue = outQueue + (tempStack.pop() + " ");
            processOutQueue(tempQueue, tempStack, tempOutQueue, outQueueList);
        }

        // 二：队列进栈
        if (!queue.isEmpty()) {
            // 先克隆
            Queue<Integer> tempQueue = new LinkedList<>(queue);
            Stack<Integer> tempStack = (Stack<Integer>) stack.clone();
            tempStack.push(tempQueue.poll());
            processOutQueue(tempQueue, tempStack, outQueue, outQueueList);
        }
    }
    /**
     * 整形数组合并
     *描述
     * 题目标题：
     *
     * 将两个整型数组按照升序合并，并且过滤掉重复数组元素。
     * 输出时相邻两数之间没有空格。
     * 请注意本题有多组样例。
     *
     *
     *
     * 输入描述：
     * 输入说明，按下列顺序输入：
     * 1 输入第一个数组的个数
     * 2 输入第一个数组的数值
     * 3 输入第二个数组的个数
     * 4 输入第二个数组的数值
     *
     * 输出描述：
     * 输出合并之后的数组
     */
    public static void method22(){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            Set<Long> set = new TreeSet<>();
            //接收第一个整形数组大小
            int size1 = sc.nextInt();
            for (int i = 0; i < size1; i++) {
                set.add(sc.nextLong()); //将该组的整数按数组大小循环添加进 set
            }
            //接收第一个整形数组大小
            int size2 = sc.nextInt();
            for (int i = 0; i < size2; i++) {
                set.add(sc.nextLong());
            }
            //遍历输出
            for (long n : set) {
                System.out.print(n);
            }
          /*
          注意：测试案例会以 两个整形数组 为一组测试用例， 并可能输入多组
          要记得组与组的结果之间换行
          */
            System.out.println();
        }

    }
    /**
     *字符串字符匹配
     * 描述
     * 判断短字符串S中的所有字符是否在长字符串T中全部出现。
     * 请注意本题有多组样例输入。
     * 数据范围:
     * 进阶：时间复杂度：，空间复杂度：
     * 输入描述：
     * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
     *
     * 输出描述：
     * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
     */
    public static void method23(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String a = sc.nextLine();
            String b = sc.nextLine();
            String[] array = a.split("");  //将 短字符串 切分并放入数组中
            //定义计数器并初始化
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (b.contains(array[i])){
                    // 循环判断 长字符串 中是否包含 短字符串中的字符
                    // 如果包含，则计数器加一
                    count++;
                }
            }
            // 当计数器大小 等于 原短字符串生成的数组长度时 ，即为 短字符串的所有字符均在长字符串中出现过
            if (count == array.length){
                System.out.println(true);
            }else {
                System.out.println(false);
            }
        }

    }
    /**
     * 在字符串中找出连续最长的数字串
     *描述
     * 输入一个字符串，返回其最长的数字子串，以及其长度。若有多个最长的数字子串，则将它们全部输出（按原字符串的相对位置）
     * 本题含有多组样例输入。
     *
     * 数据范围：字符串长度  ， 保证每组输入都至少含有一个数字
     * 输入描述：
     * 输入一个字符串。1<=len(字符串)<=200
     *
     * 输出描述：
     * 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不要输出空格）。
     */
    public static void method24(){
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] ss = line.split("[^0-9]+");
            int max  = 0;
            ArrayList<String> list = new ArrayList<>();
            for(String s : ss){
                if(s.length() > max){
                    max = s.length();
                    list.clear();
                    list.add(s);
                }else if(s.length() == max){
                    max = s.length();
                    list.add(s);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(String item : list){
                sb.append(item);
            }
            sb.append(",").append(max);
            System.out.println(sb.toString());
        }
    }
    /**
     * 数组分组
     *描述
     * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
     *
     * 本题含有多组样例输入。
     *
     * 数据范围：每个数组大小满足  ，输入的数据大小满足
     * 输入描述：
     * 第一行是数据个数，第二行是输入的数据
     *
     * 输出描述：
     * 返回true或者false
     */
    public static void method25(){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //根据输入计算sum3，sum5和所有数总和sum，同时把不是5和3倍数的剩余数放入集合
            List<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            int sum5=0, sum3=0, sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();//输入
                if (cur % 5 == 0){//5倍数和
                    sum5 += cur;
                }else if (cur % 3 == 0){//3倍数和
                    sum3 += cur;
                }else{//剩余加入集合
                    list.add(cur);
                }
                sum += cur;//总和
            }

            //特例，总和不是2的倍数，不可分2份和相等的数字
            if(sum%2!=0) System.out.println("false");
            else{//否则，在剩余数中找目标数字
                int target = sum/2 - sum3;//也可以是sum/2-sum5
                System.out.println(helper(list, target, 0));
            }
        }
    }
    private static boolean helper(List<Integer> list, int target, int start){
        if (start == list.size()) return target == 0;//终止条件

        //选择start位置，递归找新目标数target-list.get(start)， 或者不选择start位置，在后面位置找target
        return helper(list, target-list.get(start), start+1) || helper(list, target, start+1);
    }
    /**
     *计票统计
     * 描述
     * 请实现一个计票统计系统。你会收到很多投票，其中有合法的也有不合法的，请统计每个候选人得票的数量以及不合法的票数。
     * 本题有多组样例输入。
     *
     * 数据范围：每组输入中候选人数量满足  ，总票数量满足
     * 输入描述：
     * 输入候选人的人数n，第二行输入n个候选人的名字（均为大写字母的字符串），第三行输入投票人的人数，第四行输入投票。
     *
     * 输出描述：
     * 按照输入的顺序，每行输出候选人的名字和得票数量，最后一行输出不合法的票数。
     */
    public static void method26()throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String line = null;
        while ((line = f.readLine()) != null)
        {
            int n = Integer.parseInt(line);
            // 这里需要保存名字，因为需要按名字顺序打印
            String[] names = new String[n];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for (int i = 0; i < n; i++)
            {
                names[i] = st.nextToken();
            }
            // n个候选人的名字
            Map<String, Integer> map = new HashMap<>();
            for (String name : names) {
                map.put(name, 0);
            }

            int invalid = 0;
            // m个投票人
            int m = Integer.parseInt(f.readLine());
            st = new StringTokenizer(f.readLine());
            for (int i = 0; i < m; i++)
            {
                String name = st.nextToken();
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + 1);
                }
                else {
                    invalid++;
                }
            }
            for (String name : names) {
                out.println(name  + " : " + map.get(name));
            }
            out.println("Invalid : " + invalid);
        }
        out.close();
        f.close();
    }
    /**
     *人民币转换
     * 描述
     * 考试题目和要点：
     *
     * 1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。
     *
     * 2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。
     *
     * 3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分“。
     * 4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”
     * 5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”
     *
     *
     * 本题含有多组样例输入。
     *
     * 输入描述：
     * 输入一个double数
     *
     * 输出描述：
     * 输出人民币格式
     */
    public static String[] ten = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
    public static String[] power = {"万","亿"};
    public static String[] daiwei = {"元","角","分","整"};
    public static void method27(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] s = in.nextLine().split("\\.");//分割为整数部分和小数部分
            if(s[1].equals("00")){
                System.out.println("人民币" + solveZheng(Double.parseDouble(s[0])) + "元整");
            }else if(s[0].equals("0")){
                System.out.println("人民币" + solveXiao(s[1]));
            }else{
                System.out.println("人民币" + solveZheng(Double.parseDouble(s[0])) + "元" + solveXiao(s[1]));
            }
        }
    }
    public static String solveXiao(String s2){
        StringBuilder sb = new StringBuilder();
        int jiao = Integer.parseInt(s2.substring(0,1));
        int fen = Integer.parseInt(s2.substring(1,2));
        if(jiao!=0){
            sb.append(ten[jiao]);
            sb.append("角");
        }
        if(fen!=0){
            sb.append(ten[fen]);
            sb.append("分");
        }
        return sb.toString();
    }
    public static String solveZheng(double zheng){
        StringBuilder sb = new StringBuilder();
        int pow = 0;
        while((int)zheng != 0){
            if(pow!=0){
                sb.append(power[pow-1]);
            }
            int temp = (int)(zheng % 10000);
            //个位
            int gewei = temp % 10;
            int shiwei = (temp / 10) % 10;
            int baiwei = (temp/100) % 10;
            int qianwei = (temp/1000) % 10;
            if(gewei!=0){
                sb.append(ten[gewei]);
            }
            //十位
            if(shiwei!=0){
                sb.append("拾");
                if(shiwei!=1){
                    sb.append(ten[shiwei]);
                }
            }else{
                if(gewei != 0 && (temp>99 || (int)zheng > 10000)){
                    sb.append(ten[0]);
                }
            }
            //百位
            if(baiwei!=0){
                sb.append("佰");
                sb.append(ten[baiwei]);
            }else{
                if(shiwei != 0 && (temp>999 || (int)zheng > 10000)){
                    sb.append(ten[0]);
                }
            }
            if(qianwei!=0){
                sb.append("仟");
                sb.append(ten[qianwei]);
            }else{
                if(baiwei != 0 && (int)zheng > 10000){
                    sb.append(ten[0]);//
                }
            }
            zheng /= 10000;
            pow++;
            if(pow>2){
                pow=1;
            }
        }
        return sb.reverse().toString();
    }

    /**
     *记负均正II
     * 描述
     * 输入 n 个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
     * 本题有多组输入数据，输入到文件末尾。
     *
     * 数据范围： ，其中每个数都满足
     * 输入描述：
     * 输入任意个整数，每行输入一个。
     *
     * 输出描述：
     * 输出负数个数以及所有非负数的平均值
     */
    public static void method28(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int temp = 0;
        int countN = 0;
        int countP = 0;
        double sum = 0.0;
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            temp = in.nextInt();
            if(temp<0){
                countN++;
            }else if(temp>0){
                countP++;
                sum += temp;
            }
        }
        System.out.println(countN);
        if(countP==0){
            System.out.printf("0.0");
        }else{
            System.out.printf("%.1f\n",sum/countP);
        }
    }

}
