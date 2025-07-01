package dev.lpa.ObjectOrientedDesign;

public class CallCenter {

    public static void main(String[] args) {

        // var c = new CallCenter
        // c.run(); // 受付開始
        // c.callFromCustomer // 問い合わせがくる 問い合わせ情報をデータベースに保持
        // c.

    }
}

//
// 登場人物
//
class human {

}

class employee extends human {
    // 3段階のレベルの従業員が存在する

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






