package dev.lpa;

import java.util.ArrayList;
import java.util.List;

// ある文字列から順列を探すアルゴリズム@82ページ
public class FindPermutation {

    public static void main(String[] args) {

        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";

        List<Integer> result = new ArrayList<>();

        // bのスタートを先頭から1ずつ右へスライドする
        // sの文字数未満はfalseのため処理しない
        for (int i = 0; i <= b.length() - s.length(); i++) {

            String sub = b.substring(i, i + s.length());
            if (sub.contains("d")) {
                continue;
            }

            if (isPermutation(s, sub)) {
                result.add(i);
            }
            ;
        }

        System.out.println("各順列の場所は" + result + "です");
    }

    private static int charToIndex(char c) {
        return c - 'a'; // aは97である。したがってa - a = 0 になる。
    }

    private static boolean isPermutation(String s, String sub) {
        int[] sCounts = new int[4];
        int[] subCounts = new int[4];

        for (int i = 0; i < s.length(); i++) {
            sCounts[charToIndex(s.charAt(i))]++;
            subCounts[charToIndex(sub.charAt(i))]++;
        }

        for (int i = 0; i < 4; i++) {
            if (sCounts[i] != subCounts[i]) return false;
        }
        return true;
    }
}
