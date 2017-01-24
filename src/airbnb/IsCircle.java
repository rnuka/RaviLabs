package airbnb;

/**
 * Created by rnuka on 5/27/16.
 */
public class IsCircle {
    /*
 * Complete the function below.
 */
    /*Assumption: G-> Go Forward R-> Right turn L->Left Turn*/
    static String doesCircleExist(String commands) {

        //set origin
        int x = 0;
        int y = 0;

        //move based on commands, read the string and split the characters and navigate as per commands to see if circle
        char[] charArray = commands.toCharArray();



        //We need direction variable to change the x-axis and y-axis accordingly
        //assume direction 0=east, 1=west 2=north 3=south and -1 is origin
        int direction = -1;


        //based on commands if you give same commands 4 times we should be in same point if we go in circle so that we cover all 4 quadrants of graph and comeback to original
        for(int i=0; i<4;i++){
            for(int j=0;j<charArray.length;j++){
                switch(charArray[j]){
                    case 'G': {
                        switch(direction){
                            case -1: {y++; direction = 2;break;}
                            case 0: { x++; direction = 0; break;}
                            case 1: {x--; direction = 1;break;}
                            case 2: {y++; direction = 2; break;}
                            case 3: {y--; direction = 3; break;}
                        }
                    }
                    case 'R': {
                        switch(direction){
                            case -1: {
                                //change direction to east
                                direction = 0;
                                x++;
                                break;
                            }

                            case 0: {
                                //change direction to south
                                direction = 3;
                                y--;
                                break;
                            }
                            case 1: {
                                //change direction to north
                                direction = 2;
                                y++;
                                break;
                            }
                            case 2: {
                                //change direction to east
                                direction = 0;
                                x++;
                                break;
                            }
                            case 3: {
                                //change direction to west
                                direction = 1;
                                x--;
                                break;
                            }
                        }
                    }
                    case 'L': {
                        switch(direction){
                            case -1: {
                                //change direction to west
                                direction = 1;
                                x--;
                                break;
                            }

                            case 0: {
                                //change direction to north
                                direction = 2;
                                y++;
                                break;
                            }
                            case 1: {
                                //change direction to south
                                direction = 3;
                                y--;
                                break;
                            }
                            case 2: {
                                //change direction to west
                                direction = 1;
                                x--;
                            }
                            case 3: {
                                //change direction to east
                                direction = 0;
                                x++;
                                break;
                            }
                        }
                    }
                }
            }
        }//end outer for loop

        if(x==0 && y==0){
            return "YES";
        }else{
            return "NO";
        }

    }

    public static void main(String args[]){
        IsCircle ic = new IsCircle();
        System.out.println("return:" + doesCircleExist("L"));
    }


}
