package 设计模式;

public class 适配器模式样例 {
    public static void main(String[] args) {
//      假设现在我们有两种职业我们想获得他们的金钱来源
//      我们可以调用每个职业的专用方法 但是 耦合度高
//      所以我们提出
//      调用者 面向适配器 适配器处理这些职业
        WorkAdapter workAdapter_1 = new StudentWorkAdapter();
        System.out.println(workAdapter_1.getMoney(new Student()));
        WorkAdapter workAdapter_2 = new DoctorWorkAdapter();
        System.out.println(workAdapter_2.getMoney(new Doctor()));
    }
}
interface WorkAdapter {
    String getMoney(Object obj);
}
class Student {
    String getMoneyByFather() {
        return "爸爸给的钱";
    }
}

class Doctor {
    String getMoneyByPerson() {
        return "病人给的钱";
    }
}

class StudentWorkAdapter implements WorkAdapter{

    @Override
    public String getMoney(Object obj) {
        return ((Student)obj).getMoneyByFather();
    }
}

class DoctorWorkAdapter implements WorkAdapter {

    @Override
    public String getMoney(Object obj) {
        return ((Doctor)obj).getMoneyByPerson();
    }
}