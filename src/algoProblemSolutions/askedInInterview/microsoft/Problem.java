package algoProblemSolutions.askedInInterview.microsoft;

import java.util.*;
import java.text.SimpleDateFormat;

class CalendarEvent {
    private Date start, end;

    public CalendarEvent(Date start, Date end)
    {
        this.start = start;
        this.end = end;
    }

    public Date getStart()
    {
        return this.start;
    }

    public Date getEnd()
    {
        return this.end;
    }
}

public class Problem
{
    public static int CalculateTotalTimeInMeetings(Collection<CalendarEvent> events)
    {
        if (events == null || events.size() == 0) {
            return 0;
        }
        List<CalendarEvent> mergedList = mergeOverlap(new ArrayList(events));

        int duration = 0;

        for (CalendarEvent ce: mergedList) {
            long millis = ce.getEnd().getTime() - ce.getStart().getTime();
            int min = (int)((millis / 1000) / 60);
            duration += min;
        }

        return duration;
    }

    public static void main(String[] args) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
        ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();

        events.add(new CalendarEvent(sdf.parse("2018-01-01 20:00"),sdf.parse("2018-01-01 21:30")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01 20:10"),sdf.parse("2018-01-01 21:40")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01 21:40"),sdf.parse("2018-01-01 22:00")));

        System.out.println("Total time in meetings = " + Problem.CalculateTotalTimeInMeetings(events));
        System.out.println("The correct answer is 120");
    }

    public static List<CalendarEvent> mergeOverlap(List<CalendarEvent> input){
        // create a list of intervals to store the result
        List<CalendarEvent> res = new ArrayList<>();
        // Sort the input intervals with respect to start times by overriding the compare method in comparator
        Collections.sort(input, new Comparator<CalendarEvent>() {
            @Override
            public int compare(CalendarEvent o1, CalendarEvent o2) {
                if(o1.getStart().after(o2.getStart())){
                    return 1;
                }
                else if(o1.getStart().before(o2.getStart())){
                    return -1;
                }
                return 0;
            }
        });
        // loop through each event in the sorted list of intervals
        for(CalendarEvent ce : input){
            // keep a counter of the intervals added to the result list, initialize 0 for first interval to be added
            int ctr = 0;
            // if the list is empty, add the first element
            if(res.isEmpty()){
                res.add(ce);
            }
            // for all the other event
            else{
                // check if the start time of the next interval is smaller or equal to end time of interval in res
                if(ce.getStart().getTime() <= res.get(ctr).getEnd().getTime()){
                    // create new event with start time of the existing interval and end time of max of the 2 merging intervals
                    Date newEndDate;
                    if (res.get(ctr).getEnd().after(ce.getEnd())) {
                        newEndDate = res.get(ctr).getEnd();
                    } else {
                        newEndDate = ce.getEnd();
                    }
                    CalendarEvent n = new CalendarEvent(res.get(ctr).getStart(), newEndDate);
                    // remove the previous interval and add the new merged interval
                    res.remove(ctr);
                    res.add(n);
                }
                // if no overlap is found then just add the interval and increase the counter
                else{
                    res.add(ce);
                    ctr++;
                }
            }
        }
        return res;
    }

}