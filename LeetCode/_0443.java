class _0443 {
    public int compress(char[] chars) {
        int n = chars.length, read = 0, write = 0;
        if(n == 1) return 1;

        while(read < n) {
            char curr = chars[read];
            int len = 0;

            while(read < n && curr == chars[read]) {
                read++;
                len++;
            }

            chars[write++] = curr;
            if(len > 1)
                for(char d : Integer.toString(len).toCharArray())
                    chars[write++] = d;
        }

        return write;
    }
}