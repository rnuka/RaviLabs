package practice.coding.threads;

public class C{

    public static void main(String args[]){



        String[] cmd = {
                "/bin/sh",
                "-c",
                "export PATH=/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin:/usr/X11/bi"
        };

        String[] cmd2 = {
                "/bin/sh",
                "-c",
                "ls"
        };

        try {
            Process p = Runtime.getRuntime().exec(cmd);
            Process p2 = Runtime.getRuntime().exec(cmd2);
        }catch(Exception e){
            e.printStackTrace();
        }

        //new B().start();

    }

}


