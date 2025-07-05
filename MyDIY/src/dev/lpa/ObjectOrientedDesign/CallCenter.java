package dev.lpa.ObjectOrientedDesign;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {

    //
    // 問い合わせ情報
    //
    record ContactInfo(int id, String customerName, String content) {}

    public static void main(String[] args) {

        var c = new CallCenterCompany();
        c.dispatchCall( new ContactInfo(100, "Suzuki Taro", "商品Aについて質問") );
    }
}

//
// 登場人物
//
enum Level {
    LEVEL1,
    LEVEL2,
    LEVEL3,
}

enum WorkStatus {
    WAITING,
    DOING,
    DONE,
    BUSY
}

class human {
    String name;
    String age;
}

class employee extends human {
    int ID;
    int startToDate;
    Level level;

    public void work(CallCenter.ContactInfo info) {

    }
}

class operator extends employee {
    WorkStatus status;


}

class manager extends employee {
    WorkStatus status;

}

class director extends employee {
    WorkStatus status;

}

//
// dispatchCallは必ず実装する
//
interface dispatchCallable {

    void dispatchCall(CallCenter.ContactInfo info);
}

//
// コールセンター
//
class CallCenterCompany implements dispatchCallable {

    private String companyID;
    private List<employee> employees;

    public CallCenterCompany() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(employee e) {
        employees.add(e);
    }

    public List<employee> getEmployees() {
        return employees;
    }

    @Override
    public void dispatchCall(CallCenter.ContactInfo info) {

        List<operator> operators = new ArrayList<>();
        List<manager> managers = new ArrayList<>();
        List<director> directors = new ArrayList<>();

        // 役職ごとに分ける
        for (employee e : employees) {
            if (e instanceof operator o) {
                operators.add(o);
            } else if (e instanceof manager m) {
                managers.add(m);
            } else if (e instanceof director d) {
                directors.add(d);
            }
        }

        // operator → manager → director の順でWAITINGな人を探してwork()を呼ぶ
        for (operator o : operators) {
            if (o.status == WorkStatus.WAITING) {
                o.work(info);
                return;
            }
        }
        for (manager m : managers) {
            if (m.status == WorkStatus.WAITING) {
                m.work(info);
                return;
            }
        }
        for (director d : directors) {
            if (d.status == WorkStatus.WAITING) {
                d.work(info);
                return;
            }
        }
        System.out.println("全員対応中です。");
    }
}






