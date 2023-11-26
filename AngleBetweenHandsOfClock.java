/*
  Leetcode: https://leetcode.com/problems/angle-between-hands-of-a-clock/description/
*/

class Solution {
    public double angleClock(int hour, int minutes) {
        int min_angle = 6;
        int hour_angle = 30;

        // 12 considered 0 degrees ...
        double hoursAngle = (hour % 12 + minutes/60.0) * hour_angle;
        double minuteAngle = minutes * min_angle;

        double diff = Math.abs(hoursAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}
