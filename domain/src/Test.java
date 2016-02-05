import java.util.Queue;

import com.google.common.collect.EvictingQueue;

public class Test {

	public static void main(String[] args) {
		Queue<Object> q = EvictingQueue.create(2);
		q.add("1");
		q.add("2");
		q.add("3");
		q.forEach(e -> System.out.println(e));
	}

}
