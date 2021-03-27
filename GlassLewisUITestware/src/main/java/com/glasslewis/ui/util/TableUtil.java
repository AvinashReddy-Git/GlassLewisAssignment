package com.glasslewis.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableUtil {

    public static List<Map<String, String>> getGridTableContent(final WebElement gridTable) throws InterruptedException {

        Thread.sleep(2000);

        //To locate rows of table.
        List<WebElement> rows_table = gridTable.findElements(By.tagName("tr"));

        //To calculate no of rows In table.
        int rows_count = rows_table.size();

        List<String> headers = getGridTableHeader(gridTable);
        //Loop will execute for all the rows of the table

       List<Map<String,String>> content=new ArrayList<>();
        for (int row = 0; row < rows_count; row++) {
            Map<String,String> rowContent=new HashMap<>();

            //To locate columns(cells) of that specific row.
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

            //To calculate no of columns(cells) In that specific row.
            int columns_count = Columns_row.size();


            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                //To retrieve text from the cells.
                String celltext = Columns_row.get(column).getText();
                rowContent.put(headers.get(column),celltext);

            }
            content.add(rowContent);
        }

        return content;

    }

    public static List<String> getGridTableHeader(final WebElement gridTable) throws InterruptedException {

        List<String> list = new ArrayList<String>();

        Thread.sleep(2000);

        List<WebElement> rows_table = gridTable.findElements(By.tagName("tr"));

        int rows_count = rows_table.size();

        for (int row = 0; row < rows_count; row++) {

            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("th"));

            int columns_count = Columns_row.size();

            for (int column = 0; column < columns_count; column++) {

                String celltext = Columns_row.get(column).getText();
                list.add(celltext);
            }
        }

        return list;

    }

}

