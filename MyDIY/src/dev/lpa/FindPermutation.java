package dev.lpa;

import java.util.ArrayList;
import java.util.List;

// ある文字列から順列を探すアルゴリズム@82ページ
public class FindPermutation {

    public static void main(String[] args) {

        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";

        List<Integer> result = new ArrayList<>();

        // sの文字数未満はfalseのため処理しない
        for (int i = 0; i <= b.length() - s.length(); i++) {

            String sub = b.substring(i, i + s.length());
            if (sub.contains("d")) {
                continue;
            }
            if (isPermutation(s, sub)) {
                result.add(i);
            }
        }

        System.out.println("各順列の場所は" + result + "です");
    }

    private static boolean isPermutation(String s, String sub) {

        // 固定長配列の配列の長さを短くするための無名関数
        java.util.function.IntUnaryOperator charToIndex = c -> c - 'a'; // aは97である。したがってa - a = 0 になる。

        int[] sCounts = new int[4];
        int[] subCounts = new int[4];

        for (int i = 0; i < s.length(); i++) {
            sCounts[charToIndex.applyAsInt(s.charAt(i))]++;
            subCounts[charToIndex.applyAsInt(sub.charAt(i))]++;
        }

        for (int i = 0; i < 4; i++) {
            if (sCounts[i] != subCounts[i]) return false;
        }
        return true;
    }
}
