package dev.lpa.ObjectOrientedDesign;

public class CallCenter {

    public static void main(String[] args) {

        //
        // recordクラスで問い合わせを管理する
        //
        record ContactInfo(int id, String customerName, String content) {}

        // var c = new CallCenter
        // c.run(); // 受付開始(従業員をセット)

        // 問い合わせ番号 = c.callFromCustomer // 問い合わせがくる->問い合わせ情報をデータベースに保持

        // c.dispatchCall(問い合わせ番号); // 最初に繋ぐことのできる従業員に問い合わせを割り当てる(手が空いている応答者に繋ぐ->応答者で対応できない場合はマネージャに繋ぐ。マネージャが忙しい時、または対応できない場合はディレクタに繋ぐ。)
    }
}



//
// 登場人物
//
class human {

}

class employee extends human {
    // 3段階のレベルの従業員が存在する(enumを検討する)

}

class operator extends employee {

}

class manager extends employee {

}

class director extends employee {

}

//
// dispatchCallは必ず実装する
//
interface dispatchCallable {

    void dispatchCall();

}

//
// コールセンター
//
class CallCenterCompany implements dispatchCallable {

    // employee<human>() のようにジェネレータ型で従業員の配列を定義する
    operator o;
    manager m;


    // コンストラクタ
    public CallCenterCompany() {
    }

    @Override
    public void dispatchCall() {

    }
}






