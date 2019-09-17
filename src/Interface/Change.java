package Interface;

public class Change {
    //
//    @Override
//    public String process(Object input) {
//        String[] tmp = ((String)input).split("");
//        for (int i = 0; i < tmp.length; i+=2) {
//            String t = tmp[i];
//            tmp[i] = tmp[i+1];
//            tmp[i+1] = t;
//        }
//        StringBuffer a = new StringBuffer();
//        for (String i:tmp) {
//            a.append(i);
//        }
//        return a.toString();
//    }
    public String process(String s) {
        char[] ca = new char[s.length()];
        if ((s.length()) % 2 == 0) {
            for (int i = 0; i < s.length(); i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            return new String(ca);
        } else {
            for (int i = 0; i < s.length() - 1; i += 2) {
                ca[i] = s.charAt(i + 1);
                ca[i + 1] = s.charAt(i);
            }
            ca[s.length() - 1] = s.charAt(s.length() - 1);
            return new String(ca);
        }
    }
}
