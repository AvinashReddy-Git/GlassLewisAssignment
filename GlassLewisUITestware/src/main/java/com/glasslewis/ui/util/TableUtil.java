package com.glasslewis.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TableUtil {

    public static List<Map<String, String>> getGridTableContent(final WebElement gridTable) {

        List<String> headers = getGridTableHeader(gridTable);
        List<WebElement> rows_table = gridTable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        List<Map<String, String>> content = new ArrayList<>();
        for (int row = 0; row < rows_count; row++) {
            Map<String, String> rowContent = new HashMap<>();

            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

            int columns_count = Columns_row.size();

            for (int column = 0; column < columns_count; column++) {

                String celltext = Columns_row.get(column).getText();
                rowContent.put(headers.get(column), celltext);

            }
            if (rowContent.size() > 1) {
                content.add(rowContent);
            }
        }

        return content;

    }

    public static List<String> getGridTableHeader(final WebElement gridTable) {

        List<String> list = new ArrayList<String>();

        List<WebElement> rows_table = gridTable.findElements(By.tagName("tr"));

        int rows_count = rows_table.size();

        List<WebElement> Columns_row = rows_table.get(0).findElements(By.tagName("th"));

        int columns_count = Columns_row.size();

        for (int column = 0; column < columns_count; column++) {

            String celltext = Columns_row.get(column).getText();
            list.add(celltext);
        }

        return list;

    }

}