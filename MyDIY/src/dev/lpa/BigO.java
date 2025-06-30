package dev.lpa;

//
// 時間計算量
//
// sサイズの電子ファイルを送ることを考えた場合に
// メールで送信する場合はO(s)である。なぜならファイルのサイズによって計算に「時間」がかかるためである
// 空輸する場合はO(1)である。なぜならファイルのサイズに関わらず一定の時間で送ることができるためである

//
// 空間計算量
//
// n * n の二次元配列は O(n^2)のメモリ空間が必要、一般的にforループをネストすると空間計算量の効率が落ちる
// 再帰でn回呼ばれる関数は大体O(n)になる
// しかしn回呼ばれる場合はO(n)というわけでない。forループの中で、ある機能（例: 隣どおし足し合わせる）を提供する関数を処理する場合はO(1)です。
// なぜなら、ある機能はforループ内で同時に呼び出されることはないからです。つまりメモリ領域としてはforループのO(1)となるわけです。

public class BigO {

    static int callStack = 1;

    public static void main(String[] args) {
        System.out.println("Total : " + sum(5));
        System.out.println(twoSum());
        System.out.println(twoTimes());
        System.out.println(f(3));
        System.out.println(f(4));
    }

    static int sum(int n) {
        System.out.println("コールスタックに " + callStack + " 積まれました。 " + "n は " + n + " です。");
        if (n <= 0) {
            return 0;
        }
        callStack++;
        return n + sum(n - 1); // 呼び出しごとにコールスタックに積まれる。つまり実際のメモリを消費します。
    }

    // 実行時間を足す場合
    static boolean twoSum() {
        int[] arrA = {1, 5, 3, 7};
        int[] arrB = {2, 8, 4, 6};
        // 処理Aを行い、
        for (int a : arrA) {
            System.out.print(a + " ");
        }
        // 処理Aが終わってから
        System.out.println("");
        // 処理Bを行う
        for (int b : arrB) {
            System.out.print(b + " ");
        }
        System.out.println("");
        return false;
        // この場合は実行時間の和
    }

    // 実行時間をかける場合
    static boolean twoTimes() {
        int[] arrA = {1, 5, 3, 7};
        int[] arrB = {2, 8, 4, 6};
        // 処理Aを行う度に
        for (int a : arrA) {
            System.out.print(a + " ");
            // 処理Bを行う場合は
            for (int b : arrB) {
                System.out.print(b + " ");
            }
        }
        return false;
        // この実行時間は積
    }

    // 再帰の実行時間
    // n(4) = n(3) + n(3) -> 8
    // n(3) = n(2) + n(2) -> 4
    // n(2) = n(1) + n(1) -> 2
    // n(1) -> 1
    static int f(int n) {
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }
    // 複数の呼び出しを行う再帰関数では呼び出し回数の数になることが多い
    // n(1) = 1 = 2^0
    // n(2) = 2 = 2^1
    // n(4) = 3 = 2^2
    // n(8) = 4 = 2^3
    // つまりO(2^n)
    // しかし同時に全ての呼び出しが発生するわけではないので空間計算量はO(n)です。
}

