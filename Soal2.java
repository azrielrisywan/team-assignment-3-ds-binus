import java.util.LinkedList;
import java.util.Queue;

public class Soal2 {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("Item 1");
        queue.add("Item 2");

        int jumlahDenganSize = queue.size();
        System.out.println("Jumlah awal item : " + jumlahDenganSize);

        String head = queue.poll();

        System.out.println("Setelah dequeue '" + head + "', jumlah sekarang : " + queue.size());

        String newItem = "Item 3";
        queue.offer(newItem);
        System.out.println("Setelah enqueue '" + newItem + "', jumlah sekarang : " + queue.size());
    }
}
