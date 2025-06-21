package dev.lpa;

public class Main {

    String s = "abbc";
    String b = "cbabadcbbabbcbabaabccbabc";

    // counter = 0;
    int counter = 0;

    // ループ開始
    // bのスタートを先頭から1ずつ右へスライドする
    // bを4文字取得する
    // bが4文字でない場合、または'd'が含まれる場合は次のループへ
    // bが4文字の場合かつ、sの順列の場合(is順列関数の呼び出し)、counter++
    // 次のループへ

    //
    // 悪い例(=できないよりは良い)
    //
    // sの全ての組み合わせを作成して配列に格納する。
    // 全ての組み合わせを1つずつ取り出して、bを先頭から4文字ずつ取得して探す。
    // forループをネストした設計なので効率が悪い
}
