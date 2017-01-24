package pinterest;

import java.util.*;

/**
 * Created by rnuka on 12/1/16.
 */
/*Question from glassdoor:
Find the count of downstream users for any given user in a directed graph.
 */
public class DownStreamUserCount {
    //User class
    public static class User{
        String name;
        int childCount;
        boolean visited;
        public User(String name){
            this.name = name;
        }

        @Override
        public boolean equals(Object o){
          User that = (User)o;
          return this.name.equalsIgnoreCase(that.name);
        }

        @Override
        public int hashCode(){
            return 32*name.hashCode()+2913;
        }
    }

    //User graph
    public static class UserGraph{
        Map<User, List<User>> users = new HashMap<User,List<User>>();
        Map<User, Integer> userCounts = new HashMap<User,Integer>();

        public void addUser(User u){
            if(!users.containsKey(u)){
                List<User> edges = new ArrayList<User>();
                users.put(u,edges);
                userCounts.put(u,0);
            }
        }

        public void addEdge(User first, User second){
            int counter=0;
            addUser(first);
            if(!users.containsKey(second)){
                addUser(second);
                userCounts.put(second,userCounts.get(first));
            }else{
                int before = userCounts.get(second);
                //userCounts.put(second, (userCounts.get(second)+userCounts.get(first)));
                int after = userCounts.get(second)+userCounts.get(first);
                counter = after-before+1;
            }
            List edges = users.get(first);
            edges.add(second);
            users.put(first, edges);



            increaseParentCounts(second,(counter==0?1:counter));
        }

        //update all downstream counts
        private void increaseParentCounts(User u, int counter){
            System.out.println("increasing parents::"+u.name+" counter="+counter);
            //step-1: reset visited status
            resetVisitedStatus(u);

            //step-2: bfs to udpate counts
            Queue<User> queue = new LinkedList<User>();
            queue.add(u);
            while(!queue.isEmpty()){

                User curr = queue.poll();
                System.out.println("before increase::"+curr.name+" count="+userCounts.get(curr));
                curr.childCount=userCounts.get(curr)+counter;
                userCounts.put(curr, curr.childCount);

                for(User edgeUser: users.get(curr)){
                   // if(!edgeUser.visited) {
                        queue.add(edgeUser);
                        userCounts.put(edgeUser,userCounts.get(curr));
                   // }
                }
                //curr.visited=true;


            }
        }

        //update all downstream nodes visited to false
        private void resetVisitedStatus(User u){
            //TODO : update visited status of all users  under u to false
        }
    }

    public UserGraph constructGraph(String[][] edges){
        UserGraph graph = new UserGraph();
        for(String s[]: edges){
            User first = new User(s[0]);
            User second = new User(s[1]);
            graph.addEdge(first,second);
        }
        return graph;
    }

    public static void main(String[] args){
        DownStreamUserCount d = new DownStreamUserCount();
        String[] temp1 = {"a","b"};
        String[] temp2 = {"a","c"};
        String[] temp3 = {"b","d"};
        String[] temp4 = {"d","e"};
        String[] temp5 = {"x","y"};
        String[] temp6 = {"y","d"};

        String[][] input = new String[6][2];
        input[0]=temp1;
        input[1]=temp2;
        input[2]=temp3;
        input[3]=temp4;
        input[4]=temp5;
        input[5]=temp6;
        UserGraph ug = d.constructGraph(input);
        for(Map.Entry<User,Integer> curr: ug.userCounts.entrySet()){
            System.out.println("curr user:"+curr.getKey().name+" and downstream user count::"+curr.getValue());
        }

    }
}
