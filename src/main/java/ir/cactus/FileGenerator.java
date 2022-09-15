package ir.cactus;


import ir.cactus.model.Accounts;
import ir.cactus.model.Customers;
import ir.cactus.utils.AccountType;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public  class  FileGenerator {




    private static ArrayList<Customers>customers;
    private static ArrayList<Accounts>accounts;
    private  static Logger logger=Logger.getLogger(FileGenerator.class);

    private static final String CUSTOMER_FILE_NAME="Customer.csv";
    private static final String ACCOUNTS_FILE_NAME="Accounts.csv";

    public static void main(String[] args) throws ParseException {
        System.out.println("we are now generate your customer :::::::::::::");
        Generate_Customer();
        System.out.println("customer generation is done !!!");
        System.out.println("system is now adding the accounts for you ::::::::::::::");
        Generate_Account();
        System.out.println("account generation is done !!!!!");


    }

    private static void Generate_Customer(){
        try(FileWriter fileWriter=new FileWriter(CUSTOMER_FILE_NAME);
         CSVPrinter Customer_Printer=new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader("Record_Number",
                 "Customer_Id","Customer_Name","Customer_SurName","Customer_Address","Customer_Zip_Code","Customer_National_Id"
                 ,"Customer_Birth_Date"));
        ){

            customers=FileGenerator.Generate_Customer_List();
            for (int i=0;i<customers.size();i++){
                Customer_Printer.printRecord(
                        customers.get(i).getRecord_Number(),
                        customers.get(i).getCustomer_Id(),
                        customers.get(i).getCustomer_Name(),
                        customers.get(i).getCustomer_Surname(),
                        customers.get(i).getCustomer_Address(),
                        customers.get(i).getCustomer_Zip_Code(),
                        customers.get(i).getCustomer_National_ID(),
                        customers.get(i).getCustomer_Birth_Date()

                );
            }




        }catch (IOException e){
            logger.error(e);
        }




    }


    private static void Generate_Account(){
        try(FileWriter fileWriter=new FileWriter(ACCOUNTS_FILE_NAME);
        CSVPrinter Account_Printer=new CSVPrinter(fileWriter,CSVFormat.DEFAULT.withHeader(
           "Record_Number","Account_Number","Account_Type","Account_Customer_Id","Account_Limit","Account_Open_Date","Account_Balance"
        ));
        ){
             accounts=FileGenerator.Generate_Accounts_List();
            for (int i=0;i<accounts.size();i++){
                Account_Printer.printRecord(
                        accounts.get(i).getRecord_Number(),
                        accounts.get(i).getAccount_Number(),
                        accounts.get(i).getAccountType(),
                        accounts.get(i).getAccount_Customer_id(),
                        accounts.get(i).getAccount_Limit(),
                        accounts.get(i).getAccount_Open_Date(),
                        accounts.get(i).getAccount_Balance()
                        );
            }

        }catch (IOException e){
            logger.error(e);
        }
    }
    /**
     *
     *this method is using to set the unique customer information
     * we have no choice to put the data one by one without loop
     * because the data is unique we can't put 1000 customer with our own
     * so in this case we must
     */
    private static  ArrayList<Customers> Generate_Customer_List(){

        ArrayList<Customers> Customer_List=new ArrayList<>();
        Customer_List.add(new Customers(1,1,"amirhossein","fardi","tehran",1495686595,"0235343680","1998-07-12"));
        Customer_List.add(new Customers(2,2,"amir","fardi","tehran-torabi",1495586595,"0235663680","1999-07-14"));
        Customer_List.add(new Customers(3,3,"hossein","fardi","tehran-hosseine",1495686985,"0335343680","1956-07-12"));
        Customer_List.add(new Customers(4,4,"amirreza","akbari","tehran-navobat",1495686595,"0235334480","1996-09-12"));
        Customer_List.add(new Customers(5,5,"mersad","raadi","tehran-chitgar",1495686595,"0235563680","1968-03-14"));
        Customer_List.add(new Customers(6,6,"farzin","hojabri","tehran-shariati",1495686595,"0235883680","1978-05-15"));
        Customer_List.add(new Customers(7,7,"hossein","mafi","tehran-golhak",149566595,"0235398680","1958-10-16"));
        Customer_List.add(new Customers(8,8,"mehri","rahmti","tehran-azadi",1495686595,"0235334680","1955-12-14"));
        Customer_List.add(new Customers(9,9,"farank","gafari","tehran-damavand",945886595,"2035356680","1944-03-22"));
        Customer_List.add(new Customers(10,10,"yashar","fardi","tabriz",1495646595,"0233443680","2001-12-12"));
        Customer_List.add(new Customers(11,11,"iman","hojabri","mashhad",1499696595,"2340235680","2002-12-13"));
        Customer_List.add(new Customers(12,12,"yaser","akbari","tehran-khorasan",1495686595,"133403680","2003-06-22"));
        Customer_List.add(new Customers(13,13,"nser","fardi","tehran-jamaran",1686455595,"4150343680","1954-03-23"));
        Customer_List.add(new Customers(14,14,"akbar","fardi","tehran-niavaran",1455686595,"2055343680","1945-01-24"));
        Customer_List.add(new Customers(15,15,"reza","akbari","tehran-sabalan",1953586595,"2653436800","1946-02-30"));
        Customer_List.add(new Customers(16,16,"liela","akbari","ahvaz",1495682395,"2705343680","1947-03-31"));
        Customer_List.add(new Customers(17,17,"akbar","gafari","shiraz",1495634595,"2853043680","1948-04-22"));
        Customer_List.add(new Customers(18,18,"amirhossein","gafari","esfehan",1495457595,"2950343680","1949-05-24"));
        Customer_List.add(new Customers(19,19,"akbar","hojabri","bojnord",1495684695,"2305344680","1950-06-19"));
        Customer_List.add(new Customers(20,20,"farzin","fardi","birjand",1495688995,"235343667","1951-07-24"));
        Customer_List.add(new Customers(21,21,"amirhossein","hojabri","shistan",1495235695,"2350343675","1952-08-22"));
        Customer_List.add(new Customers(22,22,"akbar","fardi","oromie",1495623555,"2305343694","1953-09-26"));
        Customer_List.add(new Customers(23,23,"amirhossein","fardi","razie",1495686546,"2305343696","1954-10-01"));
        Customer_List.add(new Customers(24,24,"amirhossein","fardi","tehran-tehranparse",1455686595,"2305343688","1955-11-02"));
        Customer_List.add(new Customers(25,25,"akbar","fardi","tehran-jamshide",1491386595,"2305343623","1955-12-03"));
        Customer_List.add(new Customers(26,26,"farzin","hojabri","tehran-bhonar",1495623595,"2353043656","1956-09-12"));
        Customer_List.add(new Customers(27,27,"amirreza","rahmti","tehran-valiasr",1495466595,"2305343666","2015-09-14"));
        Customer_List.add(new Customers(28,28,"amirhossein","akbari","tehran-kargar",1495626595,"2506343680","2012-08-16"));
        Customer_List.add(new Customers(29,29,"akbar","hojabri","tehran-jomhorie",1494666595,"7753430680","2013-07-17"));
        Customer_List.add(new Customers(30,30,"amirhossein","fardi","tehran-koynasr",1495266595,"0885343640","2009-07-18"));
        Customer_List.add(new Customers(31,31,"farzin","hojabri","tehran-dolatabad",1423686595,"2904053480","2009-07-19"));
        Customer_List.add(new Customers(32,32,"amirhossein","gafari","tehran-shian",1495682395,"2305343450","2009-07-20"));
        Customer_List.add(new Customers(33,33,"farank","akbari","tehran-esteglal",1495686595,"2305347680","2007-07-21"));
        Customer_List.add(new Customers(34,34,"amirhossein","fardi","tehran-sadr",1495682395,"2302443620","2007-07-22"));
        Customer_List.add(new Customers(35,35,"akbar","fardi","tehran-tajrish",1495634595,"2205343400","2006-07-22"));
        Customer_List.add(new Customers(36,36,"amirreza","akbari","tehran-farmanie",1495456595,"6605343680","2009-07-23"));
        Customer_List.add(new Customers(37,37,"amirhossein","fardi","tehran-ponak",1424686595,"2304566680","2004-07-24"));
        Customer_List.add(new Customers(38,38,"farank","raadi","tehran-sohanak",1395686595,"2463043686","2021-07-25"));
        Customer_List.add(new Customers(39,39,"farank","fardi","tehran-afsarie",1494686595,"2360366680","2020-07-26"));
        Customer_List.add(new Customers(40,40,"amirhossein","raadi","tehran-narmak",1495456595,"5345034680","2018-07-12"));
        Customer_List.add(new Customers(41,41,"akbar","gafari","tehran-tajrish",1495454225,"5605743680","2015-07-27"));
        Customer_List.add(new Customers(42,42,"amirhossein","fardi","tehran-tajrish",1495686425,"5753083680","2014-07-28"));
        Customer_List.add(new Customers(43,43,"farank","hojabri","tehran-tajrish",1495684495,"5530663680","2013-07-29"));
        Customer_List.add(new Customers(44,44,"amirhossein","hojabri","tehran-tajrish",1495686395,"6780343680","1990-07-30"));
        Customer_List.add(new Customers(45,45,"farzin","gafari","tehran-tajrish",1495687895,"5340363680","1996-07-10"));
        Customer_List.add(new Customers(46,46,"amirreza","rahmti","tehran-esteglal",1495666595,"4432303680","1995-07-11"));
        Customer_List.add(new Customers(47,47,"amirhossein","rahmti","tehran-esteglal",1495622595,"3603343680","1994-07-13"));
        Customer_List.add(new Customers(48,48,"akbar","gafari","tehran-esteglal",1495356595,"6630743680","1993-07-07"));
        Customer_List.add(new Customers(49,49,"amirhossein","fardi","tehran-esteglal",155686595,"8802343680","1992-07-08"));
        Customer_List.add(new Customers(50,50,"akbar","hojabri","tehran-esteglal",1395686595,"8753043680","1991-07-09"));

        return Customer_List;
    }

    /**
     * this is for generate the Bank Account
     */
    private static ArrayList<Accounts> Generate_Accounts_List(){
         ArrayList<Accounts>accounts =new ArrayList<>();
        accounts.add(new Accounts(1,"6221064963631412", AccountType.Saving,1,1000000,"2003-05-12",1000000));
        accounts.add(new Accounts(2,"6219861905200982", AccountType.FixedDepositAccount,1,2450000,"1998-07-11",145500));
        accounts.add(new Accounts(3,"5845831157005611", AccountType.RecurringDeposit,1,145500,"2010-07-11",2450000));
        accounts.add(new Accounts(4,"5022291099248718", AccountType.FixedDepositAccount,1,114500,"2012-07-11",250000));
        accounts.add(new Accounts(5,"6221061056941711", AccountType.Saving,1,1200000,"2013-07-11",1200000));
        accounts.add(new Accounts(6,"6104337330589963", AccountType.RecurringDeposit,2,114500,"2014-07-11",100400));
        accounts.add(new Accounts(7,"6221061211857869", AccountType.FixedDepositAccount,3,1440000,"2015-07-11",114500));
        accounts.add(new Accounts(8,"6219861907680982", AccountType.Saving,3,10110400,"2016-07-11",250000));
        accounts.add(new Accounts(9,"5022291097814718", AccountType.RecurringDeposit,4,10001000,"2017-07-11",10001000));
        accounts.add(new Accounts(10,"6221064063451412", AccountType.Saving,4,10010100,"2018-07-11",250000));
        accounts.add(new Accounts(11,"6219861907790982", AccountType.FixedDepositAccount,4,56000000,"2019-07-11",56000000));
        accounts.add(new Accounts(12,"6221064063631415", AccountType.RecurringDeposit,5,56820000,"2020-07-11",250000));
        accounts.add(new Accounts(13,"6219861904300982", AccountType.Saving,6,1250000,"2021-07-11",2000000));
        accounts.add(new Accounts(14,"6221008063631412", AccountType.FixedDepositAccount,7,2000000,"2022-07-11",56820000));
        accounts.add(new Accounts(15,"62210600463631412", AccountType.Saving,8,2050000,"2001-10-10",15252000));
        accounts.add(new Accounts(16,"6219861906400982", AccountType.RecurringDeposit,8,1000000,"2001-02-02",1000000));
        accounts.add(new Accounts(17,"6221064063001412", AccountType.Saving,9,2000000,"2010-03-20",15252000));
        accounts.add(new Accounts(18,"5022291099214718", AccountType.FixedDepositAccount,9,52001000,"2010-04-20",250000));
        accounts.add(new Accounts(19,"6221064063631419", AccountType.Saving,10,650001000,"2001-05-13",650001000));
        accounts.add(new Accounts(20,"50222901099214718", AccountType.Saving,10,60521000,"2010-01-14",250000));
        accounts.add(new Accounts(21,"6219861909600982", AccountType.Saving,11,75001000,"2011-01-15",75001000));
        accounts.add(new Accounts(22,"6221064012131412", AccountType.Saving,11,78001000,"2012-01-16",15252000));
        accounts.add(new Accounts(23,"58514531157005611", AccountType.Saving,11,89001000,"2013-02-17",89001000));
        accounts.add(new Accounts(24,"6219861908500982", AccountType.FixedDepositAccount,12,78001000,"2014-02-18",250000));
        accounts.add(new Accounts(25,"5859831157005611", AccountType.Saving,13,7801000,"2015-02-19",250000));
        accounts.add(new Accounts(26,"6221064063631410", AccountType.Saving,14,79001000,"2016-02-20",250000));
        accounts.add(new Accounts(27,"5859831100405611", AccountType.FixedDepositAccount,15,78001000,"2016-10-21",250000));
        accounts.add(new Accounts(28,"6219861914500982", AccountType.Saving,16,79001000,"2017-11-22",76001000));
        accounts.add(new Accounts(29,"6221064044531412", AccountType.RecurringDeposit,17,74001000,"2018-12-23",250000));
        accounts.add(new Accounts(30,"6221064068531412", AccountType.Saving,17,76001000,"2019-12-24",79001000));
        accounts.add(new Accounts(31,"6219861905222982", AccountType.FixedDepositAccount,18,72001000,"2020-12-25",250000));
        accounts.add(new Accounts(32,"6221464064531412", AccountType.RecurringDeposit,18,66001000,"2001-07-26",250000));
        accounts.add(new Accounts(33,"6219861906300982", AccountType.Saving,19,86221000,"2001-12-27",66001000));
        accounts.add(new Accounts(34,"6221064994731412", AccountType.FixedDepositAccount,20,96551000,"2001-12-28",250000));
        accounts.add(new Accounts(35,"6219861907800982", AccountType.Saving,21,18585000,"2002-12-29",250000));
        accounts.add(new Accounts(36,"6221067864531412", AccountType.RecurringDeposit,22,1452000,"2003-12-30",66001000));
        accounts.add(new Accounts(37,"6221064067747412", AccountType.FixedDepositAccount,23,1247000,"2004-12-12",144000));
        accounts.add(new Accounts(38,"5859831158545611", AccountType.RecurringDeposit,24,11406000,"2004-11-13",15252000));
        accounts.add(new Accounts(39,"6221064069631462", AccountType.Saving,25,144000,"2005-10-11",66001000));
        accounts.add(new Accounts(40,"5859848957505611", AccountType.RecurringDeposit,26,1752000,"2010-09-01",144000));
        accounts.add(new Accounts(41,"5859834759405619", AccountType.Saving,27,1786000,"1998-08-02",250000));
        accounts.add(new Accounts(42,"5859831159605611", AccountType.FixedDepositAccount,28,1478000,"1945-08-03",144000));
        accounts.add(new Accounts(43,"6221064069531412", AccountType.Saving,28,158000,"1965-07-04",144000));
        accounts.add(new Accounts(44,"6219861905756982", AccountType.FixedDepositAccount,29,1012400,"1945-06-05",250000));
        accounts.add(new Accounts(45,"6221063461531412", AccountType.Saving,30,15252000,"1936-05-06",250000));
        accounts.add(new Accounts(46,"5859831156305611", AccountType.Saving,30,1785000,"1986-04-06",144000));
        accounts.add(new Accounts(47,"6221078064731412", AccountType.FixedDepositAccount,31,14252000,"1984-03-07",15252000));
        accounts.add(new Accounts(48,"5859831158595611", AccountType.RecurringDeposit,31,1527000,"1968-02-08",15252000));
        accounts.add(new Accounts(49,"6221012064731412", AccountType.Saving,32,11266000,"1978-02-09",15252000));
        accounts.add(new Accounts(50,"6219861908900982", AccountType.FixedDepositAccount,33,1427000,"1948-01-10",144000));
        return accounts;
    }
}
