package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.SmartphoneList;

public class SmartphoneListValidator {

    public static List<String> validate(SmartphoneList sl) {
        List<String> errors = new ArrayList<String>();

        String manufacturing_company_error = validateManufacturing_company(sl.getManufacturing_company());
        if(!manufacturing_company_error.equals("")) {
            errors.add(manufacturing_company_error);
        }

        String product_name_error = validateProduct_name(sl.getProduct_name());
        if(!product_name_error.equals("")) {
            errors.add(product_name_error);
        }

        String release_date_error = validateRelease_date(sl.getRelease_date());
        if(!release_date_error.equals("")) {
            errors.add(release_date_error);
        }

        String stock_error = validateStock(sl.getStock());
        if(!stock_error.equals("")) {
            errors.add(stock_error);
        }

        return errors;

    }

    private static String validateManufacturing_company(String manufacturing_company) {
        if(manufacturing_company == null || manufacturing_company.equals("")) {
            return "メーカーを入力してください。";
        }

        return "";
    }

    private static String validateProduct_name(String product_name) {
        if(product_name == null || product_name.equals("")) {
            return "製品名を入力してください。";
        }

        return "";
    }

    private static String validateRelease_date(String release_date) {
        if(release_date == null || release_date.equals("")) {
            return "発売日を入力してください。";
        }

        return "";
    }

    private static String validateStock(String stock) {
        if(stock == null || stock.equals("")) {
            return "在庫を入力してください。";
        }

        return "";
    }

}
