package Tas1AndTask2;

public class Task1 {

    public static String Uint32toIPv4(long ipAddress) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3; i > -1; i -- ) {
            sb.append((ipAddress >> i * 8) & 0xFF).append(".");
        }
        return sb.replace(sb.length()-1, sb.length(), "").toString();
    }

    public static long IPv4toUint32(String ipV4) {
        String[] octets = ipV4.split("\\.");
        long resVal = 0L;
        for (int i = 3; i > -1; i -- ) {
            resVal += Long.parseLong(octets[i]) * Math.round(Math.pow(2, 8 * (3-i)));
        }
        return resVal;
    }

    public static void main(String[] args) {
        System.out.println(Uint32toIPv4(2149583361L));
        System.out.println(IPv4toUint32("128.32.10.1"));
    }
}