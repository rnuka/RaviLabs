package practice.coding.others;

/*
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left
in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note: The read function will only be called once for each test case.
 */

/*
Key points to observe:
----------------------
1. the file you are reading may have more than n characters but you still need to stop after reading n chars
2. read4 will read 1 or 2 or 3 or 4 characters in the last read, so after n characters are done, you shouldn't make further
 read4 calls (should treat last run as eof.
 */
public class ReadNCharsUsingRead4 {
    public static class Reader4{
        public static int read4(char[] buf){
            //TODO: Implement read4
            return 4;
        }
    }
    public int read(char[] buf, int n){
        char[] buf4 = new char[4];
        int readCount = 0;
        boolean eof = false;
        while(!eof && readCount<n){
            int buf4Count = Reader4.read4(buf4);
            if(buf4Count < 4){
                eof = true;
            }
            if(buf4Count+readCount>n){
                buf4Count = n-readCount;
            }
            System.arraycopy(buf4,0,buf,readCount,buf4Count);
        }
        return readCount;
    }
}
