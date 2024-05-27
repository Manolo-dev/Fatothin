import view.MainFrame;
import model.Datas;

public class Main {
    private static Datas datas = new Datas();

    public static void main(String[] args) {
        MainFrame frame = new MainFrame(datas);
        frame.setVisible(true);
    }
}
