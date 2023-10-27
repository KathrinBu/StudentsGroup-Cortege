import java.util.List;

public class Cortege {
    private List<String> list1;
    private List<String> list2;
    private List<String> list3;
    private List<String> list4;

    public Cortege(List<String> list1, List<String> list2, List<String> list3, List<String> list4) {
        this.list1 = list1;
        this.list2 = list2;
        this.list3 = list3;
        this.list4 = list4;
    }

    public List<String> getList1() {
        return list1;
    }

    public List<String> getList2() {
        return list2;
    }

    public List<String> getList3() {
        return list3;
    }

    public List<String> getList4() {
        return list4;
    }
}
