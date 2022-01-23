package com.taniltekdemir.n11.bootcampgraduationproject.common.helper;

public class TcknUtils {

    public static boolean isValidTckn(String tckn) {
        if (tckn.length() != 11)
            return false;
        else
            return isValidTckn(tckn.toCharArray(), 0);
    }

    public static boolean isValidTckn(char[] buffer, int start) {

        if (start + 10 >= buffer.length)
            return false;

        int sum0 = 0;
        {
            int a = buffer[start + 0] - '0';
            if (a < 0 || a > 9)
                return false;
            sum0 += a;
        }
        if (sum0 == 0)
            return false;
        {
            int a = buffer[start + 2] - '0';
            if (a < 0 || a > 9)
                return false;
            sum0 += a;
        }
        {
            int a = buffer[start + 4] - '0';
            if (a < 0 || a > 9)
                return false;
            sum0 += a;
        }
        {
            int a = buffer[start + 6] - '0';
            if (a < 0 || a > 9)
                return false;
            sum0 += a;
        }
        {
            int a = buffer[start + 8] - '0';
            if (a < 0 || a > 9)
                return false;
            sum0 += a;
        }
        int sum1 = 0;
        {
            int a = buffer[start + 1] - '0';
            if (a < 0 || a > 9)
                return false;
            sum1 += a;
        }
        {
            int a = buffer[start + 3] - '0';
            if (a < 0 || a > 9)
                return false;
            sum1 += a;
        }
        {
            int a = buffer[start + 5] - '0';
            if (a < 0 || a > 9)
                return false;
            sum1 += a;
        }
        {
            int a = buffer[start + 7] - '0';
            if (a < 0 || a > 9)
                return false;
            sum1 += a;
        }
        if (buffer[start + 9] - '0' != (7 * sum0 - sum1 + 40) % 10)
            return false;

        if (buffer[start + 10] - '0' != (sum0 + sum1 + (buffer[start + 9] - '0')) % 10)
            return false;

        return true;
    }
}
