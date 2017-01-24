package practice.coding.others;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by rnuka on 10/31/15.
 */
public class MatrixReport {

    public static class Data {
        String country;
        int employeeCount;
        BigDecimal salary;
        String type;

    }

    /*
    input: List of Data Objects
    output: 2 dimension matrix form of data representation

     */
    String[][] matrixRepresentation(List<Data> input, int rowCount, int columnCount){
        String[][] output = new String[rowCount][columnCount];

        //create set of countries
        Set<String> countries = new HashSet<String>();

        //Create set of row label names
        Set<String> labelName = new HashSet<String>();

        //Create set of type label names
        Set<String> types = new HashSet<String>();

        //populate label sets
        for(Data row: input){
            countries.add(row.country);
            if(row.employeeCount > 0){
                labelName.add("Employees");
            }
            if(row.salary != null){
                labelName.add("Salary");
            }
            if(row.type != null){
                types.add(row.type);
            }
        }


        //create header
        output[0][0]="Type";
        output[0][1]="Name";
        int col=2;
        for(String country: countries){
            output[0][col++]=country;
        }
        output[0][col]="Total";

        System.out.println("types size="+types.size());

        //create first and second columns
        int k=1;
        for(String type: types){
            for(String label: labelName){
                output[k][0] = type;
                output[k][1] = label;
                k++;
            }
        }

        //add total rows
        for(String label: labelName) {
            output[k++][0] = "total";
        }


        //create remaining data cells
        for(Data row: input){
            for(int i=0;i<columnCount;i++){
                //find which column
                if(row.country==output[0][i]){
                     for(int j=1;j<rowCount;j++){
                         if(output[j][0]==row.type && output[j][1]=="Employees"){
                             output[j][i] = ""+row.employeeCount;
                         }
                         if(output[j][0]==row.type && output[j][1]=="Salary"){
                             output[j][i] = ""+row.salary.setScale(2,BigDecimal.ROUND_HALF_UP);
                         }
                     }
                }
            }
        }


        return output;
    }



    //test
    public static void main(String[] args){
        Data row1 = new Data();
        row1.country="USA";
        row1.employeeCount=2000;
        row1.salary= new BigDecimal(31500.75);
        row1.type="ONSITE";

        Data row2 = new Data();
        row2.country="USA";
        row2.employeeCount=1500;
        row2.salary= new BigDecimal(15000.29);
        row2.type="OFFSITE";

        Data row3 = new Data();
        row3.country="CAN";
        row3.employeeCount=700;
        row3.salary= new BigDecimal(21500);
        row3.type="ONSITE";

        Data row4 = new Data();
        row4.country="CAN";
        row4.employeeCount=500;
        row4.salary= new BigDecimal(15000.29);
        row4.type="OFFSITE";

        List<Data> input = new ArrayList<>();
        input.add(row1);
        input.add(row2);
        input.add(row3);
        input.add(row4);

        System.out.println("input::");
        for(Data row: input){
            System.out.print(row.type+"  "+row.country+"  "+row.employeeCount+"  "+row.salary.setScale(2,BigDecimal.ROUND_HALF_UP));
            System.out.println();
        }

        MatrixReport mr = new MatrixReport();

        String[][] output = mr.matrixRepresentation(input,7,5);

        //print
        for(int i=0; i<output.length;i++){
            for(int j=0; j<output[0].length; j++){
                System.out.print(" "+output[i][j]);
            }
            System.out.println();
        }

    }


}
