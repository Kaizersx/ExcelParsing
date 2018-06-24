package org.homework;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Parser {

    public static void main(String[] args) throws IOException {


        FileInputStream fls=  new FileInputStream("testfile.xls");

        Workbook wb= new HSSFWorkbook(fls);

        String result[]= new String[100];

        ArrayList<String>res= new ArrayList<>();



         Users users = null;

        Map <String,String>usr= new HashMap<>();
        Map <String,Integer>usrValue= new HashMap<>();

        int count1=1;
        int count2=1;

        int BarchVal=0;
        int PupkinVal=0;

        for (Row row: wb.getSheetAt(0)){


            String results1=row.getCell(0).toString();

            Cell cell;
            cell=row.getCell(1);

            double results2 = cell.getNumericCellValue();


            if (results1.equals("Александр Барчук")){

                BarchVal+=(int) results2;

                usr.put(results1,String.valueOf(count1));
                usrValue.put(results1,BarchVal);

                count1++;
            }

            else if (results1.equals("Виктор Пупкин")){

                PupkinVal+=results2;

                usr.put(results1,String.valueOf(count2));
                usrValue.put(results1,PupkinVal);

                count2++;
            }

        }


Iterator dataZ=usr.entrySet().iterator();
Iterator dataE=usrValue.entrySet().iterator();

Map.Entry zayavki= usr.entrySet().iterator().next();
Map.Entry edinici= usrValue.entrySet().iterator().next();


      //  System.out.println(zayavki.getKey() +" "+ "\nколичество заявок: "+zayavki.getValue()+"\nколичество единиц: "+ edinici.getValue());

        while(dataZ.hasNext()){

            System.out.println(dataZ.next());

        }

        while (dataE.hasNext()){

            System.out.println(dataE.next());
        }

    }


    public  static String  getCellText(Cell cell){

    String result="";

    switch (cell.getCellType()){

        case Cell.CELL_TYPE_STRING: result=cell.getRichStringCellValue().toString();

        break;

        case Cell.CELL_TYPE_NUMERIC: result= Double.toString(cell.getNumericCellValue());

        break;
        default: break;

    }

        return result;
    }


}
