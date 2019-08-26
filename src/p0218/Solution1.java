package p0218;

import javax.lang.model.element.ElementVisitor;
import java.util.*;

//Runtime: 136 ms  beats 40.49 % of java submissions.
public class Solution1 {

    class Event {
        int x;
        int height;
        int type;

        Event(int x, int height, int type) {
            this.x = x;
            this.height = height;
            this.type = type;
        }
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {

        final int ENTERING = -1;
        final int LEAVING = 1;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Event> events = new ArrayList();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < buildings.length; i++) {

            Event eventE = new Event(buildings[i][0], buildings[i][2], ENTERING);
            Event eventL = new Event(buildings[i][1], buildings[i][2], LEAVING);
            events.add(eventE);
            events.add(eventL);
        }
        events.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Event event1 = (Event) o1;
                Event event2 = (Event) o2;
                if(event1.x==event2.x) {

                    return event1.type*event1.height - event2.type*event2.height;
                }
                return event1.x-event2.x;
            }
        });

        for (Event event:events) {

            if(event.type==ENTERING) {

                if(queue.size()==0 || event.height>queue.peek()) {

                    List<Integer> point  = new ArrayList<>();
                    point.add(event.x);
                    point.add(event.height);
                    result.add(point);
                }
                queue.add(event.height);
            }

            if(event.type==LEAVING) {
                queue.remove(event.height);
                if(queue.size()==0 || event.height>queue.peek()) {

                    List<Integer> point = new ArrayList<>();
                    point.add(event.x);
                    if(queue.size()==0)
                        point.add(0);
                    else
                        point.add(queue.peek());
                    result.add(point);
                }
            }
        }
        return result;
    }

}
