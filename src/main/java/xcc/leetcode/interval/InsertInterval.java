package xcc.leetcode.interval;

import java.util.ArrayList;

/**
 *
 * Given a set of non-overlapping intervals,
 * insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 *
 *  Example 1:
 *      Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 *  Example 2:
 *      Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 *      This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 * Created with IntelliJ IDEA.
 * User: lightsaber
 * Date: 3/25/14
 * Time: 11:07 PM
 */
public class InsertInterval
{
    //Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if(newInterval == null)
        {
            return intervals;
        }

        boolean newIntervalPlaced = false;
        Interval currInterval = newInterval;

        ArrayList<Interval> result = new ArrayList<Interval>();

        for(Interval i : intervals)
        {
            // if newInterval > current i or if the newInterval has been placed
            if(i.end < currInterval.start || newIntervalPlaced)
            {
                result.add(i);
            }
            // if newInterval < current i
            else if(i.start > currInterval.end)
            {
                result.add(currInterval);
                newIntervalPlaced = true;
                result.add(i);
            }
            // the two interval intersect, merge
            else
            {
                currInterval = new Interval(
                        Math.min(i.start, currInterval.start), Math.max(i.end, currInterval.end));
            }
        }

        // if the new interval has not been placed, place it
        if(!newIntervalPlaced) result.add(currInterval);

        return result;
    }
}
